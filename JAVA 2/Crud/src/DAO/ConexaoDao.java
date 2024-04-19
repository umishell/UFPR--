package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDao {

    public Connection connectDB() {
        Connection conn;

        try {
            String url,user,password;
            url = "jdbc:mysql://localhost:3306/crud";
            user = "root";
            password = "Azukiaraiazukitogi#3";
            conn = DriverManager.getConnection(url,user,password);
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "@ConexaoDao: " + e.getMessage());
            return null;
        }

    }

}
