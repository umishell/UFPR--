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
import model.dto.Van;


public class VanDaoSql implements VanDao {

    private static VanDaoSql dao;

    public static VanDaoSql getVanDaoSql() {
        if (dao == null) {
            return dao = new VanDaoSql();
        } else {
            return dao;
        }
    }

    private final String selectByPlaca = "SELECT * FROM veiculo WHERE placa=?";

    public boolean vanExists(Van van) throws SQLException, IOException, NullPointerException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(selectByPlaca)) {
            stmt.setString(1, van.getPlaca());
            ResultSet rs = stmt.executeQuery();
            // Check if any row is returned (indicating Placa exists)
            return rs.next();
        }
    }

    private final String insertVeiculo = "INSERT INTO veiculo (valorDeCompra, tipo, ano, placa) VALUES (?,?,?,?);";
    private final String insertVan = "INSERT INTO van (idveiculo, idmodeloVan) VALUES (?,?))";
    
    @Override
    public void add(Van van) {
//van.to_String();
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtVeiculo = conn.prepareStatement(insertVeiculo, Statement.RETURN_GENERATED_KEYS); PreparedStatement stmtMoto = conn.prepareStatement(insertVan);) {
            stmtVeiculo.setDouble(1, van.getValorDeCompra());
            stmtVeiculo.setString(2, "Van");
            stmtVeiculo.setInt(3, van.getAno());
            stmtVeiculo.setString(4, van.getPlaca());
            stmtMoto.setInt(1, GetId.getIdVeiculo(conn, van.getPlaca()));
            stmtMoto.setInt(2, GetId.getIdmodelo(conn, "Van", van.getModelo()));
            stmtVeiculo.execute();
            stmtMoto.execute();

            ResultSet rs = stmtVeiculo.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            van.setIdveiculo(i);
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@VanDaoSql.add() Error adding van: \n" + e.getMessage());
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
                                        modelovan.modelo
                                     FROM van
                                     INNER JOIN veiculo ON van.idveiculo = veiculo.idveiculo
                                     INNER JOIN estado ON veiculo.idestado = estado.idestado
                                     INNER JOIN modelovan ON van.idmodeloVan = modelovan.idmodeloVan
                                     INNER JOIN categoria ON modelovan.idcategoria = categoria.idcategoria
                                     INNER JOIN marca ON modelovan.idmarca = marca.idmarca
                                     ORDER BY van.idveiculo;
                                     """;
    @Override
    public ArrayList<Van> getAll() {

        ArrayList<Van> vans = new ArrayList<>();

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
                            System.out.println("veiculo-> " + idveiculo + ": " + idCliente + " " + valor + " " + date + " " + dias);
                        }
                    }

                }
                String categoria = rs.getString("categoria");
                Double valorDeCompra = rs.getDouble("valorDeCompra");
                String placa = rs.getString("placa");
                int ano = rs.getInt("ano");
                String modelo = rs.getString("modelo");

                vans.add(new Van(idveiculo, "Van", marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo));
            }
            return vans;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@VanDaoSql.getAll():  Error getting all vans: \n" + e.getMessage());
            e.printStackTrace();
        }
        return vans;
    }
    
    private final String selectAllNaoLocadas = """
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
                                     WHERE locacao.idcliente = ? AND locacao.active = 0
                                     ORDER BY motocicleta.idveiculo;
                                     """;
    public ArrayList<Van> getAllNaoLocadas(int idcliente) {

        ArrayList<Van> vans = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLocacoes = conn.prepareStatement("select * from locacao where idveiculo = ?"); PreparedStatement stmtLista = conn.prepareStatement(selectAllNaoLocadas);) {
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

                    vans.add(new Van(idveiculo, "Van", marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo));
                }
            }
            return vans;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.getAllNaoLocados():  Error getting all vans nao locadas: \n" + e.getMessage());
            e.printStackTrace();
        }
        return vans;
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
                                        modelovan.modelo
                                      FROM van
                                      INNER JOIN veiculo ON van.idveiculo = veiculo.idveiculo
                                      INNER JOIN estado ON veiculo.idestado = estado.idestado
                                      INNER JOIN modelovan ON van.idmodeloVan = modelovan.idmodeloVan
                                      INNER JOIN categoria ON modelovan.idcategoria = categoria.idcategoria
                                      INNER JOIN marca ON modelovan.idmarca = marca.idmarca
                                      WHERE veiculo.idveiculo = ?
                                      ORDER BY van.idveiculo;
                                      """;
    @Override
    public Van getById(int id) {
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

                    return new Van(idveiculo, tipo, marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo);
                } else {
                    throw new SQLException("Moto não encontrado com id=" + id);
                }
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@VanDaoSql.getById():  Error getting van by ID: \n" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private final String update = "UPDATE veiculo SET idestado=?, valorDeCompra=?, ano=?, placa=? WHERE idveiculo=?"
            + "UPDATE  van SET idmodeloVan=? WHERE idveiculo=?;";

    @Override
    public void update(Van van) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(update);) {
            int idveiculo = GetId.getIdVeiculo(conn, van.getPlaca());
            stmtAtualiza.setInt(1, GetId.getIdEstado(conn, van.getEstado()));
            stmtAtualiza.setDouble(2, van.getValorDeCompra());
            stmtAtualiza.setInt(3, van.getAno());
            stmtAtualiza.setString(4, van.getPlaca());
            stmtAtualiza.setInt(5, idveiculo);
            stmtAtualiza.setInt(6, GetId.getIdmodelo(conn, "Van", van.getModelo()));
            stmtAtualiza.setInt(7, idveiculo);

            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@VanDaoSql.update():  Error updating van: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private final String updateEstado = "UPDATE veiculo SET idestado=? WHERE idveiculo=?";

    public void updateEstado(Van van) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(updateEstado);) {
            stmtAtualiza.setInt(1, GetId.getIdEstado(conn, van.getEstado()));
            stmtAtualiza.setInt(2, GetId.getIdVeiculo(conn, van.getPlaca()));
            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@VanDaoSql.updateEstado():  "
                    + "Error updating Estado of veiculo: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private final String delete = "DELETE FROM van WHERE idveiculo=?; "
            + "DELETE FROM veiculo WHERE idveiculo=?";

    @Override
    public void delete(Van van) {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(delete);) {
            stmtExcluir.setInt(1, GetId.getIdVeiculo(conn, van.getPlaca()));
            stmtExcluir.setInt(1, GetId.getIdVeiculo(conn, van.getPlaca()));

            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@VanDaoSql.delete():  Error deleting van: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private final String deleteAll = "TRUNCATE van;"
            + "DELETE FROM veiculo WHERE tipo = 1";

    @Override
    public void deleteAll() throws SQLException, IOException {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(deleteAll);) {
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@VanDaoSql.deleteAll():  Error deleting all vans: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

}
