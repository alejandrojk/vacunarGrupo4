package vacunargrupo4.modelos;

import java.sql.Date;
import java.time.LocalDate;

public class RegistroVacunados {

    private Citas citas;
    private Vacuna vacuna;
    private Date fecha;
    private int id;
    private int idVacuna;
    private int idCita;

    public RegistroVacunados(Vacuna v, Citas c) {
        vacuna=v;
        citas=c;
    }
    public RegistroVacunados() {
    }

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Vacuna vacuna) {
        this.idVacuna = vacuna.getId();
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(Citas cita) {
        this.idCita = cita.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Citas c) {
        this.fecha = (Date) c.getFecha();
    }

    @Override
    public String toString() {
        return "RegistroVacunados{" + "citas=" +citas.getPersona().getNombre() +" "+citas.getPersona().getApellido()+", vacuna=" + vacuna.getNroSerie() + ", fecha=" + fecha + '}';
    } 
        
}
