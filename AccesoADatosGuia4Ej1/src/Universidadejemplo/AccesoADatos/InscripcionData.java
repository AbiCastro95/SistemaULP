
package Universidadejemplo.AccesoADatos;

import Universidadejemplo.Entidades.Alumno;
import Universidadejemplo.Entidades.Inscripcion;
import Universidadejemplo.Entidades.Materia;
import java.sql.Connection;
import java.util.List;


public class InscripcionData {
    private Connection con;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
    }
    
    public void guardarInscripcion(Inscripcion inscripcion){
        
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        return null;
    }
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id){
        return null;
    }
    
    public List<Materia> obtenerMateriasCursadas(int id){
        return null;
    }
    
    public List<Materia> obtenerMateriasNOCursadas(int id){
        return null;
    }
    
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
        
    }
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        
    }
    
    public List<Alumno> obtenerAlumnosPorMateria(int idMateria){
        return null;
    }
}
