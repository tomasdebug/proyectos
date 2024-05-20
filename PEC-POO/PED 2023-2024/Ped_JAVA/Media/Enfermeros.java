package Media;
/**
 * Write a description of class Enfermera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enfermeros extends Personal_Sanitario
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Enfermera para asignar un sanitario como enfermero
     * @param p = personal sanitario que se va a crear
     */
    public Enfermeros(Personal_Sanitario p)
    {
        // initialise instance variables
        super(p);
        profesion+="Enfermero";
    }
    /**
     * Constructor de la clase Enfermeros.Para crear de cero el sanitario
     * 
     * @param edad La edad del enfermero.
     * @param nomComp El nombre completo del enfermero.
     * @param DNI El número de DNI del enfermero.
     * @param fecha_nac_en_String La fecha de nacimiento del enfermero en formato de cadena (dd/MM/yyyy).
     * @param turno El turno de trabajo del enfermero.
     */
      public Enfermeros(int edad,String nomComp,String DNI,String fecha_nac_en_String ,String turno)
    {
        // initialise instance variables
        super(edad,nomComp,DNI,fecha_nac_en_String,turno);
        profesion+="Enfermero";

    }
}
