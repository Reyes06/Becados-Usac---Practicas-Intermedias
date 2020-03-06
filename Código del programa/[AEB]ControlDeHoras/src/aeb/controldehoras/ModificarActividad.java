package aeb.controldehoras;

import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author EddyReyes
 */
public class ModificarActividad extends javax.swing.JFrame {

    DefaultTableModel modeloActividades;
    DefaultTableModel modeloEstudiantes;
    JComboBox combobox;
    JLabel contador;
    int carnet;
    int id_actividad;

    public ModificarActividad(JLabel contador, String[] informacionActividad, DefaultTableModel modeloActividades, DefaultTableModel modeloEstudiantes, int carnet, JComboBox combobox) {
        initComponents();
        this.modeloActividades = modeloActividades;
        this.modeloEstudiantes = modeloEstudiantes;
        this.contador = contador;
        this.combobox = combobox;
        this.carnet = carnet;
        setLocationRelativeTo(null);
        
        cargarComboBox();
        cargarInformacion(informacionActividad);
        redimensionarImagen(jLabel7);
    }
    
    public void cargarComboBox(){
        DBConection conexion = new DBConection();
        try {
            String[] actividades = conexion.obtenerActividades();
            DefaultComboBoxModel modelo = (DefaultComboBoxModel) jComboBox1.getModel();
            for (String actividad : actividades) {
                modelo.addElement(actividad);
            }
            jComboBox1.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(AgregarActividadIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarInformacion(String[] info) {
        this.id_actividad = Integer.parseInt(info[0]);
        String fecha = info[1];
        String actividad = info[2];
        String lugar = info[3];
        String horaFin = info[4];
        String horaIni = info[5];
        String totalHoras = info[6];

        try {
            jTextField3.setText(lugar);
            jComboBox1.setSelectedItem(actividad);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
            jDateChooser1.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(ModificarActividad.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getLocalizedMessage());
        }
        if (horaIni.equals("---") && horaFin.equals("---")) {
            jRadioButton1.setSelected(true);
            jPanel2.setVisible(true);
            jPanel3.setVisible(false);
            jTextField1.setText(totalHoras);
        } else {
            jRadioButton2.setSelected(true);
            jPanel2.setVisible(false);
            jPanel3.setVisible(true);
            jFormattedTextField1.setText(horaIni);
            jFormattedTextField2.setText(horaFin);

        }
    }

    public void actualizarListadoActividades() {
        DBConection conexion = new DBConection();
        try {

            int temp = modeloActividades.getRowCount();
            for (int i = 0; i < temp; i++) {
                modeloActividades.removeRow(0);
            }
            String[] actividades = conexion.obtenerActividades(carnet);
            for (String actividad : actividades) {
                String[] datos = actividad.split(";");
                modeloActividades.addRow(datos);
            }
            float totalHoras = 0;
            for (int fila = 0; fila < modeloActividades.getRowCount(); fila++) {
                totalHoras += Float.valueOf(modeloActividades.getValueAt(fila, 6).toString());
            }
            contador.setText(Float.toString(totalHoras));
        } catch (SQLException ex) {
            Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void redimensionarImagen(JLabel lbl) {
        ImageIcon temp = new ImageIcon("src/imagenes/modificar.jpg");
        Icon temp2 = new ImageIcon(temp.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
        lbl.setIcon(temp2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Actividad");
        setMinimumSize(new java.awt.Dimension(575, 320));
        setPreferredSize(new java.awt.Dimension(575, 320));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setText("Fecha");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("Lugar");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setText("Hrs");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, 20));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel9.setText("Hora fin");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 20));

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 40, -1));

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(jFormattedTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 40, -1));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel10.setText("Hora inicio");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 20));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel11.setText("Hrs");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, 20));

        jPanel1.add(jPanel3, "card3");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 70, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("Total de horas");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 20));

        jPanel1.add(jPanel2, "card2");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 280, 80));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("Actividad realizada");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 220, 200));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 280, -1));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 220, -1));

        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 100, 30));

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 100, 30));

        jRadioButton1.setText("Total de horas");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jRadioButton2.setText("Hora Inicio-Fin");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int resp = JOptionPane.showConfirmDialog(rootPane, "¿Desea eliminar esta actividad?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            DBConection conexion = new DBConection();
            try {
                conexion.eliminarActividad(id_actividad);
                actualizarListadoActividades();
                actualizarListadoEstudiantes(combobox.getSelectedIndex());
                JOptionPane.showMessageDialog(rootPane, "Actividad elminada exitosamente");
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ControlDeHoras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
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
            int eleccion;
            if (jRadioButton1.isSelected()) {
                eleccion = 1;
            } else {
                eleccion = 2;
            }
            String lugar = jTextField3.getText();
            String actividadRealizada = jComboBox1.getSelectedItem().toString();

            if (lugar.trim().equals("") || actividadRealizada.trim().equals("") || fecha.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar todos los campos");
            } else {
                DBConection conexion = new DBConection();
                if (jRadioButton1.isSelected()) {
                    double totalDeHoras = Double.valueOf(jTextField1.getText());
                    conexion.reescribirActividad(id_actividad, fecha, lugar, actividadRealizada, totalDeHoras);
                    actualizarListadoActividades();
                    actualizarListadoEstudiantes(combobox.getSelectedIndex());
                    JOptionPane.showMessageDialog(rootPane, "Modificado exitosamente");
                    this.dispose();
                } else {
                    String[] horaInicio = jFormattedTextField2.getText().split(":");
                    String[] horaFin = jFormattedTextField1.getText().split(":");
                    int horaI = Integer.parseInt(horaInicio[0]);
                    int horaF = Integer.parseInt(horaFin[0]);
                    int minutosI = Integer.parseInt(horaInicio[1]);
                    int minutosF = Integer.parseInt(horaFin[1]);
                    if (horaI < 24 && horaF <= 24 && minutosI < 60 && minutosF < 60) {
                        if (horaF == 24 && minutosF == 0 || horaF < 24) {
                            conexion.reescribirActividad(id_actividad, fecha, lugar, actividadRealizada, horaInicio, horaFin);
                            actualizarListadoActividades();
                            actualizarListadoEstudiantes(combobox.getSelectedIndex());
                            JOptionPane.showMessageDialog(rootPane, "Modificado exitosamente");
                            this.dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Las horas de inicio y fin deben de estar en formato de 24 horas");
                    }
                }
            }
        } catch (NumberFormatException e) {
            boolean eleccion = jRadioButton1.isSelected();
            if (eleccion) {
                JOptionPane.showMessageDialog(rootPane, "El campo de total de horas debe de ser numérico");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Las horas de inicio y fin deben de estar en formato de 24 horas");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al guardar la información. Contacte con el administrador.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        jRadioButton2
                .setSelected(false);
        jPanel2
                .setVisible(true);
        jPanel3
                .setVisible(false);
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        jRadioButton1
                .setSelected(false);
        jPanel2
                .setVisible(false);
        jPanel3
                .setVisible(true);
    }//GEN-LAST:event_jRadioButton2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
