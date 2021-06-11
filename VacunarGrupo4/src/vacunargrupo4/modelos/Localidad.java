
package vacunargrupo4.modelos;


public class Localidad {
    String nombre;
    int id;

    public Localidad(String nombre) {
        this.nombre = nombre;
    }
    public Localidad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
