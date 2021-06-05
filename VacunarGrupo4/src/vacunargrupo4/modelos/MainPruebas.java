package vacunargrupo4.modelos;

import vacunargrupo4.control.Conexion;
import javax.swing.JOptionPane;
import vacunargrupo4.control.PersonaData;
import java.sql.*;
import java.time.LocalDate;
import vacunargrupo4.control.CitasData;
import vacunargrupo4.control.CtroData;
import vacunargrupo4.control.LabData;
import vacunargrupo4.control.VacunaData;


public class MainPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conexion = null;
        try{
          conexion = new Conexion("jdbc:mysql://localhost/vacunar","root", "");
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error de driver");
        }
        
        
//        Persona p = new Persona("Maxi","Rodriguez","aaacnon","Villa Mercedes","ajaaoifjio","Esencial",34104,26573,2,fechaNac);
//        PersonaData pd = new PersonaData(conexion);
        
        CtroVacunacion ctroVM = new CtroVacunacion();
//         Date fecha2 = new Date(121,12,5);
//         Time hora2 = new Time(10,45,00);
//        Citas cts = new Citas(vac,ctroVM,p,"primera dosis",fecha2,hora2,false);
//        CitasData cd = new CitasData(conexion);
//        cd.actualizarCita(cts, 2);
        
        LocalDate fechaNac = LocalDate.of(1978, 03, 16);
        Persona h = new Persona ("Mayra","Ramos","lopez@hotmail.com","La Toma","Mitre 2360","Salud",11919361,26631592,fechaNac);
        PersonaData pe = new PersonaData(conexion);
        
        //PRUEBAS EN CLASE PERSONA DATA
        //pe.registrarPersona(h);
        //System.out.println(pe.buscarPersona(4515746));
        //pe.actualizarPersona(h, 34104821);
        //pe.borrarPersona(4515746);
//        System.out.println(pe.obtenerPersonas());
//        
        LabData lab = new LabData(conexion);
//      System.out.println(lab.buscarLaboratorio("oxford"));
        
        CtroData centro = new CtroData(conexion);
        //System.out.println(centro.buscarCtroVacunacion("Poli"));
        
      Laboratorio lb = lab.buscarLaboratorio("Pfizer");  
      Vacuna vac = new Vacuna(lb);
      VacunaData vc = new VacunaData(conexion);
      vc.ingresarLote(vac, 4);
      vc.cambiarEstado(84930004);
      
    }
    
}
