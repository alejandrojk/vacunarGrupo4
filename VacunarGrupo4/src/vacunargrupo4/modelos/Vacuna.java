package vacunargrupo4.modelos;

public class Vacuna {

    private int id;
    private boolean estado;
    private int nroSerie;
    private Laboratorio laboratorio;

    public Vacuna(int id, int nroSerie, Laboratorio laboratorio) {
        this.id = id;
        this.nroSerie = nroSerie;
        this.laboratorio = laboratorio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(int nroSerie) {
        this.nroSerie = nroSerie;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    
    
}
