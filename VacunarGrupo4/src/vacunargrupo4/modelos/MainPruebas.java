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
        Vacuna vac = vc.obtenerVacuna(8490006);
        CtroData cc = new CtroData(conexion);
        CtroVacunacion ctroVM = cc.buscarCtroVacunacion("Policlinico vm");
        LocalDate fechaNac = LocalDate.of(1974,2,12); 
        PersonaData pe = new PersonaData(conexion);
        Persona h = pe.buscarPersona(34104821);
        Date fecha2 = new Date(121,12,5);
        Time hora2 = new Time(10,45,00);
        Citas cts = new Citas(vac,ctroVM,h,"primera dosis",fecha2,hora2,true);
        CitasData cd = new CitasData(conexion);
        cd.fijarTurno(cts);
        //cd.aplicarVacuna(vac, cts);
        RegistroVacunados rv = new RegistroVacunados(vac,cts);
        RegistroData rd = new RegistroData(conexion);                           
        // HASTA ACA, CREA TODAS LAS CLASES, OBTIENE DATOS YA CREADOS EN LA BD. CREA UNA CITA, OTORGA UN TURNO, APLICA LA VACUNA.
        // CAMBIA LOS ESTADOS DE LA CITA Y LA VACUNA APLICADAS Y LOS AGREGA EN EL REGISTRO DE VACUNADOS
        // FALTAN VALIDACIONES
        
        
        
        


        //cc.vacAplicadas("Policlinico vm");                            //LISTA VACUNAS APLICADAS Y DNI EN DETERMINADO CENTRO
        //System.out.println(rd.obtenerVacunados());                    //LISTA TODOS LOS VACUNADOS
        //System.out.println(cd.obtenerCitasPasadas());                 //LISTA CITAS CON ESTADO FALSE EN EL ULTIMO MES
        //System.out.println(vc.obtenerVacunas());                      //LISTA VACUNAS DISPONIBLES 
        //System.out.println(cc.cantidadAplicadas("Policlinico vm"));   //CANTIDAD APLICADAS EN DETERMINADO CENTRO




        //PRUEBAS EN CLASE PERSONA DATA
        //pe.registrarPersona(h);
        //System.out.println(pe.buscarPersona(4515746));
        //pe.borrarPersona(4515746);
//      System.out.println(pe.obtenerPersonas());
        
        
        //PRUEBAS VACUNA DATA
      
//      vc.ingresarLote(vac, 4);
//      vc.cambiarEstado(84930004);
      
    }
    
}
