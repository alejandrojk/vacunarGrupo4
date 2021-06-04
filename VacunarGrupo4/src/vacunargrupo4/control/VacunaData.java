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
import vacunargrupo4.modelos.Vacuna;

/**
 *
 * @author Maxi
 */
public class VacunaData {
    private Connection con;
    ArrayList<Vacuna> loteVacunas = new ArrayList();
    public VacunaData(Conexion conexion){
        try{
            con = conexion.getConexion();
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"error de conexion persona");
        }
    }


public void ingresarLote(Vacuna vacuna,int cantidad){
    Vacuna nueva;
    
    for (int i=0;i<cantidad;i++){
        int nroSerie = 100+i;
        try{
            String sql="INSERT INTO vacuna (idLaboratorio,nroSerie,estado) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            nueva = vacuna;
            ps.setInt(1,nueva.getLaboratorio().getId());
            ps.setInt(2,nueva.getNroSerie());
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



}

