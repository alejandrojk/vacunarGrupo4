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
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vacunargrupo4.modelos.Citas;
import vacunargrupo4.modelos.Conexion;
import vacunargrupo4.modelos.Persona;

/**
 *
 * @author Usuario
 */
public class PersonaData {
    private Connection con;
    public PersonaData(Conexion conexion){
        try{
            con = conexion.getConexion();
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"error de conexion persona");
        }
    }
   

    
    public void registrarPersona(Persona persona){
        try{
            String sql="INSERT INTO persona (nombre,apellido,dni,fechaNacimiento,email,celular,localidad,direccion,idPatologia,ambitoLaboral) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setInt(3, persona.getDni());
            ps.setDate(4, (Date) persona.getFechaNac());
            ps.setString(5,persona.getEmail());
            ps.setInt(6, persona.getCelular());
            ps.setString(7,persona.getLocalidad());
            ps.setString(8, persona.getDireccion());
            ps.setInt(9, persona.getIdPatologia());
            ps.setString(10, persona.getaLaboral());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                persona.setIdPersona(rs.getInt(1));
            }
            ps.close();
        }catch (SQLException ex) {
            Logger.getLogger(PersonaData.class.getName()).log(Level.SEVERE,null,ex);
        }    
    }







}
    

