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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vacunargrupo4.modelos.Citas;
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
    
    public ArrayList<Persona> obtenerPersonas(){
        Persona persona;
        ArrayList <Persona> personas = new ArrayList(); 
        
        try{
            String sql = "SELECT * FROM persona";
            PreparedStatement ps = con.prepareStatement(sql);
            
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                persona = new Persona();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                persona.setDni(rs.getInt("dni"));
                persona.setAltura(rs.getInt("altura"));
                persona.setPeso(rs.getDouble("peso"));
                persona.setCelular(rs.getInt("celular"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setEmail(rs.getString("email"));
                persona.setLocalidad(rs.getString("localidad"));
                persona.setaLaboral(rs.getString("ambitoLaboral"));
                persona.setIdPatologia(rs.getInt("idPatologia"));
                personas.add(persona);
            }
            ps.close();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"error de conexion buscando todas las personas registradas");
        }
        return personas;
    }
   
    
    public Persona buscarPersona(int dni){
        Persona persona=null;
        try{
            String sql = "SELECT * FROM persona WHERE dni=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                persona = new Persona();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                persona.setDni(rs.getInt("dni"));
                persona.setPeso(rs.getDouble("peso"));
                persona.setCelular(rs.getInt("celular"));
                persona.setAltura(rs.getInt("altura"));
                persona.setEmail(rs.getString("email"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setLocalidad(rs.getString("localidad"));
                persona.setaLaboral(rs.getString("ambitoLaboral"));
                persona.setIdPatologia(rs.getInt("idPatologia"));
            }
            ps.close();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"error de conexion buscando persona");
        }
        return persona;
    }
    public Persona buscarPersonaId(int id){
        Persona persona=null;
        try{
            String sql = "SELECT * FROM persona WHERE idPersona=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                persona = new Persona();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                persona.setDni(rs.getInt("dni"));
                persona.setPeso(rs.getDouble("peso"));
                persona.setCelular(rs.getInt("celular"));
                persona.setAltura(rs.getInt("altura"));
                persona.setEmail(rs.getString("email"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setLocalidad(rs.getString("localidad"));
                persona.setaLaboral(rs.getString("ambitoLaboral"));
                persona.setIdPatologia(rs.getInt("idPatologia"));
            }
            ps.close();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"error de conexion buscando persona");
        }
        return persona;
    }

    
    public void registrarPersona(Persona persona){
        try{
            String sql="INSERT INTO persona (nombre,apellido,dni,fechaNacimiento,email,celular,localidad,direccion,idPatologia,ambitoLaboral,altura,peso) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setInt(3, persona.getDni());
            ps.setDate(4, null);
            ps.setString(5,persona.getEmail());
            ps.setInt(6, persona.getCelular());
            ps.setString(7,persona.getLocalidad());
            ps.setString(8, persona.getDireccion());
            ps.setInt(9, persona.getIdPatologia());
            ps.setString(10, persona.getaLaboral());
            ps.setInt(11, persona.getAltura());
            ps.setDouble(12, persona.getPeso());
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
    
    public void borrarPersona(int dni){
        
        try{
            String sql="DELETE FROM persona WHERE dni=?";
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dni);
            
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,"Operacion Realizada");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error DNI:"+dni+" tiene citas activas");
        }
    }
    
    public void actualizarPersona(Persona persona, int id){
        try{
            String sql = "UPDATE `persona` SET `idPatologia`=?,`nombre`=?,`apellido`=?,`email`=?,`celular`=?,`localidad`=?,`ambitoLaboral`=?,`dni`=?,`direccion`=?,fechaNacimiento=?,altura=?,peso=? WHERE idPersona=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido());
            ps.setString(4, persona.getEmail());
            ps.setInt(5,persona.getCelular());
            ps.setDate(10, Date.valueOf(persona.getFechaNac()));
            ps.setString(7,persona.getaLaboral());
            ps.setInt(1,persona.getIdPatologia());
            ps.setString(9,persona.getDireccion());
            ps.setString(6,persona.getLocalidad());
            ps.setInt(8, persona.getDni());
            ps.setInt(11,persona.getAltura());
            ps.setDouble(12, persona.getPeso());
            ps.setInt(13, id);
            
            ps.executeUpdate();
            
            ps.close();
        }catch (SQLException ex) {
            Logger.getLogger(PersonaData.class.getName()).log(Level.SEVERE,null,ex);
        }
    }







}
    

