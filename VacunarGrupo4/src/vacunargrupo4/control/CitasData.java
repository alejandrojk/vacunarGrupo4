package vacunargrupo4.control;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vacunargrupo4.modelos.Citas;
import vacunargrupo4.modelos.CtroVacunacion;
import vacunargrupo4.modelos.Persona;
import vacunargrupo4.modelos.RegistroVacunados;
import vacunargrupo4.modelos.Vacuna;


/**
 *
 * @author Usuario
 */
public class CitasData {
    
    private Connection con;
    private Conexion aux;
    public CitasData(Conexion conexion){
        try{
            con = conexion.getConexion();
            this.aux=conexion;
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"error de conexion persona");
        }
    }
     
    
    public Citas buscarCita(int id) throws SQLException {
        Citas cita = new Citas();
        CitasData pd = new CitasData(aux);
        
        
        String sql = "SELECT * FROM citas WHERE idCitas=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                cita.setId(rs.getInt("idCitas"));
                cita.setIdPersona(rs.getInt("idPersona"));
                cita.setIdCento(rs.getInt("idCentro"));
                cita.setMotivo(rs.getString("motivo"));
                cita.setHora(rs.getTime("horaTurno"));
                cita.setFecha(rs.getDate("fecha"));
                cita.setEstado(rs.getBoolean("estado"));               
            }
            ps.close();
     
        
        return cita;  
    }
    
    
     public void actualizarCita(Citas citas, int id){
        try{
            String sql = "UPDATE citas SET idCentro=?, motivo=?, horaTurno=?, fecha=?, estado=?, WHERE idPersona=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, (citas.getCentro().getIdCentro()));
            ps.setString(2, citas.getMotivo());
            //ps.setDate(3, Date.valueOf(citas.getFecha()));
            //ps.setTime(5, Time.valueOf(citas.getHora()));    
            ps.setBoolean(1, (citas.getEstado()));
                    
            ps.executeUpdate();
            
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error de conexion");
        }
    
    }
    public Citas citaFinalizada(Persona persona) throws SQLException{
        Citas cita=null;
        
        
        String sql = "SELECT motivo FROM citas,persona WHERE citas.estado=false "
                   + "AND citas.motivo='Primera Dosis'"+" AND citas.idPersona="+persona.getIdPersona();
        PreparedStatement ps = con.prepareStatement(sql);
        
        
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            cita = new Citas();         
            cita.setMotivo(rs.getString("motivo"));
            
        }
        ps.close();
        if(cita!=null){
            return cita;
        }else{
            return null;
        }               
        
    }
    
    public boolean citaPendiente(int dni,String motivo) throws SQLException {
        Citas cita = new Citas();
        Persona persona;
        PersonaData pd = new PersonaData(aux);
        persona = pd.buscarPersona(dni);
        
        String sql = "SELECT estado FROM citas,persona WHERE citas.motivo=? AND citas.idPersona="+persona.getIdPersona();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,motivo);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                cita.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
     
        
        return cita.getEstado();    
    }


   /* 
   public void turnosSemana() throws SQLException{           //NO SETEA BIEN LAS HORAS Y FECHA (ESTE METODO QUIZAS NO SIRVE)
       Persona persona;
       PersonaData p = new PersonaData(aux);
       ArrayList<Persona> registrados = new ArrayList();
       
       try {
           String sql = "SELECT * FROM persona ORDER BY fechaNacimiento ASC LIMIT 35";
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                persona = new Persona();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                persona.setDni(rs.getInt("dni"));
                persona.setAltura(rs.getInt("altura"));
                persona.setPeso(rs.getDouble("peso"));
                persona.setCelular(rs.getInt("celular"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setEmail(rs.getString("email"));
                persona.setLocalidad(rs.getString("localidad"));
                persona.setaLaboral(rs.getString("ambitoLaboral"));
                persona.setIdPatologia(rs.getInt("idPatologia"));
                registrados.add(persona);
            }
            ps.close();
       }catch (NullPointerException c){
           
       } catch (SQLException ex) {
            Logger.getLogger(CitasData.class.getName()).log(Level.SEVERE, null, ex);
        }
       Citas cita = new Citas();
       try{
            
            int turnos=0;
            Time hora=new Time(8,30,00);
            LocalDate fecha = LocalDate.now();
            for (Persona item:registrados){
               String sql = "INSERT INTO citas (idPersona,motivo,horaTurno,fecha,estado) VALUES(?,?,?,?,?)";
               PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
               ps.setInt(1,item.getIdPersona());
               //ps.setInt(2,registrados.get(i).get);
               ps.setString(2, "Primera dosis");
               ps.setTime(3, hora);               
               ps.setDate(4, Date.valueOf(fecha));
               ps.setBoolean(5, true);
               ps.executeUpdate();
               ResultSet rs = ps.getGeneratedKeys();
               if(rs.next()){
                    cita.setId(rs.getInt(1));
                }
               ps.close();
               
               hora.setTime(30);
               turnos++;
               if (turnos==7){
                   fecha.plusDays(1);
                   turnos=0;
               }
            }
            
        }catch(NullPointerException c){
            JOptionPane.showMessageDialog(null, "Chupala nestor");
        }
   } 
   */
        public void fijarTurno(Citas cita){
            
        try {
            String sql = "INSERT INTO citas (idPersona,idCentro,motivo,horaTurno,fecha,estado) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                        
            Date date = cita.getFecha();
            
            ps.setInt(1,cita.getPersona().getIdPersona());
            ps.setInt(2,cita.getCentro().getIdCentro());
            ps.setString(3, cita.getMotivo());
            ps.setTime(4, cita.getHora());
            Timestamp timestamp = new Timestamp(date.getTime());
            ps.setTimestamp(5, timestamp);
            ps.setBoolean(6, cita.getEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                cita.setId(rs.getInt(1));
            }
            ps.close();
            JOptionPane.showMessageDialog(null, "Cita otorgada con exito a: "+ cita.getPersona().getNombre()+" "+cita.getPersona().getApellido()+ " para el dia: "+cita.getFecha()+" a las "+cita.getHora());
            }
        
            catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"error de conexion fijando cita");
            }
        }    
        public Persona buscarPersona(int dni){
            Persona p;
            PersonaData pd = new PersonaData(aux);            
            p=pd.buscarPersona(dni);
            return p;               
        }
        public Persona buscarPersonaId(int id){
            Persona p;
            PersonaData pd = new PersonaData(aux);            
            p=pd.buscarPersonaId(id);
            return p;               
        }
        public CtroVacunacion buscarCtro(String nombre){
            CtroData cv = new CtroData(aux);
            return cv.buscarCtroVacunacion(nombre);
        }
        public CtroVacunacion buscarCtro(int id){
            CtroData cv = new CtroData(aux);
            CtroVacunacion c;
            c=cv.buscarCtroVacunacion(id);
            return c;
        }
        
        
        public void aplicarVacuna(Vacuna v,Citas c) throws SQLException {
            RegistroVacunados rv = new RegistroVacunados(v,c);
            Date fech = rv.getCitas().getFecha();
            Timestamp ts = new Timestamp(fech.getTime());
            
            try{
                String sql = "INSERT INTO registrovacunados (vacuna,idCita,fechaAplicacion) VALUES (?,?,?)";
                PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, rv.getVacuna().getNroSerie());
                ps.setInt(2, rv.getCitas().getId());
                ps.setTimestamp(3, ts);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
            
                if(rs.next()){
                    rv.setId(rs.getInt(1));
                }
                ps.close();                                              
                
            }catch(NullPointerException r){} catch (SQLException ex) {
            
            Logger.getLogger(CitasData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            try{
                Citas cita = rv.getCitas();
                Vacuna vacuna= rv.getVacuna();
                String sql = "UPDATE vacuna,citas,registrovacunados SET vacuna.estado=false,citas.estado=false \n" +
                "WHERE registrovacunados.vacuna = vacuna.nroSerie AND registrovacunados.idCita = citas.idCitas;";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.executeUpdate();           
                ps.close();
                
                JOptionPane.showMessageDialog(null, "Vacunao");
            }catch(NullPointerException r){}
        }

        public ArrayList<Citas> obtenerCitasPasadas(){
                Citas cita;
                ArrayList<Citas> citas = new ArrayList();

                try{
                String sql = "SELECT * FROM `citas` WHERE fecha BETWEEN CURRENT_DATE - INTERVAL 30 DAY AND CURRENT_DATE\n" +
                "AND estado=false;";
                PreparedStatement ps = con.prepareStatement(sql);


                ResultSet rs=ps.executeQuery();

                while(rs.next()){
                    cita = new Citas();
                    cita.setId(rs.getInt("idCitas"));
                    Persona pe = buscarPersonaId(rs.getInt("idPersona"));
                    cita.setPersona(pe);
                    cita.setIdPersona(pe.getIdPersona());
                    CtroVacunacion cv = buscarCtro(rs.getInt("idCentro"));
                    cita.setCentro(cv);
                    cita.setIdCento(cv.getIdCentro());
                    cita.setMotivo(rs.getString("motivo"));
                    cita.setFecha(rs.getDate("fecha"));
                    cita.setHora(rs.getTime("horaTurno"));
                    cita.setEstado(rs.getBoolean("estado"));
                    citas.add(cita);
                }
                ps.close();
            }catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"error de conexion buscando todas las citas registradas");
            }
            return citas;
        }
        public ArrayList<Citas> obtenerCitasActuales(){
                Citas cita;
                ArrayList<Citas> citas = new ArrayList();

                try{
                String sql = "SELECT * FROM `citas` WHERE fecha >= CURRENT_DATE " +
                "AND estado=true;";
                PreparedStatement ps = con.prepareStatement(sql);


                ResultSet rs=ps.executeQuery();

                while(rs.next()){
                    cita = new Citas();
                    cita.setId(rs.getInt("idCitas"));
                    Persona pe = buscarPersonaId(rs.getInt("idPersona"));
                    cita.setPersona(pe);
                    cita.setIdPersona(pe.getIdPersona());
                    CtroVacunacion cv = buscarCtro(rs.getInt("idCentro"));
                    cita.setCentro(cv);
                    cita.setIdCento(cv.getIdCentro());
                    cita.setMotivo(rs.getString("motivo"));
                    cita.setFecha(rs.getDate("fecha"));
                    cita.setHora(rs.getTime("horaTurno"));
                    cita.setEstado(rs.getBoolean("estado"));
                    citas.add(cita);
                }
                ps.close();
            }catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"error de conexion buscando todas las citas registradas");
            }
            return citas;
        }


}

