/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunargrupo4.vistas;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import vacunargrupo4.control.Conexion;
import vacunargrupo4.control.PatologiaData;
import vacunargrupo4.modelos.Patologia;
import vacunargrupo4.modelos.Persona;

/**
 *
 * @author Maxi
 */
public class ViewPersona extends javax.swing.JInternalFrame {

    Persona p;
    Conexion con;
    
    public ViewPersona(Conexion conexion,Persona p) {
        initComponents();
        con=conexion;
        this.p=p;
        cargaDatos();
    }
    
    
   
    public void cargaDatos(){
        jtDni.setText(String.valueOf(p.getDni()));
        jtNombre.setText(p.getNombre());
        jtApellido.setText(p.getApellido());
        jtEmail.setText(p.getEmail());
        jtAltura.setText(String.valueOf(p.getAltura()));
        jtPeso.setText(String.valueOf(p.getPeso()));
        jtTel.setText(String.valueOf(p.getCelular()));
        jtLocalidad.setText(p.getLocalidad());
        jtDomicilio.setText(p.getDireccion());
        jtFecha.setText(String.valueOf(p.getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtDni4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtDni = new javax.swing.JTextField();
        jtFecha = new javax.swing.JTextField();
        jtEmail = new javax.swing.JTextField();
        jtLocalidad = new javax.swing.JTextField();
        jtTel = new javax.swing.JTextField();
        jtDomicilio = new javax.swing.JTextField();
        jtPeso = new javax.swing.JTextField();
        jtAltura = new javax.swing.JTextField();

        jtDni4.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtDni4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDni4ActionPerformed(evt);
            }
        });
        jtDni4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDni4KeyTyped(evt);
            }
        });

        setBackground(new java.awt.Color(51, 35, 76));
        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(51, 35, 76));

        jLabel12.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Peso");

        jLabel11.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Altura");

        jLabel9.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Telefono");

        jLabel8.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Domicilio");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("D.N.I");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha Nac");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre");

        jLabel10.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Localidad");

        jtNombre.setEditable(false);
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

        jtApellido.setEditable(false);
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

        jtDni.setEditable(false);
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

        jtFecha.setEditable(false);
        jtFecha.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtFechaActionPerformed(evt);
            }
        });
        jtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtFechaKeyTyped(evt);
            }
        });

        jtEmail.setEditable(false);
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

        jtLocalidad.setEditable(false);
        jtLocalidad.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtLocalidadActionPerformed(evt);
            }
        });
        jtLocalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtLocalidadKeyTyped(evt);
            }
        });

        jtTel.setEditable(false);
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

        jtDomicilio.setEditable(false);
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

        jtPeso.setEditable(false);
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

        jtAltura.setEditable(false);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtPeso, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jtTel, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jtDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jtLocalidad))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
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

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreActionPerformed

    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyTyped
        jtNombre.setBorder(null);
    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtApellidoActionPerformed

    private void jtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellidoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtApellidoKeyTyped

    private void jtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDniActionPerformed

    private void jtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDniKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDniKeyTyped

    private void jtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtFechaActionPerformed

    private void jtFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFechaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtFechaKeyTyped

    private void jtDni4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDni4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDni4ActionPerformed

    private void jtDni4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDni4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDni4KeyTyped

    private void jtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEmailActionPerformed

    private void jtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEmailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEmailKeyTyped

    private void jtLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtLocalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtLocalidadActionPerformed

    private void jtLocalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtLocalidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtLocalidadKeyTyped

    private void jtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTelActionPerformed

    private void jtTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTelKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTelKeyTyped

    private void jtDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDomicilioActionPerformed

    private void jtDomicilioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDomicilioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDomicilioKeyTyped

    private void jtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPesoActionPerformed

    private void jtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPesoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPesoKeyTyped

    private void jtAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtAlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtAlturaActionPerformed

    private void jtAlturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtAlturaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtAlturaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtAltura;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtDni4;
    private javax.swing.JTextField jtDomicilio;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtFecha;
    private javax.swing.JTextField jtLocalidad;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPeso;
    private javax.swing.JTextField jtTel;
    // End of variables declaration//GEN-END:variables
}
