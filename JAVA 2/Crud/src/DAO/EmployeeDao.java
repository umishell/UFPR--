package DAO;

import DTO.Employee;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class EmployeeDao {

    Connection conn; //access globally
    PreparedStatement stmt;
    ResultSet rs;
    ArrayList<Employee> employees = new ArrayList<>();

    public void registerEmployee(Employee emp) {
        conn = new ConexaoDao().connectDB();
        try {
            String sql = "insert into employee (name, address) values (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getAddress());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "register successful.");
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "@EmployeeDao.registerEmployee() : " + e.getMessage());
        }
    }

    public ArrayList<Employee> searchAll() {
        conn = new ConexaoDao().connectDB();
        try {
            String sql = "select * from employee";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            Employee emp;
            while (rs.next()) {
                emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAddress(rs.getString("address"));
                employees.add(emp);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "@EmployeeDao.search(): " + e.getMessage());
            return null;
        }
        return employees;
    }
    
    public void updateEmployee(Employee emp){
        conn = new ConexaoDao().connectDB();
        try {
            String sql = "update employee set name = ?, address = ? where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getAddress());
            stmt.setInt(3, emp.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "update successful.");
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "@EmployeeDao.updateEmployee() : " + e.getMessage());
        }
    }
    
    public void deleteEmployee(int id){
        conn = new ConexaoDao().connectDB();
        try {
            String sql = "delete from employee where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "employee deleted.");
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "@EmployeeDao.deleteEmployee() : " + e.getMessage());
        }
    }
}
