package model.connection;

import model.dto.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDaoSql implements ClienteDao {

    private static ClienteDaoSql dao;

    public static ClienteDaoSql getClienteDaoSql() {
        if (dao == null) {
            return dao = new ClienteDaoSql();
        } else {
            return dao;
        }
    }

    private final String selectByCpf = "SELECT * from cliente WHERE cpf=?";

    public boolean clienteExists(Cliente cliente) throws SQLException, IOException, NullPointerException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(selectByCpf)) {
            stmt.setString(1, cliente.getCpf());
            ResultSet rs = stmt.executeQuery();
            // Check if any row is returned (indicating CPF exists)
            return rs.next();
        }
    }

    private final String insert = "INSERT INTO cliente (nome,sobrenome,rg,cpf,endereco) VALUES (?,?,?,?,?)";

    @Override
    public void add(Cliente cliente) throws SQLException, IOException {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEndereco());

            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            cliente.setId(i);
        }
    }

    private final String selectAll = "SELECT * FROM cliente";

    @Override
    public ArrayList<Cliente> getAll() throws SQLException, IOException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(selectAll); ResultSet rs = stmt.executeQuery();) {
            ArrayList<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String rg = rs.getString("rg");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                int bool = rs.getInt("comVeiculoLocado");
                Boolean comVeiculoLocado = bool == 1;

                clientes.add(new Cliente(id, nome, sobrenome, rg, cpf, endereco, comVeiculoLocado));
            }
            return clientes;

        }
    }

    private final String selectById = "SELECT * FROM cliente WHERE id=?";

    @Override
    public Cliente getById(int id) throws SQLException, IOException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(selectById);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobrenome");
                    String rg = rs.getString("rg");
                    String cpf = rs.getString("cpf");
                    String endereco = rs.getString("endereco");
                    int bool = rs.getInt("comVeiculoLocado");
                    Boolean comVeiculoLocado = bool == 1;

                    return new Cliente(id, nome, sobrenome, rg, cpf, endereco, comVeiculoLocado);
                } else {
                    throw new SQLException("Cliente não encontrado com id=" + id);
                }
            }
        }
    }

    public Cliente getByCpf(String CPF) throws SQLException, IOException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(selectByCpf);) {
            stmt.setString(1, CPF);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobrenome");
                    String rg = rs.getString("rg");
                    String cpf = rs.getString("cpf");
                    String endereco = rs.getString("endereco");
                    int bool = rs.getInt("comVeiculoLocado");
                    Boolean comVeiculoLocado = bool == 1;

                    return new Cliente(id, nome, sobrenome, rg, cpf, endereco, comVeiculoLocado);
                } else {
                    throw new SQLException("Cliente não encontrado com cpf=" + CPF);
                }
            }
        }
    }

    private final String update = "UPDATE cliente SET nome=?, sobrenome=?, rg=?, cpf=?, endereco=? WHERE cpf=?";

    @Override
    public void update(Cliente cliente) throws SQLException, IOException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(update);) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getCpf());
            stmt.executeUpdate();
        }
    }

    private final String updateComVeiculoLocado = "UPDATE cliente set comVeiculoLocado=? WHERE cpf=?";

    public void updateComVeiculoLocado(Cliente cliente) throws SQLException, IOException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(updateComVeiculoLocado);) {
            int bool = (cliente.getComVeiculoLocado()) ? 1 : 0;
            stmt.setInt(1, bool);
            stmt.setString(2, cliente.getCpf());
            stmt.executeUpdate();
        }
    }

    private final String deleteLocacaoIdCliente = "DELETE FROM locacao WHERE idcliente= (SELECT id FROM cliente WHERE cpf=?)";
    private final String delete = "DELETE FROM cliente WHERE cpf=?";

    @Override
    public void delete(Cliente cliente) throws SQLException, IOException {
        String cpf = cliente.getCpf();
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt0 = conn.prepareStatement(deleteLocacaoIdCliente); PreparedStatement stmt1 = conn.prepareStatement(delete);) {
            stmt0.setString(1, cpf);
            stmt0.executeUpdate();
            stmt1.setString(1, cpf);
            stmt1.executeUpdate();
        }
    }

    private final String deleteAll = "TRUNCATE cliente";

    @Override
    public void deleteAll() throws SQLException, IOException {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(deleteAll);) {
            stmtExcluir.executeUpdate();
        }
    }

}
