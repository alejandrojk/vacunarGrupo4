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
import vacunargrupo4.modelos.Vacuna;
import vacunargrupo4.modelos.Vacuna;

/**
 *
 * @author Maxi
 */
public class VacunaData {
    private Connection con;
    private Conexion aux;
    ArrayList<Vacuna> loteVacunas = new ArrayList();
    public VacunaData(Conexion conexion){
        try{
            con = conexion.getConexion();
            this.aux=conexion;
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"error de conexion persona");
        }
    }


public void ingresarLote(Vacuna nueva,int cantidad,int serie){
    
    
    for (int i=0;i<cantidad;i++){
        int nroSerie = Integer.valueOf(String.valueOf(serie) + String.valueOf(00056)+String.valueOf(i));
        
        try{
            String sql="INSERT INTO vacuna (laboratorio,nroSerie,estado) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1,nueva.getLaboratorio().getId());
            ps.setInt(2,nroSerie);
            ps.setBoolean(3, nueva.isEstado());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                nueva.setId(rs.getInt(1));
            }
            ps.close();
        }catch (SQLException ex) {
            Logger.getLogger(PersonaData.class.getName()).log(Level.SEVERE,null,ex);
        }    
    }
}

public ArrayList<Vacuna> obtenerVacunas(){
        Vacuna vacuna;
        ArrayList <Vacuna> vacunas = new ArrayList(); 
        
        try{
            String sql = "SELECT * FROM vacuna WHERE estado=true";
            PreparedStatement ps = con.prepareStatement(sql);
            
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                vacuna = new Vacuna();
                vacuna.setId(rs.getInt("idVacuna"));
                LabData lab = new LabData(aux);
                vacuna.setLaboratorio((lab.buscarLaboratorio(rs.getInt("laboratorio"))));
                vacuna.setNroSerie(rs.getInt("nroSerie"));
                vacuna.setEstado(rs.getBoolean("estado"));                                              
                vacunas.add(vacuna);
            }
            ps.close();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"error de conexion buscando todos los vacunas registrados");
        }
        return vacunas;
    }

public Vacuna obtenerVacuna(int nroSerie){
        Vacuna vacuna=null;
                
        try{
            String sql = "SELECT * FROM vacuna WHERE nroSerie=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nroSerie);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                vacuna = new Vacuna();
                vacuna.setId(rs.getInt("idVacuna"));
                LabData lab = new LabData(aux);
                vacuna.setLaboratorio((lab.buscarLaboratorio(rs.getInt("laboratorio"))));
                vacuna.setNroSerie(rs.getInt("nroSerie"));
                vacuna.setEstado(rs.getBoolean("estado"));                                              
            }
            ps.close();
        }catch(SQLException ex){
        }
        if (vacuna!=null){
            return vacuna;
        }else{
            JOptionPane.showMessageDialog(null, "No se encuentra una vacuna con Numero de Serie: "+nroSerie);
            return vacuna;
        }       
    }

    public void cambiarEstado(int nroSerie){ 
        Vacuna vac = obtenerVacuna(nroSerie);

            if (vac.isEstado()){
               try{
                String sql="UPDATE vacuna SET estado=false WHERE nroSerie=?";
                PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, nroSerie);

                ps.executeUpdate();
                ps.close();
                }catch (SQLException ex) {JOptionPane.showMessageDialog(null, "No puedo cambiarse el estado de la vacuna ID: "+nroSerie);} 
            }else{
                try{
                String sql="UPDATE vacuna SET estado=true WHERE nroSerie=?";
                PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, nroSerie);

                ps.executeUpdate();
                ps.close();
                }catch (SQLException ex) {JOptionPane.showMessageDialog(null, "No puedo cambiarse el estado de la vacuna ID: "+nroSerie);}
            }
    }
}


