/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.combo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import view.Frame;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.connection.ConnectionFactory;

/**
 *
 * @author zuria
 */
public class ComboBox {

    private static final String sqlGetidMarca = "select idmarca from marca where marca=?";
    private static final String sqlModeloMotocicleta = "select modelo from ModeloMotocicleta where idmarca=? order by modelo";
    private static final String sqlModeloAutomovel = "select modelo from ModeloAutomovel where idmarca=? order by modelo";
    private static final String sqlModeloVan = "select modelo from ModeloVan where idmarca=? order by modelo";
    private static final String sqlMarcas = "select marca from marca order by marca";
    
    public static void loadCboxModelo(JComboBox<Object> cbox, String type, int idmarca) {
        ResultSet rs;
        try {
            switch (type) {
                case "Motocicleta" -> {
                    try (Connection conn = ConnectionFactory.getConnection(); 
                         PreparedStatement stmtModelo = conn.prepareStatement(sqlModeloMotocicleta);) {
                         stmtModelo.setInt(1,idmarca);
                         rs = stmtModelo.executeQuery();
                        while (rs.next()) {
                            cbox.addItem(rs.getString("modelo"));
                        }
                    }
                }
                case "Automóvel" -> {
                    try (Connection conn = ConnectionFactory.getConnection(); 
                         PreparedStatement stmtModelo = conn.prepareStatement(sqlModeloAutomovel);) {
                         stmtModelo.setInt(1,idmarca);
                         rs = stmtModelo.executeQuery();
                        while (rs.next()) {
                            cbox.addItem(rs.getString("modelo"));
                        }
                    }
                }
                case "Van" -> {
                    try (Connection conn = ConnectionFactory.getConnection(); 
                         PreparedStatement stmtModelo = conn.prepareStatement(sqlModeloVan);) {
                         stmtModelo.setInt(1,idmarca);
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
            JOptionPane.showMessageDialog(null, "@Frame.loadCboxModelo(): " + e.getMessage());
        }
    }

    public static int getIdMarca(String marca){
        try (Connection conn = ConnectionFactory.getConnection(); 
            PreparedStatement stmtModelo = conn.prepareStatement(sqlGetidMarca);) {
            stmtModelo.setString(1, marca);
            ResultSet rs = stmtModelo.executeQuery();
            while (rs.next()) {
                return rs.getInt("idmarca");
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@Frame.loadCboxModelo(): " + e.getMessage());
        }
        return 0;
    }
    
    public static void loadCboxMarca(JComboBox<String> cbox) {
        try (Connection conn = ConnectionFactory.getConnection(); 
            PreparedStatement stmtMarca = conn.prepareStatement(sqlMarcas);) {
            ResultSet rs = stmtMarca.executeQuery();
                while (rs.next()) {
                    cbox.addItem(rs.getString("marca"));
                }
        }catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.loadCboxMarca(): " + e.getMessage());
        }
    }
}
