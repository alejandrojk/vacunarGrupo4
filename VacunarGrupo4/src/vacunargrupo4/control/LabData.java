/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunargrupo4.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vacunargrupo4.modelos.Laboratorio;


/**
 *
 * @author Maxi
 */
public class LabData {
    
    private Connection con;
    public LabData(Conexion conexion){
        try{
           con = conexion.getConexion();
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"error de conexion lab");
        }
    }
    
    public Laboratorio buscarLaboratorio(String nombreComercial){
        Laboratorio lab=null;
        try{
            String sql = "SELECT * FROM laboratorio WHERE nombreComercial=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreComercial);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                lab = new Laboratorio();
                lab.setNombre(rs.getString("nombreComercial"));
                lab.setDireccion(rs.getString("direccion"));
                lab.setPaisOrigen(rs.getString("paisOrigen"));
                lab.setId(rs.getInt("idLaboratorio"));
                
            }
            ps.close();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"error de conexion buscando Laboratorio");
        }
        return lab;
    }
    public Laboratorio buscarLaboratorio(int id){
        Laboratorio lab=null;
        try{
            String sql = "SELECT * FROM laboratorio WHERE idLaboratorio=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                lab = new Laboratorio();
                lab.setNombre(rs.getString("nombreComercial"));
                lab.setDireccion(rs.getString("direccion"));
                lab.setPaisOrigen(rs.getString("paisOrigen"));
                lab.setId(id);
                
            }
            ps.close();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"error de conexion buscando Laboratorio");
        }
        return lab;
    }
    
    public ArrayList<Laboratorio> obtenerLaboratorios(){
        Laboratorio laboratorio;
        ArrayList <Laboratorio> laboratorios = new ArrayList(); 
        
        try{
            String sql = "SELECT * FROM laboratorio";
            PreparedStatement ps = con.prepareStatement(sql);
            
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                laboratorio = new Laboratorio();
                laboratorio.setId(rs.getInt("idLaboratorio"));
                laboratorio.setNombre(rs.getString("nombreComercial"));
                laboratorio.setDireccion(rs.getString("direccion"));
                laboratorio.setPaisOrigen(rs.getString("paisOrigen"));                                              
                laboratorios.add(laboratorio);
            }
            ps.close();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"error de conexion buscando todos los laboratorios registrados");
        }
        return laboratorios;
    }

    
    public void registrarLaboratorio(Laboratorio lab){
        try{
            String sql="INSERT INTO laboratorio (paisOrigen,nombreComercial,direccion) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, lab.getPaisOrigen());
            ps.setString(2, lab.getNombre());
            ps.setString(3, lab.getDireccion());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                lab.setId(rs.getInt(1));
            }
            ps.close();
        }catch (SQLException ex) {
            Logger.getLogger(LabData.class.getName()).log(Level.SEVERE,null,ex);
        }    
    }
    
    public void borrarLaboratorio(int nombreComercial){
        
        try{
            String sql="DELETE FROM laboratorio WHERE nombreComercial=?";
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, nombreComercial);
            
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error de conexion al borrar laboratorio");
        }
    }
    
    public void actualizarLaboratorio(Laboratorio lab, int nombreComercial){
        try{
            String sql = "UPDATE `laboratorio` SET paisOrigen=?,nombreComercial=?,direccion=? WHERE nombreComercial=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, lab.getPaisOrigen());
            ps.setString(2, lab.getNombre());
            ps.setString(3,lab.getDireccion());
            ps.setInt(4,nombreComercial);
                       
            ps.executeUpdate();            
            ps.close();
        }catch (SQLException ex) {
            Logger.getLogger(LabData.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
