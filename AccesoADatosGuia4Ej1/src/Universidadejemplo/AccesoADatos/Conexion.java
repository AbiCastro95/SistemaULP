
package Universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String URL="jdbc:mysql://localhost/";
    private static final String DB="universidad";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    private static Conexion conexion;
    
     private Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Clase Conexion: Error al cargar Driver");
        }
    }
    
    public static Connection getConexion() {
        Connection con=null;//Si es la primera conexion
        if(conexion == null){
           conexion = new Conexion();
        }
        try {
            // Setup the connection with the DB
            con = DriverManager.getConnection(URL + DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + USUARIO + "&password=" + PASSWORD);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion ");
        }
        
        return con;
    }
}


    

