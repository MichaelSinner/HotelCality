/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.User;
import com.uan.hotelcality.Connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Sinner
 */
public class UserDAO 
{
    private Connection conn;
    
    public UserDAO()
    {
        conn = DBConnection.getConnection();
    }
    
    public void addUser(User user)
    {
        try {
            String sql = "INSERT INTO usuarios(idusuarios,email,pasword,nombre,tipoUsuario) "+"VALUES(?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, user.getId());
            pstm.setString(2, user.getMail());
            pstm.setString(3, user.getPassword());
            pstm.setString(4, user.getName());
            pstm.setInt(5, user.getTypeUser());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar a "+user.getName()+" : "+ex);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeUser(int userID)
    {
        try {
            String sql = "DELETE FROM usuarios WHERE idusuarios=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, userID);
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al Borrar al usuario "+userID+" : "+ex);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editUser(User user)
    {
        try {
            String sql = "UPDATE usuarios set email =?, pasword=?, nombre=?, tipoUsuario=? where idusuarios=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getMail());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getName());
            pstm.setInt(4, user.getTypeUser());
            pstm.setInt(5, user.getId());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al editar al ususario "+user.getId()+" : "+ex);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List getAllUsers(){
        List listUsers = new ArrayList();
        
        
        try {
            String sql = "SELECT * FROM usuarios";    
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                User user = new User();
                user.setId(rs.getInt("idusuarios"));
                user.setMail(rs.getString("email"));
                user.setPassword(rs.getString("pasword"));
                user.setName(rs.getString("nombre"));
                user.setTypeUser(rs.getInt("tipoUsurio"));
                listUsers.add(user);
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar todos los usuarios : "+ex);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUsers;
    }
    public User getUserbyID(int userID)
    {
        User user = new User();
        try {
            String sql = "SELECT * FROM usuarios WHERE idusuario=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, userID);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                user.setId(rs.getInt("idusuarios"));
                user.setMail(rs.getString("email"));
                user.setPassword(rs.getString("pasword"));
                user.setName(rs.getString("nombre"));
                user.setTypeUser(rs.getInt("tipoUsurio"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
    public boolean validate(User user)
    {
        
        boolean isValidated = false;
        String emailModel = null;
        String passwordModel = null;
        
        
        try {
            String sql = "select * from usuarios where email='"+user.getMail()+"' and pasword='"+user.getPassword()+"'";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            isValidated = rs.next();
          
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error validadndo :"+ex);
        }
         
        return isValidated;
                 
    }
    
}
