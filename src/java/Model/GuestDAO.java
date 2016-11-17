/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


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
public class GuestDAO {

    private Connection conn;
    
    public GuestDAO() {
        conn = DBConnection.getConnection();
    }
    
    public void addGuest(Guest guest)
    {
        try {
            String sql = "INSERT INTO huespedes(idhuespedes,namehuesped,telephonehuesped,cedulahuesped,emaihuesped,daysStayed,numRoom,payment) "+
                    "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, guest.getId());
            pstm.setString(2,guest.getName());
            pstm.setString(3, guest.getTelephone());
            pstm.setString(4, guest.getCedula());
            pstm.setString(5, guest.getEmail());
            pstm.setInt(6, guest.getDaysStay());
            pstm.setInt(7, guest.getNumRoom());
            pstm.setInt(8, guest.getPayment());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar a "+guest.getName()+" : "+ex);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeGuest(int guestID)
    {
        try {
            String sql = "DELETE FROM huespedes WHERE idhuespedes=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, guestID);
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al Borrar al usuario "+guestID+" : "+ex);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editGuest(Guest guest)
    {
        try {
            String sql = "UPDATE huespedes set namehuesped =?, telephonehuesped=?, cedulahuesped=?, emaihuesped=?, daysStayed=?, numRoom=?, payment=? where idhuespedes=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, guest.getName());
            pstm.setString(2, guest.getTelephone());
            pstm.setString(3, guest.getCedula());
            pstm.setString(4, guest.getEmail());
            pstm.setInt(5, guest.getDaysStay());
            pstm.setInt(6, guest.getNumRoom());
            pstm.setInt(7, guest.getPayment());
            pstm.setInt(8, guest.getId());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al editar al huesped "+guest.getId()+" : "+ex);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List getAllGuest(){
        List listGuests = new ArrayList();
        
        
        try {
            String sql = "SELECT * FROM huespedes";    
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                Guest guest = new Guest();
                guest.setId(rs.getInt("idhuespedes"));
                guest.setName(rs.getString("namehuesped"));
                guest.setTelephone(rs.getString("telephonehuesped"));
                guest.setCedula(rs.getString("cedulahuesped"));
                guest.setEmail(rs.getString("emaihuesped"));
                guest.setDaysStay(rs.getInt("daysStayed"));
                guest.setNumRoom(rs.getInt("numRoom"));
                guest.setPayment(rs.getInt("payment"));
                listGuests.add(guest);
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar todos los huespedes : "+ex);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listGuests;
    }
    public Guest getGuestbyID(int guestID)
    {
        Guest guest = new Guest();
        try {
            String sql = "SELECT * FROM huespedes WHERE idhuespedes=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, guestID);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
               guest.setId(rs.getInt("idhuespedes"));
                guest.setName(rs.getString("namehuesped"));
                guest.setTelephone(rs.getString("telephonehuesped"));
                guest.setCedula(rs.getString("cedulahuesped"));
                guest.setEmail(rs.getString("emaihuesped"));
                guest.setDaysStay(rs.getInt("daysStayed"));
                guest.setNumRoom(rs.getInt("numRoom"));
                guest.setPayment(rs.getInt("payment"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return guest;
    }
    
}
