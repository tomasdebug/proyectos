package Media;
/**
 * Write a description of class P_Cafeteria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P_Cafeteria extends Personal_Soporte_Hospital
{
   

    /**
     * Constructor for objects of class P_Cafeteria
     * @param p:personal que quiero que se haga de la cafeteria
     */
    public P_Cafeteria(Personal_Soporte_Hospital p)
    {
       super(p);
       profesion+="P_Cafeteria";
    }
    /**
     * Constructor de la clase P_Cafeteria.Desde cero
     * 
     * @param edad La edad del personal de cafetería.
     * @param nomComp El nombre completo del personal de cafetería.
     * @param DNI El número de DNI del personal de cafetería.
     * @param fecha_nac_en_String La fecha de nacimiento del personal de cafetería en formato de cadena (dd/MM/yyyy).
     * @param turno El turno de trabajo del personal de cafetería.
     */
     public P_Cafeteria(int edad,String nomComp,String DNI,String fecha_nac_en_String ,String turno)
    {
        // initialise instance variables
        super(edad,nomComp,DNI,fecha_nac_en_String,turno);
        profesion+="P_Cafeteria";

    }
    //En esta practica no hace nada,pero es necesario para manterner la cafeteria
}
