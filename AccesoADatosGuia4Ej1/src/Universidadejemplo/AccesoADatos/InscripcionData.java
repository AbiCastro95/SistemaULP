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
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class InscripcionData {

    private Connection con;
    private MateriaData matData;
    private AlumnoData aluData;
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción. ");
        }
    }
    /* 
    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        
        sql = "SELECT * FROM inscripcion";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            Inscripcion inscripcion;

            while (rs.next()){
                inscripcion = new Inscripcion();
                
                inscripcion.setIdInscripto(rs.getInt("idInscripto"));
                inscripcion.setNota(rs.getDouble("nota"));
                inscripcion.setIdAlumno(rs.getInt("idAlumno"));
                inscripcion.setIdMateria(rs.getInt("idMateria"));
                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la tabla inscripción. ");
        }
        
        return inscripciones;
    }
    
    */
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción. ");
        }
        
        return inscripciones;
    }
    

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        return null;
    }

    public List<Materia> obtenerMateriasCursadas(int id) {
        return null;
    }

    public List<Materia> obtenerMateriasNOCursadas(int id) {
        return null;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {

    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {

    }

    public List<Alumno> obtenerAlumnosPorMateria(int idMateria) {
        return null;
    }
}
