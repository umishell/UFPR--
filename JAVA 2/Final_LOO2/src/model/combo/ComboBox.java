package model.combo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.connection.ConnectionFactory;
import model.connection.GetId;

public class ComboBox {

    private static final String sqlModeloMotocicleta = "select modelo from ModeloMotocicleta where idmarca=? and idcategoria=? order by modelo";
    private static final String sqlModeloAutomovel = "select modelo from ModeloAutomovel where idmarca=? and idcategoria=? order by modelo";
    private static final String sqlModeloVan = "select modelo from ModeloVan where idmarca=? and idcategoria=? order by modelo";

    public static void loadCboxModelo(JComboBox<Object> cbox, String type, String marca, String categoria) {
        cbox.removeAllItems();
        ResultSet rs;
        int idmarca = GetId.getIdMarca(marca);
        int idcategoria = GetId.getIdCategoria(categoria);
        try {
            switch (type) {
                case "Motocicleta" -> {
                    try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtModelo = conn.prepareStatement(sqlModeloMotocicleta);) {
                        stmtModelo.setInt(1, idmarca);
                        stmtModelo.setInt(2, idcategoria);
                        rs = stmtModelo.executeQuery();
                        while (rs.next()) {
                            cbox.addItem(rs.getString("modelo"));
                        }
                    }
                }
                case "Automovel" -> {
                    try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtModelo = conn.prepareStatement(sqlModeloAutomovel);) {
                        stmtModelo.setInt(1, idmarca);
                        stmtModelo.setInt(2, idcategoria);
                        rs = stmtModelo.executeQuery();
                        while (rs.next()) {
                            cbox.addItem(rs.getString("modelo"));
                        }
                    }
                }
                case "Van" -> {
                    try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmtModelo = conn.prepareStatement(sqlModeloVan);) {
                        stmtModelo.setInt(1, idmarca);
                        stmtModelo.setInt(2, idcategoria);
                        rs = stmtModelo.executeQuery();
                        while (rs.next()) {
                            cbox.addItem(rs.getString("modelo"));
                        }
                    }
                }
                default -> {
                }
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.loadCboxModelo(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static final String sqlMarcas = "select marca from marca order by marca";

    public static void loadCboxMarca(JComboBox<String> cbox) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlMarcas);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cbox.addItem(rs.getString(1));
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.loadCboxMarca(): " + e.getMessage());
        }
    }

    private static final String sqlCategorias = "select categoria from categoria";

    public static void loadCboxCategoria(JComboBox<String> cbox) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlCategorias);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cbox.addItem(rs.getString(1));
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.loadCboxMarca(): " + e.getMessage());
        }
    }

    public static void loadCboxEstado(JComboBox<String> cbox) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlMarcas);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cbox.addItem(rs.getString(1));
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.loadCboxMarca(): " + e.getMessage());
        }
    }

}
