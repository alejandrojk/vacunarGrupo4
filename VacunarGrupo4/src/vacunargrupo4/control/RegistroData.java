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
       
public ArrayList<RegistroVacunados> obtenerVacunados(){
                RegistroVacunados r = null;
                ArrayList<RegistroVacunados> rv = new ArrayList();

                try{
                String sql = "SELECT * FROM registrovacunados WHERE fechaAplicacion BETWEEN CURRENT_DATE - INTERVAL 30 DAY AND CURRENT_DATE\n";
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
               JOptionPane.showMessageDialog(null,"error de conexion buscando todas los vacunados");
            }
            return rv;
        }
    
    
}
