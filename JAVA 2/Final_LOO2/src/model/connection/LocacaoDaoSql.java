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

public class LocacaoDaoSql implements LocacaoDao {

    private final String insert = "insert into locacao (int dias, double valor, Date date, int idcliente, int idveiculo) values (?,?,?,?,?)";
    private final String selectAll = "select * from locacao";
    private final String selectById = "select * from locacao where idlocacao = ?";
    private final String update = "update locacao set dias=?, valor=?, date=? where idlocacao = ?";
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

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAdiciona = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);) {
            stmtAdiciona.setInt(1, locacao.getDias());
            stmtAdiciona.setDouble(2, locacao.getValor());
            stmtAdiciona.setDate(3, java.sql.Date.valueOf(locacao.getDate()));
            stmtAdiciona.setInt(4, locacao.getIdCliente());
            stmtAdiciona.setInt(5, locacao.getIdVeiculo());
            stmtAdiciona.execute();
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.add():  Error adding locacao: " + e.getMessage());
        }

    }

    @Override
    public List<Locacao> getAll() /*throws SQLException, IOException*/ {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtLista = conn.prepareStatement(selectAll); ResultSet rs = stmtLista.executeQuery();) {
            List<Locacao> locacoes = new ArrayList();
            while (rs.next()) {
                int dias = rs.getInt("dias");
                double valor = rs.getDouble("valor");
                LocalDate date = rs.getDate("date").toLocalDate();
                int idCliente = rs.getInt("idcliente");
                int idVeiculo = rs.getInt("idveiculo");
                locacoes.add(new Locacao(dias, valor, date, idCliente, idVeiculo));
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
            stmtLista.setInt(1, idlocacao);
            try (ResultSet rs = stmtLista.executeQuery()) {
                if (rs.next()) {
                    int dias = rs.getInt("dias");
                    double valor = rs.getDouble("valor");
                    LocalDate date = rs.getDate("date").toLocalDate();
                    int idCliente = rs.getInt("idcliente");
                    int idVeiculo = rs.getInt("idveiculo");

                    return new Locacao(dias, valor, date, idCliente, idVeiculo);
                } else {
                    throw new SQLException("Locacao não encontrada com idlocacao=" + idlocacao);
                }
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.getById():  Error getting locacao by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Locacao locacao) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = conn.prepareStatement(update);) {

            stmtAtualiza.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.update():  Error updating locacao: " + e.getMessage());
        }
    }

    @Override
    public void delete(Locacao locacao) /*throws SQLException, IOException*/ {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(delete);) {
            stmtExcluir.setInt(1, ComboBox.getIdLocacao(locacao.getIdVeiculo(), locacao.getDate()));
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.delete():  Error deleting locacao: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() throws SQLException, IOException {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(deleteAll);) {
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.deleteAll():  Error deleting all locacoes: " + e.getMessage());
        }
    }
}
