package Media;
/**
 * Write a description of class Personal_Soporte_hospital here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personal_Soporte_Hospital extends Personal 
{
    // instance variables - replace the example below with your own
   
    //Solo administracion tendrá acceso a estos constructures
 
    /**
     * Constructor for objects of class Personal_Soporte_hospital
     * @param p: personal de soporte elegido 
     */
    public Personal_Soporte_Hospital(Personal p)
    {
        // initialise instance variables
        super(p,p.turno,p.fecha_de_incorporacion);
        p.profesion+="Soporte ";

    }
    /**
     * Constructor de la clase Personal_Soporte_Hospital.Desde cero
     * 
     * @param edad La edad del personal de soporte hospitalario.
     * @param nomComp El nombre completo del personal de soporte hospitalario.
     * @param DNI El número de DNI del personal de soporte hospitalario.
     * @param fecha_nac_en_String La fecha de nacimiento del personal de soporte hospitalario en formato de cadena (dd/MM/yyyy).
     * @param turno El turno de trabajo del personal de soporte hospitalario.
     */
    public Personal_Soporte_Hospital(int edad,String nomComp,String DNI,String fecha_nac_en_String,String turno) 
    {
        // initialise instance variables
        super(edad,nomComp,DNI,fecha_nac_en_String, turno);
        profesion+="Soporte ";

    }
   
}
