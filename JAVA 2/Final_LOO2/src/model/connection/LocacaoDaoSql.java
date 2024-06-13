package model.connection;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.combo.ComboBox;
import model.dto.Locacao;

public class LocacaoDaoSql implements LocacaoDao {

    private final String insert = "insert into locacao (int dias, double valor, Date date, int idcliente, int idveiculo) values (?,?,?,"
            + "(SELECT idcliente FROM cliente WHERE cpf = ?),"
            + "(SELECT idveiculo FROM veiculo WHERE placa = ?))";
    private final String selectAll = "select * from locacao";
    private final String selectAllwithCliente = "select * from locacao where idcliente = ?";
    private final String locacaoIsActive = "SELECT * FROM locacao WHERE idveiculo = (select * FROM veiculo WHERE placa = ?) AND date = ? AND active = 1";
    private final String selectAllwithVeiculo = "select * from locacao where idveiculo = ?";
    private final String selectById = "select * from locacao where idlocacao = ?";
    //private final String update = "update locacao set dias=?, valor=?, date=? where idlocacao = ?";
    private final String delete = "delete from locacao where idlocacao = ?";
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
    }

    public boolean locacaoIsActive(LocalDate date, String placa) throws SQLException, IOException, NullPointerException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(locacaoIsActive)) {
            stmt.setString(1, placa);
            stmt.setDate(2, Date.valueOf(date));
            ResultSet rs = stmt.executeQuery();
            // Check if any row is returned (indicating locacao exists and is active)
            return rs.next();
        }
    }

    public void add(Locacao locacao, String cpf, String placa) {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAdiciona = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);) {
            stmtAdiciona.setInt(1, locacao.getDias());
            stmtAdiciona.setDouble(2, locacao.getValor());
            stmtAdiciona.setDate(3, Date.valueOf(locacao.getDate()));
            stmtAdiciona.setString(4, cpf);
            stmtAdiciona.setString(5, placa);
            stmtAdiciona.execute();
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.add():  Error adding locacao: " + e.getMessage());
        }

    }

    @Override
    public ArrayList<Locacao> getAll() {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLista = conn.prepareStatement(selectAll); ResultSet rs = stmtLista.executeQuery();) {
            ArrayList<Locacao> locacoes = new ArrayList();
            while (rs.next()) {
                boolean active = rs.getBoolean("active");
                int dias = rs.getInt("dias");
                double valor = rs.getDouble("valor");
                LocalDate date = rs.getDate("date").toLocalDate();
                int idCliente = rs.getInt("idcliente");
                int idVeiculo = rs.getInt("idveiculo");
                locacoes.add(new Locacao(active, dias, valor, date, idCliente, idVeiculo));
            }
            return locacoes;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.getAll():  Error getting all locacoes: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Locacao> getAllwithCliente(int idcliente) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLista = conn.prepareStatement(selectAllwithCliente); ResultSet rs = stmtLista.executeQuery();) {
            ArrayList<Locacao> locacoes = new ArrayList();
            stmtLista.setInt(1, idcliente);
            while (rs.next()) {
                boolean active = rs.getBoolean("active");
                int dias = rs.getInt("dias");
                double valor = rs.getDouble("valor");
                LocalDate date = rs.getDate("date").toLocalDate();
                int idCliente = rs.getInt("idcliente");
                int idVeiculo = rs.getInt("idveiculo");
                locacoes.add(new Locacao(active, dias, valor, date, idCliente, idVeiculo));
            }
            return locacoes;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.getAllwithCliente():  Error getting all locacoes with idcliente " + idcliente + " :" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Locacao> getAllwithVeiculo(int idveiculo) /*throws SQLException, IOException*/ {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLista = conn.prepareStatement(selectAllwithVeiculo); ResultSet rs = stmtLista.executeQuery();) {
            ArrayList<Locacao> locacoes = new ArrayList<>();
            stmtLista.setInt(1, idveiculo);
            while (rs.next()) {
                boolean active = rs.getBoolean("active");
                int dias = rs.getInt("dias");
                double valor = rs.getDouble("valor");
                LocalDate date = rs.getDate("date").toLocalDate();
                int idCliente = rs.getInt("idcliente");
                int idVeiculo = rs.getInt("idveiculo");
                locacoes.add(new Locacao(active, dias, valor, date, idCliente, idVeiculo));
            }
            return locacoes;

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.getAllwithVeiculo():  Error getting all locacoes with idveiculo: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Locacao getById(int idlocacao) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLista = conn.prepareStatement(selectById);) {
            stmtLista.setInt(1, idlocacao);
            try (ResultSet rs = stmtLista.executeQuery()) {
                if (rs.next()) {
                    boolean active = rs.getBoolean("active");
                    int dias = rs.getInt("dias");
                    double valor = rs.getDouble("valor");
                    LocalDate date = rs.getDate("date").toLocalDate();
                    int idCliente = rs.getInt("idcliente");
                    int idVeiculo = rs.getInt("idveiculo");

                    return new Locacao(active, dias, valor, date, idCliente, idVeiculo);
                } else {
                    throw new SQLException("Locacao não encontrada com idlocacao=" + idlocacao);
                }
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.getById():  Error getting locacao by ID: " + e.getMessage());
        }
        return null;
    }

    private final String update = "update locacao set dias=?, valor=?, date=? , idcliente=?, idveiculo=? where idlocacao = ?";

    @Override
    public void update(Locacao locacao) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(update);) {
            stmtAtualiza.setInt(1, locacao.getDias());
            stmtAtualiza.setDouble(2, locacao.getValor());
            stmtAtualiza.setDate(3, java.sql.Date.valueOf(locacao.getDate()));
            stmtAtualiza.setInt(4, locacao.getIdCliente());
            stmtAtualiza.setInt(5, locacao.getIdVeiculo());
            stmtAtualiza.setInt(6, ComboBox.getIdLocacao(locacao.getIdVeiculo(), locacao.getDate()));

            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.update():  Error updating locacao: " + e.getMessage());
        }
    }

    @Override
    public void delete(Locacao locacao) {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(delete);) {
            stmtExcluir.setInt(1, ComboBox.getIdLocacao(locacao.getIdVeiculo(), locacao.getDate()));
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.delete():  Error deleting locacao: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(deleteAll);) {
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.deleteAll():  Error deleting all locacoes: " + e.getMessage());
        }
    }
}
