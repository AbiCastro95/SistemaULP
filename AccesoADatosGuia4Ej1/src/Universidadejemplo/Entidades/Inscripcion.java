package Universidadejemplo.Entidades;

public class Inscripcion {

    private int idInscripto;
    private double nota;
    private Alumno alumno;
    private Materia materia;

    public Inscripcion() {
    }

    public Inscripcion(int idInscripto, double nota, Alumno alumno, Materia materia) {
        this.idInscripto = idInscripto;
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Inscripcion(double nota, Alumno alumno, Materia materia) {
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }
    
    public Inscripcion(double nota){
        this.nota = nota;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public int getIdAlumno() {
        return alumno.getIdAlumno();
    }
    
    public void setIdAlumno(int idAlumno){
        this.alumno.setIdAlumno(idAlumno);
    }
    
    public int getIdMateria(){
        return materia.getIdMateria();
    }
    
    public void setIdMateria(int idMateria){
        this.materia.setIdMateria(idMateria);
    }

    @Override
    public String toString() {
        return "Inscripto{" + "idInscripto=" + idInscripto + ", nota=" + nota + ", Alumno=" + alumno + ", Materia=" + materia + '}';
    }

}
