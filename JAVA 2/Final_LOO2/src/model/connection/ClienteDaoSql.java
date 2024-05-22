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

public class ClienteDaoSql implements ClienteDao {

    private final String insert = "insert into cliente (nome,sobrenome,rg,cpf,endereco,comVeiculoLocado) values (?,?,?,?,?,?)";
    private final String selectAll = "select * from cliente";
    private final String selectById = "select * from cliente where id=?";
    private final String selectByCpf = "select cpf from cliente where cpf = ?";
    private final String update = "update cliente set nome=?, sobrenome=?, rg=?, cpf=?, endereco=? WHERE ID=?";
    private final String updateComVeiculoLocado = "update cliente set comVeiculoLocado=? WHERE id=?";
    private final String delete = "delete from cliente WHERE ID=?";
    private final String deleteAll = "TRUNCATE cliente";

    private static ClienteDaoSql dao;

    public static ClienteDaoSql getClienteDaoSql() {
        if (dao == null) {
            return dao = new ClienteDaoSql();
        } else {
            return dao;
        }
    }

    @Override
    public void add(Cliente cliente) {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAdiciona = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);) {
            stmtAdiciona.setString(1, cliente.getNome());
            stmtAdiciona.setString(2, cliente.getSobrenome());
            stmtAdiciona.setString(3, cliente.getRg());
            stmtAdiciona.setString(4, cliente.getCpf());
            stmtAdiciona.setString(5, cliente.getEndereco());
            stmtAdiciona.setBoolean(6, cliente.getComVeiculoLocado());

            stmtAdiciona.execute();

            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            cliente.setId(i);

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ClienteDaoSql.add().when client exists:  Error adding cliente: " + e.getMessage());
        }

    }

    @Override
    public List<Cliente> getAll() {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLista = conn.prepareStatement(selectAll); ResultSet rs = stmtLista.executeQuery();) {
            List<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String rg = rs.getString("rg");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                Boolean comVeiculoLocado = rs.getBoolean("comVeiculoLocado");

                clientes.add(new Cliente(id, nome, sobrenome, rg, cpf, endereco, comVeiculoLocado));
            }
            return clientes;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ClienteDaoSql.getAll():  Error getting all clients: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Cliente getById(int id) {
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

                    return new Cliente(id, nome, sobrenome, rg, cpf, endereco, comVeiculoLocado);
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
    public void update(Cliente cliente) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(update);) {
            stmtAtualiza.setString(1, cliente.getNome());
            stmtAtualiza.setString(2, cliente.getSobrenome());
            stmtAtualiza.setString(3, cliente.getRg());
            stmtAtualiza.setString(4, cliente.getCpf());
            stmtAtualiza.setString(5, cliente.getEndereco());
            stmtAtualiza.setInt(6, cliente.getId());
            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ClienteDaoSql.update():  Error updating client: " + e.getMessage());
        }
    }

    public void updateComVeiculoLocado(Cliente cliente) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(updateComVeiculoLocado);) {
            stmtAtualiza.setBoolean(1, cliente.getComVeiculoLocado());
            stmtAtualiza.setInt(2, cliente.getId());
            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ClienteDaoSql.updateComVeiculoLocado():  "
                    + "Error updating updateComVeiculoLocado of client: " + e.getMessage());
        }
    }

    @Override
    public void delete(Cliente cliente) {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(delete);) {
            stmtExcluir.setInt(1, cliente.getId());
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ClienteDaoSql.delete():  Error deleting client: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(deleteAll);) {
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ClienteDaoSql.deleteAll():  Error deleting all clients: " + e.getMessage());
        }
    }

    public boolean clienteCpfExists(Cliente cliente) throws SQLException, IOException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(selectByCpf)) {
            stmt.setString(1, cliente.getCpf());
            ResultSet rs = stmt.executeQuery();

            // Check if any row is returned (indicating CPF exists)
            return rs.next();
        }
    }

}
