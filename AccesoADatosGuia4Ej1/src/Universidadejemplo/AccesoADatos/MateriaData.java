package Universidadejemplo.AccesoADatos;

import Universidadejemplo.Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class MateriaData {

    private Connection con;
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    public MateriaData() {
        con = Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia) {
        
        sql = "INSERT INTO materia (nombre, año, estado) VALUES (?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());
            
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            
            if (rs.next()){
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia añadida con éxito. ");
            }else{
                JOptionPane.showMessageDialog(null, "Error al obtener ID. ");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia. "+ex.getMessage());
        }
        
    }

    public Materia buscarMateriaPorId(int id) {
        
        Materia materia = null;
        
        sql = "SELECT nombre, año, estado FROM materia WHERE idMateria = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                materia = new Materia();
                
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe la materia. ");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia. "+ex.getMessage());
        }

        return materia;
    }
    

    public void modificarMateria(Materia materia) {
        
        sql = "UPDATE materia SET nombre = ?, año = ?, estado = ? WHERE idMateria = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());
            ps.setInt(4, materia.getIdMateria());
            
            int registroFilas = ps.executeUpdate();
            
            if (registroFilas == 1){
                JOptionPane.showMessageDialog(null, "Materia modificada con éxito. ");
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro la materia. ");
            }
            
            ps.close();
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia. "+ex.getMessage());
        }
    }

    public void eliminarMateria(int id) {
        
        sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int registroFilas = ps.executeUpdate();
            
            if (registroFilas == 1){
                JOptionPane.showMessageDialog(null, "Materia eliminada con éxito. ");
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro la materia. ");
            }
            
            ps.close();
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia. "+ex.getMessage());
        }
    }

    public List<Materia> listarMateria() {
        List<Materia> materias = new ArrayList<>();
        
        sql = "SELECT * FROM materia WHERE estado = 1";
        
        try {
            ps = con.prepareStatement(sql); 
            
            rs = ps.executeQuery();
            
            while (rs.next()){
                Materia materia = new Materia();
                
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));
                
                materias.add(materia);
            }
            
            ps.close();
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia. "+ex.getMessage());
        }
        
        return materias;
    }

}
