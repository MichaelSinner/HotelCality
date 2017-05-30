/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.uan.restaurante.Connection.DBConnection;
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
public class PlatoDAO {
    private Connection conn;

    public PlatoDAO() {
        conn = DBConnection.getConnection();
    }
    
    public void addPlato(Plato plato)
    {
        try {
            String sql = "INSERT INTO platos(idplatos,nombre,descripcion,complejidad,precio,region,servicio,receta) "+
                    "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, plato.getIdPlato());
            pstm.setString(2, plato.getNombre());
            pstm.setString(3, plato.getDescripcion());
            pstm.setInt(4, plato.getComplejidad());
            pstm.setInt(5, plato.getPrecio());
            pstm.setString(6, plato.getRegion());
            pstm.setString(7, plato.getServicio());
            pstm.setString(8, plato.getReceta());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar el plato "+plato.getIdPlato()+" : "+ex);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removePlato(int platoID)
    {
        try {
            String sql = "DELETE FROM platos WHERE idplatos=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, platoID);
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al Borrar el plato "+platoID+" : "+ex);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editPlato(Plato plato)
    {
       try {
            String sql = "UPDATE platos set nombre =?, descripcion=?, complejidad=?, precio=?, region=?, servicio=?, receta=? where idplatos=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, plato.getNombre());
            pstm.setString(2, plato.getDescripcion());
            pstm.setInt(3, plato.getComplejidad());
            pstm.setInt(4, plato.getPrecio());
            pstm.setString(5, plato.getRegion());
            pstm.setString(6, plato.getServicio());
            pstm.setString(7, plato.getReceta());
            pstm.setInt(8, plato.getIdPlato());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al editar el plato "+plato.getIdPlato()+" : "+ex);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List getAllPlatos(){
        List listPlatos = new ArrayList();
        
        
        try {
            String sql = "SELECT * FROM platos";    
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                Plato plato= new Plato();
                
                plato.setIdPlato(rs.getInt("idplatos"));
                plato.setNombre(rs.getString("nombre"));
                plato.setDescripcion(rs.getString("descripcion"));
                plato.setComplejidad(rs.getInt("complejidad"));
                plato.setPrecio(rs.getInt("precio"));
                plato.setRegion(rs.getString("region"));
                plato.setServicio(rs.getString("servicio"));
                plato.setReceta(rs.getString("receta"));
                
                listPlatos.add(plato);
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar todos los platos : "+ex);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPlatos;
    }
    
    public Plato getPlatobyID(int platoID){
    
        Plato plato = new Plato();
         
        try {
            String sql = "SELECT * FROM huespedes WHERE idhuespedes=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, platoID);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                plato.setIdPlato(rs.getInt("idplatos"));
                plato.setNombre(rs.getString("nombre"));
                plato.setDescripcion(rs.getString("descripcion"));
                plato.setComplejidad(rs.getInt("complejidad"));
                plato.setPrecio(rs.getInt("precio"));
                plato.setRegion(rs.getString("region"));
                plato.setServicio(rs.getString("servicio"));
                plato.setReceta(rs.getString("receta"));
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return plato;
    }
    
}

 