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

    public void registerEmployee(Employee employee) {
        conn = new ConexaoDao().connectDB();
        try {
            String sql = "insert into employee (name, address) values (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getAddress());
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
}
