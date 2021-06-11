
package vacunargrupo4.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vacunargrupo4.modelos.Patologia;

/**
 *
 * @author Maxi
 */
public class PatologiaData {

    Connection con;
    public PatologiaData(Conexion conexion) {
        try{
           con = conexion.getConexion();
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"error de conexion lab");
        }
    }
    
    
    public ArrayList<Patologia> obtenerPatologias(){
        Patologia patologia;
        ArrayList <Patologia> patologias = new ArrayList(); 
        
        try{
            String sql = "SELECT * FROM patologias";
            PreparedStatement ps = con.prepareStatement(sql);
            
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                patologia = new Patologia();
                patologia.setId(rs.getInt("idPatologia"));
                patologia.setNombre(rs.getString("nombre"));                                              
                patologias.add(patologia);
            }
            ps.close();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"error de conexion buscando todas las patologias registradas");
        }
        return patologias;
    }
    
    
}
