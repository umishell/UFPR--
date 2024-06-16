package model.connection;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.dto.Locacao;
import model.dto.Automovel;


public class AutomovelDaoSql implements AutomovelDao {

    private static AutomovelDaoSql dao;

    public static AutomovelDaoSql getAutomovelDaoSql() {
        if (dao == null) {
            return dao = new AutomovelDaoSql();
        } else {
            return dao;
        }
    }

    private final String selectByPlaca = "SELECT * FROM veiculo WHERE placa=?";

    public boolean autoExists(Automovel auto) throws SQLException, IOException, NullPointerException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(selectByPlaca)) {
            stmt.setString(1, auto.getPlaca());
            ResultSet rs = stmt.executeQuery();
            // Check if any row is returned (indicating Placa exists)
            return rs.next();
        }
    }

    private final String insertVeiculo = "INSERT INTO veiculo (valorDeCompra, tipo, ano, placa) VALUES (?,?,?,?)";
    private final String insertAuto = "INSERT INTO automovel (idveiculo, idmodeloAutomovel) VALUES (?,?))";
                                      
    @Override
    public void add(Automovel auto) {
//auto.to_String();
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtVeiculo = conn.prepareStatement(insertVeiculo, Statement.RETURN_GENERATED_KEYS); PreparedStatement stmtAuto = conn.prepareStatement(insertAuto);) {
            stmtVeiculo.setDouble(1, auto.getValorDeCompra());
            stmtVeiculo.setString(2, "Automovel");
            stmtVeiculo.setInt(3, auto.getAno());
            stmtVeiculo.setString(4, auto.getPlaca());
            stmtAuto.setInt(1, GetId.getIdVeiculo(conn, auto.getPlaca()));
            stmtAuto.setInt(2, GetId.getIdmodelo(conn, "Automovel", auto.getModelo()));
            stmtVeiculo.execute();
            stmtAuto.execute();

            ResultSet rs = stmtVeiculo.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            auto.setIdveiculo(i);
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@AutomovelDaoSql.add() Error adding auto: \n" + e.getMessage());
            e.printStackTrace();
        }

    }

    private final String selectAll = """
                                     SELECT
                                        veiculo.idveiculo,
                                        marca.marca,
                                        estado.estado,
                                        categoria.categoria,
                                        veiculo.valorDeCompra,
                                        veiculo.placa,
                                        veiculo.ano ,
                                        modeloautomovel.modelo
                                     FROM automovel
                                     INNER JOIN veiculo ON automovel.idveiculo = veiculo.idveiculo
                                     INNER JOIN estado ON veiculo.idestado = estado.idestado
                                     INNER JOIN modeloAutomovel ON automovel.idmodeloAutomovel = modeloautomovel.idmodeloAutomovel
                                     INNER JOIN categoria ON modeloautomovel.idcategoria = categoria.idcategoria
                                     INNER JOIN marca ON modeloautomovel.idmarca = marca.idmarca
                                     ORDER BY automovel.idveiculo;
                                     """;

    @Override
    public ArrayList<Automovel> getAll() {

        ArrayList<Automovel> autos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLocacoes = conn.prepareStatement("SELECT * FROM locacao WHERE idveiculo = ?"); PreparedStatement stmtLista = conn.prepareStatement(selectAll); ResultSet rs = stmtLista.executeQuery();) {

            while (rs.next()) {
                int idveiculo = rs.getInt("idveiculo");
                String marca = rs.getString("marca");
                String estado = rs.getString("estado");

                ArrayList<Locacao> locacoes = new ArrayList<>();
                stmtLocacoes.setInt(1, idveiculo);
                try (ResultSet rs0 = stmtLocacoes.executeQuery();) {
                    if (!rs0.isBeforeFirst()) { //if there are rows available{
                        System.out.println("veiculo " + idveiculo + " sem locacoes.");
                        locacoes = null;
                    } else {
                        while (rs0.next()) {
                            boolean active = rs0.getBoolean("active");
                            int dias = rs0.getInt("dias");
                            double valor = rs0.getDouble("valor");
                            LocalDate date = rs0.getDate("date").toLocalDate();
                            int idCliente = rs0.getInt("idcliente");
                            locacoes.add(new Locacao(active, dias, valor, date, idCliente, idveiculo));
                            //System.out.println("veiculo-> " + idveiculo + ": " + idCliente + " " + valor + " " + date + " " + dias);
                        }
                    }

                }
                String categoria = rs.getString("categoria");
                Double valorDeCompra = rs.getDouble("valorDeCompra");
                String placa = rs.getString("placa");
                int ano = rs.getInt("ano");
                String modelo = rs.getString("modelo");

                autos.add(new Automovel(idveiculo, "Automovel", marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo));
            }
            return autos;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@AutomovelDaoSql.getAll():  Error getting all autos: \n" + e.getMessage());
            e.printStackTrace();
        }
        return autos;
    }
    
    private final String selectAllLocados = """
                                     SELECT
                                        veiculo.idveiculo,
                                        marca.marca,
                                        estado.estado,
                                        categoria.categoria,
                                        veiculo.valorDeCompra,
                                        veiculo.placa,
                                        veiculo.ano,
                                        modeloautomovel.modelo,
                                        locacao.idcliente
                                      FROM automovel
                                      INNER JOIN veiculo ON automovel.idveiculo = veiculo.idveiculo
                                      INNER JOIN locacao ON automovel.idveiculo = locacao.idveiculo
                                     
                                      INNER JOIN estado ON veiculo.idestado = estado.idestado
                                      INNER JOIN modeloAutomovel ON automovel.idmodeloAutomovel = modeloautomovel.idmodeloAutomovel
                                      INNER JOIN categoria ON modeloautomovel.idcategoria = categoria.idcategoria
                                      INNER JOIN marca ON modeloautomovel.idmarca = marca.idmarca
                                      WHERE estado.estado = 'locado' AND locacao.idcliente = ?
                                      GROUP BY veiculo.idveiculo, marca.marca, estado.estado, categoria.categoria,
                                     		  veiculo.valorDeCompra, veiculo.placa, veiculo.ano, modeloautomovel.modelo;
                                     """;

    public ArrayList<Automovel> getAllLocadosPorCliente(int idcliente) {

        ArrayList<Automovel> autos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLocacoes = conn.prepareStatement("SELECT * FROM locacao where idveiculo = ?"); 
                PreparedStatement stmtLista = conn.prepareStatement(selectAllLocados);) {
            stmtLista.setInt(1, idcliente);
            try (ResultSet rs = stmtLista.executeQuery();) {
                while (rs.next()) {
                    int idveiculo = rs.getInt("idveiculo");
                    String marca = rs.getString("marca");
                    String estado = rs.getString("estado");

                    ArrayList<Locacao> locacoes = new ArrayList<>();
                    stmtLocacoes.setInt(1, idveiculo);
                    try (ResultSet rs0 = stmtLocacoes.executeQuery();) {
                        if (!rs0.isBeforeFirst()) { //if there are rows available{
                            //System.out.println("veiculo " + idveiculo + " sem locacoes.");
                            locacoes = null;
                        } else {
                            while (rs0.next()) {
                                boolean active = rs0.getBoolean("active");
                                int dias = rs0.getInt("dias");
                                double valor = rs0.getDouble("valor");
                                LocalDate date = rs0.getDate("date").toLocalDate();
                                int idCliente = rs0.getInt("idcliente");
                                locacoes.add(new Locacao(active, dias, valor, date, idCliente, idveiculo));
                            }
                        }
                    }
                    String categoria = rs.getString("categoria");
                    Double valorDeCompra = rs.getDouble("valorDeCompra");
                    String placa = rs.getString("placa");
                    int ano = rs.getInt("ano");
                    String modelo = rs.getString("modelo");

                    autos.add(new Automovel(idveiculo, "Automovel", marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo));
                }
            }
            return autos;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@AutomovelDaoSql.getAllNaoLocados():  Error getting all autos nao locados: \n" + e.getMessage());
            e.printStackTrace();
        }
        return autos;
    }

    private final String selectAllDisponiveis = """
                                     SELECT
                                       veiculo.idveiculo,
                                       marca.marca,
                                       estado.estado,
                                       categoria.categoria,
                                       veiculo.valorDeCompra,
                                       veiculo.placa,
                                       veiculo.ano,
                                       modeloautomovel.modelo
                                     FROM automovel
                                     INNER JOIN veiculo ON automovel.idveiculo = veiculo.idveiculo
                                     INNER JOIN estado ON veiculo.idestado = estado.idestado
                                     INNER JOIN modeloAutomovel ON automovel.idmodeloAutomovel = modeloautomovel.idmodeloAutomovel
                                     INNER JOIN categoria ON modeloautomovel.idcategoria = categoria.idcategoria
                                     INNER JOIN marca ON modeloautomovel.idmarca = marca.idmarca
                                     WHERE estado.estado = ?
                                     GROUP BY veiculo.idveiculo, marca.marca, estado.estado, categoria.categoria,
                                              veiculo.valorDeCompra, veiculo.placa, veiculo.ano, modeloautomovel.modelo;
                                     """;

    public ArrayList<Automovel> getAllWithEstado(String estado) {

        ArrayList<Automovel> autos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLocacoes = conn.prepareStatement("SELECT * FROM locacao where idveiculo = ?"); 
                PreparedStatement stmtLista = conn.prepareStatement(selectAllDisponiveis);) {
            stmtLista.setString(1, estado);
            try (ResultSet rs = stmtLista.executeQuery();) {
                while (rs.next()) {
                    int idveiculo = rs.getInt("idveiculo");
                    String marca = rs.getString("marca");
                    //String estado = rs.getString("estado");

                    ArrayList<Locacao> locacoes = new ArrayList<>();
                    stmtLocacoes.setInt(1, idveiculo);
                    try (ResultSet rs0 = stmtLocacoes.executeQuery();) {
                        if (!rs0.isBeforeFirst()) { //if there are rows available{
                            //System.out.println("veiculo " + idveiculo + " sem locacoes.");
                            locacoes = null;
                        } else {
                            while (rs0.next()) {
                                boolean active;
                                if (estado == "disponivel") {
                                    active = true;
                                } else {
                                    active = false;
                                }
                                int dias = rs0.getInt("dias");
                                double valor = rs0.getDouble("valor");
                                LocalDate date = rs0.getDate("date").toLocalDate();
                                int idCliente = rs0.getInt("idcliente");
                                locacoes.add(new Locacao(active, dias, valor, date, idCliente, idveiculo));
                            }
                        }
                    }
                    String categoria = rs.getString("categoria");
                    Double valorDeCompra = rs.getDouble("valorDeCompra");
                    String placa = rs.getString("placa");
                    int ano = rs.getInt("ano");
                    String modelo = rs.getString("modelo");

                    autos.add(new Automovel(idveiculo, "Automovel", marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo));
                }
            }
            return autos;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@AutomovelDaoSql.getAllNaoLocados():  Error getting all autos nao locados: \n" + e.getMessage());
            e.printStackTrace();
        }
        return autos;
    }

    private final String selectById = """
                                      SELECT
                                        veiculo.idveiculo,
                                        marca.marca,
                                        estado.estado,
                                        categoria.categoria,
                                        veiculo.valorDeCompra,
                                        veiculo.placa,
                                        veiculo.ano,
                                        modeloautomovel.modelo
                                      FROM automovel
                                      INNER JOIN veiculo ON automovel.idveiculo = veiculo.idveiculo
                                      INNER JOIN estado ON veiculo.idestado = estado.idestado
                                      INNER JOIN modeloAutomovel ON automovel.idmodeloAutomovel = modeloautomovel.idmodeloAutomovel
                                      INNER JOIN categoria ON modeloautomovel.idcategoria = categoria.idcategoria
                                      INNER JOIN marca ON modeloautomovel.idmarca = marca.idmarca
                                      WHERE veiculo.idveiculo = ?
                                      ORDER BY automovel.idveiculo;
                                      """;

    @Override
    public Automovel getById(int id) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLista = conn.prepareStatement(selectById);) {
            stmtLista.setInt(1, id);
            try (ResultSet rs = stmtLista.executeQuery()) {
                if (rs.next()) {
                    int idveiculo = rs.getInt("idveiculo");
                    String tipo = rs.getString("tipo");
                    String marca = rs.getString("marca");
                    String estado = rs.getString("estado");
                    LocacaoDaoSql l = new LocacaoDaoSql();
                    ArrayList<Locacao> locacoes = l.getAllwithVeiculo(idveiculo);
                    String categoria = rs.getString("categoria");
                    Double valorDeCompra = rs.getDouble("valorDeCompra");
                    String placa = rs.getString("placa");
                    int ano = rs.getInt("ano");
                    String modelo = rs.getString("modelo");

                    return new Automovel(idveiculo, tipo, marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo);
                } else {
                    throw new SQLException("Auto não encontrado com id=" + id);
                }
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@AutomovelDaoSql.getById():  Error getting auto by ID: \n" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private final String update = "UPDATE veiculo SET idestado=?, valorDeCompra=?, ano=?, placa=? WHERE idveiculo=?"
            + "UPDATE  automovel SET idmodeloAutomovel=? WHERE idveiculo=?;";

    @Override
    public void update(Automovel auto) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(update);) {
            int idveiculo = GetId.getIdVeiculo(conn, auto.getPlaca());
            stmtAtualiza.setInt(1, GetId.getIdEstado(conn, auto.getEstado()));
            stmtAtualiza.setDouble(2, auto.getValorDeCompra());
            stmtAtualiza.setInt(3, auto.getAno());
            stmtAtualiza.setString(4, auto.getPlaca());
            stmtAtualiza.setInt(5, idveiculo);
            stmtAtualiza.setInt(6, GetId.getIdmodelo(conn, "Automovel", auto.getModelo()));
            stmtAtualiza.setInt(7, idveiculo);

            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@AutomovelDaoSql.update():  Error updating auto: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private final String updateEstado = "UPDATE veiculo SET idestado=? WHERE idveiculo=?";

    public void updateEstado(Automovel auto) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(updateEstado);) {
            stmtAtualiza.setInt(1, GetId.getIdEstado(conn, auto.getEstado()));
            stmtAtualiza.setInt(2, GetId.getIdVeiculo(conn, auto.getPlaca()));
            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@AutomovelDaoSql.updateEstado():  "
                    + "Error updating Estado of veiculo: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private final String delete = "DELETE FROM automovel WHERE idveiculo=?;"
            + "DELETE FROM veiculo WHERE idveiculo=?";

    @Override
    public void delete(Automovel auto) {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(delete);) {
            stmtExcluir.setInt(1, GetId.getIdVeiculo(conn, auto.getPlaca()));
            stmtExcluir.setInt(1, GetId.getIdVeiculo(conn, auto.getPlaca()));

            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@AutomovelDaoSql.delete():  Error deleting auto: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private final String deleteAll = "TRUNCATE automovel;"
            + "DELETE FROM veiculo WHERE tipo = 2";

    @Override
    public void deleteAll() throws SQLException, IOException {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(deleteAll);) {
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@AutomovelDaoSql.deleteAll():  Error deleting all autos: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

}
