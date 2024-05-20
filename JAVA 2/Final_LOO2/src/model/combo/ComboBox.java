/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.combo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import view.Frame;
import com.mysql.cj.jdbc.Driver; // Example using MySQL Connector/J driver

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.connection.ConnectionFactory;

/**
 *
 * @author zuria
 */
public class ComboBox {

    private static final String sqlGetidModeloMotocicleta = "select idmodeloMotocicleta from modeloMotocicleta where modelo=?";
    private static final String sqlGetidModeloAutomovel = "select idmodeloAutomovel from modeloAutomovel where modelo=?";
    private static final String sqlGetidModeloVan = "select idmodeloVan from modeloVan where modelo=?";
    private static final String sqlGetidVeiculo = "select idveiculo from veiculo where placa=?";
    private static final String sqlGetidEstado = "select idestado from estado where estado=?";
    private static final String sqlGetidMarca = "select idmarca from marca where marca=?";
    private static final String sqlGetidCategoria = "select idCategoria from categoria where categoria=?";
    private static final String sqlGetidLocacao = "select idlocacao from locacao where idveiculo = ? && data = ?";
    private static final String sqlModeloMotocicleta = "select modelo from ModeloMotocicleta where idmarca=? and idcategoria=? order by modelo";
    private static final String sqlModeloAutomovel = "select modelo from ModeloAutomovel where idmarca=? and idcategoria=? order by modelo";
    private static final String sqlModeloVan = "select modelo from ModeloVan where idmarca=? and idcategoria=? order by modelo";
    private static final String sqlMarcas = "select marca from marca order by marca";
    private static final String sqlCategorias = "select categoria from categoria";

    public static void loadCboxModelo(JComboBox<Object> cbox, String type, String marca, String categoria) {
        cbox.removeAllItems();
        ResultSet rs;
        int idmarca = getIdMarca(marca);
        int idcategoria = getIdCategoria(categoria);
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

    public static int getIdEstado(String estado) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlGetidEstado);) {
            stmt.setString(1, estado);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idmarca");
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.getIdEstado(): " + e.getMessage());
        }
        return 0;
    }

    public static int getIdMarca(String marca) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlGetidMarca);) {
            stmt.setString(1, marca);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idmarca");
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.getIdMarca(): " + e.getMessage());
        }
        return 0;
    }

    public static int getIdCategoria(String categoria) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlGetidCategoria);) {
            stmt.setString(1, categoria);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idcategoria");
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.getIdCategoria(): " + e.getMessage());
        }
        return 0;
    }

    public static int getIdVeiculo(String placa) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlGetidVeiculo);) {
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idveiculo");
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.getIdEstado(): " + e.getMessage());
        }
        return 0;
    }

    public static int getIdLocacao(int idveiculo, Calendar data) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlGetidLocacao);) {
            stmt.setInt(1, idveiculo);
            Date sqldate = driver.calendarToUtilDate(data);
            stmt.setDate(2, d);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idmarca");
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.getIdMarca(): " + e.getMessage());
        }
        return 0;
    }
    
    public static int getIdmodelo(String type, String modelo) {
        try {
            switch (type) {
                case "Motocicleta" -> {
                    try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlGetidModeloMotocicleta);) {
                        stmt.setString(1, modelo);
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            return rs.getInt("idmodeloMotocicleta");
                        }
                    }
                }
                case "Automovel" -> {
                    try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlGetidModeloAutomovel);) {
                        stmt.setString(1, modelo);
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            return rs.getInt("idmodeloAutomovel");
                        }
                    }
                }
                case "Van" -> {
                    try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlGetidModeloVan);) {
                        stmt.setString(1, modelo);
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            return rs.getInt("idmodeloVan");
                        }
                    }
                }
                default -> {
                }
            }

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.getIdModelo(): " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

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
