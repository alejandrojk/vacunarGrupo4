/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunargrupo4.vistas;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import vacunargrupo4.control.CitasData;
import vacunargrupo4.control.Conexion;
import vacunargrupo4.control.CtroData;
import vacunargrupo4.control.LabData;
import vacunargrupo4.control.PersonaData;
import vacunargrupo4.control.RegistroData;
import vacunargrupo4.control.VacunaData;
import vacunargrupo4.modelos.Citas;
import vacunargrupo4.modelos.CtroVacunacion;
import vacunargrupo4.modelos.Laboratorio;
import vacunargrupo4.modelos.Persona;
import vacunargrupo4.modelos.RegistroVacunados;
import vacunargrupo4.modelos.Vacuna;
import static vacunargrupo4.vistas.ViewRegistroPersona.validarString;



/**
 *
 * @author Maxi
 */
public class ViewListas extends javax.swing.JInternalFrame {

    private static void moveToFront(ViewLote nuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Principal principal;
    private Border border;
    private Conexion conexion;
    private DefaultTableModel modelo;
    private DefaultTableModel modelo2;
    private DefaultTableModel modelo3;
    private DefaultTableModel modelo4;
    private DefaultTableModel modelo5;
    private DefaultTableModel modelo6;
    private LabData ld;
    private PersonaData pd;
    private VacunaData vd;
    private CtroData cv;
    private CitasData cd;
    private RegistroData rd;
    private ArrayList <CtroVacunacion> centros;
    private ArrayList <Laboratorio> laboratorios;
    private ArrayList <Vacuna> vacunas;
    private ArrayList <Persona> personas;
    private ArrayList <Citas> citas;
    private ArrayList <RegistroVacunados> vacunados;
    
    public ViewListas(Conexion conexion) {
        this.conexion=conexion;
        initComponents();
        border = new LineBorder(Color.getHSBColor(0, 87, 100), 3, true);
        modelo = new DefaultTableModel();
        modelo2 = new DefaultTableModel();
        modelo3 = new DefaultTableModel();
        modelo4 = new DefaultTableModel();
        modelo5 = new DefaultTableModel();
        modelo6 = new DefaultTableModel();
        pd = new PersonaData(conexion);
        ld = new LabData(conexion);
        vd = new VacunaData(conexion);
        cv = new CtroData(conexion);
        cd = new CitasData(conexion);
        rd = new RegistroData(conexion);
        personas = pd.obtenerPersonas();
        vacunas = vd.obtenerVacunas();
        laboratorios = (ArrayList<Laboratorio>) ld.obtenerLaboratorios();
        centros = cv.obtenerCtroVacunacions();
        citas = cd.obtenerCitasActuales();
        vacunados = rd.obtenerVacunados();
        cabeceraTabla();
        cabeceraTablaVac();
        cabeceraTablaCtro();
        cabeceraTablaPer();
        cabeceraTablaCitas();
        cabeceraTablaReg();
        cargaDatosLab();
        cargarDatosVac();
        cargaDatosCtro();
        cargaDatosPer();
        cargaDatosCita();
        cargaDatosReg();
    }
    
    public void cargaDatosReg(){
        int b= modelo6.getRowCount()-1;
        for(int i = b;i>=0;i--){
            modelo6.removeRow(i);
        }
        for (RegistroVacunados c:vacunados){
            modelo6.addRow(new Object[]{c.getId(),c.getCitas().getId(),c.getVacuna().getNroSerie(),c.getDosis(),c.getFecha()});       
        }       
    }
    public void cabeceraTablaReg(){
        ArrayList<Object> columns= new ArrayList();
        columns.add("ID");
        columns.add("Cita");
        columns.add("Vacuna");
        columns.add("Dosis");
        columns.add("Fecha");
        for (Object it:columns){
            modelo6.addColumn(it);
        }
        tReg.setModel(modelo6);
    }
    public void cargaDatosCita(){
        int b= modelo5.getRowCount()-1;
        for(int i = b;i>=0;i--){
            modelo5.removeRow(i);
        }
        for (Citas c:citas){
            modelo5.addRow(new Object[]{c.getId(),c.getPersona().getDni(),c.getCentro().getNombre(),c.getMotivo(),c.getFecha(),c.getHora(),c.getEstado()});       
        }
        
    }
    public void cargaDatosCtro(){
        int b= modelo3.getRowCount()-1;
        for(int i = b;i>=0;i--){
            modelo3.removeRow(i);
        }
        for (CtroVacunacion c:centros){
            modelo3.addRow(new Object[]{c.getIdCentro(),c.getLocalidad(),c.getNombre(),c.getDireccion()});       
        }
        
    }
    public void cargaDatosLab(){
        borrarFilasTabla();
        for (Laboratorio c:laboratorios){
            modelo.addRow(new Object[]{c.getId(),c.getNombre(),c.getPaisOrigen(),c.getDireccion()});       
        }
    }
    public void cargarDatosVac(){
        int b= modelo2.getRowCount()-1;
        for(int i = b;i>=0;i--){
            modelo2.removeRow(i);
        }
        for (Vacuna c:vacunas){
            modelo2.addRow(new Object[]{c.getId(),c.getNroSerie(),c.getLaboratorio().getNombre(),c.isEstado()});       
        }
    }
    public void cabeceraTablaCitas(){
        ArrayList<Object> columns= new ArrayList();
        columns.add("ID");
        columns.add("DNI");
        columns.add("Lugar");
        columns.add("Motivo");
        columns.add("Fecha");
        columns.add("Hora");
        columns.add("Estado");
        for (Object it:columns){
            modelo5.addColumn(it);
        }
        tCita.setModel(modelo5);
    }
    public void cabeceraTablaCtro(){
        ArrayList<Object> columns= new ArrayList();
        columns.add("ID");
        columns.add("Localidad");
        columns.add("Nombre");
        columns.add("Direccion");
        for (Object it:columns){
            modelo3.addColumn(it);
        }
        tCtro.setModel(modelo3);
    }
    public void cargaDatosPer(){
        int b= modelo4.getRowCount()-1;
        for(int i = b;i>=0;i--){
            modelo4.removeRow(i);
        }
        for (Persona c:personas){
            modelo4.addRow(new Object[]{c.getIdPersona(),c.getNombre(),c.getApellido(),c.getDni(),c.getFechaNac(),c.getPeso(),c.getAltura(),
            c.getIdPatologia(),c.getEmail(),c.getCelular(),c.getaLaboral(),c.getDireccion(),c.getLocalidad()});       
        }
        
    }
    public void cabeceraTablaPer(){
        ArrayList<Object> columns= new ArrayList();
        columns.add("ID");
        columns.add("Nombre");
        columns.add("Apellido");
        columns.add("DNI");
        columns.add("Fecha de Nac.");
        columns.add("Peso");
        columns.add("Altura");
        columns.add("Patologia");
        columns.add("Email");
        columns.add("Telefono");
        columns.add("Rubro");
        columns.add("Direccion");
        columns.add("Localidad");
        
        for (Object it:columns){
            modelo4.addColumn(it);
        }
        tSol.setModel(modelo4);
    }
    
    public void cabeceraTablaVac(){
        ArrayList<Object> columns= new ArrayList();
        columns.add("ID");
        columns.add("nroSerie");
        columns.add("Laboratorio");
        columns.add("Estado");
        for (Object it:columns){
            modelo2.addColumn(it);
        }
        tVacuna.setModel(modelo2);
    }

    public void cabeceraTabla(){
        ArrayList<Object> columns= new ArrayList();
        columns.add("ID");
        columns.add("Nombre");
        columns.add("Pais");
        columns.add("Direccion");
        for (Object it:columns){
            modelo.addColumn(it);
        }
        tLab.setModel(modelo);
    }

    public void borrarFilasTabla(){
        int b= modelo.getRowCount()-1;
        for(int i = b;i>=0;i--){
            modelo.removeRow(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel3 = new javax.swing.JPanel();
        jbSubir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tVacuna = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tLab = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtPais = new javax.swing.JTextField();
        jtDireccion = new javax.swing.JTextField();
        jbAdd = new javax.swing.JButton();
        jtBorrar = new javax.swing.JButton();
        jtCambiarLab = new javax.swing.JButton();
        tSolicitudes = new javax.swing.JToolBar();
        jScrollPane4 = new javax.swing.JScrollPane();
        tSol = new javax.swing.JTable();
        jToolBar4 = new javax.swing.JToolBar();
        jScrollPane5 = new javax.swing.JScrollPane();
        tCita = new javax.swing.JTable();
        jToolBar5 = new javax.swing.JToolBar();
        jScrollPane6 = new javax.swing.JScrollPane();
        tReg = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tCtro = new javax.swing.JTable();
        jtModificarCtro = new javax.swing.JToggleButton();
        jtCargarCtro = new javax.swing.JToggleButton();
        jtEliminarCtro = new javax.swing.JToggleButton();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenu2.setText("jMenu2");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTabbedPane1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(300, 300));

        jToolBar1.setRollover(true);
        jToolBar1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(51, 35, 76));

        jbSubir.setBackground(new java.awt.Color(51, 35, 76));
        jbSubir.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jbSubir.setForeground(new java.awt.Color(255, 255, 255));
        jbSubir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/17897607481553668480-24.png"))); // NOI18N
        jbSubir.setText("Cargar Lote");
        jbSubir.setBorder(null);
        jbSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSubirActionPerformed(evt);
            }
        });

        tVacuna.setBackground(new java.awt.Color(83, 58, 124));
        tVacuna.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        tVacuna.setForeground(new java.awt.Color(255, 255, 255));
        tVacuna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tVacuna.setGridColor(new java.awt.Color(51, 35, 76));
        tVacuna.setRowHeight(20);
        jScrollPane2.setViewportView(tVacuna);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jbSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.add(jPanel3);

        jTabbedPane1.addTab("Vacunas", jToolBar1);

        jToolBar2.setRollover(true);

        tLab.setBackground(new java.awt.Color(83, 58, 124));
        tLab.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        tLab.setForeground(new java.awt.Color(255, 255, 255));
        tLab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tLab.setFillsViewportHeight(true);
        tLab.setGridColor(new java.awt.Color(51, 35, 76));
        tLab.setPreferredSize(new java.awt.Dimension(305, 85));
        tLab.setRowHeight(20);
        jScrollPane1.setViewportView(tLab);

        jToolBar2.add(jScrollPane1);

        jPanel1.setBackground(new java.awt.Color(51, 35, 76));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pais");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Direccion");

        jtNombre.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreKeyTyped(evt);
            }
        });

        jtPais.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtPaisKeyTyped(evt);
            }
        });

        jtDireccion.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDireccionKeyTyped(evt);
            }
        });

        jbAdd.setBackground(new java.awt.Color(51, 35, 76));
        jbAdd.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jbAdd.setForeground(new java.awt.Color(255, 255, 255));
        jbAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plus.png"))); // NOI18N
        jbAdd.setText("Cargar");
        jbAdd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        jtBorrar.setBackground(new java.awt.Color(51, 35, 76));
        jtBorrar.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtBorrar.setForeground(new java.awt.Color(255, 255, 255));
        jtBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        jtBorrar.setText("Eliminar");
        jtBorrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBorrarActionPerformed(evt);
            }
        });

        jtCambiarLab.setBackground(new java.awt.Color(51, 35, 76));
        jtCambiarLab.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtCambiarLab.setForeground(new java.awt.Color(255, 255, 255));
        jtCambiarLab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actuaizar.png"))); // NOI18N
        jtCambiarLab.setText("Modificar");
        jtCambiarLab.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtCambiarLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCambiarLabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtNombre)
                            .addComponent(jtPais)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtDireccion)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtCambiarLab, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(57, 57, 57)
                                    .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jtBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtCambiarLab, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar2.add(jPanel1);

        jTabbedPane1.addTab("Laboratorios", jToolBar2);

        tSolicitudes.setRollover(true);

        tSol.setBackground(new java.awt.Color(83, 58, 124));
        tSol.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        tSol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tSol.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tSol.setFillsViewportHeight(true);
        tSol.setMaximumSize(new java.awt.Dimension(2147483647, 863));
        tSol.setPreferredSize(new java.awt.Dimension(1400, 863));
        tSol.setRowHeight(18);
        tSol.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tSol);

        tSolicitudes.add(jScrollPane4);

        jTabbedPane1.addTab("Solicitudes", tSolicitudes);

        jToolBar4.setRollover(true);

        tCita.setBackground(new java.awt.Color(83, 58, 124));
        tCita.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        tCita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tCita.setRowHeight(20);
        jScrollPane5.setViewportView(tCita);

        jToolBar4.add(jScrollPane5);

        jTabbedPane1.addTab("Turnos", jToolBar4);

        jToolBar5.setRollover(true);

        tReg.setBackground(new java.awt.Color(83, 58, 124));
        tReg.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        tReg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tReg.setRowHeight(20);
        jScrollPane6.setViewportView(tReg);

        jToolBar5.add(jScrollPane6);

        jTabbedPane1.addTab("Reg. vacunados", jToolBar5);

        jPanel2.setBackground(new java.awt.Color(51, 35, 76));

        tCtro.setBackground(new java.awt.Color(83, 58, 124));
        tCtro.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        tCtro.setForeground(new java.awt.Color(255, 255, 255));
        tCtro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tCtro.setRowHeight(20);
        jScrollPane3.setViewportView(tCtro);

        jtModificarCtro.setBackground(new java.awt.Color(51, 35, 76));
        jtModificarCtro.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtModificarCtro.setForeground(new java.awt.Color(255, 255, 255));
        jtModificarCtro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actuaizar.png"))); // NOI18N
        jtModificarCtro.setText("  Modificar");
        jtModificarCtro.setBorder(null);
        jtModificarCtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtModificarCtroActionPerformed(evt);
            }
        });

        jtCargarCtro.setBackground(new java.awt.Color(51, 35, 76));
        jtCargarCtro.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtCargarCtro.setForeground(new java.awt.Color(255, 255, 255));
        jtCargarCtro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/17897607481553668480-24.png"))); // NOI18N
        jtCargarCtro.setText("Cargar Ctro.");
        jtCargarCtro.setBorder(null);
        jtCargarCtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCargarCtroActionPerformed(evt);
            }
        });

        jtEliminarCtro.setBackground(new java.awt.Color(51, 35, 76));
        jtEliminarCtro.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtEliminarCtro.setForeground(new java.awt.Color(255, 255, 255));
        jtEliminarCtro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        jtEliminarCtro.setText("  Eliminar");
        jtEliminarCtro.setBorder(null);
        jtEliminarCtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEliminarCtroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtModificarCtro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCargarCtro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtEliminarCtro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtCargarCtro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtModificarCtro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtEliminarCtro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Ctros. Vacunacion", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtModificarCtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtModificarCtroActionPerformed

        try{
            String localidad,nombre,direccion;
            int id;
            CtroData  cd= new CtroData(conexion);
            CtroVacunacion cc;

            id = (Integer) tCtro.getValueAt(tCtro.getSelectedRow(), 0);
            localidad = (String) tCtro.getValueAt(tCtro.getSelectedRow(), 1);
            nombre = (String) tCtro.getValueAt(tCtro.getSelectedRow(), 2);
            direccion = (String) tCtro.getValueAt(tCtro.getSelectedRow(), 3);

            cc= new CtroVacunacion ();

            cc.setIdCentro(id);
            cc.setLocalidad(localidad);
            cc.setDireccion(direccion);
            cc.setNombre(nombre);

            int opcion = JOptionPane.showConfirmDialog(this, "Esta seguro que desea guardar los cambios?", "Actualizar", 2, 3);
            if (opcion==0){
                cd.actualizarCtroVacunacion(cc, cc.getNombre());
                JOptionPane.showMessageDialog(jMenu1, "Cambios Realizados");
            }
        }catch(Exception c){
            JOptionPane.showMessageDialog(jMenu1, "No realizo ningun cambio");
        }
    }//GEN-LAST:event_jtModificarCtroActionPerformed

    private void jtBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBorrarActionPerformed
        int id;
        LabData ld = new LabData(conexion);
        try{
        id = (int) tLab.getValueAt(tLab.getSelectedRow(), 0);
        
        int opcion = JOptionPane.showConfirmDialog(this, "Esta seguro que desea eliminar?", "Actualizar", 2, 3);
            if (opcion==0){               
                ld.borrarLaboratorio(id);             
            }
            
        }catch (Exception c){
            
        }
    }//GEN-LAST:event_jtBorrarActionPerformed

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed

        LabData lb = new LabData(conexion);
        Laboratorio lab;

        try{
            String nombre = jtNombre.getText();
            if (nombre.isEmpty()){
                JOptionPane.showMessageDialog(jMenu1, "Debe completar el Nombre");
                jtNombre.requestFocus();
                jtNombre.setBorder(border);
            }else{
                String pais = jtPais.getText();
                if (pais.isEmpty()){
                    JOptionPane.showMessageDialog(jMenu1, "Debe completar el Pais");
                    jtPais.requestFocus();
                    jtPais.setBorder(border);}
                else if (!validarString(pais)){
                    JOptionPane.showMessageDialog(this, "Pais no puede contener numeros");
                    jtPais.requestFocus();
                    jtPais.setBorder(border);
                }else{
                    String direccion = jtDireccion.getText();
                    if (direccion.isEmpty()){
                        JOptionPane.showMessageDialog(jMenu1, "Debe completar Direccion");
                        jtDireccion.requestFocus();
                        jtDireccion.setBorder(border);
                    }   else{
                        lab = new Laboratorio(nombre,direccion,pais);
                        lb.registrarLaboratorio(lab);
                        JOptionPane.showMessageDialog(jMenu1, "Laboratorio Agregado");
                        this.cargaDatosLab();
                        jtDireccion.setText(null);
                        jtPais.setText(null);
                        jtNombre.setText(null);
                    }
                }
            }
        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(jMenu1, "Error en carga de datos");
            jtNombre.requestFocus();
            jtNombre.setBorder(border);
        }
    }//GEN-LAST:event_jbAddActionPerformed

    private void jbSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSubirActionPerformed

        ViewLote nuevo = new ViewLote(conexion);
        Principal.Principal.add(nuevo);
        nuevo.moveToFront();
        nuevo.setVisible(true);
    }//GEN-LAST:event_jbSubirActionPerformed

    private void jtCambiarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCambiarLabActionPerformed
        try{
            String nombre,direccion,pais;
            int id;
            LabData  cd= new LabData(conexion);
            Laboratorio cc;

            id = (Integer) tLab.getValueAt(tLab.getSelectedRow(), 0);
            nombre = (String) tLab.getValueAt(tLab.getSelectedRow(), 1);
            pais = (String) tLab.getValueAt(tLab.getSelectedRow(), 2);
            direccion = (String) tLab.getValueAt(tLab.getSelectedRow(), 3);

            cc= new Laboratorio ();

            cc.setId(id);
            cc.setNombre(nombre);
            cc.setDireccion(direccion);
            cc.setPaisOrigen(pais);

            int opcion = JOptionPane.showConfirmDialog(this, "Esta seguro que desea guardar los cambios?", "Actualizar", 2, 3);
            if (opcion==0){
                cd.actualizarLaboratorio(cc, id);
                JOptionPane.showMessageDialog(jMenu1, "Cambios Realizados");
            }
        }catch(Exception c){
            JOptionPane.showMessageDialog(jMenu1, "No realizo ningun cambio");
        }
    }//GEN-LAST:event_jtCambiarLabActionPerformed

    private void jtCargarCtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCargarCtroActionPerformed
        ViewCtro nuevo = new ViewCtro(conexion);
        Principal.Principal.add(nuevo);
        nuevo.moveToFront();
        nuevo.setVisible(true);
    }//GEN-LAST:event_jtCargarCtroActionPerformed

    private void jtEliminarCtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEliminarCtroActionPerformed
        int id;
        CtroData ld = new CtroData(conexion);
        try{
        id = (int) tCtro.getValueAt(tCtro.getSelectedRow(), 0);
        
        
        
        int opcion = JOptionPane.showConfirmDialog(this, "Esta seguro que desea eliminar?", "Actualizar", 2, 3);
            if (opcion==0){             
                ld.borrarCtroVacunacion(id);                                                    
            }
                                         
        }catch (Exception c){
            
        } 
    }//GEN-LAST:event_jtEliminarCtroActionPerformed

    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyTyped
        jtNombre.setBorder(null);
    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPaisKeyTyped
        jtPais.setBorder(null);
    }//GEN-LAST:event_jtPaisKeyTyped

    private void jtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDireccionKeyTyped
        jtDireccion.setBorder(null);
    }//GEN-LAST:event_jtDireccionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbSubir;
    private javax.swing.JButton jtBorrar;
    private javax.swing.JButton jtCambiarLab;
    private javax.swing.JToggleButton jtCargarCtro;
    private javax.swing.JTextField jtDireccion;
    private javax.swing.JToggleButton jtEliminarCtro;
    private javax.swing.JToggleButton jtModificarCtro;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPais;
    private javax.swing.JTable tCita;
    private javax.swing.JTable tCtro;
    private javax.swing.JTable tLab;
    private javax.swing.JTable tReg;
    private javax.swing.JTable tSol;
    private javax.swing.JToolBar tSolicitudes;
    private javax.swing.JTable tVacuna;
    // End of variables declaration//GEN-END:variables
}
