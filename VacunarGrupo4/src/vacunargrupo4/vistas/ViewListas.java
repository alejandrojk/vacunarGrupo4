/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunargrupo4.vistas;

import java.awt.Color;
import java.sql.Date;
import java.time.LocalDate;
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
import vacunargrupo4.modelos.Localidad;
import vacunargrupo4.modelos.Patologia;
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
        jbTurno = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jbb = new javax.swing.JToolBar();
        jScrollPane5 = new javax.swing.JScrollPane();
        tC = new javax.swing.JTable();
        jbVacunar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tLab1 = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        jPanel9 = new javax.swing.JPanel();
        jToolBar6 = new javax.swing.JToolBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tVacuna = new javax.swing.JTable();
        jbSubir = new javax.swing.JButton();
        tSolicitudes = new javax.swing.JToolBar();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tSol = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jtDni = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jbDarTurno = new javax.swing.JButton();
        jbReg = new javax.swing.JButton();
        jbModificarPer = new javax.swing.JButton();
        jtBorrarPer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tCtro = new javax.swing.JTable();
        jtCargarCtro = new javax.swing.JToggleButton();
        jtModificarCtro = new javax.swing.JToggleButton();
        jtEliminarCtro = new javax.swing.JToggleButton();
        jToolBar5 = new javax.swing.JToolBar();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tReg = new javax.swing.JTable();
        jToolBar3 = new javax.swing.JToolBar();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tCita = new javax.swing.JTable();
        jbVacunar1 = new javax.swing.JButton();
        jToolBar4 = new javax.swing.JToolBar();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tLab = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jbBorrarLab = new javax.swing.JButton();
        jtCambiarLab1 = new javax.swing.JButton();
        jbCargar = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenu2.setText("jMenu2");

        jbTurno.setBackground(new java.awt.Color(51, 35, 76));
        jbTurno.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jbTurno.setForeground(new java.awt.Color(255, 255, 255));
        jbTurno.setText("Dar Turno");
        jbTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jbb.setRollover(true);

        tC.setBackground(new java.awt.Color(83, 58, 124));
        tC.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        tC.setForeground(new java.awt.Color(255, 255, 255));
        tC.setModel(new javax.swing.table.DefaultTableModel(
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
        tC.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tC.setAutoscrolls(false);
        tC.setFillsViewportHeight(true);
        tC.setGridColor(new java.awt.Color(83, 58, 124));
        tC.setPreferredSize(new java.awt.Dimension(180, 80));
        tC.setRowHeight(20);
        jScrollPane5.setViewportView(tC);

        jbb.add(jScrollPane5);

        jbVacunar.setText("Aplicar");
        jbVacunar.setFocusable(false);
        jbVacunar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbVacunar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbVacunar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVacunarActionPerformed(evt);
            }
        });
        jbb.add(jbVacunar);

        tLab1.setBackground(new java.awt.Color(83, 58, 124));
        tLab1.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        tLab1.setForeground(new java.awt.Color(255, 255, 255));
        tLab1.setModel(new javax.swing.table.DefaultTableModel(
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
        tLab1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tLab1.setFillsViewportHeight(true);
        tLab1.setGridColor(new java.awt.Color(83, 58, 124));
        tLab1.setPreferredSize(new java.awt.Dimension(305, 85));
        tLab1.setRowHeight(20);
        jScrollPane1.setViewportView(tLab1);

        jToolBar2.setRollover(true);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );

        jToolBar6.setRollover(true);

        setBackground(new java.awt.Color(51, 35, 76));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTabbedPane1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(300, 300));

        jToolBar1.setRollover(true);
        jToolBar1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(51, 35, 76));

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tVacuna.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tVacuna.setFillsViewportHeight(true);
        tVacuna.setGridColor(new java.awt.Color(83, 58, 124));
        tVacuna.setRowHeight(20);
        jScrollPane2.setViewportView(tVacuna);
        if (tVacuna.getColumnModel().getColumnCount() > 0) {
            tVacuna.getColumnModel().getColumn(0).setPreferredWidth(10);
            tVacuna.getColumnModel().getColumn(0).setMaxWidth(10);
        }

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jbSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jToolBar1.add(jPanel3);

        jTabbedPane1.addTab("Vacunas", jToolBar1);

        tSolicitudes.setRollover(true);

        jPanel4.setBackground(new java.awt.Color(51, 35, 76));

        tSol.setBackground(new java.awt.Color(83, 58, 124));
        tSol.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        tSol.setForeground(new java.awt.Color(255, 255, 255));
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
        tSol.setGridColor(new java.awt.Color(83, 58, 124));
        tSol.setMaximumSize(new java.awt.Dimension(2147483647, 863));
        tSol.setPreferredSize(new java.awt.Dimension(1400, 863));
        tSol.setRowHeight(20);
        tSol.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tSol);

        jButton1.setBackground(new java.awt.Color(51, 35, 76));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtDni.setBackground(new java.awt.Color(83, 58, 124));
        jtDni.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtDni.setForeground(new java.awt.Color(255, 255, 255));
        jtDni.setText("DNI");
        jtDni.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                jtDniComponentRemoved(evt);
            }
        });
        jtDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtDniFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtDniFocusLost(evt);
            }
        });
        jtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDniKeyTyped(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(51, 35, 76));

        jbDarTurno.setBackground(new java.awt.Color(51, 35, 76));
        jbDarTurno.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jbDarTurno.setForeground(new java.awt.Color(255, 255, 255));
        jbDarTurno.setText("Nuevo Turno");
        jbDarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarTurnoActionPerformed(evt);
            }
        });

        jbReg.setBackground(new java.awt.Color(51, 35, 76));
        jbReg.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jbReg.setForeground(new java.awt.Color(255, 255, 255));
        jbReg.setText("Registrar Persona");
        jbReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegActionPerformed(evt);
            }
        });

        jbModificarPer.setBackground(new java.awt.Color(51, 35, 76));
        jbModificarPer.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jbModificarPer.setForeground(new java.awt.Color(255, 255, 255));
        jbModificarPer.setText("Modificar");
        jbModificarPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarPerActionPerformed(evt);
            }
        });

        jtBorrarPer.setBackground(new java.awt.Color(51, 35, 76));
        jtBorrarPer.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtBorrarPer.setForeground(new java.awt.Color(255, 255, 255));
        jtBorrarPer.setText("Borrar");
        jtBorrarPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBorrarPerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jbDarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jbReg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jbModificarPer, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jtBorrarPer, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbReg, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificarPer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtBorrarPer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(306, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jtDni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tSolicitudes.add(jPanel4);

        jTabbedPane1.addTab("Solicitudes", tSolicitudes);

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
        tCtro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tCtro.setFillsViewportHeight(true);
        tCtro.setGridColor(new java.awt.Color(83, 58, 124));
        tCtro.setRowHeight(20);
        tCtro.setSelectionBackground(new java.awt.Color(83, 58, 124));
        jScrollPane3.setViewportView(tCtro);

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
            .addComponent(jScrollPane3)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jtCargarCtro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jtModificarCtro, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jtEliminarCtro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtEliminarCtro, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtCargarCtro, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtModificarCtro, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ctros. Vacunacion", jPanel2);

        jToolBar5.setRollover(true);

        tReg.setBackground(new java.awt.Color(83, 58, 124));
        tReg.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        tReg.setForeground(new java.awt.Color(255, 255, 255));
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tReg.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tReg.setDropMode(javax.swing.DropMode.ON);
        tReg.setFillsViewportHeight(true);
        tReg.setGridColor(new java.awt.Color(83, 58, 124));
        tReg.setPreferredSize(new java.awt.Dimension(300, 150));
        tReg.setRowHeight(20);
        jScrollPane6.setViewportView(tReg);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );

        jToolBar5.add(jPanel10);

        jTabbedPane1.addTab("Reg. vacunados", jToolBar5);

        jToolBar3.setRollover(true);

        jPanel6.setBackground(new java.awt.Color(51, 35, 76));

        tCita.setBackground(new java.awt.Color(83, 58, 124));
        tCita.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        tCita.setForeground(new java.awt.Color(255, 255, 255));
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tCita.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tCita.setFillsViewportHeight(true);
        tCita.setGridColor(new java.awt.Color(83, 58, 124));
        tCita.setRowHeight(20);
        jScrollPane7.setViewportView(tCita);
        if (tCita.getColumnModel().getColumnCount() > 0) {
            tCita.getColumnModel().getColumn(0).setPreferredWidth(10);
            tCita.getColumnModel().getColumn(0).setMaxWidth(10);
        }

        jbVacunar1.setBackground(new java.awt.Color(51, 35, 76));
        jbVacunar1.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jbVacunar1.setForeground(new java.awt.Color(255, 255, 255));
        jbVacunar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/17897607481553668480-24.png"))); // NOI18N
        jbVacunar1.setText("Aplicar vacuna");
        jbVacunar1.setFocusable(false);
        jbVacunar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbVacunar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbVacunar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVacunar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(331, Short.MAX_VALUE)
                .addComponent(jbVacunar1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(316, 316, 316))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jbVacunar1)
                .addContainerGap())
        );

        jToolBar3.add(jPanel6);

        jTabbedPane1.addTab("Turnos", jToolBar3);

        jToolBar4.setRollover(true);

        jPanel7.setBackground(new java.awt.Color(51, 35, 76));

        tLab.setBackground(new java.awt.Color(83, 58, 124));
        tLab.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        tLab.setForeground(new java.awt.Color(255, 255, 255));
        tLab.setModel(new javax.swing.table.DefaultTableModel(
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
        tLab.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tLab.setFillsViewportHeight(true);
        tLab.setGridColor(new java.awt.Color(83, 58, 124));
        tLab.setMaximumSize(new java.awt.Dimension(2147483647, 863));
        tLab.setPreferredSize(new java.awt.Dimension(1400, 863));
        tLab.setRowHeight(20);
        tLab.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(tLab);

        jPanel8.setBackground(new java.awt.Color(51, 35, 76));

        jbBorrarLab.setBackground(new java.awt.Color(51, 35, 76));
        jbBorrarLab.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jbBorrarLab.setForeground(new java.awt.Color(255, 255, 255));
        jbBorrarLab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        jbBorrarLab.setText("Eliminar");
        jbBorrarLab.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbBorrarLab.setFocusable(false);
        jbBorrarLab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbBorrarLab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbBorrarLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarLabActionPerformed(evt);
            }
        });

        jtCambiarLab1.setBackground(new java.awt.Color(51, 35, 76));
        jtCambiarLab1.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtCambiarLab1.setForeground(new java.awt.Color(255, 255, 255));
        jtCambiarLab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actuaizar.png"))); // NOI18N
        jtCambiarLab1.setText("Modificar");
        jtCambiarLab1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtCambiarLab1.setFocusable(false);
        jtCambiarLab1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jtCambiarLab1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtCambiarLab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCambiarLab1ActionPerformed(evt);
            }
        });

        jbCargar.setBackground(new java.awt.Color(51, 35, 76));
        jbCargar.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jbCargar.setForeground(new java.awt.Color(255, 255, 255));
        jbCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plus.png"))); // NOI18N
        jbCargar.setText("Cargar");
        jbCargar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbCargar.setFocusable(false);
        jbCargar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbCargar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jbCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jtCambiarLab1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jbBorrarLab, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbBorrarLab)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jtCambiarLab1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(jbCargar))))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jToolBar4.add(jPanel7);

        jTabbedPane1.addTab("Laboratorios", jToolBar4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTurnoActionPerformed
        
    }//GEN-LAST:event_jbTurnoActionPerformed

    private void jbVacunar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVacunar1ActionPerformed
        ViewVacunacion nuevo = new ViewVacunacion(conexion);
        Principal.Principal.add(nuevo);
        nuevo.moveToFront();
        nuevo.setVisible(true);
    }//GEN-LAST:event_jbVacunar1ActionPerformed

    private void jbVacunarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVacunarActionPerformed
        
    }//GEN-LAST:event_jbVacunarActionPerformed

    private void jtBorrarPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBorrarPerActionPerformed
        int dni;
        PersonaData ld = new PersonaData(conexion);
        try{
            dni = (int) tSol.getValueAt(tSol.getSelectedRow(), 3);

            int opcion = JOptionPane.showConfirmDialog(this, "Esta seguro que desea eliminar?", "Actualizar", 2, 3);
            if (opcion==0){
                ld.borrarPersona(dni);
            }

        }catch (Exception c){

        }
    }//GEN-LAST:event_jtBorrarPerActionPerformed

    private void jbModificarPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarPerActionPerformed
        try{
            String nombre,apellido,email,aLaboral,direccion;
            Localidad loc;
            Patologia pat;
            int id,dni,altura,telefono;
            double peso;
            LocalDate fecha;
            PersonaData pd = new PersonaData(conexion);
            Persona per;

            id = (Integer) tSol.getValueAt(tSol.getSelectedRow(), 0);
            nombre = (String) tSol.getValueAt(tSol.getSelectedRow(), 1);
            apellido = (String) tSol.getValueAt(tSol.getSelectedRow(), 2);
            dni = (Integer) tSol.getValueAt(tSol.getSelectedRow(), 3);
            fecha = (LocalDate) tSol.getValueAt(tSol.getSelectedRow(), 4);
            peso = (Double) tSol.getValueAt(tSol.getSelectedRow(), 5);
            altura = (Integer) tSol.getValueAt(tSol.getSelectedRow(), 6);
            pat = (Patologia) tSol.getValueAt(tSol.getSelectedRow(), 7);
            email = (String) tSol.getValueAt(tSol.getSelectedRow(), 8);
            telefono = (Integer) tSol.getValueAt(tSol.getSelectedRow(), 9);
            aLaboral = (String) tSol.getValueAt(tSol.getSelectedRow(), 10);
            direccion = (String) tSol.getValueAt(tSol.getSelectedRow(), 11);
            loc = (Localidad) tSol.getValueAt(tSol.getSelectedRow(), 12);
            per= new Persona ();

            per.setAltura(altura);
            per.setApellido(apellido);
            per.setCelular(telefono);
            per.setDireccion(direccion);
            per.setDni(dni);
            per.setEmail(email);
            per.setFechaNac(fecha);
            per.setIdPatologia(pat.getId());
            per.setIdPersona(id);
            per.setLocalidad(loc.getNombre());
            per.setNombre(nombre);
            per.setPeso(peso);
            per.setaLaboral(aLaboral);

            int opcion = JOptionPane.showConfirmDialog(this, "Esta seguro que desea guardar los cambios?", "Actualizar", 2, 3);
            if (opcion==0){
                pd.actualizarPersona(per, id);
                JOptionPane.showMessageDialog(jMenu1, "Cambios Realizados");
            }
        }catch(Exception c){
            JOptionPane.showMessageDialog(jMenu1, "No realizo ningun cambio");
        }
    }//GEN-LAST:event_jbModificarPerActionPerformed

    private void jbRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegActionPerformed
        ViewRegistroPersona nuevo = new ViewRegistroPersona(conexion);
        Principal.Principal.add(nuevo);
        nuevo.moveToFront();
        nuevo.setVisible(true);
    }//GEN-LAST:event_jbRegActionPerformed

    private void jbDarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarTurnoActionPerformed

        ViewTurnos nuevo = new ViewTurnos(conexion);
        Principal.Principal.add(nuevo);
        nuevo.moveToFront();
        nuevo.setVisible(true);
    }//GEN-LAST:event_jbDarTurnoActionPerformed

    private void jtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDniKeyTyped
        jtDni.setBorder(null);
    }//GEN-LAST:event_jtDniKeyTyped

    private void jtDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtDniFocusLost

    }//GEN-LAST:event_jtDniFocusLost

    private void jtDniFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtDniFocusGained
        jtDni.setText(null);
    }//GEN-LAST:event_jtDniFocusGained

    private void jtDniComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jtDniComponentRemoved

    }//GEN-LAST:event_jtDniComponentRemoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int dni;
        PersonaData pd = new PersonaData(conexion);
        Persona nuevo;

        try{
            dni = Integer.parseInt(jtDni.getText());
            nuevo = pd.buscarPersona(dni);

            int b= modelo4.getRowCount()-1;
            for(int i = b;i>=0;i--){
                modelo4.removeRow(i);
            }

            modelo4.addRow(new Object[]{nuevo.getIdPersona(),nuevo.getNombre(),nuevo.getApellido(),nuevo.getDni(),nuevo.getFechaNac(),nuevo.getPeso(),nuevo.getAltura(),
                nuevo.getIdPatologia(),nuevo.getEmail(),nuevo.getCelular(),nuevo.getaLaboral(),nuevo.getDireccion(),nuevo.getLocalidad()});

        }catch(NumberFormatException c){
            JOptionPane.showMessageDialog(jtDni, "Debe ingresar DNI valido");
            jtDni.setBorder(border);
            jtDni.requestFocus();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarActionPerformed
        ViewLab nuevo = new ViewLab(conexion);
        Principal.Principal.add(nuevo);
        nuevo.moveToFront();
        nuevo.setVisible(true);
    }//GEN-LAST:event_jbCargarActionPerformed

    private void jtCargarCtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCargarCtroActionPerformed
        ViewCtro nuevo = new ViewCtro(conexion);
        Principal.Principal.add(nuevo);
        nuevo.moveToFront();
        nuevo.setVisible(true);
    }//GEN-LAST:event_jtCargarCtroActionPerformed

    private void jbSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSubirActionPerformed
        ViewLote nuevo= new ViewLote(conexion);
        Principal.Principal.add(nuevo);
        nuevo.moveToFront();
        nuevo.setVisible(true);
    }//GEN-LAST:event_jbSubirActionPerformed

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

    private void jbBorrarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarLabActionPerformed
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
    }//GEN-LAST:event_jbBorrarLabActionPerformed

    private void jtCambiarLab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCambiarLab1ActionPerformed
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
    }//GEN-LAST:event_jtCambiarLab1ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JButton jbBorrarLab;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbDarTurno;
    private javax.swing.JButton jbModificarPer;
    private javax.swing.JButton jbReg;
    private javax.swing.JButton jbSubir;
    private javax.swing.JButton jbTurno;
    private javax.swing.JButton jbVacunar;
    private javax.swing.JButton jbVacunar1;
    private javax.swing.JToolBar jbb;
    private javax.swing.JButton jtBorrarPer;
    private javax.swing.JButton jtCambiarLab1;
    private javax.swing.JToggleButton jtCargarCtro;
    private javax.swing.JTextField jtDni;
    private javax.swing.JToggleButton jtEliminarCtro;
    private javax.swing.JToggleButton jtModificarCtro;
    private javax.swing.JTable tC;
    private javax.swing.JTable tCita;
    private javax.swing.JTable tCtro;
    private javax.swing.JTable tLab;
    private javax.swing.JTable tLab1;
    private javax.swing.JTable tReg;
    private javax.swing.JTable tSol;
    private javax.swing.JToolBar tSolicitudes;
    private javax.swing.JTable tVacuna;
    // End of variables declaration//GEN-END:variables

public static boolean validarString(String user){
    String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        boolean specialchar = false;
        boolean numero = false;
            for (int i = 0; i < user.length(); i++) {
                if (specialChars.contains(String.valueOf(user.charAt(i)))) {
                    specialchar = true;
                } else if (Character.isDigit(Integer.valueOf(user.charAt(i)))) {
                    numero = true;
                }
            }
            if (specialchar || numero) {
                return false;
            } else {
                return true;
            }
        }

}



