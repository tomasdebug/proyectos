package Media;
/**
 * Write a description of class Personal_Sanitario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personal_Sanitario extends Personal
{
    
    private boolean ocupado=false;

        //Solo administracion tendrá acceso a estos constructures
    /**
     * Constructor de la clase Personal_Sanitario.
     * 
     * @param p Personal cualquiera del hospital.
     */
    public Personal_Sanitario(Personal p )
    {
       super(p,p.turno,p.fecha_de_incorporacion);
    }
   /**
     * Constructor de la clase Personal_Sanitario.
     * 
     * @param edad La edad del personal sanitario.
     * @param nomComp El nombre completo del personal sanitario.
     * @param DNI El número de DNI del personal sanitario.
     * @param fecha_nac_en_String La fecha de nacimiento del personal sanitario en formato de cadena (dd/MM/yyyy).
     * @param turno El turno de trabajo del personal sanitario.
     */
       public Personal_Sanitario(int edad,String nomComp,String DNI,String fecha_nac_en_String,String turno )
    {
       
        super(edad,nomComp,DNI,fecha_nac_en_String,turno);
        profesion+="Sanitario ";

    }
    /**
    * Getter de la disponibilidad que tiene el personal actual
    */
    public boolean getDisponibilidad()
    {
        return ocupado;

    }
   /**
    * Setter de la disponibilidad que tiene el personal actual
    * @param disponibilidad disponibilidad que tiene el medico actualmente.
    */
    public void setDisponibilidad(boolean disponibilidad)
    {
         ocupado=disponibilidad;

    }
    /**
    * Setter del turno que tiene el personal actual
    * @param turno El turno de trabajo del personal sanitario.
    */
    //Los medicos pueden tener el turno de noche ,en todo caso serían de emerjencias
    public void setTurno(String turno){
        if(turno.toLowerCase().equals("mañana")||turno.toLowerCase().equals("tarde")||turno.toLowerCase().equals("noche")){
            this.turno=turno;
        }
        }
}
