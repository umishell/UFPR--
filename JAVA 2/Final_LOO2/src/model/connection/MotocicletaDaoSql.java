package model.connection;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.combo.ComboBox;
import model.dto.Locacao;
import model.dto.Motocicleta;

public class MotocicletaDaoSql implements MotocicletaDao {

    private final String selectByPlaca = "SELECT * from veiculo WHERE placa=?";
    private final String updateEstado = "update veiculo set idestado=? WHERE idveiculo=?";
    private final String delete = "delete from motocicleta WHERE idveiculo=?; "
            + "delete from veiculo where idveiculo=?";
    private final String deleteAll = "TRUNCATE motocicleta;"
            + "delete from veiculo where tipo = 1";

    private static MotocicletaDaoSql dao;

    public static MotocicletaDaoSql getMotocicletaDaoSql() {
        if (dao == null) {
            return dao = new MotocicletaDaoSql();
        } else {
            return dao;
        }
    }

    public boolean motoExists(Motocicleta moto) throws SQLException, IOException, NullPointerException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(selectByPlaca)) {
            stmt.setString(1, moto.getPlaca());
            ResultSet rs = stmt.executeQuery();
            // Check if any row is returned (indicating Placa exists)
            return rs.next();
        }
    }

    private final String insertVeiculo = "INSERT INTO veiculo (valorDeCompra, tipo, ano, placa) VALUES (?,?,?,?);";
    private final String insertMoto = """
                                  INSERT INTO motocicleta (idveiculo, idmodeloMotocicleta) 
                                  VALUES ((SELECT idveiculo FROM veiculo WHERE placa=?),
                                  (SELECT idmodeloMotocicleta FROM modelomotocicleta WHERE modelo = ?));""";

    @Override
    public void add(Motocicleta moto) {
//moto.to_String();
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtVeiculo = conn.prepareStatement(insertVeiculo, Statement.RETURN_GENERATED_KEYS); PreparedStatement stmtMoto = conn.prepareStatement(insertMoto);) {
            stmtVeiculo.setDouble(1, moto.getValorDeCompra());
            stmtVeiculo.setString(2, "Motocicleta");
            stmtVeiculo.setInt(3, moto.getAno());
            stmtVeiculo.setString(4, moto.getPlaca());
            stmtMoto.setString(1, moto.getPlaca());
            stmtMoto.setString(2, moto.getModelo());
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

    private final String selectAll = "SELECT\n"
            + "    veiculo.idveiculo,\n"
            + "    veiculo.placa,\n"
            + "    veiculo.ano ,\n"
            + "    veiculo.valorDeCompra,\n"
            + "    estado.estado,\n"
            + "    modelomotocicleta.modelo,\n"
            + "    categoria.categoria,\n"
            + "    marca.marca\n"
            + "FROM motocicleta\n"
            + "INNER JOIN veiculo ON motocicleta.idveiculo = veiculo.idveiculo\n"
            + "INNER JOIN estado ON veiculo.idestado = estado.idestado\n"
            + "INNER JOIN modeloMotocicleta ON motocicleta.idmodeloMotocicleta = modelomotocicleta.idmodeloMotocicleta\n"
            + "INNER JOIN categoria ON modelomotocicleta.idcategoria = categoria.idcategoria\n"
            + "INNER JOIN marca ON modelomotocicleta.idmarca = marca.idmarca\n"
            + "ORDER BY motocicleta.idveiculo;";

    @Override
    public ArrayList<Motocicleta> getAll() {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLista = conn.prepareStatement(selectAll); ResultSet rs = stmtLista.executeQuery();) {
            ArrayList<Motocicleta> motocicletas = new ArrayList<>();
            while (rs.next()) {
                int idveiculo = rs.getInt("idveiculo");
                String marca = rs.getString("marca");
                String estado = rs.getString("estado");
                LocacaoDaoSql l = new LocacaoDaoSql();
                ArrayList<Locacao> locacoes = l.getAllwithVeiculo(idveiculo);
                String categoria = rs.getString("categoria");
                Double valorDeCompra = rs.getDouble("valorDeCompra");
                String placa = rs.getString("placa");
                int ano = rs.getInt("ano");
                String modelo = rs.getString("modelo");

                motocicletas.add(new Motocicleta(idveiculo, "Motocicleta", marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo));
            }
            return motocicletas;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.getAll():  Error getting all motocicletas: \n" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private final String selectById = "SELECT\n"
            + "    veiculo.idveiculo,\n"
            + "    veiculo.placa,\n"
            + "    veiculo.ano ,\n"
            + "    veiculo.valorDeCompra,\n"
            + "    estado.estado,\n"
            + "    modelomotocicleta.modelo,\n"
            + "    categoria.categoria,\n"
            + "    marca.marca\n"
            + "FROM motocicleta\n"
            + "INNER JOIN veiculo ON motocicleta.idveiculo = veiculo.idveiculo\n"
            + "INNER JOIN estado ON veiculo.idestado = estado.idestado\n"
            + "INNER JOIN modeloMotocicleta ON motocicleta.idmodeloMotocicleta = modelomotocicleta.idmodeloMotocicleta\n"
            + "INNER JOIN categoria ON modelomotocicleta.idcategoria = categoria.idcategoria\n"
            + "INNER JOIN marca ON modelomotocicleta.idmarca = marca.idmarca\n"
            + "where veiculo.idveiculo = ?";

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

    private final String update = "update veiculo set idestado=?, valorDeCompra=?, ano=?, placa=? where idveiculo=?"
            + "update  motocicleta set idmodeloMotocicleta=? where idveiculo=?;";

    @Override
    public void update(Motocicleta moto) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(update);) {
            int idveiculo = ComboBox.getIdVeiculo(moto.getPlaca());
            stmtAtualiza.setInt(1, ComboBox.getIdEstado(moto.getEstado()));
            stmtAtualiza.setDouble(2, moto.getValorDeCompra());
            stmtAtualiza.setInt(3, moto.getAno());
            stmtAtualiza.setString(4, moto.getPlaca());
            stmtAtualiza.setInt(5, idveiculo);
            stmtAtualiza.setInt(6, ComboBox.getIdmodelo("Motocicleta", moto.getModelo()));
            stmtAtualiza.setInt(7, idveiculo);

            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.update():  Error updating moto: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateEstado(Motocicleta moto) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(updateEstado);) {
            stmtAtualiza.setInt(1, ComboBox.getIdEstado(moto.getEstado()));
            stmtAtualiza.setInt(2, ComboBox.getIdVeiculo(moto.getPlaca()));
            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.updateEstado():  "
                    + "Error updating Estado of veiculo: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Motocicleta moto) {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(delete);) {
            stmtExcluir.setInt(1, ComboBox.getIdVeiculo(moto.getPlaca()));
            stmtExcluir.setInt(1, ComboBox.getIdVeiculo(moto.getPlaca()));

            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.delete():  Error deleting moto: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

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
