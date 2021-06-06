package vacunargrupo4.modelos;

import vacunargrupo4.control.Conexion;
import javax.swing.JOptionPane;
import vacunargrupo4.control.PersonaData;
import java.sql.*;
import java.time.LocalDate;
import vacunargrupo4.control.CitasData;
import vacunargrupo4.control.CtroData;
import vacunargrupo4.control.LabData;
import vacunargrupo4.control.RegistroData;
import vacunargrupo4.control.VacunaData;


public class MainPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Conexion conexion = null;
        try{
          conexion = new Conexion("jdbc:mysql://localhost/vacunar","root", "");
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error de driver");
        }
        
        
        LabData lab = new LabData(conexion);
        Laboratorio lb = lab.buscarLaboratorio("Pfizer");  
        VacunaData vc = new VacunaData(conexion);
        Vacuna vac = vc.obtenerVacuna(8490001);
        CtroData cc = new CtroData(conexion);
        CtroVacunacion ctroVM = cc.buscarCtroVacunacion("Policlinico vm");
        LocalDate fechaNac = LocalDate.of(1974,2,12); 
        PersonaData pe = new PersonaData(conexion);
        Persona h = pe.buscarPersona(34104821);
        Date fecha2 = new Date(121,12,5);
        Time hora2 = new Time(10,45,00);
        Citas cts = new Citas(vac,ctroVM,h,"primera dosis",fecha2,hora2,true);
        CitasData cd = new CitasData(conexion);
        //cd.fijarTurno(cts);
        RegistroVacunados rv = new RegistroVacunados(vac,cts);
        RegistroData rd = new RegistroData(conexion);
        rd.aplicarVacuna(vac, cts);
        //System.out.println(vac);
        
       
        //PRUEBAS EN CLASE PERSONA DATA
        //pe.registrarPersona(h);
        //System.out.println(pe.buscarPersona(4515746));
        //pe.actualizarPersona(h, 34104821);
        //pe.borrarPersona(4515746);
//        System.out.println(pe.obtenerPersonas());
//        
        
//      System.out.println(lab.buscarLaboratorio("oxford"));
        
        
        //System.out.println(centro.buscarCtroVacunacion("Poli"));
        
        //PRUEBAS VACUNA DATA
      
//      vc.ingresarLote(vac, 4);
//      vc.cambiarEstado(84930004);
      
    }
    
}
