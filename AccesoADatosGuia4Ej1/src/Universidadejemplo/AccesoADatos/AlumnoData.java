/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author Glori
 */
public class AlumnoData {
    private Connection con;
    
    public AlumnoData(){
          con = Conexion.getConexion();
    }
   public void guardarAlumno(Alumno alumno){//viene un alumno sin id
       String sql="INSERT INTO alumno (nombre, fechaNacimiento, estado) VALUES (?,?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setDate(2,Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(3, alumno.getEstado());
            
            ps.executeUpdate();//guardo en la bd
            
            ResultSet rs= ps.getGeneratedKeys();//recupero la clave primaria
            
            if (rs.next()){
               alumno.setIdAlumno(rs.getInt(1));//completo el alumno en java
                System.out.println("Alta exitosa");
            }else
                System.out.println("error al obtener el id ");
            
        
        
        
        
        } catch (SQLException ex) {
            System.out.println("Error al insertar "+ex);;
        }
       
       
    } 
}
