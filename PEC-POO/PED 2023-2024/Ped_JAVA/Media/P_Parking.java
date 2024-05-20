package Media;
/**
 * Write a description of class P_Aparcamiento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P_Parking extends Personal_Soporte_Hospital
{

    /**
     * Constructor for objects of class P_Aparcamiento
     * @param p:personal que quiero que se haga del personal de parking
     */
    public P_Parking(Personal_Soporte_Hospital p)
    {
        super(p);
        p.profesion+="P_Parking";
    }
    /**
     * Constructor de la clase P_Parking.
     * 
     * @param edad La edad del personal de cafetería.
     * @param nomComp El nombre completo del personal de cafetería.
     * @param DNI El número de DNI del personal de cafetería.
     * @param fecha_nac_en_String La fecha de nacimiento del personal de cafetería en formato de cadena (dd/MM/yyyy).
     * @param turno El turno de trabajo del personal de cafetería.
     */
    public P_Parking(int edad,String nomComp,String DNI,String fecha_nac_en_String,String turno )
    {
        // initialise instance variables
        super(edad,nomComp,DNI,fecha_nac_en_String,turno);
        profesion+="P_Parking";

    }
    //No hace nada en esta practica pero es necesario para tener parking
}
