package model.connection;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.combo.ComboBox;
import model.dto.Locacao;
import model.dto.Motocicleta;

public class MotocicletaDaoSql implements MotocicletaDao {


    private final String updateEstado = "update veiculo set idestado=? WHERE idveiculo=?";
    private final String delete = "delete from motocicleta WHERE idveiculo=?; "
                                + "delete from veiculo where idveiculo=?";
    private final String deleteAll = "TRUNCATE motocicleta;"
                                   + "delete from veiculo where tipo = 1";

    private static ClienteDaoSql dao;

    public static ClienteDaoSql getClienteDaoSql() {
        if (dao == null) {
            return dao = new ClienteDaoSql();
        } else {
            return dao;
        }
    }

    private final String insert = "insert into veiculo (idestado, valorDeCompra, tipo, ano, placa) values (?,?,?,?,?);"
            + "insert into modelomotocicleta (idmarca, idcategoria, modelo) values (?,?,?);"
            + "insert into motocicleta (idveiculo, idmodeloMotocicleta) values (?,?);";

    @Override
    public void add(Motocicleta moto) {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAdiciona = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);) {
            stmtAdiciona.setInt(1, ComboBox.getIdEstado(moto.getEstado()));
            stmtAdiciona.setDouble(2, moto.getValorDeCompra()); 
            stmtAdiciona.setInt(3, 1);
            stmtAdiciona.setInt(4, moto.getAno());
            stmtAdiciona.setString(5, moto.getPlaca());
            stmtAdiciona.setInt(6, ComboBox.getIdEstado(moto.getEstado()));
            stmtAdiciona.setInt(7, ComboBox.getIdCategoria(moto.getCategoria()));
            stmtAdiciona.setString(8, moto.getModelo());
            stmtAdiciona.setInt(9, ComboBox.getIdVeiculo(moto.getPlaca()));
            stmtAdiciona.setInt(10, ComboBox.getIdmodelo("Motocicleta", moto.getModelo()));
            stmtAdiciona.execute();

            //ResultSet rs = stmtAdiciona.getGeneratedKeys();
            //rs.next();
            //int i = rs.getInt(1);
            //moto.setId(i);
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.add() Error adding moto: " + e.getMessage());
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
    public List<Motocicleta> getAll() {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLista = conn.prepareStatement(selectAll); ResultSet rs = stmtLista.executeQuery();) {
            List<Motocicleta> motocicletas = new ArrayList();
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

                motocicletas.add(new Motocicleta(marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo));
            }
            return motocicletas;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.getAll():  Error getting all motocicletas: " + e.getMessage());
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
                    String marca = rs.getString("marca");
                    String estado = rs.getString("estado");
                    LocacaoDaoSql l = new LocacaoDaoSql();
                    ArrayList<Locacao> locacoes = l.getAllwithVeiculo(idveiculo);
                    String categoria = rs.getString("categoria");
                    Double valorDeCompra = rs.getDouble("valorDeCompra");
                    String placa = rs.getString("placa");
                    int ano = rs.getInt("ano");
                    String modelo = rs.getString("modelo");

                    return new Motocicleta(marca, estado, locacoes, categoria, valorDeCompra, placa, ano, modelo);
                } else {
                    throw new SQLException("Moto não encontrado com id=" + id);
                }
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.getById():  Error getting moto by ID: " + e.getMessage());
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
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.update():  Error updating moto: " + e.getMessage());
        }
    }

    public void updateEstado(Motocicleta moto) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(updateEstado);) {
            stmtAtualiza.setInt(1, ComboBox.getIdEstado(moto.getEstado()));
            stmtAtualiza.setInt(2, ComboBox.getIdVeiculo(moto.getPlaca()));
            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.updateEstado():  "
                    + "Error updating Estado of veiculo: " + e.getMessage());
        }
    }

    @Override
    public void delete(Motocicleta moto) {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(delete);) {
            stmtExcluir.setInt(1, ComboBox.getIdVeiculo(moto.getPlaca()));
            stmtExcluir.setInt(1, ComboBox.getIdVeiculo(moto.getPlaca()));
            
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.delete():  Error deleting moto: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() throws SQLException, IOException {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(deleteAll);) {
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@MotocicletaDaoSql.deleteAll():  Error deleting all motos: " + e.getMessage());
        }
    }

}
