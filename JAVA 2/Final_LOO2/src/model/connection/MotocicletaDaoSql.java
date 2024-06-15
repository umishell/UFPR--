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
import model.dto.Motocicleta;

public class MotocicletaDaoSql implements MotocicletaDao {

    private static MotocicletaDaoSql dao;

    public static MotocicletaDaoSql getMotocicletaDaoSql() {
        if (dao == null) {
            return dao = new MotocicletaDaoSql();
        } else {
            return dao;
        }
    }

    private final String selectByPlaca = "SELECT * FROM veiculo WHERE placa=?";

    public boolean motoExists(Motocicleta moto) throws SQLException, IOException, NullPointerException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(selectByPlaca)) {
            stmt.setString(1, moto.getPlaca());
            ResultSet rs = stmt.executeQuery();
            // Check if any row is returned (indicating Placa exists)
            return rs.next();
        }
    }

    private final String insertVeiculo = "INSERT INTO veiculo (valorDeCompra, tipo, ano, placa) VALUES (?,?,?,?);";
    private final String insertMoto = "INSERT INTO motocicleta (idveiculo, idmodeloMotocicleta) VALUES (?,?))";

    @Override
    public void add(Motocicleta moto) {
//moto.to_String();
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtVeiculo = conn.prepareStatement(insertVeiculo, Statement.RETURN_GENERATED_KEYS); PreparedStatement stmtMoto = conn.prepareStatement(insertMoto);) {
            stmtVeiculo.setDouble(1, moto.getValorDeCompra());
            stmtVeiculo.setString(2, "Motocicleta");
            stmtVeiculo.setInt(3, moto.getAno());
            stmtVeiculo.setString(4, moto.getPlaca());
            stmtMoto.setInt(1, GetId.getIdVeiculo(conn, moto.getPlaca()));
            stmtMoto.setInt(2, GetId.getIdmodelo(conn, "Motocicleta", moto.getModelo()));
            stmtVeiculo.execute();
            stmtMoto.execute();

            ResultSet rs = stmtVeiculo.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            moto.setIdveiculo(i);
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.add() Error adding moto: \n" + e.getMessage());
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
                                        modelomotocicleta.modelo
                                     FROM motocicleta
                                     INNER JOIN veiculo ON motocicleta.idveiculo = veiculo.idveiculo
                                     INNER JOIN estado ON veiculo.idestado = estado.idestado
                                     INNER JOIN modeloMotocicleta ON motocicleta.idmodeloMotocicleta = modelomotocicleta.idmodeloMotocicleta
                                     INNER JOIN categoria ON modelomotocicleta.idcategoria = categoria.idcategoria
                                     INNER JOIN marca ON modelomotocicleta.idmarca = marca.idmarca
                                     ORDER BY motocicleta.idveiculo;
                                     """;

    @Override
    public ArrayList<Motocicleta> getAll() {

        ArrayList<Motocicleta> motos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLocacoes = conn.prepareStatement("select * from locacao where idveiculo = ?"); PreparedStatement stmtLista = conn.prepareStatement(selectAll); ResultSet rs = stmtLista.executeQuery();) {

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
//System.out.println("veiculo-> "+idveiculo + ": " + idCliente + " " + valor + " " + date + " " + dias);
                        }
                    }
                }
                String categoria = rs.getString("categoria");
                Double valorDeCompra = rs.getDouble("valorDeCompra");
                String placa = rs.getString("placa");
                int ano = rs.getInt("ano");
                String modelo = rs.getString("modelo");

                motos.add(new Motocicleta(idveiculo, "Motocicleta", marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo));
            }
            return motos;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.getAll():  Error getting all motos: \n" + e.getMessage());
            e.printStackTrace();
        }
        return motos;
    }
    /*private final String selectAllLocadas = """
                                     SELECT
                                        veiculo.idveiculo,
                                        marca.marca,
                                        estado.estado,
                                        categoria.categoria,
                                        veiculo.valorDeCompra,
                                        veiculo.placa,
                                        veiculo.ano ,
                                        modelomotocicleta.modelo,
                                        locacao.active
                                     FROM motocicleta
                                     INNER JOIN veiculo ON motocicleta.idveiculo = veiculo.idveiculo
                                     INNER JOIN locacao ON motocicleta.idveiculo = locacao.idveiculo
                                     INNER JOIN estado ON veiculo.idestado = estado.idestado
                                     INNER JOIN modeloMotocicleta ON motocicleta.idmodeloMotocicleta = modelomotocicleta.idmodeloMotocicleta
                                     INNER JOIN categoria ON modelomotocicleta.idcategoria = categoria.idcategoria
                                     INNER JOIN marca ON modelomotocicleta.idmarca = marca.idmarca
                                     WHERE locacao.idcliente = ? AND locacao.active = 1
                                     ORDER BY motocicleta.idveiculo;
                                     """;*/
    private final String selectAllLocadas = """
                                     SELECT
                                        veiculo.idveiculo,
                                        marca.marca,
                                        estado.estado,
                                        categoria.categoria,
                                        veiculo.valorDeCompra,
                                        veiculo.placa,
                                        veiculo.ano,
                                        modelomotocicleta.modelo,
                                        locacao.idcliente
                                      FROM motocicleta
                                      INNER JOIN veiculo ON motocicleta.idveiculo = veiculo.idveiculo
                                      INNER JOIN locacao ON motocicleta.idveiculo = locacao.idveiculo
                                     
                                      INNER JOIN estado ON veiculo.idestado = estado.idestado
                                      INNER JOIN modeloMotocicleta ON motocicleta.idmodeloMotocicleta = modelomotocicleta.idmodeloMotocicleta
                                      INNER JOIN categoria ON modelomotocicleta.idcategoria = categoria.idcategoria
                                      INNER JOIN marca ON modelomotocicleta.idmarca = marca.idmarca
                                      WHERE estado.estado = 'locado' AND locacao.idcliente = ?
                                      GROUP BY veiculo.idveiculo, marca.marca, estado.estado, categoria.categoria,
                                     		  veiculo.valorDeCompra, veiculo.placa, veiculo.ano, modelomotocicleta.modelo;
                                     """;

    public ArrayList<Motocicleta> getAllLocadasPorCliente(int idcliente) {

        ArrayList<Motocicleta> motos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLocacoes = conn.prepareStatement("select * from locacao where idveiculo = ?"); 
                PreparedStatement stmtLista = conn.prepareStatement(selectAllLocadas);) {
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

                    motos.add(new Motocicleta(idveiculo, "Motocicleta", marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo));
                }
            }
            return motos;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.getAllNaoLocados():  Error getting all motos nao locadas: \n" + e.getMessage());
            e.printStackTrace();
        }
        return motos;
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
                                       modelomotocicleta.modelo
                                     FROM motocicleta
                                     INNER JOIN veiculo ON motocicleta.idveiculo = veiculo.idveiculo
                                     INNER JOIN estado ON veiculo.idestado = estado.idestado
                                     INNER JOIN modeloMotocicleta ON motocicleta.idmodeloMotocicleta = modelomotocicleta.idmodeloMotocicleta
                                     INNER JOIN categoria ON modelomotocicleta.idcategoria = categoria.idcategoria
                                     INNER JOIN marca ON modelomotocicleta.idmarca = marca.idmarca
                                     WHERE estado.estado = ?
                                     GROUP BY veiculo.idveiculo, marca.marca, estado.estado, categoria.categoria,
                                              veiculo.valorDeCompra, veiculo.placa, veiculo.ano, modelomotocicleta.modelo;
                                     """;

    public ArrayList<Motocicleta> getAllWithEstado(String estado) {

        ArrayList<Motocicleta> motos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLocacoes = conn.prepareStatement("select * from locacao where idveiculo = ?"); 
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

                    motos.add(new Motocicleta(idveiculo, "Motocicleta", marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo));
                }
            }
            return motos;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.getAllNaoLocados():  Error getting all motos nao locadas: \n" + e.getMessage());
            e.printStackTrace();
        }
        return motos;
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
                                        modelomotocicleta.modelo
                                      FROM motocicleta
                                      INNER JOIN veiculo ON motocicleta.idveiculo = veiculo.idveiculo
                                      INNER JOIN estado ON veiculo.idestado = estado.idestado
                                      INNER JOIN modeloMotocicleta ON motocicleta.idmodeloMotocicleta = modelomotocicleta.idmodeloMotocicleta
                                      INNER JOIN categoria ON modelomotocicleta.idcategoria = categoria.idcategoria
                                      INNER JOIN marca ON modelomotocicleta.idmarca = marca.idmarca
                                      WHERE veiculo.idveiculo = ?
                                      ORDER BY motocicleta.idveiculo;
                                      """;

    @Override
    public Motocicleta getById(int id) {
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

                    return new Motocicleta(idveiculo, tipo, marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo);
                } else {
                    throw new SQLException("Moto não encontrado com id=" + id);
                }
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.getById():  Error getting moto by ID: \n" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private final String update = "UPDATE veiculo SET idestado=?, valorDeCompra=?, ano=?, placa=? WHERE idveiculo=?"
            + "UPDATE  motocicleta set idmodeloMotocicleta=? WHERE idveiculo=?;";

    @Override
    public void update(Motocicleta moto) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(update);) {
            int idveiculo = GetId.getIdVeiculo(conn, moto.getPlaca());
            stmtAtualiza.setInt(1, GetId.getIdEstado(conn, moto.getEstado()));
            stmtAtualiza.setDouble(2, moto.getValorDeCompra());
            stmtAtualiza.setInt(3, moto.getAno());
            stmtAtualiza.setString(4, moto.getPlaca());
            stmtAtualiza.setInt(5, idveiculo);
            stmtAtualiza.setInt(6, GetId.getIdmodelo(conn, "Motocicleta", moto.getModelo()));
            stmtAtualiza.setInt(7, idveiculo);

            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.update():  Error updating moto: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private final String updateEstado = "UPDATE veiculo SET idestado=? WHERE idveiculo=?";

    public void updateEstado(Motocicleta moto) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(updateEstado);) {
            stmtAtualiza.setInt(1, GetId.getIdEstado(conn, moto.getEstado()));
            stmtAtualiza.setInt(2, GetId.getIdVeiculo(conn, moto.getPlaca()));
            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.updateEstado():  "
                    + "Error updating Estado of veiculo: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private final String delete = "DELETE FROM motocicleta WHERE idveiculo=?; "
            + "DELETE FROM veiculo WHERE idveiculo=?";

    @Override
    public void delete(Motocicleta moto) {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(delete);) {
            stmtExcluir.setInt(1, GetId.getIdVeiculo(conn, moto.getPlaca()));
            stmtExcluir.setInt(1, GetId.getIdVeiculo(conn, moto.getPlaca()));

            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.delete():  Error deleting moto: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private final String deleteAll = "TRUNCATE motocicleta;"
            + "DELTE FROM veiculo WHERE tipo = 1";

    @Override
    public void deleteAll() throws SQLException, IOException {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(deleteAll);) {
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.deleteAll():  Error deleting all motos: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

}
