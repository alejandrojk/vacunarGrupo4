/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunargrupo4.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.JOptionPane;
import vacunargrupo4.modelos.Citas;
import vacunargrupo4.modelos.Conexion;


/**
 *
 * @author Usuario
 */
public class CitasData {
    
    private Connection con;
    public CitasData(Conexion conexion){
        try{
            con = conexion.getConexion();
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"error de conexion persona");
        }
    }
    
     public void actualizarCita(Citas citas, int id){
        try{
            String sql = "UPDATE citas SET idCentro=?, motivo=?, horaTurno=?, fecha=?, estado=?, WHERE idPersona=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, (citas.getCentro().getIdCentro()));
            ps.setString(2, citas.getMotivo());
            ps.setDate(3, Date.valueOf(citas.getFecha()));
            ps.setTime(5, Time.valueOf(citas.getHora()));    
            ps.setBoolean(1, (citas.getEstado()));
                    
            ps.executeUpdate();
            
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error de conexion");
        }
    
    }
    
    
}

