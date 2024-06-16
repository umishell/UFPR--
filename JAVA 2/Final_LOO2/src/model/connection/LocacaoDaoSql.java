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
import model.dto.Locacao;

public class LocacaoDaoSql implements LocacaoDao {

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

    private final String addLocacao = "SELECT * FROM locacao WHERE idveiculo = ? AND date = ? AND active = 1";

    public boolean locacaoIsActive(LocalDate date, int idveiculo) throws SQLException, IOException, NullPointerException {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(addLocacao);) {
            stmt.setInt(1, idveiculo);
            stmt.setDate(2, Date.valueOf(date));
            ResultSet rs = stmt.executeQuery();
            // Check if any row is returned (indicating locacao exists and is active)
            return rs.next();
        }
    }

    private final String insert = "INSERT INTO locacao (dias, valor, date, idcliente, idveiculo) VALUES (?,?,?,?,?)";
    private final String updateCategoriaVeiculo = "UPDATE veiculo SET idestado=2 WHERE idveiculo=?";


    public void add(Locacao locacao, int idcliente, int idveiculo) {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtAdiciona = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement stmt0 = conn.prepareStatement(updateCategoriaVeiculo);) {
            stmtAdiciona.setInt(1, locacao.getDias());
            stmtAdiciona.setDouble(2, locacao.getValor());
            stmtAdiciona.setDate(3, Date.valueOf(locacao.getDate()));
            System.out.println("@LocacaoDaoSql.add(), idcliente: " + idcliente);
            stmtAdiciona.setInt(4, idcliente);
            stmtAdiciona.setInt(5, idveiculo);
            stmt0.setInt(1, idveiculo);
            stmtAdiciona.execute();
            stmt0.executeUpdate();
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.add():  Error adding locacao: " + e.getMessage());
            e.printStackTrace();
        }

    }

    private final String selectAll = "select * from locacao";

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

    private final String selectAllwithCliente = "select * from locacao where idcliente = ?";

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

    private final String selectAllwithVeiculo = "select * from locacao where idveiculo = ?";

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

    private final String selectById = "select * from locacao where idlocacao = ?";

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

    private final String update = "UPDATE locacao SET dias=?, valor=?, date=? , idcliente=?, idveiculo=? WHERE idlocacao = ?";
    
    @Override
    public void update(Locacao locacao) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(update);) {
            stmt.setInt(1, locacao.getDias());
            stmt.setDouble(2, locacao.getValor());
            stmt.setDate(3, java.sql.Date.valueOf(locacao.getDate()));
            stmt.setInt(4, locacao.getIdCliente());
            stmt.setInt(5, locacao.getIdVeiculo());
            stmt.setInt(6, GetId.getIdLocacao(conn, locacao.getIdVeiculo(), locacao.getDate()));
            
            stmt.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.update():  Error updating locacao: " + e.getMessage());
        }
    }

    private final String delete = "delete from locacao where idlocacao = ?";

    @Override
    public void delete(Locacao locacao) {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(delete);) {
            stmtExcluir.setInt(1, GetId.getIdLocacao(conn, locacao.getIdVeiculo(), locacao.getDate()));
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.delete():  Error deleting locacao: " + e.getMessage());
        }
    }

    private final String deleteAll = "TRUNCATE locacao";

    @Override
    public void deleteAll() {

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = conn.prepareStatement(deleteAll);) {
            stmtExcluir.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@LocacaoDaoSql.deleteAll():  Error deleting all locacoes: " + e.getMessage());
        }
    }
}
