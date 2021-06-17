/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunargrupo4.vistas;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import vacunargrupo4.control.CitasData;
import vacunargrupo4.control.Conexion;
import vacunargrupo4.control.CtroData;
import vacunargrupo4.control.LocalidadData;
import vacunargrupo4.control.PersonaData;
import vacunargrupo4.control.RegistroData;
import vacunargrupo4.modelos.Citas;
import vacunargrupo4.modelos.CtroVacunacion;
import vacunargrupo4.modelos.Localidad;
import vacunargrupo4.modelos.Persona;
import vacunargrupo4.modelos.RegistroVacunados;

/**
 *
 * @author Maxi
 */
public class ViewTurnos extends javax.swing.JInternalFrame {

    Conexion conexion;
    Border border;
    ArrayList<CtroVacunacion> centros;
    CtroData ct;
    
    public ViewTurnos(Conexion conexion) {
        initComponents();
        border = new LineBorder(Color.RED, 2, true);
        this.conexion=conexion;
        ct = new CtroData(conexion);
        centros = ct.obtenerCtroVacunacions();
        cargarCentros();
        jtDni.requestFocus();
    }

    public void cargarCentros(){
        for(CtroVacunacion item:centros){
            cbCentros.addItem(item);
    }
    
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbCentros = new javax.swing.JComboBox<>();
        jrMotivo1 = new javax.swing.JRadioButton();
        jrMotivo2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jtDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcFecha = new com.toedter.calendar.JDateChooser();
        jtBuscar = new javax.swing.JButton();
        jbTurno = new javax.swing.JButton();
        jtHora = new javax.swing.JFormattedTextField();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCheckBox1.setText("jCheckBox1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(51, 35, 76));
        jPanel1.setForeground(new java.awt.Color(51, 35, 76));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sistema de Turnos");

        cbCentros.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N

        jrMotivo1.setBackground(new java.awt.Color(51, 35, 76));
        buttonGroup1.add(jrMotivo1);
        jrMotivo1.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jrMotivo1.setForeground(new java.awt.Color(255, 255, 255));
        jrMotivo1.setText("Primera dósis");

        jrMotivo2.setBackground(new java.awt.Color(51, 35, 76));
        buttonGroup1.add(jrMotivo2);
        jrMotivo2.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jrMotivo2.setForeground(new java.awt.Color(255, 255, 255));
        jrMotivo2.setText("Segunda dósis");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("D.N.I");

        jtDni.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDniKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Motivo");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/TopSitio2.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ctro. vacunacion");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hora");

        jcFecha.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N

        jtBuscar.setBackground(new java.awt.Color(51, 35, 76));
        jtBuscar.setForeground(new java.awt.Color(51, 35, 76));
        jtBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa2.png"))); // NOI18N
        jtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtBuscar.setBorderPainted(false);
        jtBuscar.setOpaque(false);
        jtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBuscarActionPerformed(evt);
            }
        });

        jbTurno.setBackground(new java.awt.Color(51, 35, 76));
        jbTurno.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jbTurno.setForeground(new java.awt.Color(255, 255, 255));
        jbTurno.setText("Registrar Turno");
        jbTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTurnoActionPerformed(evt);
            }
        });

        try {
            jtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:00")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtHora.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCentros, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrMotivo1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jrMotivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrMotivo1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrMotivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCentros, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtHora, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(93, 93, 93)
                .addComponent(jbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBuscarActionPerformed
        int dni;
        PersonaData pd = new PersonaData(conexion);
        Persona nuevo;
        
        try{
            dni = Integer.parseInt(jtDni.getText());
            nuevo = pd.buscarPersona(dni);
            ViewPersona per = new ViewPersona(conexion,nuevo);
            Principal.Principal.add(per);
            per.moveToFront();
            per.setVisible(true);
            
        }catch(NumberFormatException c){
            JOptionPane.showMessageDialog(jtDni, "Debe ingresar DNI valido");
            jtDni.setBorder(border);
            jtDni.requestFocus();
        }
    }//GEN-LAST:event_jtBuscarActionPerformed

    private void jtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDniKeyTyped
        jtDni.setBorder(null);
    }//GEN-LAST:event_jtDniKeyTyped

    private void jbTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTurnoActionPerformed
        int dni;
        boolean val=false;
        String motivo=null;
        Date fecha;       
        Time hora;
        CitasData cd = new CitasData(conexion);
        Citas cita= new Citas();
        CtroVacunacion centro;
        PersonaData pd = new PersonaData(conexion);
        Persona persona = null;
        
        try{
            dni = Integer.parseInt(jtDni.getText());
            
            try{
                if (jrMotivo1.isSelected()){
                    motivo="Primera Dosis";
                }
                if (jrMotivo2.isSelected()){
                    motivo="Segunda Dosis";
                }if (!jrMotivo1.isSelected()&&!jrMotivo2.isSelected()){
                    JOptionPane.showMessageDialog(jrMotivo1, "Debe seleccionar una opcion en motivo");
                }else{                                      
                   try{
                        fecha = jcFecha.getDate();
                        
                        try{
                            hora = Time.valueOf(jtHora.getText());                                                      
                            
                            try{                               
                               
                               centro = (CtroVacunacion) cbCentros.getSelectedItem();
                               
                               persona = pd.buscarPersona(dni);
                               cita.setCentro(centro);
                               cita.setEstado(true);
                               cita.setFecha(fecha);
                               cita.setHora(hora);
                               cita.setMotivo(motivo);
                               cita.setPersona(persona);                             
                              
                               try{
                                   RegistroData rd = new RegistroData(conexion);                                  
                                    
                                   
                                   if(rd.isVacunado(dni,motivo)){
                                      JOptionPane.showMessageDialog(jtDni, cita.getPersona().getNombre()+" "+cita.getPersona().getApellido()+ " "
                                      + "DNI: "+cita.getPersona().getDni()+ " ya posee "+motivo);                                      
                                   
                                       if (cd.citaPendiente(dni, motivo)){
                                           JOptionPane.showMessageDialog(jtDni, "DNI: "+dni+" tiene una cita pendiente para "+motivo);                                      
                                       }
                                       else {
                                           cd.fijarTurno(cita);      
                                       }
                                   }else{
                                       cd.fijarTurno(cita);
                                   }
                                           
                                                                                                                                                                                                                                                                                                                                                        
                               }catch(Exception r){
                                   JOptionPane.showMessageDialog(jtDni, "Error imbecil");
                               }                                                             
                            }catch (Exception d){
                                JOptionPane.showMessageDialog(jtDni, "Error creando cita");
                            }
                        }catch(Exception d){
                            JOptionPane.showMessageDialog(jtDni, "Error Hora");
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(jtDni, "Error con la fecha");
                    }
                    
                }
            
                
            }catch(Exception c ){
                 JOptionPane.showMessageDialog(jtDni, "Error en motivo");
            }
        
        
        }catch(NumberFormatException c){
            JOptionPane.showMessageDialog(jtDni, "Debe ingresar DNI valido");
            jtDni.setBorder(border);
            jtDni.requestFocus();
        }
    }//GEN-LAST:event_jbTurnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<CtroVacunacion> cbCentros;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbTurno;
    private com.toedter.calendar.JDateChooser jcFecha;
    private javax.swing.JRadioButton jrMotivo1;
    private javax.swing.JRadioButton jrMotivo2;
    private javax.swing.JButton jtBuscar;
    private javax.swing.JTextField jtDni;
    private javax.swing.JFormattedTextField jtHora;
    // End of variables declaration//GEN-END:variables
}
