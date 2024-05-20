package Media;
import Controlador.Controlador;
import java.util.*;

/**
 * Write a description of class Aparcamiento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Parking
{
    // instance variables - replace the example below with your own
    private ArrayList<P_Parking> lis_P_Parking;

    /**
     * Constructor for objects of class Aparcamiento
     */
    public Parking(ArrayList<P_Parking> lis_P_Parking)
    {
            this.lis_P_Parking=lis_P_Parking;  
    }
    /*
     * Codigo obsoleto por Sacarlista de administracion
      public void solucionar_incidencia()
    {
            String Datos;
            for(P_Parking p:lis_P_Parking){
                 Datos=("enviando a" + p.getNom()+"a solucionar el problema");
                Controlador.MandarDatos(Datos);
               
             
            }
       
    }
    */
}
