/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunargrupo4.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vacunargrupo4.modelos.Localidad;


public class LocalidadData {

    Connection con;
    public LocalidadData(Conexion conexion) {
        try{
            con = conexion.getConexion();
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"error de conexion en LocalidadData");
        }
    }
    
    public ArrayList<Localidad> obtenerLocalidads(){
        Localidad localidad;
        ArrayList <Localidad> localidades = new ArrayList(); 
        
        try{
            String sql = "SELECT * FROM localidades";
            PreparedStatement ps = con.prepareStatement(sql);
            
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                localidad = new Localidad();
                localidad.setId(rs.getInt("id"));
                localidad.setNombre(rs.getString("localidad"));                             
                localidades.add(localidad);
            }
            ps.close();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"error de conexion buscando localidades");
        }
        return localidades;
    }
    
}
