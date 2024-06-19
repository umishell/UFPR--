package model.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.dto.Venda;

public class VendaDaoSql {

    private static VendaDaoSql dao;

    public static VendaDaoSql getVendaDaoSql() {
        if (dao == null) {
            return dao = new VendaDaoSql();
        } else {
            return dao;
        }
    }

    private final String efetivar = "INSERT INTO venda (idveiculo, idcliente, date) VALUES (?,?,?)";
    private final String updateEstadoVeiculo = "UPDATE veiculo SET idestado=3 WHERE idveiculo=?";

    public void efetivar(Venda venda) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(efetivar); PreparedStatement stmt0 = conn.prepareStatement(updateEstadoVeiculo);) {
            stmt.setInt(1, venda.getIdveiculo());
            stmt.setInt(2, venda.getIdcliente());
            stmt.setDate(3, Date.valueOf(venda.getLocalDate()));
            stmt0.setInt(1, venda.getIdveiculo());
            stmt.executeUpdate();
            stmt0.executeUpdate();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@VendaDaoSql.efetivar():  Error completing sale: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
