package vacunargrupo4.modelos;

import java.util.Date;

public class Persona {

    private String nombre;
    private String apellido;
    private String email;
    private String localidad;
    private String direccion;
    private String aLaboral;
    private int dni;
    private int celular;
    private Date fechaNac;

    public Persona(String n, String a, String mail, String localidad, String direccion, int dni, int cel, Date fecha) {
    }

    public Persona(String n, String a, int dni, Date fecha) {
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

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
}
