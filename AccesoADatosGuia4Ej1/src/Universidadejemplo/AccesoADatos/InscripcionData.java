package Universidadejemplo.AccesoADatos;

import Universidadejemplo.Entidades.Alumno;
import Universidadejemplo.Entidades.Inscripcion;
import Universidadejemplo.Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class InscripcionData {

    private Connection con;
    private MateriaData matData = new MateriaData();
    private AlumnoData aluData = new AlumnoData();
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    public InscripcionData() {
        con = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion inscripcion) {
        
        sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES ( ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(3, inscripcion.getMateria().getIdMateria());
            
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            
            if (rs.next()){
                inscripcion.setIdInscripto(rs.getInt("idInscripto"));
                JOptionPane.showMessageDialog(null, "Inscripción realizada con éxito. ");
            }else{
                JOptionPane.showMessageDialog(null, "No se ha encontrado la materia. ");
            }
            
            ps.close();
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción. "+ex.getMessage());
        }
    }

    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        
        sql = "SELECT * FROM inscripcion";
        
        try {
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while (rs.next()){
                Inscripcion inscripcion = new Inscripcion();
                
                inscripcion.setIdInscripto(rs.getInt("idInscripto"));
                inscripcion.setNota(rs.getDouble("nota"));
                
                Alumno alumno = aluData.buscarAlumnoPorId(rs.getInt("idAlumno"));
                Materia materia = matData.buscarMateriaPorId(rs.getInt("idMateria"));
                
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripciones.add(inscripcion);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción. "+ex.getMessage());
        }
        
        return inscripciones;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        List<Inscripcion> inscripciones = new ArrayList<>();
        
        sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()){
                Inscripcion inscripcion = new Inscripcion();
                
                inscripcion.setIdInscripto(rs.getInt("idInscripto"));
                inscripcion.setNota(rs.getDouble("nota"));
                
                Alumno alumno = aluData.buscarAlumnoPorId(rs.getInt("idAlumno"));
                Materia materia = matData.buscarMateriaPorId(rs.getInt("idMateria"));
                
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripciones.add(inscripcion);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción. "+ex.getMessage());
        }
        
        return inscripciones;
    }

    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> materias = new ArrayList<>();
        
        sql = "SELECT m.idMateria, nombre, año FROM inscripcion i, materia m WHERE "
                + "m.idMateria = i.idMateria AND idAlumno = ?";
        
        try {  
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Materia materia = new Materia();
                
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                
                materias.add(materia);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción. "+ex.getMessage());
        }

        return materias;
    }

    public List<Materia> obtenerMateriasNOCursadas(int id) {
 
        List<Materia> materias = new ArrayList<>();
        
        sql = "SELECT m.idMateria, nombre, año FROM materia m WHERE estado = 1 AND m.idMateria NOT IN "
                + "(SELECT i.idMateria FROM inscripcion i WHERE i.idAlumno = ?)";

        try {   
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Materia materia = new Materia();
                
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                
                materias.add(materia);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción. "+ex.getMessage());
        }

        return materias;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
            
        sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int registroFilas = ps.executeUpdate();
            
            if (registroFilas == 1){
                JOptionPane.showMessageDialog(null, "Inscripción eliminada con éxito. ");
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar la inscripción. ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción. "+ex.getMessage());
        }
        
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        
        sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int registroFilas = ps.executeUpdate();
            if (registroFilas == 1){
                JOptionPane.showMessageDialog(null, "Nota actualizada. ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción. "+ex.getMessage());
        }
    }

    public List<Alumno> obtenerAlumnosPorMateria(int idMateria) {
        
        List<Alumno> alumnos = new ArrayList<>();
        
        sql = "SELECT a.idAlumno, dni, apellido, nombre FROM inscripcion i, alumno a WHERE "
                + "estado = 1 AND a.idAlumno = i.idAlumno AND idMateria = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            rs = ps.executeQuery();
            while(rs.next()){
                Alumno alumno = new Alumno();
                
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                
                alumnos.add(alumno);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción. "+ex.getMessage());
        }

        return alumnos;
    }
}
