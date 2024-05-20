package Media;
/**
 * Write a description of class Estudiantes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Estudiantes
{
    // instance variables - replace the example below with your own
    private clases_laboratorios clase_asignada;
    private Persona estudiante;
    /**
     * Constructor for objects of class Estudiantes
     */
    public Estudiantes(clases_laboratorios clase_asignada, Persona p)
    {
       estudiante=p;
       this.clase_asignada=clase_asignada;
    }

}
