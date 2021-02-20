/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gustavo
 */
public class Conexion {
    private String jdbcURL = "jdbc:mysql://localhost:8889/evaluacion?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false";
    private String dbUser = "root";
    private String dbPassword = "root";
    
    public Usuario Login(String correo, String password) throws ClassNotFoundException, SQLException{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM usuario WHERE mail = ? and pass = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, correo);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        Usuario user = null;
 
        if (result.next()) {
            user = new Usuario();
            user.setNombre(result.getString("nombre"));
            user.setApellido(result.getString("apPaterno"));
            user.setMail(correo);
        }
 
        connection.close();
 
        return user;
    }
}
    

