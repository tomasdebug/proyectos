package Media;
import java.util.ArrayList;

/**
 * Write a description of class clases_laboratorios here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class clases_laboratorios
{
    // instance variables - replace the example below with your own
    private Personal_Sanitario tutor;
    private ArrayList<Estudiantes> estudiantes;
    /**
     * Constructor for objects of class clases_laboratorios
     */
    public clases_laboratorios(Personal_Sanitario tutor,ArrayList<Estudiantes> est)
    {
      this.tutor=tutor;
      estudiantes=est;
    }

    /**
     *Asumimos que una clase sigue a su tutor a donde sea.
     */
    public void seguir_a_untutor(Personal_Sanitario p)
    {
        System.out.println("La clase está siguendo a "+ p.getNom());
    }
}
