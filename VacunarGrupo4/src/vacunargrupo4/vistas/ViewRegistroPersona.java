/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunargrupo4.vistas;

import java.awt.Color;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import vacunargrupo4.control.Conexion;
import vacunargrupo4.control.LocalidadData;
import vacunargrupo4.control.PatologiaData;
import vacunargrupo4.control.PersonaData;
import vacunargrupo4.control.RegistroData;
import vacunargrupo4.modelos.Localidad;
import vacunargrupo4.modelos.Patologia;
import vacunargrupo4.modelos.Persona;

/**
 *
 * @author Maxi
 */
public class ViewRegistroPersona extends javax.swing.JInternalFrame {

    Border border = new LineBorder(Color.RED, 2, true);
    Conexion con;
    PatologiaData patologia;
    LocalidadData loc;
    ArrayList<Patologia> patologias;
    ArrayList<Localidad> localidades;
    
    
    public ViewRegistroPersona(Conexion conexion) {
        initComponents();
        con=conexion;
        this.patologia = new PatologiaData(conexion);
        patologias = patologia.obtenerPatologias();
        loc= new LocalidadData(conexion);
        localidades = loc.obtenerLocalidads();
        cargarPatologias();
        cargarLocalidades();
    }
    
    public void cargarLocalidades(){
        for(Localidad item:localidades){
            cbLoc.addItem(item);
    }
    }
    public void cargarPatologias(){
        for(Patologia item:patologias){
            cbPat.addItem(item);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jtTel = new javax.swing.JTextField();
        jtAltura = new javax.swing.JTextField();
        jtPeso = new javax.swing.JTextField();
        cbPat = new javax.swing.JComboBox<>();
        cbLoc = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtDni = new javax.swing.JTextField();
        jcFecha = new com.toedter.calendar.JDateChooser();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtDomicilio = new javax.swing.JTextField();
        jtEmail = new javax.swing.JTextField();

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/TopSitio.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setMaximumSize(new java.awt.Dimension(400, 50));
        jLabel4.setMinimumSize(new java.awt.Dimension(400, 50));
        jLabel4.setPreferredSize(new java.awt.Dimension(1064, 210));

        jLabel16.setText("jLabel16");

        setBackground(new java.awt.Color(51, 35, 76));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/TopSitio.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(1200, 1157));
        setPreferredSize(new java.awt.Dimension(1200, 1157));

        jPanel1.setBackground(new java.awt.Color(51, 35, 76));
        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 1157));

        jtTel.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTelActionPerformed(evt);
            }
        });
        jtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtTelKeyTyped(evt);
            }
        });

        jtAltura.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtAlturaActionPerformed(evt);
            }
        });
        jtAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtAlturaKeyTyped(evt);
            }
        });

        jtPeso.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPesoActionPerformed(evt);
            }
        });
        jtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtPesoKeyTyped(evt);
            }
        });

        cbPat.setMaximumRowCount(15);

        cbLoc.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        cbLoc.setMaximumRowCount(15);

        jToggleButton1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jToggleButton1.setText("Solicitar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/TopSitio2.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Telefono");

        jLabel10.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Localidad");

        jLabel11.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Altura");

        jLabel12.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Peso");

        jLabel13.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Patologia base");

        jtDni.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDniActionPerformed(evt);
            }
        });
        jtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDniKeyTyped(evt);
            }
        });

        jtNombre.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });
        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreKeyTyped(evt);
            }
        });

        jtApellido.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtApellidoActionPerformed(evt);
            }
        });
        jtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtApellidoKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro Solicitante");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("D.N.I");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha Nac");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Domicilio");

        jLabel8.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email");

        jtDomicilio.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDomicilioActionPerformed(evt);
            }
        });
        jtDomicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDomicilioKeyTyped(evt);
            }
        });

        jtEmail.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEmailActionPerformed(evt);
            }
        });
        jtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtEmailKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(245, 245, 245))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbPat, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(150, 150, 150)
                                        .addComponent(jLabel17))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addComponent(cbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(209, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(351, 351, 351))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPat, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDniActionPerformed

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreActionPerformed

    private void jtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtApellidoActionPerformed

    private void jtDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDomicilioActionPerformed

    private void jtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEmailActionPerformed

    private void jtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTelActionPerformed

    private void jtAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtAlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtAlturaActionPerformed

    private void jtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPesoActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
    boolean val = false;  
    PersonaData pd = new PersonaData(con);
    int dni=0,tel = 0,altura = 0;
    double peso = 0;
    String nombre = null,apellido = null,domicilio=null,localidad = null,email = null;
    LocalDate fecha = null;
    
    try{
        dni= Integer.parseInt(jtDni.getText());
            try{
                nombre = jtNombre.getText();
                    if (nombre.isEmpty()){
                        JOptionPane.showMessageDialog(this, "Campo vacio en NOMBRE");
                        jtNombre.requestFocus();
                        jtNombre.setBorder(border);
                    }
                    else if (!validarString(nombre)){
                            JOptionPane.showMessageDialog(this, "Formato de NOMBRE incorrecto");
                            jtNombre.requestFocus();
                            jtNombre.setBorder(border);
                    }else{
                        try{
                        apellido = jtApellido.getText();
                        if(apellido.isEmpty()){
                            JOptionPane.showMessageDialog(this, "Campo vacio en APELLIDO");
                            jtApellido.requestFocus();
                            jtApellido.setBorder(border);
                        }else if (!validarString(apellido)){
                            JOptionPane.showMessageDialog(this, "Formato de APELLIDO incorrecto");
                            jtApellido.requestFocus();
                            jtApellido.setBorder(border);
                        }else{
                            // try{
                         //   fecha = LocalDate.parse((CharSequence) jcFecha.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            
                            try{
                                domicilio = jtDomicilio.getText();
                                if(domicilio.isEmpty()){
                                JOptionPane.showMessageDialog(this, "Campo vacio en DOMICILIO");
                                jtDomicilio.requestFocus();
                                jtDomicilio.setBorder(border);
                            }  else{
                                 try{
                                    email = jtEmail.getText();
                                        if(email.isEmpty()){
                                        JOptionPane.showMessageDialog(this, "Campo vacio en EMAIL");
                                        jtEmail.requestFocus();
                                        jtEmail.setBorder(border);
                                        } else{
                                            try{
                                                tel= Integer.parseInt(jtTel.getText());
                                        
                                            try{
                                                localidad = cbLoc.getSelectedItem().toString();
                                                if (localidad.isEmpty()){
                                                    JOptionPane.showMessageDialog(this, "Debe seleccionar una localidad");
                                                }else{
                                                  try{
                                                    altura = Integer.parseInt(jtAltura.getText());
                                                
                                                    try{
                                                        peso = Double.parseDouble(jtPeso.getText());
                                                    
                                                        try{
                                                            Patologia patologia = (Patologia) cbPat.getSelectedItem();
                                                                if (patologia==null){
                                                                    JOptionPane.showMessageDialog(this, "Debe seleccionar una opcion en patologia");
                                                                }else{
                                                                    val = true;
                                                                }
                                                        }catch(NumberFormatException e){
                                                            JOptionPane.showMessageDialog(this, "Error en patologia");
                                                            cbPat.requestFocus();
                                                        }                                                
                                                    }catch(NumberFormatException e){
                                                        JOptionPane.showMessageDialog(this, "PESO debe ser numero entero o decimal");
                                                        jtPeso.requestFocus();
                                                        jtPeso.setBorder(border);
                                                    }  
                                           
                                                    }catch(NumberFormatException e){
                                                        JOptionPane.showMessageDialog(this, "ALTURA debe ser numero entero");
                                                        jtAltura.requestFocus();
                                                        jtAltura.setBorder(border);
                                                    }  
                                                }
                                                
                                            }catch(Exception e){
                                                JOptionPane.showMessageDialog(this, "error en localidad");
                                            }
                                        }catch(NumberFormatException e){
                                            JOptionPane.showMessageDialog(this, "TELEFONO debe ser numero entero");
                                            jtTel.requestFocus();
                                            jtTel.setBorder(border);
                                        }
                                        }
                                         
                                }catch(Exception e){
                                    JOptionPane.showMessageDialog(this, "Error en email");
                                    jtEmail.requestFocus();
                                    jtEmail.setBorder(border);
                                }   
                                }
                                
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(this, "Error en domicilio");
                                jtDomicilio.requestFocus();
                                jtDomicilio.setBorder(border);
                            }
                      //  }catch(Exception e){
                        //    JOptionPane.showMessageDialog(this, "El formato de fecha debe ser: dd/MM/yyyy");
                          //  jcFecha.requestFocus();
                           // jcFecha.setBorder(border);  
                        //}
                        }
                       
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, "Formato de APELLIDO incorrecto");
                        jtApellido.requestFocus();
                        jtApellido.setBorder(border);
                    }
                    }
                    
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, "Error en Nombre");
                        jtNombre.requestFocus();
                        jtNombre.setBorder(border);
                    }
                }catch(NumberFormatException e){
                     JOptionPane.showMessageDialog(this, "DNI debe ser numero entero");
                     jtDni.requestFocus();
                     jtDni.setBorder(border);
                }
            
                if (val){
                    Persona p = new Persona(nombre,apellido,email,localidad,domicilio,"salud",dni,tel,fecha,altura,peso);
                    pd.registrarPersona(p);
                    JOptionPane.showMessageDialog(this, "Solicitud Realizada");
                }
                
                
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jtDomicilioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDomicilioKeyTyped
        jtDomicilio.setBorder(null);
    }//GEN-LAST:event_jtDomicilioKeyTyped

    private void jtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDniKeyTyped
        jtDni.setBorder(null);
    }//GEN-LAST:event_jtDniKeyTyped

    private void jtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellidoKeyTyped
        jtApellido.setBorder(null);
    }//GEN-LAST:event_jtApellidoKeyTyped

    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyTyped
        jtNombre.setBorder(null);
    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEmailKeyTyped
        jtEmail.setBorder(null);
    }//GEN-LAST:event_jtEmailKeyTyped

    private void jtTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTelKeyTyped
       jtTel.setBorder(null);
    }//GEN-LAST:event_jtTelKeyTyped

    private void jtAlturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtAlturaKeyTyped
       jtAltura.setBorder(null);
    }//GEN-LAST:event_jtAlturaKeyTyped

    private void jtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPesoKeyTyped
        jtPeso.setBorder(null);
    }//GEN-LAST:event_jtPesoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Localidad> cbLoc;
    private javax.swing.JComboBox<Patologia> cbPat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private com.toedter.calendar.JDateChooser jcFecha;
    private javax.swing.JTextField jtAltura;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtDomicilio;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPeso;
    private javax.swing.JTextField jtTel;
    // End of variables declaration//GEN-END:variables

void limpiar(){
       jtDni.setText(null);
       jtNombre.setText(null);
       jtApellido.setText(null);
       jtDomicilio.setText(null);
       jtTel.setText(null);
       jtAltura.setText(null);
       jtPeso.setText(null);
       cbLoc.setAction(null);
       cbPat.setAction(null);
       jtEmail.setText(null);
       jcFecha.setDate(null);
       jtDni.requestFocus();
}
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
