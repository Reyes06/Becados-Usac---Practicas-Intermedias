package aeb.controldehoras;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eddy
 */
public class ControlDeHoras extends javax.swing.JFrame {

    int registroAcademico;
    DefaultTableModel modeloEstudiantes;
    JComboBox combobox;

    public ControlDeHoras(int registroAcademico, DefaultTableModel modelo, JComboBox combobox) {
        initComponents();
        this.registroAcademico = registroAcademico;
        this.modeloEstudiantes = modelo;
        this.combobox = combobox;
        generarListadoActividades();
        cargarTotalDeHoras();
        cargarPerfil();
        setLocationRelativeTo(null);
    }

    public void cargarPerfil() {
        DBConection conexion = new DBConection();
        try {
            String[] informacion = conexion.obtenerEstudiante(registroAcademico);
            jTextField1.setText(registroAcademico + "");
            jTextField2.setText(informacion[0]);
            jTextField3.setText(informacion[1]);
            jTextField5.setText(informacion[3]);
            jComboBox1.setSelectedItem(informacion[2]);
        } catch (SQLException ex) {
            Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generarListadoEstudiantes(int seleccion) {
        DBConection conexion = new DBConection();
        try {
            String[] estudiantes = conexion.obtenerEstudiantes(seleccion);
            int temp = modeloEstudiantes.getRowCount();
            for (int i = 0; i < temp; i++) {
                modeloEstudiantes.removeRow(0);
            }
            for (String estudiante : estudiantes) {
                String[] datos = estudiante.split(";");
                modeloEstudiantes.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarTotalDeHoras() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        if (modelo.getRowCount() > 0) {
            float totalHoras = 0;
            for (int fila = 0; fila < modelo.getRowCount(); fila++) {
                totalHoras += Float.valueOf(modelo.getValueAt(fila, 6).toString());
            }
            jLabel4.setText(Float.toString(totalHoras));
        } else {
            jLabel4.setText("0");
        }
    }

    public void generarListadoActividades() {
        DBConection conexion = new DBConection();
        try {
            String[] actividades = conexion.obtenerActividades(registroAcademico);
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            int temp = modelo.getRowCount();
            for (int i = 0; i < temp; i++) {
                modelo.removeRow(0);
            }
            for (String actividad : actividades) {
                String[] datos = actividad.split(";");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarInformacion(int registroAcademico) {
        String dpi = jTextField2.getText();
        String nombre = jTextField3.getText();
        String unidadAcademica = (String) jComboBox1.getSelectedItem();
        String carrera = jTextField5.getText();
        DBConection conexion = new DBConection();
        try {
            conexion.modificarEstudiante(registroAcademico, dpi, nombre, unidadAcademica, carrera);
            generarListadoEstudiantes(combobox.getSelectedIndex());
            JOptionPane.showMessageDialog(rootPane, "Modificado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información del Estudiante");
        setPreferredSize(new java.awt.Dimension(860, 580));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Fecha", "Actividad", "Lugar", "Hora Inicio", "Hora Fin", "Horas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 800, 360));

        jButton3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton3.setText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 100, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("Carné (DPI)");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("Nombre");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jTextField1.setEnabled(false);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 244, -1));

        jTextField2.setEnabled(false);
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 295, -1));

        jTextField3.setEnabled(false);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 325, -1));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel9.setText("Registro académico");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("Total de horas realizadas:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, 30));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel4.setText("100");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, -1, -1));

        jTextField5.setEnabled(false);
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 320, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01 - Facultad de Agronomia", "02 - Facultad de Arquitectura", "03 - Facultad de Ciencias Economicas", "04 - Facultad de Ciencias Juridicas y Sociales", "05 - Facultad de Ciencias Medicas", "06 - Facultad de Ciencias Quimicas y Farmacia", "07 - Facultad de Humanidades", "08 - Facultad de Ingenieria", "09 - Facultad de Odontologia", "10 - Facultad de Medicina Veterinaria y Zootecnia", "13 - Escuela de Ciencias Psicologicas", "14 - Escuela de historia", "15 - Escuela de Trabajo Social", "16 - Escuela de Ciencias de la Comuncicacion", "24 - Centro de estudios del mar -CEMA-", "28 - Escuela de Ciencia Politica", "29 - EFPEM", "30 - Escuela de Ciencias Linguisticas", "33 - Escuela Superior de Arte", "36 - ITUGS" }));
        jComboBox1.setEnabled(false);
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 240, -1));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setText("Unidad académica");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setText("Carrera");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 820, 100));

        jButton6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton6.setText("Eliminar Estudiante");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 150, 30));

        jButton4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton4.setText("Modificar Datos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 120, 30));

        jButton5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton5.setText("Agregar Actividad");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 130, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carta", "Oficio" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 100, 30));

        jLabel1.setText("Tamaño:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DBConection conexion = new DBConection();
        conexion.generarReporte(registroAcademico, jComboBox2.getSelectedIndex());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int resp = JOptionPane.showConfirmDialog(rootPane, "El estudiante " + jTextField3.getText().toUpperCase() + " se eliminará de forma permanente.\nDesea continuar?", "Eliminar estudiante", JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.YES_OPTION) {
            try {
                DBConection conexion = new DBConection();
                conexion.borrarEstudiante(registroAcademico);
                generarListadoEstudiantes(jComboBox1.getSelectedIndex());
                JOptionPane.showMessageDialog(rootPane, "Estudiante eliminado exitosamente");
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        String id = modelo.getValueAt(fila, 0).toString();
        String fecha = modelo.getValueAt(fila, 1).toString();
        String actividad = modelo.getValueAt(fila, 2).toString();
        String lugar = modelo.getValueAt(fila, 3).toString();
        String horaIni = modelo.getValueAt(fila, 4).toString();
        String horaFin = modelo.getValueAt(fila, 5).toString();
        String totalHoras = modelo.getValueAt(fila, 6).toString();
        String[] info = {id, fecha, actividad, lugar, horaIni, horaFin, totalHoras};
        ModificarActividad ma = new ModificarActividad(jLabel4, info, modelo, modeloEstudiantes, registroAcademico, combobox);
        ma.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jButton4.getText().equals("Guardar Datos")) {
            modificarInformacion(registroAcademico);
            jButton4.setText("Modificar Datos");
            jTextField2.setEnabled(false);
            jTextField3.setEnabled(false);
            jTextField5.setEnabled(false);
            jComboBox1.setEnabled(false);
        } else if (jButton4.getText().equals("Modificar Datos")) {
            jButton4.setText("Guardar Datos");
            jTextField2.setEnabled(true);
            jTextField3.setEnabled(true);
            jTextField5.setEnabled(true);
            jComboBox1.setEnabled(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        AgregarActividadIndividual aai = new AgregarActividadIndividual(jLabel4, (DefaultTableModel)jTable1.getModel(), modeloEstudiantes, registroAcademico, combobox);
        aai.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
