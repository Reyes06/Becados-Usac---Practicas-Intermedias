package aeb.controldehoras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author EddyReyes
 */
public class DBConection {

    public Connection conectar() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost/aeb?user=root&password=123");
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Lo siento... algo ha fallado");
            System.err.println(e.getMessage());
            System.err.println(e.getLocalizedMessage());
            return null;
        }
    }
    
    public void eliminarListadoActividades(int id_actividad) throws SQLException{
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            //Eliminar de la tabla control
            consulta = "DELETE FROM control WHERE id_actividad = ?;";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, id_actividad);
            sentencia.executeUpdate();
            conexion.close();
            
            //Eliminar de la tabla actividad
            consulta = "DELETE FROM actividad WHERE id_actividad = ?;";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, id_actividad);
            sentencia.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }
    
    public String[] obtenerActividades() throws SQLException{
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            consulta = "SELECT actividad FROM actividad "
                    + "WHERE id_actividad != 1 "
                    + "ORDER BY actividad ASC;";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<String> actividades = new ArrayList();
            while(rs.next()){
                actividades.add(rs.getString(1));
            }
            conexion.close();
            return actividades.toArray(new String[actividades.size()]);
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
            return null;
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }
    
    public String[] obtenerListadoActividades() throws SQLException{
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            consulta = "SELECT id_actividad, actividad FROM actividad "
                    + "WHERE id_actividad != 1 "
                    + "ORDER BY actividad ASC;";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<String> actividades = new ArrayList();
            while(rs.next()){
                actividades.add(rs.getInt(1) + ";" + rs.getString(2));
            }
            conexion.close();
            return actividades.toArray(new String[actividades.size()]);
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
            return null;
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }
    
    public void ingresarActividad(String actividad) throws SQLException{
        Connection conexion = null;
        String consulta = "";
        PreparedStatement sentencia = null;
        try {
            consulta = "INSERT INTO actividad VALUES (null, ?)";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, actividad);
            sentencia.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }

    public void ingresarEstudiante(int registroAcademico, String dpi, String nombre, String unidadAcademica, String carrera) throws SQLException {
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            //Insertar en la tabla Estudiantes
            consulta = "INSERT INTO estudiante VALUES (?,?,?,?,?);";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, registroAcademico);
            sentencia.setString(2, dpi);
            sentencia.setString(3, nombre);
            sentencia.setString(4, unidadAcademica);
            sentencia.setString(5, carrera);
            sentencia.executeUpdate();
            conexion.close();
            
            //Insertar en la tabla Control
            consulta = "INSERT INTO control VALUES (null, '2018-12-30', 'Guatemala', '---', '---', 0, ?, 1);";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, registroAcademico);
            sentencia.executeUpdate();
            conexion.close();

        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }

    public void ingresarActividad(String fecha, String lugar, float totalDeHoras, int registroAcademico, String actividadRealizada) throws SQLException {
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            //Obtener el id de la actividad
            consulta = "SELECT id_actividad FROM actividad WHERE actividad = ?;";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, actividadRealizada);
            ResultSet rs = sentencia.executeQuery();
            rs.next();
            int idActividad = rs.getInt(1);
            conexion.close();

            //Ingresar a la tabla control
            consulta = "INSERT INTO control VALUES (null,?,?,'---','---',?,?,?)";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, fecha);
            sentencia.setString(2, lugar);
            sentencia.setFloat(3, totalDeHoras);
            sentencia.setInt(4, registroAcademico);
            sentencia.setInt(5, idActividad);
            
            sentencia.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }

    public void ingresarActividad(String fecha, String lugar, String[] horaDeInicio, String[] horaDeFin, int registroAcademico, String actividadRealizada) throws SQLException {
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            //Obtener el id de la actividad
            consulta = "SELECT id_actividad FROM actividad WHERE actividad = ?;";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, actividadRealizada);
            ResultSet rs = sentencia.executeQuery();
            rs.next();
            int id_actividad = rs.getInt(1);
            conexion.close();

            //Ingresar a la tabla control
            consulta = "INSERT INTO control VALUES (null,?,?,?,?,?,?,?)";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, fecha);
            sentencia.setString(2, lugar);
            sentencia.setString(3, horaDeInicio[0] + ":" + horaDeInicio[1]);
            sentencia.setString(4, horaDeFin[0] + ":" + horaDeFin[1]);
                double temp = Double.valueOf(horaDeFin[0]) - Double.valueOf(horaDeInicio[0]) + (Double.valueOf(horaDeFin[1]) - Double.valueOf(horaDeInicio[1])) / 60;
                double temp2 = (double) Math.round(temp * 100d) / 100d;
            sentencia.setDouble(5, temp2);
            sentencia.setInt(6, registroAcademico);
            sentencia.setInt(7, id_actividad);
            sentencia.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }

    public String[] obtenerEstudiantes(int seleccion) throws SQLException {
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            consulta = "SELECT E.registro_academico, E.nombre, SUM(C.horas) AS horasTotales "
                    + "FROM control C, estudiante E "
                    + "WHERE C.registro_academico = E.registro_academico "
                    + "GROUP BY E.registro_academico ";
            switch (seleccion) {
                case 0:
                    consulta += "ORDER BY E.registro_academico DESC";
                    break;
                case 1:
                    consulta += "ORDER BY E.registro_academico ASC";
                    break;
                case 2:
                    consulta += "ORDER BY horasTotales DESC";
                    break;
                case 3:
                    consulta += "ORDER BY horasTotales ASC";
                    break;
                case 4:
                    consulta += "ORDER BY E.nombre ASC";
                    break;
                case 5:
                    consulta += "ORDER BY E.nombre DESC";
                    break;
            }

            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<String> estudiantes = new ArrayList();
            while (rs.next()) {
                int registroAcademico = rs.getInt(1);
                String nombre = rs.getString(2);
                float totalHoras = rs.getFloat(3);
                String estudiante = registroAcademico + ";" + nombre + ";" + totalHoras;
                estudiantes.add(estudiante);
            }
            conexion.close();
            return estudiantes.toArray(new String[estudiantes.size()]);
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
        return null;
    }

    public String[] obtenerEstudiantes() throws SQLException{
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            consulta = "SELECT registro_academico, nombre FROM estudiante;";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<String> estudiantes = new ArrayList();
            while(rs.next()){
                estudiantes.add(rs.getInt(1) + ";" +rs.getString(2));
            }
            conexion.close();
            return estudiantes.toArray(new String[estudiantes.size()]);
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
            return null;
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }
    
    public void modificarEstudiante(int registroAcademico, String dpi, String nombre, String unidadAcademica, String carrera) throws SQLException {
        String consulta = "UPDATE estudiante SET dpi = ?, nombre = ?, unidad_academica = ?, carrera = ? "
                + "WHERE estudiante.registro_academico = ?";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, dpi);
            sentencia.setString(2, nombre);
            sentencia.setString(3, unidadAcademica);
            sentencia.setString(4, carrera);
            sentencia.setInt(5, registroAcademico);
            sentencia.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }

    public String[] obtenerEstudiante(int registroAcademico) throws SQLException {
        String consulta = "SELECT dpi, nombre, unidad_academica, carrera FROM estudiante "
                + "WHERE registro_academico = ?";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, registroAcademico);
            ResultSet rs = sentencia.executeQuery();
            rs.next();
            String[] informacion = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
            return informacion;
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
        return null;
    }

    public void borrarEstudiante(int registroAcademico) throws SQLException {
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            //Eliminar de la tabla control
            consulta = "DELETE FROM control WHERE registro_academico = ?";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, registroAcademico);
            sentencia.executeUpdate();
            conexion.close();

            //Eliminar de la tabla estudiante
            consulta = "DELETE FROM estudiante WHERE registro_academico = ?";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, registroAcademico);
            sentencia.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }

    public String[] obtenerActividades(int registroAcademico) throws SQLException {
        String consulta = "SELECT C.id, C.fecha, A.actividad, C.lugar, C.hora_inicio, C.hora_fin, C.horas "
                + "FROM actividad A, control C "
                + "WHERE A.id_actividad = C.id_actividad "
                + "AND C.registro_academico = ? "
                + "AND C.id_actividad != 1 "
                + "ORDER BY C.fecha";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, registroAcademico);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<String> actividades = new ArrayList();
            while (rs.next()) {
                int id_actividad = rs.getInt(1);
                String fecha = rs.getString(2);
                String actividad = rs.getString(3);
                String lugar = rs.getString(4);
                String horaInicio = rs.getString(5);
                String horaFin = rs.getString(6);
                float horas = rs.getFloat(7);
                actividades.add(id_actividad + ";" + fecha + ";" + actividad + ";" + lugar + ";" + horaInicio + ";" + horaFin + ";" + horas);
            }
            return actividades.toArray(new String[actividades.size()]);
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
            return null;
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }

    public String[] buscarEstudiante(int registroAcademico, int ordenamiento) throws SQLException {
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            consulta = "SELECT E.registro_academico, E.nombre, SUM(C.horas) AS horasTotales "
                    + "FROM estudiante E, control C "
                    + "WHERE E.registro_academico = C.registro_academico "
                    + "AND E.registro_academico LIKE ? "
                    + "GROUP BY E.registro_academico ";
            switch (ordenamiento) {
                case 0:
                    consulta += "ORDER BY E.registro_academico DESC";
                    break;
                case 1:
                    consulta += "ORDER BY E.registro_academico ASC";
                    break;
                case 2:
                    consulta += "ORDER BY horasTotales DESC";
                    break;
                case 3:
                    consulta += "ORDER BY horasTotales ASC";
                    break;
                case 4:
                    consulta += "ORDER BY E.nombre ASC";
                    break;
                case 5:
                    consulta += "ORDER BY E.nombre DESC";
                    break;
            }
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, registroAcademico+"%");
            ResultSet rs = sentencia.executeQuery();
            conexion.close();
            ArrayList<String> estudiantes = new ArrayList();
            while (rs.next()) {
                registroAcademico = rs.getInt(1);
                String nombre = rs.getString(2);
                float totalHoras = rs.getFloat(3);
                String estudiante = registroAcademico + ";" + nombre + ";" + totalHoras;
                estudiantes.add(estudiante);
            }
            conexion.close();
            return estudiantes.toArray(new String[estudiantes.size()]);
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
            return null;
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }

    public String[] buscarEstudiantes (String registro) throws SQLException{
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            consulta = "SELECT registro_academico, nombre FROM estudiante WHERE registro_academico LIKE ?;";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, registro+"%");
            ResultSet rs = sentencia.executeQuery();
            ArrayList<String> estudiantes = new ArrayList();
            while(rs.next()){
                estudiantes.add(rs.getInt(1) + ";" + rs.getString(2));
            }
            conexion.close();
            return estudiantes.toArray(new String[estudiantes.size()]);
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
            return null;
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }
    
    public void reescribirActividad(int id_control, String fecha, String lugar, String actividadRealizada, String[] horaIni, String[] horaFin) throws SQLException {
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            //Obtener el id de la actividad
            consulta = "SELECT id_actividad FROM actividad WHERE actividad = ?;";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, actividadRealizada);
            ResultSet rs = sentencia.executeQuery();
            rs.next();
            int id_actividad = rs.getInt(1);
            conexion.close();
            
            //Modificar la tabla Control
            consulta = "UPDATE control SET fecha = ?, lugar = ?, id_actividad = ?, hora_inicio = ?, hora_fin = ?, horas = ? "
                    + "WHERE id = ?;";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, fecha);
            sentencia.setString(2, lugar);
            sentencia.setInt(3, id_actividad);
            sentencia.setString(4, horaIni[0] + ":" + horaIni[1]);
            sentencia.setString(5, horaFin[0] + ":" + horaFin[1]);
            double temp = Double.valueOf(horaFin[0]) - Double.valueOf(horaIni[0]) + (Double.valueOf(horaFin[1]) - Double.valueOf(horaIni[1])) / 60;
            double temp2 = (double) Math.round(temp * 100d) / 100d;
            sentencia.setDouble(6, temp2);
            sentencia.setInt(7, id_control);
            sentencia.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }

    public void reescribirActividad(int id_control, String fecha, String lugar, String actividadRealizada, double totalHoras) throws SQLException {
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            //Obtener el id de la actividad
            consulta = "SELECT id_actividad FROM actividad WHERE actividad = ?;";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, actividadRealizada);
            ResultSet rs = sentencia.executeQuery();
            rs.next();
            int id_actividad = rs.getInt(1);
            conexion.close();
            
            //Modificar la tabla Control
            consulta = "UPDATE control SET fecha = ?, lugar = ?, id_actividad = ?, hora_inicio = ?, hora_fin = ?, horas = ? "
                    + "WHERE id = ?;";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, fecha);
            sentencia.setString(2, lugar);
            sentencia.setInt(3, id_actividad);
            sentencia.setString(4, "---");
            sentencia.setString(5, "---");
            sentencia.setDouble(6, totalHoras);
            sentencia.setInt(7, id_control);
            sentencia.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }

    public boolean eliminarActividad(int id_control) throws SQLException {
        String consulta;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            //Eliminar de la tabla control
            consulta = "DELETE FROM control WHERE id = ?";
            conexion = conectar();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, id_control);
            sentencia.executeUpdate();
            conexion.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
            return false;
        } finally {
            if (null != conexion) {
                conexion.close();
            }
            if (null != sentencia) {
                sentencia.close();
            }
        }
    }
    
    public void generarReporte(int registro_academico, int eleccion){
        try {
            Connection conexion = conectar();
            String path;
            
            if(eleccion == 0){
                path = "src/reportes/ReporteCarta.jasper";
            } else {
                path = "src/reportes/ReporteOficio.jasper";
            }
            
            JRLoader.loadObjectFromFile(path);
            
            Map parametros = new HashMap();
            parametros.put("registro_academico", registro_academico);
            JasperPrint jprint = JasperFillManager.fillReport(path, parametros, conexion);
            
            JasperViewer view = new JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
            
        } catch (JRException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
        }
    }
}
