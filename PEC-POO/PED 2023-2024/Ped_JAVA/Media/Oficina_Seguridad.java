package Media;
import Controlador.Controlador;
import java.util.*;

/**
 * Write a description of class Oficina_Seguridad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oficina_Seguridad
{

   private ArrayList<P_Seguridad> lis_empleados;
  
    /**
     * Constructor for objects of class Oficina_Seguridad
     */
    public Oficina_Seguridad(ArrayList<P_Seguridad> lis_empleados)
    {
        // initialise instance variables
        this.lis_empleados=lis_empleados;
    } 
    /**
     * Asigna una zona de trabajo a un empleado de seguridad.
     * 
     * @param zonatrab La zona de trabajo que se asignará al empleado.
     * @param p El empleado de seguridad al que se le asignará la zona de trabajo.
     */
    public void asignarZonadeTrabajo(String zonatrab,P_Seguridad p)
    {
      p.zonaTrabajo=zonatrab;
    }
    /**
     * Asigna una zona de trabajo a un empleado de seguridad mediante su índice en la lista de empleados.
     * 
     * @param zonatrab La zona de trabajo que se asignará al empleado.
     * @param index El índice del empleado de seguridad al que se le asignará la zona de trabajo.
     */
    public void asignarZonadeTrabajo(String zonatrab,int index)
    {
      P_Seguridad p =lis_empleados.get(index);
      String datos =("El guardia" + p.getNom() +" se ha cambiado desde " + p.zonaTrabajo + " hasta la zona de trabajo "+ zonatrab);
       Controlador.MandarDatos(datos);
      p.zonaTrabajo=zonatrab;
     
    }
    /**
     * Notifica una incidencia al empleado de seguridad seleccionado.
     * 
     * @param incidencia La descripción de la incidencia que se notificará.
     * @param index El índice del empleado de seguridad al que se le notificará la incidencia.
     */
    //Pasa la incidencia hasta el guardia de seguridad seleccionado
    public void NotificarIncidencia(String incidencia ,int index){
     lis_empleados.get(index).NotificarIncidencia(incidencia);
    }
    

}
