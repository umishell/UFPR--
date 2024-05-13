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
import javax.swing.JOptionPane;
import model.connection.ConnectionFactory;

/**
 *
 * @author zuria
 */
public class ComboBox {
    
    private static final String sqlModeloMotocicleta = "select description from ModeloMotocicleta order by description";
    private static final String sqlModeloAutomovel = "select description from ModeloAutomovel order by description";
    private static final String sqlModeloVan = "select description from ModeloVan order by description";
    
    public static ResultSet showCboxModeloMotocicleta() {
         try (Connection conn = ConnectionFactory.getConnection(); 
             PreparedStatement stmtModelo = conn.prepareStatement(sqlModeloMotocicleta);)
        {
            return stmtModelo.executeQuery();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.showCboxModelo(): " + e.getMessage());
            return null;
        }
    }
    
    public static ResultSet showCboxModeloAutomovel() {
         try (Connection conn = ConnectionFactory.getConnection(); 
             PreparedStatement stmtModelo = conn.prepareStatement(sqlModeloAutomovel);)
        {
            return stmtModelo.executeQuery();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.showCboxModelo(): " + e.getMessage());
            return null;
        }
    }
    
    public static ResultSet showCboxModeloVan() {
         try (Connection conn = ConnectionFactory.getConnection(); 
             PreparedStatement stmtModelo = conn.prepareStatement(sqlModeloVan);)
        {
            return stmtModelo.executeQuery();

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@ComboBox.showCboxModelo(): " + e.getMessage());
            return null;
        }
    }

}
