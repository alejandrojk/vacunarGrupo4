/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunargrupo4.vistas;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import vacunargrupo4.control.CitasData;
import vacunargrupo4.control.Conexion;
import vacunargrupo4.control.CtroData;
import vacunargrupo4.control.PersonaData;
import vacunargrupo4.control.VacunaData;
import vacunargrupo4.modelos.Citas;
import vacunargrupo4.modelos.CtroVacunacion;
import vacunargrupo4.modelos.Vacuna;
import static vacunargrupo4.vistas.ViewRegistroPersona.validarString;

/**
 *
 * @author Maxi
 */
public class ViewVacunacion extends javax.swing.JInternalFrame {

    Conexion conexion;
    ArrayList<CtroVacunacion> centros;
    CtroData ct;
    Border border;
    public ViewVacunacion(Conexion conexion) {
        initComponents();
        this.conexion=conexion;
        border = new LineBorder(Color.RED, 2, true);
        this.conexion=conexion;
        ct = new CtroData(conexion);
        centros = ct.obtenerCtroVacunacions();
        cargaCentro();
        cargaDosis();
        jtNombre.requestFocus();
    }
    
    public void cargaCentro(){
        for (CtroVacunacion item:centros){
            cbCentro.addItem(item);
        }
    }
    public void cargaDosis(){
        cbDosis.addItem("Primera Dosis");
        cbDosis.addItem("Segunda Dosis");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtVacuna = new javax.swing.JTextField();
        jtApe = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtDni = new javax.swing.JTextField();
        cbDosis = new javax.swing.JComboBox<>();
        jbVacunar = new javax.swing.JButton();
        cbCentro = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jtCita = new javax.swing.JTextField();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(51, 35, 76));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("APELLIDO");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRE");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("LUGAR DE VACUNACION");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DOSIS");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("VACUNA");

        jLabel8.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("D.N.I");

        jtVacuna.setBackground(new java.awt.Color(83, 58, 124));
        jtVacuna.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtVacuna.setForeground(new java.awt.Color(255, 255, 255));
        jtVacuna.setText("8490001");
        jtVacuna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtVacunaKeyTyped(evt);
            }
        });

        jtApe.setBackground(new java.awt.Color(83, 58, 124));
        jtApe.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtApe.setForeground(new java.awt.Color(255, 255, 255));
        jtApe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtApeKeyTyped(evt);
            }
        });

        jtNombre.setBackground(new java.awt.Color(83, 58, 124));
        jtNombre.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtNombre.setForeground(new java.awt.Color(255, 255, 255));
        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreKeyTyped(evt);
            }
        });

        jtDni.setBackground(new java.awt.Color(83, 58, 124));
        jtDni.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtDni.setForeground(new java.awt.Color(255, 255, 255));
        jtDni.setText("42234534");
        jtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDniKeyTyped(evt);
            }
        });

        cbDosis.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N

        jbVacunar.setBackground(new java.awt.Color(51, 35, 76));
        jbVacunar.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jbVacunar.setForeground(new java.awt.Color(255, 255, 255));
        jbVacunar.setText("Guardar");
        jbVacunar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVacunarActionPerformed(evt);
            }
        });

        cbCentro.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("NRO CITA");

        jtCita.setBackground(new java.awt.Color(83, 58, 124));
        jtCita.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jtCita.setForeground(new java.awt.Color(255, 255, 255));
        jtCita.setText("110");
        jtCita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtCitaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbVacunar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtApe, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtCita, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(76, 76, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtVacuna)
                                    .addComponent(cbDosis, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(29, 29, 29)
                                .addComponent(cbCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtApe, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtCita, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDosis, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtVacuna, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jbVacunar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
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

    private void jbVacunarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVacunarActionPerformed
        int dni,vacuna,idCita;
        String dosis,nombre,apellido;
        CtroVacunacion c = new CtroVacunacion();
        Vacuna v = new Vacuna();
        Citas cita = new Citas();
        CtroData cd=new CtroData(conexion);
        VacunaData vd = new VacunaData(conexion);
        PersonaData pd = new PersonaData(conexion);
        CitasData cc = new CitasData(conexion);
        
        try{
        dni= Integer.parseInt(jtDni.getText());
            
            
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
                        
                        apellido = jtApe.getText();
                        if(apellido.isEmpty()){
                            JOptionPane.showMessageDialog(this, "Campo vacio en APELLIDO");
                            jtApe.requestFocus();
                            jtApe.setBorder(border);
                        }else if (!validarString(apellido)){
                            JOptionPane.showMessageDialog(this, "Formato de APELLIDO incorrecto");
                            jtApe.requestFocus();
                            jtApe.setBorder(border);
                        }else{
                            try{
                                idCita=Integer.parseInt(jtCita.getText());
                                cita = cc.buscarCita(idCita);
                                if(cita.getId()==0){
                                   JOptionPane.showMessageDialog(this,"No se encuentra cita: "+idCita); 
                                }else{
                                    
                                
                            try{                               
                                c = (CtroVacunacion) cbCentro.getSelectedItem();
                                dosis = (String) cbDosis.getSelectedItem();
                                cita.setMotivo(dosis);
                                int num=Integer.parseInt(jtVacuna.getText());
                                v = vd.obtenerVacuna(num);
                                if(!cita.getEstado()){
                                    JOptionPane.showMessageDialog(this," ya fue vacunado en cita: "+idCita);
                                    
                                }else{
                                    if(!v.isEstado()){
                                        JOptionPane.showMessageDialog(this, "Vacuna con numero de serie: "+num+" ya ha sido usada o no se encuentra disponible");
                                    }else{
                                        cc.aplicarVacuna(v, cita);
                                        limpiar();
                                    }
                                }
                                     
                            
                            }catch(NumberFormatException d){
                                JOptionPane.showMessageDialog(this, "El nro de Serie de la vacuna deben ser solo numeros");
                                jtVacuna.requestFocus();
                                jtVacuna.setBorder(border);
                            }
                            
                          
                                }
                            }catch(NumberFormatException h){
                                JOptionPane.showMessageDialog(this, "Numero de Cita incorrecto");
                                jtCita.requestFocus();
                                jtCita.setBorder(border);    
                            } catch (SQLException ex) {
                                Logger.getLogger(ViewVacunacion.class.getName()).log(Level.SEVERE, null, ex);
                            } 
                         }
                        
                    
                    
                }}catch(NumberFormatException e){
                     JOptionPane.showMessageDialog(this, "DNI debe ser numero entero");
                     jtDni.requestFocus();
                     jtDni.setBorder(border);
                }   
        
    }//GEN-LAST:event_jbVacunarActionPerformed

    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyTyped
jtNombre.setBorder(null);        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtApeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApeKeyTyped
        jtApe.setBorder(null);// TODO add your handling code here:
    }//GEN-LAST:event_jtApeKeyTyped

    private void jtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDniKeyTyped
jtDni.setBorder(null);        // TODO add your handling code here:
    }//GEN-LAST:event_jtDniKeyTyped

    private void jtCitaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCitaKeyTyped
jtCita.setBorder(null);        // TODO add your handling code here:
    }//GEN-LAST:event_jtCitaKeyTyped

    private void jtVacunaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtVacunaKeyTyped
jtVacuna.setBorder(null);        // TODO add your handling code here:
    }//GEN-LAST:event_jtVacunaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<CtroVacunacion> cbCentro;
    private javax.swing.JComboBox<String> cbDosis;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbVacunar;
    private javax.swing.JTextField jtApe;
    private javax.swing.JTextField jtCita;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtVacuna;
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
public void limpiar(){
    jtNombre.setText(null);
    jtDni.setText(null);
    jtApe.setText(null);
    jtVacuna.setText(null);
    jtCita.setText(null);
}

}

