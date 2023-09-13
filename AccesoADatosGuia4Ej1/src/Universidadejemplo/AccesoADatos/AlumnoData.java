package Universidadejemplo.AccesoADatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Universidadejemplo.Entidades.Alumno;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlumnoData {

    private Connection con;

    String sql;
    PreparedStatement ps;
    ResultSet rs;

    public AlumnoData() {
        con = Conexion.getConexion();
    }

    public void guardarAlumno(Alumno alumno) {//viene un alumno sin id
        
        sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.getEstado());

            ps.executeUpdate();//guardo en la bd

            rs = ps.getGeneratedKeys();//recupero la clave primaria

            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));//completo el alumno en java
                JOptionPane.showMessageDialog(null, "Alta exitosa.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al obtener el id.");
            }
            
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno. ");
        }
    }

    public Alumno buscarAlumnoPorId(int id) {
        Alumno alumno = null;
        
        sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                alumno = new Alumno();
                
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno.");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno. ");
        }
        
        return alumno;
    }

    public Alumno buscarAlumnoPorDni(int dni) {
        Alumno alumno = null;
        
        sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni = ? AND estado = 1";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                alumno = new Alumno();
                
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno.");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno. ");
        }
        
        return alumno;
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        
        sql = "SELECT * FROM alumno WHERE estado = 1";
        
        try {
            
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido("idAlumno");
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));

                alumnos.add(alumno);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno. ");
        }
        
        return alumnos;
    }

    public void modificarAlumno(Alumno alumno) {
        
        sql = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?, fechaNacimiento = ? WHERE idAlumno = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getIdAlumno());
            
            int registroFilas = ps.executeUpdate();

            if (registroFilas == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró al alumno.");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno. ");
        }
    }

    public void eliminarAlumnoPorId(int id) {
        
        sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int registroFilas = ps.executeUpdate();

            if (registroFilas == 1) {
                JOptionPane.showMessageDialog(null, "Alumno eliminado exitosamente.");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno. ");
        }
    }

}
