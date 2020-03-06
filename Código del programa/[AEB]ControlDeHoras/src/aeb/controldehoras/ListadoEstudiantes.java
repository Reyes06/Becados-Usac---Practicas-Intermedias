package aeb.controldehoras;

import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EddyReyes
 */
public class ListadoEstudiantes extends javax.swing.JFrame {

    public ListadoEstudiantes() {
        initComponents();
        generarListadoEstudiantes(0);
        setLocationRelativeTo(null);
        jButton3.setEnabled(false);
        cargarImagenes();
    }

    public void generarListadoEstudiantes(int seleccion) {
        DBConection conexion = new DBConection();
        try {
            String[] estudiantes = conexion.obtenerEstudiantes(seleccion);
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
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

    public void cargarImagenes() {
        redimensionarImagen("src/imagenes/estadistica.png", jLabel6);
        redimensionarImagen("src/imagenes/nuevo.png", jLabel2);
        redimensionarImagen("src/imagenes/Actividad.png", jLabel5);
        redimensionarImagen("src/imagenes/buscar.png", jButton4);
        redimensionarImagen("src/imagenes/actividad.jpg", jLabel1);
    }

    private void redimensionarImagen(String ruta, JLabel lbl) {
        ImageIcon temp = new ImageIcon(ruta);
        Icon temp2 = new ImageIcon(temp.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        lbl.setIcon(temp2);
    }

    private void redimensionarImagen(String ruta, JButton btn) {
        ImageIcon temp = new ImageIcon(ruta);
        Icon temp2 = new ImageIcon(temp.getImage().getScaledInstance(26, 26, Image.SCALE_DEFAULT));
        btn.setIcon(temp2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de horas -AEB-");
        setMaximumSize(new java.awt.Dimension(690, 660));
        setMinimumSize(new java.awt.Dimension(690, 660));
        setPreferredSize(new java.awt.Dimension(690, 660));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Registro Academico", "Nombre", "Total de horas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(270);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 660, 470));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel3.setText("Ordenar listado");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registro académico (Desc)", "Registro académico (Asc)", "Total de horas (Desc)", "Total de horas (Asc)", "Nombre (A-Z)", "Nombre (Z-A)" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 30));

        jButton7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton7.setText("Estadisticas");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 170, 30));

        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 30, 30));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 220, 110));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton3.setText("Mostrar listado completo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 210, 30));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setText("Registro académico");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 30, 30));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, 30));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 110));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton5.setText("Nuevo Estudiante");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 140, 30));

        jButton9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton9.setText("Actividades");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 140, 30));

        jButton6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton6.setText("Actividad Grupal");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 140, 30));

        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 30, 30));

        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 30, 30));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 190, 110));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        AgregarEstudiante au = new AgregarEstudiante((DefaultTableModel) jTable1.getModel(), jComboBox1);
        au.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        AgregarActividadGrupal aag = new AgregarActividadGrupal((DefaultTableModel) jTable1.getModel(), jComboBox1.getSelectedIndex());
        aag.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Actividades act = new Actividades((DefaultTableModel) jTable1.getModel(), jComboBox1);
        act.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jButton3.setEnabled(true);
        DBConection db = new DBConection();
        try {

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            int temp = modelo.getRowCount();
            for (int i = 0; i < temp; i++) {
                modelo.removeRow(0);
            }
            String[] estudiantes = db.buscarEstudiante(Integer.parseInt(jTextField1.getText()), 0);

            if (estudiantes.length > 0) {
                for (String estudiante : estudiantes) {
                    String[] datos = estudiante.split(";");
                    modelo.addRow(datos);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se encontraron resultados");
                generarListadoEstudiantes(jComboBox1.getSelectedIndex());
            }

        } catch (SQLException ex) {
            Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "El registro academico debe ser un campo numérico");
            generarListadoEstudiantes(jComboBox1.getSelectedIndex());
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        generarListadoEstudiantes(jComboBox1.getSelectedIndex());
        jButton3.setEnabled(false);
        jTextField1.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        int index = jComboBox1.getSelectedIndex();
        if (jTextField1.getText().trim().equals("")) {
            generarListadoEstudiantes(index);
        } else {
            try {
                DBConection db = new DBConection();
                DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                int temp = modelo.getRowCount();
                for (int i = 0; i < temp; i++) {
                    modelo.removeRow(0);
                }
                String[] estudiantes = db.buscarEstudiante(Integer.parseInt(jTextField1.getText()), index);

                if (estudiantes.length > 0) {
                    for (String estudiante : estudiantes) {
                        String[] datos = estudiante.split(";");
                        modelo.addRow(datos);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se encontraron resultados");
                    generarListadoEstudiantes(jComboBox1.getSelectedIndex());
                }

            } catch (SQLException ex) {
                Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "El registro académico debe ser un campo numérico");
                generarListadoEstudiantes(jComboBox1.getSelectedIndex());
            }
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Opción actualmente no disponible");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        String carnet = modelo.getValueAt(fila, 0).toString();
        ControlDeHoras cdh = new ControlDeHoras(Integer.parseInt(carnet), modelo, jComboBox1);
        cdh.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
