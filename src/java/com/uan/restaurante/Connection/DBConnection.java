/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uan.restaurante.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection 
{
    private static Connection conn = null;
    
    public static Connection getConnection(){
        if(conn != null)
        {
            return conn;
        }
        else{
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/db_restaurante";
                String user = "root";
                String password = "root";
                
                conn = DriverManager.getConnection(url, user, password);
                
                System.out.println("Conexion exitosa");
                
            } catch (ClassNotFoundException ex) {
                System.out.println("Driver +"+ex);
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                System.out.println("SQLException : "+ex);
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return conn;
        }
    }
}
