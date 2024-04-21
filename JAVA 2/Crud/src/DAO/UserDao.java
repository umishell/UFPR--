package DAO;

import DTO.User;
import java.sql.*;
import javax.swing.JOptionPane;

public class UserDao {

    Connection conn; //access globally

    public ResultSet userAutentication(User user) {
        conn = new ConexaoDao().connectDB();
        try {
            String sql = "select * from user where name = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "@UserDao: " + e.getMessage());
            return null;
        }
    }
}
