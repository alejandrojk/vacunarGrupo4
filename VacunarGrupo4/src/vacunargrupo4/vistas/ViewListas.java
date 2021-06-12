/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunargrupo4.vistas;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import vacunargrupo4.control.Conexion;
import vacunargrupo4.control.CtroData;
import vacunargrupo4.control.LabData;
import vacunargrupo4.control.PersonaData;
import vacunargrupo4.control.VacunaData;
import vacunargrupo4.modelos.CtroVacunacion;
import vacunargrupo4.modelos.Laboratorio;
import vacunargrupo4.modelos.Persona;
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
    private LabData ld;
    private PersonaData pd;
    private VacunaData vd;
    private CtroData cv;
    private ArrayList <CtroVacunacion> centros;
    private ArrayList <Laboratorio> laboratorios;
    private ArrayList <Vacuna> vacunas;
    private ArrayList <Persona> personas;
    
    public ViewListas(Conexion conexion) {
        this.conexion=conexion;
        initComponents();
        border = new LineBorder(Color.getHSBColor(0, 87, 100), 3, true);
        modelo = new DefaultTableModel();
        modelo2 = new DefaultTableModel();
        modelo3 = new DefaultTableModel();
        modelo4 = new DefaultTableModel();
        pd = new PersonaData(conexion);
        ld = new LabData(conexion);
        vd = new VacunaData(conexion);
        cv = new CtroData(conexion);
        personas = pd.obtenerPersonas();
        vacunas = vd.obtenerVacunas();
        laboratorios = (ArrayList<Laboratorio>) ld.obtenerLaboratorios();
        centros = cv.obtenerCtroVacunacions();
        cabeceraTabla();
        cabeceraTablaVac();
        cabeceraTablaCtro();
        cabeceraTablaPer();
        cargaDatosLab();
        cargarDatosVac();
        cargaDatosCtro();
        cargaDatosPer();
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tCtro = new javax.swing.JTable();
        jtModificar = new javax.swing.JToggleButton();
        tSolicitudes = new javax.swing.JToolBar();
        jScrollPane4 = new javax.swing.JScrollPane();
        tSol = new javax.swing.JTable();
        jToolBar4 = new javax.swing.JToolBar();
        jToolBar5 = new javax.swing.JToolBar();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenu2.setText("jMenu2");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTabbedPane1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(150, 150));

        jToolBar1.setRollover(true);
        jToolBar1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N

        jbSubir.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jbSubir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/17897607481553668480-24.png"))); // NOI18N
        jbSubir.setText("Cargar Lote");
        jbSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSubirActionPerformed(evt);
            }
        });

        tVacuna.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
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
        tVacuna.setRowHeight(20);
        jScrollPane2.setViewportView(tVacuna);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jbSubir)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jbSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jToolBar1.add(jPanel3);

        jTabbedPane1.addTab("Vacunas", jToolBar1);

        jToolBar2.setRollover(true);

        tLab.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
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
        tLab.setPreferredSize(new java.awt.Dimension(305, 85));
        tLab.setRowHeight(20);
        jScrollPane1.setViewportView(tLab);

        jToolBar2.add(jScrollPane1);

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel2.setText("Pais");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel3.setText("Direccion");

        jtNombre.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N

        jtPais.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N

        jtDireccion.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N

        jbAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plus.png"))); // NOI18N
        jbAdd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        jtBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        jtBorrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

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
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jtBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtDireccion)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
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
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jbAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jToolBar2.add(jPanel1);

        jTabbedPane1.addTab("Laboratorios", jToolBar2);

        tCtro.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
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

        jtModificar.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actuaizar.png"))); // NOI18N
        jtModificar.setText("Modificar");
        jtModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ctros. Vacunacion", jPanel2);

        tSolicitudes.setRollover(true);

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
        tSol.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tSol.setFillsViewportHeight(true);
        tSol.setMaximumSize(new java.awt.Dimension(2147483647, 863));
        tSol.setPreferredSize(new java.awt.Dimension(1400, 863));
        tSol.setRowHeight(18);
        jScrollPane4.setViewportView(tSol);

        tSolicitudes.add(jScrollPane4);

        jTabbedPane1.addTab("Solicitudes", tSolicitudes);

        jToolBar4.setRollover(true);
        jTabbedPane1.addTab("Turnos", jToolBar4);

        jToolBar5.setRollover(true);
        jTabbedPane1.addTab("Reg. vacunados", jToolBar5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jtModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtModificarActionPerformed
        
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
    }//GEN-LAST:event_jtModificarActionPerformed


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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbSubir;
    private javax.swing.JButton jtBorrar;
    private javax.swing.JTextField jtDireccion;
    private javax.swing.JToggleButton jtModificar;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPais;
    private javax.swing.JTable tCtro;
    private javax.swing.JTable tLab;
    private javax.swing.JTable tSol;
    private javax.swing.JToolBar tSolicitudes;
    private javax.swing.JTable tVacuna;
    // End of variables declaration//GEN-END:variables
}
