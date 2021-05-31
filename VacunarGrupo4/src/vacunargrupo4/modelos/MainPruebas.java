package vacunargrupo4.modelos;

import javax.swing.JOptionPane;
import vacunargrupo4.control.PersonaData;
import java.sql.*;
import vacunargrupo4.control.CitasData;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxi
 */ 
public class MainPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conexion = null;
        try{
          conexion = new Conexion("jdbc:mysql://localhost/vacunar", "root", "");
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error de driver");
        }
        Laboratorio aztrazeneca = new Laboratorio("azrazeneca","Ohio","USA");
        Date fechaNac = new Date(112-05-11);
        Persona p = new Persona("Maxi","Rodriguez","aaacnon","Villa Mercedes","ajaaoifjio","Esencial",34104,26573,2,fechaNac);
        PersonaData pd = new PersonaData(conexion);
        Vacuna vac = new Vacuna(8,25554,aztrazeneca);
        CtroVacunacion ctroVM = new CtroVacunacion();
         Date fecha2 = new Date(121,12,5);
         Time hora2 = new Time(10,45,00);
        Citas cts = new Citas(vac,ctroVM,p,"primera dosis",fecha2,hora2,false);
        CitasData cd = new CitasData(conexion);
        cd.actualizarCita(cts, 2);
    }
    
}
