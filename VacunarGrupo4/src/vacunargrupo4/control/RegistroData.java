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
import vacunargrupo4.modelos.Citas;
import vacunargrupo4.modelos.CtroVacunacion;
import vacunargrupo4.modelos.Persona;
import vacunargrupo4.modelos.RegistroVacunados;
import vacunargrupo4.modelos.Vacuna;

/**
 *
 * @author Maxi
 */
public class RegistroData {

    private Connection con;
    private Conexion aux;
    public RegistroData(Conexion conexion){         
        try{
            con = conexion.getConexion();
            aux = conexion;
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"error de conexion en RegistroData");
        }
    }
    
    
    public void aplicarVacuna(Vacuna v,Citas c) {
            RegistroVacunados rv = new RegistroVacunados(v,c);
            
            try{
                String sql = "INSERT INTO registrovacunados (vacuna,idCita,fechaAplicacion) VALUES (?,?,?)";
                PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, rv.getVacuna().getNroSerie());
                ps.setInt(2, rv.getCitas().getId());
                ps.setDate(3, (Date) rv.getCitas().getFecha());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
            
                if(rs.next()){
                    rv.setId(rs.getInt(1));
                }
                ps.close();
                
                rv.getCitas().setEstado(false);
                rv.getVacuna().setEstado(false);
                JOptionPane.showMessageDialog(null, "Vacunao");
            
            }catch(NullPointerException r){} catch (SQLException ex) {
                Logger.getLogger(CitasData.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    public ArrayList<RegistroVacunados> obtenerVacunados(){
                RegistroVacunados r = null;
                ArrayList<RegistroVacunados> rv = new ArrayList();

                try{
                String sql = "SELECT * FROM `rs` WHERE fecha BETWEEN CURRENT_DATE - INTERVAL 30 DAY AND CURRENT_DATE\n" +
                "AND  estado=false;";
                PreparedStatement ps = con.prepareStatement(sql);


                ResultSet rs=ps.executeQuery();

                while(rs.next()){
                    r = new RegistroVacunados();
                    r.setId(rs.getInt("idRegistrados"));
                    r.setIdVacuna(rs.getInt("vacuna"));
                    r.setIdCita(rs.getInt("idCita"));
                    r.setFecha(rs.getDate("fechaAplicacion"));
                    rv.add(r);
                }
                ps.close();
            }catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"error de conexion buscando todas las rs registradas");
            }
            return rv;
        }
    

//    public Citas buscarCita(int id){
//        CitasData cv = new CitasData(aux);
//        return cv.buscarCita();
//    }
//    
//    public Vacuna buscarVacuna(int id){
//        VacunaData vd = new VacunaData(aux);          HACER METODO PARA BUSCAR CITAS Y VACUNA EN SUS CLASES
//        return vd.buscarVacuna(id);
//                
//    }
    
}
