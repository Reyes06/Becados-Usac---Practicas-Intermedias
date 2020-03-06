package aeb.controldehoras;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EddyReyes
 */
public class Actividades extends javax.swing.JFrame {

    DefaultTableModel modeloEstudiantes;
    JComboBox combobox;

    public Actividades(DefaultTableModel modeloEstudiantes, JComboBox combobox) {
        initComponents();
        cargarActividades();
        this.setLocationRelativeTo(null);
        this.modeloEstudiantes = modeloEstudiantes;
        this.combobox = combobox;
    }

    public void actualizarListadoEstudiantes() {
        DBConection conexion = new DBConection();
        try {
            String[] estudiantes = conexion.obtenerEstudiantes(combobox.getSelectedIndex());
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

    public void cargarActividades() {
        DBConection conexion = new DBConection();
        try {
            String[] actividades = conexion.obtenerListadoActividades();
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            for (String actividad : actividades) {
                modelo.addRow(actividad.split(";"));
            }
            jTable1.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void recargarActividades() {
        DBConection conexion = new DBConection();
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            int temp = modelo.getRowCount();
            for (int i = 0; i < temp; i++) {
                modelo.removeRow(0);
            }
            String[] actividades = conexion.obtenerListadoActividades();
            for (String actividad : actividades) {
                modelo.addRow(actividad.split(";"));
            }
            jTable1.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actividades");
        setPreferredSize(new java.awt.Dimension(520, 430));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Actividad");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 14, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 300, 25));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripción"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 490, 300));

        jButton1.setText("Agregar");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, 25));

        jButton2.setText("Eliminar");
        jButton2.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String actividad = jTextField1.getText();
        if (!actividad.equals("")) {
            DBConection conexion = new DBConection();
            try {
                conexion.ingresarActividad(actividad);
                recargarActividades();
                JOptionPane.showMessageDialog(rootPane, "Agregado correctamente");
            } catch (SQLException ex) {
                Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Por favor ingrese una actividad en el cuadro de texto");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTable1.getSelectedRow() > -1) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            String id = modelo.getValueAt(jTable1.getSelectedRow(), 0).toString();
            String actividad = modelo.getValueAt(jTable1.getSelectedRow(), 1).toString();
            int resp = JOptionPane.showConfirmDialog(rootPane, "La actividad " + actividad.toUpperCase() + " se eliminará de forma permanente.\nDesea continuar?", "Eliminar actividad", JOptionPane.YES_NO_OPTION);

            if (resp == JOptionPane.YES_OPTION) {
                try {
                    DBConection conexion = new DBConection();
                    conexion.eliminarListadoActividades(Integer.parseInt(id));
                    recargarActividades();
                    actualizarListadoEstudiantes();
                    JOptionPane.showMessageDialog(rootPane, "Actividad eliminada exitosamente");
                } catch (SQLException ex) {
                    Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una actividad");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
