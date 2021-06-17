package vacunargrupo4.modelos;

public class CtroVacunacion {
    public int idCentro;
    public String nombre;
    private String localidad;
    private String direccion;
    private Vacuna vacuna;

    public CtroVacunacion(String nombre, String localidad, String direccion, Vacuna vacuna) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.direccion = direccion;
        this.vacuna = vacuna;
    }    

    public CtroVacunacion() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    @Override
    public String toString() {
        return nombre +" - "+ localidad;
    }
    
    
    
    
}
