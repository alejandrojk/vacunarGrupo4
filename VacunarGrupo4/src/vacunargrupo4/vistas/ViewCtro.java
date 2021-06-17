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
import vacunargrupo4.control.Conexion;
import vacunargrupo4.control.CtroData;
import vacunargrupo4.control.LocalidadData;
import vacunargrupo4.modelos.CtroVacunacion;
import vacunargrupo4.modelos.Laboratorio;
import vacunargrupo4.modelos.Localidad;
import vacunargrupo4.modelos.Vacuna;

/**
 *
 * @author Maxi
 */
public class ViewCtro extends javax.swing.JInternalFrame {

    Conexion conexion;
    ArrayList<Localidad> localidades;
    LocalidadData loc;
    Border border;
    public ViewCtro(Conexion conexion) {
        initComponents();
        border = new LineBorder(Color.getHSBColor(0, 87, 100), 3, true);
        this.conexion=conexion;
        loc= new LocalidadData(conexion);
        localidades = loc.obtenerLocalidads();
        cargarLocalidades();
    }
    
    public void cargarLocalidades(){
        for(Localidad item:localidades){
            cbLoc.addItem(item);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtDir = new javax.swing.JTextField();
        cbLoc = new javax.swing.JComboBox<>();
        jbCargar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(51, 35, 76));

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Localidad");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Direccion");

        jtNombre.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreKeyTyped(evt);
            }
        });

        jtDir.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jtDir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDirKeyTyped(evt);
            }
        });

        cbLoc.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N

        jbCargar.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jbCargar.setText("Cargar");
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtDir, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(jtNombre)
                            .addComponent(cbLoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jbCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jbCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
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

    private void jbCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarActionPerformed
        String nombre,direccion;
        Localidad loc;
        CtroData cd = new CtroData(conexion);
        try{
            
            nombre = jtNombre.getText();
            if (nombre.isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe completar el Nombre");
                jtNombre.requestFocus();
                jtNombre.setBorder(border);
            }else{
                direccion = jtDir.getText();
                    if (direccion.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Debe completar Direccion");
                        jtDir.requestFocus();
                        jtDir.setBorder(border);
                    }else{
                        loc = (Localidad) cbLoc.getSelectedItem();
                        CtroVacunacion c = new CtroVacunacion();
                        c.setDireccion(direccion);
                        c.setLocalidad(loc.getNombre());
                        c.setNombre(nombre);
                        cd.registrarCtroVacunacion(c);
                        JOptionPane.showMessageDialog(null, "Centro cargado correctamente");
                    }
            }
        
        }catch(NumberFormatException c){
            JOptionPane.showMessageDialog(null, "Error al cargar centro");
        }    
    }//GEN-LAST:event_jbCargarActionPerformed

    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyTyped
        jtNombre.setBorder(null);
    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtDirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDirKeyTyped
        jtDir.setBorder(null);
    }//GEN-LAST:event_jtDirKeyTyped

    public void limpiar(){
        jtNombre.setText(null);
        jtDir.setText(null);
        jtNombre.requestFocus();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Localidad> cbLoc;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCargar;
    private javax.swing.JTextField jtDir;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
