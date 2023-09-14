

import Universidadejemplo.AccesoADatos.*;
import Universidadejemplo.Entidades.*;
import java.util.ArrayList;
import java.util.List;

public class Pruebas {

    public static void main(String[] args) {
        AlumnoData aluData = new AlumnoData();
        
        //System.out.println(aluData.buscarAlumnoPorId(2));
        
        InscripcionData iData = new InscripcionData();
        /*
        System.out.println("Materias cursadas: ");
        for (Materia mat2 : iData.obtenerMateriasCursadas(3)){
            System.out.println(mat2.getNombre());
        }
        System.out.println("------------------------");
        System.out.println("Materias NO cursadas: ");
        for (Materia mat2 : iData.obtenerMateriasNOCursadas(3)){
            System.out.println(mat2.getNombre());
        }
        System.out.println("------------------------");
        System.out.println("Alumnos por materia: ");
        for (Alumno alumno : iData.obtenerAlumnosPorMateria(2)){
            System.out.println(alumno.getNombre());
        }
        
        System.out.println("Actualizar Nota: ");
        iData.actualizarNota(2, 2, 8);
        */
        System.out.println("Obtener inscripciones por alumno: ");
        for (Inscripcion inscrip : iData.obtenerInscripcionesPorAlumno(3)){
            System.out.println(inscrip);
        }
        
    }
    
}
