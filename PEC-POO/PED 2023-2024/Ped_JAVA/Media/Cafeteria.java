package Media;

import java.util.*;

/**
 * Write a description of class Cafeteria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cafeteria
{

   //inicializo la lista de empleados
   protected ArrayList<P_Cafeteria> lis_empleados;

    /**
     * Constructor for objects of class Cafeteria
     */
    public Cafeteria( ArrayList<P_Cafeteria> lis_empcaf)
    {
         lis_empleados=lis_empcaf;
    }

    /**
     * @param  p : persona a la que le sirvo comida
     *
     */
    public void ServirComida(Persona p)
    {
        String nombre=p.getNom();
       System.out.println("Comida servida a "+ nombre);
    }
    /*
     * Codigo obsoleto,ya que en administracion puedo devolver las listas que quiera
    public void getPersonal()
    {
      
            for(P_Cafeteria p:lis_empleados){
             System.out.println("enviando a" + p.getNom());
             
            }
            
    }
    */
}

