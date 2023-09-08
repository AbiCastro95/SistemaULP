
package Universidadejemplo.AccesoADatos;

import Universidadejemplo.Entidades.Alumno;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Universidadejemplo.Vistas.Conectar;
import Universidadejemplo.Entidades.Alumno;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

public class AlumnoData {
    private Connection con;
    
    public AlumnoData(){
          con = Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno){//viene un alumno sin id
       String sql="INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4,Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.getEstado());
            
            ps.executeUpdate();//guardo en la bd
            
            ResultSet rs= ps.getGeneratedKeys();//recupero la clave primaria
            
            if (rs.next()){
                alumno.setIdAlumno(rs.getInt(1));//completo el alumno en java
                System.out.println("Alta exitosa");
            }else{
                System.out.println("error al obtener el id ");
            }
            
            ps.close();
        
        } catch (SQLException ex) {
            System.out.println("Error al insertar "+ex);;
        }

    }
    
    public Alumno buscarAlumnoPorId(int id){
        return null;
    }

    public Alumno buscarAlumnoPorDni(int dni){
        return null;
    }
    
    public List<Alumno> listarAlumnos(){
        return null;
    }
    
    public void modificarAlumno(Alumno alumno){
        
    }
    
    public void eliminarAlumnoPorId(int id){
        
    }
 
}
