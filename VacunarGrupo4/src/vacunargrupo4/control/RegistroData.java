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
       
public ArrayList<RegistroVacunados> obtenerVacunados(){
                RegistroVacunados r = null;
                ArrayList<RegistroVacunados> rv = new ArrayList();
                

                try{
                String sql = "SELECT * FROM registrovacunados";
                PreparedStatement ps = con.prepareStatement(sql);


                ResultSet rs=ps.executeQuery();

                while(rs.next()){
                    
                    r = new RegistroVacunados();
                    Vacuna v = buscarVacuna(rs.getInt("vacuna"));
                    Citas c = buscarCita(rs.getInt("idCita"));                    
                    r.setVacuna(v);                  
                    r.setIdVacuna(v.getId());
                    r.setId(rs.getInt("idRegistrados"));                                    
                    r.setCitas(c);
                    r.setIdCita(c.getId());
                    r.setDosis(rs.getString("dosis"));
                    r.setFecha(rs.getDate("fechaAplicacion"));
                    rv.add(r);
                    
                    
                }
                ps.close();
            }catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"error de conexion buscando todas los vacunados");
            }
            return rv;
        }
    
 public boolean isVacunado(int dni,String motivo){
     Persona persona = new Persona();
     RegistroVacunados reg = new RegistroVacunados();
     PersonaData pd = new PersonaData(aux);
     persona = pd.buscarPersona(dni);
        
     try{
        String sql = "SELECT dosis FROM persona p,citas c,registrovacunados rv WHERE rv.idCita=c.idCitas AND c.idPersona="+persona.getIdPersona();
        PreparedStatement ps = con.prepareStatement(sql);      
        
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){               
                reg.setDosis(rs.getString("dosis"));               
            }
            ps.close();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"error is vacunado");
        }
     
        
     return reg.getDosis().equals(motivo);
        
 }
 
 public Vacuna buscarVacuna(int nroserie){
            Vacuna v;
            VacunaData vd = new VacunaData(aux);            
            v=vd.obtenerVacuna(nroserie);
            return v;               
        }
 public Citas buscarCita(int id) throws SQLException{
            Citas c;
            CitasData pd = new CitasData(aux);            
            c=pd.buscarCita(id);
            return c;               
        }
 public Persona buscarPersonaId(int id){
            Persona p;
            PersonaData pd = new PersonaData(aux);            
            p=pd.buscarPersonaId(id);
            return p;               
        }
 
}
