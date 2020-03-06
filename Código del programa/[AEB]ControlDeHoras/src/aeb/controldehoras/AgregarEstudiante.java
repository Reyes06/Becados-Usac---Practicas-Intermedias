package aeb.controldehoras;

import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EddyReyes
 */
public class AgregarEstudiante extends JFrame {

    DefaultTableModel modelo;
    JComboBox combobox;
    
    public AgregarEstudiante(DefaultTableModel modelo, JComboBox combobox) {
        initComponents();
        redimensionarImagen();
        setLocationRelativeTo(null);
        this.modelo = modelo;
        this.combobox = combobox;
        this.setVisible(true);
    }
    
    public void actualizarListadoEstudiantes() {
        DBConection conexion = new DBConection();
        try {
            String[] estudiantes = conexion.obtenerEstudiantes(combobox.getSelectedIndex());
            int temp = modelo.getRowCount();
            for (int i = 0; i < temp; i++) {
                modelo.removeRow(0);
            }
            for (String estudiante : estudiantes) {
                String[] datos = estudiante.split(";");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void redimensionarImagen(){
        ImageIcon temp = new ImageIcon("src/imagenes/nuevousuario.png");
        Icon temp2 = new ImageIcon(temp.getImage().getScaledInstance(lbl_icono.getWidth()-10, lbl_icono.getHeight()-10, Image.SCALE_DEFAULT));
        lbl_icono.setIcon(temp2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        lbl_icono = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Estudiante");
        setPreferredSize(new java.awt.Dimension(660, 270));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setText("Registro académico");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("Carné (DPI)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("Unidad académica");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("Carrera");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 244, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 290, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 325, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 327, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01 - Facultad de Agronomia", "02 - Facultad de Arquitectura", "03 - Facultad de Ciencias Economicas", "04 - Facultad de Ciencias Juridicas y Sociales", "05 - Facultad de Ciencias Medicas", "06 - Facultad de Ciencias Quimicas y Farmacia", "07 - Facultad de Humanidades", "08 - Facultad de Ingenieria", "09 - Facultad de Odontologia", "10 - Facultad de Medicina Veterinaria y Zootecnia", "13 - Escuela de Ciencias Psicologicas", "14 - Escuela de historia", "15 - Escuela de Trabajo Social", "16 - Escuela de Ciencias de la Comuncicacion", "24 - Centro de estudios del mar -CEMA-", "28 - Escuela de Ciencia Politica", "29 - EFPEM", "30 - Escuela de Ciencias Linguisticas", "33 - Escuela Superior de Arte", "36 - ITUGS" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 244, -1));
        getContentPane().add(lbl_icono, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 190, 180));

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 200, 95, 30));

        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 95, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            int registroAcademico = Integer.parseInt(jTextField1.getText());
            String dpi = jTextField2.getText();
            String nombre = jTextField3.getText();
            String unidadAcademica = jComboBox1.getSelectedItem().toString();
            String carrera = jTextField5.getText();
            if(nombre.trim().equals("") || unidadAcademica.trim().equals("") || carrera.trim().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Alguno de los campos está vacio");
            } else {
                DBConection conexion = new DBConection();
                conexion.ingresarEstudiante(registroAcademico, dpi, nombre, unidadAcademica, carrera);
                JOptionPane.showMessageDialog(rootPane, "Registrado exitosamente");
                actualizarListadoEstudiantes();
                this.dispose();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Los campos registro académico y DPI deben de ser numéricos");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Error al guardar la información. Contacte con el administrador.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lbl_icono;
    // End of variables declaration//GEN-END:variables
}
