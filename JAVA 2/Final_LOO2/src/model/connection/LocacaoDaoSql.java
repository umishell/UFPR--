package model.connection;

import model.dto.Cliente;

import java.io.IOException;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;
import model.dto.Locacao;

public class LocacaoDaoSql implements LocacaoDao {

    private final String insert = "insert into locacao (int dias, double valor, Date data, int idcliente, int idveiculo) values (?,?,?,?)";
    private final String selectAll = "select * from locacao";
    private final String selectById = "select * from locacao where idlocacao = ?";
    //private final String update = "update locacao set dias=?, valor=?, data=? where idcliente = ? && idveiculo = ? && data = ?";
    private final String delete = "delete from locacao where idcliente = ? && idveiculo = ?";
    private final String deleteAll = "TRUNCATE locacao";

    private static LocacaoDaoSql dao;

    public static LocacaoDaoSql getLocacaoDaoSql() {
        if (dao == null) {
            return dao = new LocacaoDaoSql();
        } else {
            return dao;
        }
    }

    @Override
    public void add(Locacao locacao) {
        
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
    public List<Locacao> getAll() /*throws SQLException, IOException*/ {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLista = conn.prepareStatement(selectAll); ResultSet rs = stmtLista.executeQuery();) {
            List<Cliente> locacoes = new ArrayList();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String rg = rs.getString("rg");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                Boolean comVeiculoLocado = rs.getBoolean("comVeiculoLocado");

                locacoes.add(new Cliente(id, nome, sobrenome, rg, cpf, endereco, comVeiculoLocado));
            }
            return locacoes;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.getAll():  Error getting all locacoes: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Locacao getById(int idlocacao) {
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

                    return new Locacao(dias, valor, data, cliente);
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

    public void updateComVeiculoLocado(Cliente cliente) throws SQLException, IOException {
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
    public void delete(Cliente cliente) /*throws SQLException, IOException*/ {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(delete);) {
            stmtExcluir.setInt(1, cliente.getId());
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

    public boolean clienteCpfExists(Cliente cliente) throws SQLException, IOException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(selectByCpf)) {
            stmt.setString(1, cliente.getCpf());
            ResultSet rs = stmt.executeQuery();

            // Check if any row is returned (indicating CPF exists)
            return rs.next();
        }
    }

}
