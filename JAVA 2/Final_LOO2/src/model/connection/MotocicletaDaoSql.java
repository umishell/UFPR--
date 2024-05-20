package model.connection;

import model.dto.Cliente;

import java.io.IOException;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import model.combo.ComboBox;
import model.dto.Locacao;
import model.dto.Motocicleta;

public class MotocicletaDaoSql implements MotocicletaDao {

        private final String insert = "insert into veiculo (idestado, valorDeCompra, tipo, ano, placa) values (?,?,?,?,?);"
            + "insert into modelomotocicleta (idmarca, idcategoria, modelo) values (?,?,?);"
            + "insert into motocicleta (idveiculo, idmodeloMotocicleta) values (?,?);";

    
    private final String selectById = "select * from moto where id=?";
    private final String selectByCpf = "select cpf from moto where cpf = ?";
    private final String update = "update moto set nome=?, sobrenome=?, rg=?, cpf=?, endereco=? WHERE ID=?";
    private final String updateComVeiculoLocado = "update moto set comVeiculoLocado=? WHERE id=?";
    private final String delete = "delete from moto WHERE ID=?";
    private final String deleteAll = "TRUNCATE moto";

    private static ClienteDaoSql dao;

    public static ClienteDaoSql getClienteDaoSql() {
        if (dao == null) {
            return dao = new ClienteDaoSql();
        } else {
            return dao;
        }
    }



    @Override
    public void add(Motocicleta moto) {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAdiciona = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);) {
            stmtAdiciona.setInt(1, ComboBox.getIdEstado(moto.getEstado()));
            stmtAdiciona.setDouble(2, moto.getValorDeCompra());
            stmtAdiciona.setString(3, "Motocicleta");
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
    public List<Motocicleta> getAll() /*throws SQLException, IOException*/ {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLista = conn.prepareStatement(selectAll); ResultSet rs = stmtLista.executeQuery();) {
            List<Motocicleta> motocicletas = new ArrayList();
            while (rs.next()) {
                int idveiculo = rs.getInt("idveiculo");
                String marca = rs.getString("marca");
                String estado = rs.getString("estado");
                Locacao locacao;
                if (estado == "locado"){
                    int dias = 
                    double valor = 
                    Calendar data = 
                    Cliente cliente = new Cliente()
                    LocacaoDaoSql l = new LocacaoDaoSql();
                    l.
                    locacao = new Locacao(id, id, data, cliente)
                }else{ 
                    locacao = null;
                }
                Locacao locacao = rs.getString("rg");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                Boolean comVeiculoLocado = rs.getBoolean("comVeiculoLocado");

                motocicletas.add(new Motocicleta());
            }
            return motocicletas;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ClienteDaoSql.getAll():  Error getting all clients: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Motocicleta getById(int id) throws SQLException, IOException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLista = conn.prepareStatement(selectById);) {
            stmtLista.setInt(1, id);
            try (ResultSet rs = stmtLista.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobrenome");
                    String rg = rs.getString("rg");
                    String cpf = rs.getString("cpf");
                    String endereco = rs.getString("endereco");
                    Boolean comVeiculoLocado = rs.getBoolean("comVeiculoLocado");

                    return new Motocicleta(id, nome, sobrenome, rg, cpf, endereco, comVeiculoLocado);
                } else {
                    throw new SQLException("Cliente não encontrado com id=" + id);
                }
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ClienteDaoSql.getById():  Error getting client by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Motocicleta moto) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(update);) {
            stmtAtualiza.setString(1, moto.getNome());
            stmtAtualiza.setString(2, moto.getSobrenome());
            stmtAtualiza.setString(3, moto.getRg());
            stmtAtualiza.setString(4, moto.getCpf());
            stmtAtualiza.setString(5, moto.getEndereco());
            stmtAtualiza.setInt(6, moto.getId());
            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ClienteDaoSql.update():  Error updating client: " + e.getMessage());
        }
    }

    public void updateComVeiculoLocado(Cliente moto) throws SQLException, IOException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(updateComVeiculoLocado);) {
            stmtAtualiza.setBoolean(1, moto.getComVeiculoLocado());
            stmtAtualiza.setInt(2, moto.getId());
            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ClienteDaoSql.updateComVeiculoLocado():  "
                    + "Error updating updateComVeiculoLocado of client: " + e.getMessage());
        }
    }

    @Override
    public void delete(Motocicleta moto) /*throws SQLException, IOException*/ {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(delete);) {
            stmtExcluir.setInt(1, moto.getId());
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ClienteDaoSql.delete():  Error deleting client: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() throws SQLException, IOException {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(deleteAll);) {
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ClienteDaoSql.deleteAll():  Error deleting all clients: " + e.getMessage());
        }
    }

    public boolean clienteCpfExists(Cliente moto) throws SQLException, IOException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(selectByCpf)) {
            stmt.setString(1, moto.getCpf());
            ResultSet rs = stmt.executeQuery();

            // Check if any row is returned (indicating CPF exists)
            return rs.next();
        }
    }

}
