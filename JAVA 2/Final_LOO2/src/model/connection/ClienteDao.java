package model.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.dto.Cliente;

public class ClienteDao {

    private final String insert = "insert into cliente (nome,sobrenome,rg,cpf,endereco,comVeiculoLocado) values (?,?,?,?,?,?)";
    private final String selectAll = "select * from cliente";
    private final String selectByCpf = "select * from cliente where cpf=?";
    private final String update = "update cliente set nome=?, sobrenome=?, rg=?, cpf=?, endereco=? WHERE ID=?";
    private final String updateComVeiculoLocado = "update cliente set comVeiculoLocado=? WHERE cpf=?";
    private final String delete = "delete from cliente WHERE ID=?";
    private final String deleteAll = "TRUNCATE cliente";

    public void add(Cliente cliente) throws SQLException, IOException {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);) {
            // seta os valores
            stmtAdiciona.setString(1, cliente.getNome());
            stmtAdiciona.setInt(2, cliente.getSemestre());
            stmtAdiciona.setDate(3, Date.valueOf(cliente.getDataNascimento()));
            // executa
            stmtAdiciona.execute();
            //Seta o id do aluno
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            long i = rs.getLong(1);
            aluno.setId(i);
        }
    }

    public List<Aluno> getAll() throws SQLException, IOException {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtLista = connection.prepareStatement(selectAll); ResultSet rs = stmtLista.executeQuery();) {
            List<Aluno> alunos = new ArrayList();
            while (rs.next()) {
                // criando o objeto Aluno
                //Aluno aluno = new Aluno();
                long id = rs.getLong("ID");
                String nome = rs.getString("NOME");
                int semestre = rs.getInt("SEMESTRE");
                LocalDate dataNascimento = rs.getDate("DATA_NASCIMENTO").toLocalDate();

                // adicionando o objeto à lista
                alunos.add(new Aluno(id, nome, semestre, dataNascimento));
            }

            return alunos;
        }
    }

    public Aluno getById(long id) throws SQLException, IOException {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtLista = connection.prepareStatement(selectById);) {
            stmtLista.setLong(1, id);
            try (ResultSet rs = stmtLista.executeQuery()) {
                if (rs.next()) {
                    // criando o objeto Aluno
                    //Aluno aluno = new Aluno();
                    String nome = rs.getString("NOME");
                    int semestre = rs.getInt("SEMESTRE");
                    LocalDate dataNascimento = rs.getDate("DATA_NASCIMENTO").toLocalDate();
                    return new Aluno(id, nome, semestre, dataNascimento);
                } else {
                    throw new SQLException("Aluno não encontrado com id=" + id);
                }
            }
        }
    }

    public void update(Aluno aluno) throws SQLException, IOException {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = connection.prepareStatement(update);) {

            stmtAtualiza.setString(1, aluno.getNome());
            stmtAtualiza.setInt(2, aluno.getSemestre());
            stmtAtualiza.setDate(3, Date.valueOf(aluno.getDataNascimento()));
            stmtAtualiza.setLong(4, aluno.getId());
            stmtAtualiza.executeUpdate();
        }
    }
    
    public void updateComVeiculoLocado(Cliente cliente) throws SQLException, IOException {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = connection.prepareStatement(update);) {

            stmtAtualiza.setBoolean(1, cliente.isComVeiculoLocado());
            stmtAtualiza.executeUpdate();
        }
    }

    public void delete(Aluno aluno) throws SQLException, IOException {

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = connection.prepareStatement(delete);) {
            stmtExcluir.setLong(1, aluno.getId());
            stmtExcluir.executeUpdate();
        }
    }

    public void deleteAll() throws SQLException, IOException {

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = connection.prepareStatement(deleteAll);) {
            stmtExcluir.executeUpdate();
        }
    }

}
