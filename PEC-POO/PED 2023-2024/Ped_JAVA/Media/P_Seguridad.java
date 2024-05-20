package Media;
import Controlador.Controlador;
import java.time.LocalTime;

/**
 * Write a description of class P_Seguridad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P_Seguridad extends Personal_Soporte_Hospital
{
    // instance variables - replace the example below with your own
    protected String zonaTrabajo;
   
    /**
    * Constructor for objects of class P_Seguridad
    * @param p:personal que quiero que se haga del personal de seguridad
    */
    public P_Seguridad(Personal_Soporte_Hospital p)
    {
        super(p);
        p.profesion+="P_Parking";
    }
    /**
     * Constructor de la clase P_Seguridad.
     * 
     * @param edad La edad del personal de cafetería.
     * @param nomComp El nombre completo del personal de cafetería.
     * @param DNI El número de DNI del personal de cafetería.
     * @param fecha_nac_en_String La fecha de nacimiento del personal de cafetería en formato de cadena (dd/MM/yyyy).
     * @param turno El turno de trabajo del personal de cafetería.
     */
    public P_Seguridad(int edad,String nomComp,String DNI,String fecha_nac_en_String,String turno )
    {
        // initialise instance variables
        super(edad,nomComp,DNI,fecha_nac_en_String,turno);
        profesion+="P_Seguridad";

    }
    /**
     * Método para notificar una incidencia al guarda de seguridad.
     * El guarda de seguridad verifica la incidencia recibida.
     * 
     * @param incidencia La descripción de la incidencia que se debe verificar.
     */
       public void NotificarIncidencia(String incidencia)// se le da al guarda de seguridad una incidencia que verificar y este lo hace
    {
         String datos;
         LocalTime horaActual = LocalTime.now();
        
        
            datos=(nomComp + " en " + zonaTrabajo + " notificó un incidente  de" +incidencia+ " durante su turno de " +turno +"a las "+horaActual);
      
       Controlador.MandarDatos(datos);
    }
    
}
