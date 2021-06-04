package vacunargrupo4.modelos;

import java.time.LocalDate;
import java.util.Date;

public class Persona {

    private String nombre;
    private String apellido;
    private String email;
    private String localidad;
    private String direccion;
    private String aLaboral;
    private int idPersona;
    private int dni;
    private int celular;
    private LocalDate fechaNac;
    private int idPatologia=1;

    public Persona(String nombre, String apellido, String email, String localidad, String direccion, String aLaboral, int dni, int celular, LocalDate fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.localidad = localidad;
        this.direccion = direccion;
        this.aLaboral = aLaboral;
        this.dni = dni;
        this.celular = celular;
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", idPersona=" + idPersona + '}';
    }

   
    public Persona(String n, String a, int dni, Date fecha) {
    }

    public int getIdPatologia() {
        return idPatologia;
    }

    public void setIdPatologia(int idPatologia) {
        this.idPatologia = idPatologia;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getaLaboral() {
        return aLaboral;
    }

    public void setaLaboral(String aLaboral) {
        this.aLaboral = aLaboral;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
}
