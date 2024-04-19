/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.User;
import java.sql.Connection;
import java.sql.ResultSet;



/**
 *
 * @author Pichau
 */
public class UserDao {
    
    Connection conn;
     
    public ResultSet userAutentication(User user){
        conn = new ConexaoDao().connectDB();
        try {
            
        } catch (Exception e) {
        }
    }
            
}
