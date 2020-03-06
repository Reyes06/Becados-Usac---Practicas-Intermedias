package aeb.controldehoras;

import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EddyReyes
 */
public class AgregarActividadGrupal extends javax.swing.JFrame {

    DefaultTableModel modeloTabla1;
    DefaultTableModel modeloTabla2;
    DefaultTableModel modeloEstudiantes;
    int ordenamientoEstudiantes;

    public AgregarActividadGrupal(DefaultTableModel modeloEstudiantes, int ordenamientoEstudiantes) {
        initComponents();
        setLocationRelativeTo(null);
        modeloTabla1 = (DefaultTableModel) jTable1.getModel();
        modeloTabla2 = (DefaultTableModel) jTable2.getModel();
        this.modeloEstudiantes = modeloEstudiantes;
        this.ordenamientoEstudiantes = ordenamientoEstudiantes;
        redimensionarImagen("src/imagenes/buscar.png", jButton4);
        cargarEstudiantes();
        cargarActividades();
        cargarRadioButtons();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Actividad Grupal");
        setPreferredSize(new java.awt.Dimension(1015, 550));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("INFORMACION DE LA ACTIVIDAD");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel2.setText("Fecha");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel3.setText("Lugar");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel4.setText("Actividad");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 300, 20));

        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 280, 20));

        jRadioButton1.setText("Total de horas");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, -1, -1));

        jRadioButton2.setText("Hora Inicio-Fin");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 350, 10));

        jLabel7.setText("Registro academico");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 180, 30));

        jButton4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 30, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "R.A.", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(75);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(75);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 350, 240));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 110, 30));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 10, 500));

        jLabel5.setText("ESTUDIANTES INVOLUCRADOS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "R.A.", "Nombre", "HInicio", "HFin", "Horas"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(75);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(75);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(75);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(350);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(350);
            jTable2.getColumnModel().getColumn(4).setMaxWidth(75);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 600, 430));

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 480, 100, 30));

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 480, 100, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 70, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("Total de horas");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        jPanel1.add(jPanel2, "card2");

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setText("Hrs");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 45, -1, 20));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel9.setText("Hora fin");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 45, -1, 20));

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 45, 40, -1));

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(jFormattedTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 15, 40, -1));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel10.setText("Hora inicio");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, -1, 20));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel11.setText("Hrs");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 15, -1, 20));

        jPanel1.add(jPanel3, "card3");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 220, 80));

        jButton5.setText("Vaciar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 480, 100, 30));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 300, -1));

        jButton6.setText("Cancelar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 480, 100, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void redimensionarImagen(String ruta, JButton btn) {
        ImageIcon temp = new ImageIcon(ruta);
        Icon temp2 = new ImageIcon(temp.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        btn.setIcon(temp2);
    }

    private void cargarEstudiantes() {
        DBConection conexion = new DBConection();
        try {
            String[] estudiantes = conexion.obtenerEstudiantes();
            for (String estudiante : estudiantes) {
                modeloTabla1.addRow(estudiante.split(";"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarActividadGrupal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void recargarEstudiantes() {
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            modeloTabla1.removeRow(0);
        }
        cargarEstudiantes();
    }

    private void cargarActividades() {
        DBConection conexion = new DBConection();
        try {
            String[] actividades = conexion.obtenerActividades();
            DefaultComboBoxModel modelo = (DefaultComboBoxModel) jComboBox2.getModel();
            for (String actividad : actividades) {
                modelo.addElement(actividad);
            }
            //jComboBox1.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(AgregarActividadIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarRadioButtons() {
        jRadioButton2.setSelected(true);
        jPanel3.setVisible(true);
        jPanel2.setVisible(false);
    }

    public void actualizarListadoEstudiantes(int seleccion) {
        DBConection conexion = new DBConection();
        try {
            int temp = modeloEstudiantes.getRowCount();
            for (int i = 0; i < temp; i++) {
                modeloEstudiantes.removeRow(0);
            }
            String[] estudiantes = conexion.obtenerEstudiantes(seleccion);
            for (String estudiante : estudiantes) {
                String[] datos = estudiante.split(";");
                modeloEstudiantes.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        jRadioButton2.setSelected(false);
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        jRadioButton1.setSelected(false);
        jPanel2.setVisible(false);
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DBConection conexion = new DBConection();

        try {
            int temp = modeloTabla1.getRowCount();
            for (int i = 0; i < temp; i++) {
                modeloTabla1.removeRow(0);
            }
            String[] estudiantes;
            if (jTextField2.getText().equals("")) {
                estudiantes = conexion.obtenerEstudiantes();
            } else {
                estudiantes = conexion.buscarEstudiantes(jTextField2.getText());
            }

            if (estudiantes.length > 0) {
                for (String estudiante : estudiantes) {
                    String[] datos = estudiante.split(";");
                    modeloTabla1.addRow(datos);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se encontraron resultados");
                recargarEstudiantes();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextField2.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int fila = jTable1.getSelectedRow();
        try {
            if (fila > -1) {
                boolean existe = false;
                String carne = modeloTabla1.getValueAt(fila, 0).toString();
                int temp2 = jTable2.getRowCount();
                for (int i = 0; i < temp2; i++) {
                    if (carne.equals(modeloTabla2.getValueAt(i, 0))) {
                        existe = true;
                    }
                }
                if (!existe) {
                    String nombre = modeloTabla1.getValueAt(fila, 1).toString();
                    String horaIni;
                    String horaFin;
                    String horas;
                    if (jRadioButton2.isSelected()) {
                        horaIni = jFormattedTextField2.getText();
                        horaFin = jFormattedTextField1.getText();
                        String[] horaIni2 = jFormattedTextField2.getText().split(":");
                        String[] horaFin2 = jFormattedTextField1.getText().split(":");
                        double temp = Double.valueOf(horaFin2[0]) - Double.valueOf(horaIni2[0]) + (Double.valueOf(horaFin2[1]) - Double.valueOf(horaIni2[1])) / 60;
                        horas = Double.toString((double) Math.round(temp * 100d) / 100d);

                        int horaI = Integer.parseInt(horaIni.split(":")[0]);
                        int horaF = Integer.parseInt(horaFin.split(":")[0]);
                        int minutosI = Integer.parseInt(horaIni.split(":")[1]);
                        int minutosF = Integer.parseInt(horaFin.split(":")[1]);

                        if (horaI < 24 && horaF <= 24 && minutosI < 60 && minutosF < 60) {
                            String[] estudiante = {carne, nombre, horaIni, horaFin, horas};
                            modeloTabla2.addRow(estudiante);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "ERROR: La hora debe estar en formato de 24 horas");
                        }
                    } else {
                        if(jTextField3.getText().equals("")){
                            JOptionPane.showMessageDialog(rootPane, "ERROR: No se ha llenado el campo de total de horas");
                        } else {
                            horaIni = "---";
                            horaFin = "---";
                            horas = jTextField3.getText();
                            String[] estudiante = {carne, nombre, horaIni, horaFin, horas};
                            modeloTabla2.addRow(estudiante);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Estudiante ya registrado");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "ERROR: La hora debe estar en formato de 24 horas");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Hora en formato invalido");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jRadioButton2.setSelected(true);
        jRadioButton1.setSelected(false);
        jPanel3.setVisible(true);
        jPanel2.setVisible(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jRadioButton1.setSelected(true);
        jRadioButton2.setSelected(false);
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int fila = jTable2.getSelectedRow();
        if (fila > -1) {
            modeloTabla2.removeRow(fila);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ningun estudiante seleccionado");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int temp = modeloTabla2.getRowCount();
        for (int i = 0; i < temp; i++) {
            modeloTabla2.removeRow(0);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String formato = jDateChooser1.getDateFormatString();
        Date date = jDateChooser1.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String fecha;
        try {
            fecha = String.valueOf(sdf.format(date));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "ERROR: Formato de la fecha incorrecto");
            fecha = "";
        }
        String lugar = jTextField1.getText();
        String actividadRealizada = jComboBox2.getSelectedItem().toString();
        
        int tamanoTabla = jTable2.getRowCount();
        if(tamanoTabla == 0){
            JOptionPane.showMessageDialog(rootPane, "ERROR: Tabla de ESTUDIANTES INVOLUCRADOS vacía");
        } else {
            for (int fila = 0; fila < tamanoTabla; fila++) {

                int registroAcademico = Integer.parseInt(modeloTabla2.getValueAt(fila, 0).toString());
                String horaIni = modeloTabla2.getValueAt(fila, 2).toString();
                String horaFin = modeloTabla2.getValueAt(fila, 3).toString();
                float totalHoras = Float.valueOf(modeloTabla2.getValueAt(fila, 4).toString());

                if (lugar.trim().equals("") || actividadRealizada.trim().equals("") || fecha.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informacion de la actividad incompleta");
                } else {
                    DBConection conexion = new DBConection();
                    if (horaIni.equals("---") && horaFin.equals("---")) {
                        try {
                            conexion.ingresarActividad(fecha, lugar, totalHoras, registroAcademico, actividadRealizada);
                        } catch (SQLException ex) {
                            Logger.getLogger(AgregarActividadGrupal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        String[] horaInicio2 = jFormattedTextField2.getText().split(":");
                        String[] horaFin2 = jFormattedTextField1.getText().split(":");
                        try {
                            int horaI = Integer.parseInt(horaInicio2[0]);
                            int horaF = Integer.parseInt(horaFin2[0]);
                            int minutosI = Integer.parseInt(horaInicio2[1]);
                            int minutosF = Integer.parseInt(horaFin2[1]);
                            if (horaI < 24 && horaF <= 24 && minutosI < 60 && minutosF < 60) {
                                if (horaF == 24 && minutosF == 0 || horaF < 24) {
                                    try {
                                        conexion.ingresarActividad(fecha, lugar, horaInicio2, horaFin2, registroAcademico, actividadRealizada);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(AgregarActividadGrupal.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    this.dispose();
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Hora en formato invalido");
                            }
                        } catch (NumberFormatException e) {
                            if (jRadioButton1.isSelected()) {
                                JOptionPane.showMessageDialog(rootPane, "El campo de total de horas debe de ser numérico");
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Hora en formato invalido");
                            }
                        }
                    }
                }
            }
            actualizarListadoEstudiantes(ordenamientoEstudiantes);
            JOptionPane.showMessageDialog(rootPane, "Actividad registrada correctamente");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
