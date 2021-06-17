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
    private String dosis;

    public RegistroVacunados(Vacuna v, Citas c) {
        this.vacuna=v;
        this.citas=c;
    }
    public RegistroVacunados() {
    }

    public Citas getCitas() {
        return citas;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna){
        this.idVacuna = idVacuna;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "RegistroVacunados{" + "cita=" +idCita +" "+", vacuna=" +idVacuna + ", fecha=" + fecha + "}";
    } 
        
}
