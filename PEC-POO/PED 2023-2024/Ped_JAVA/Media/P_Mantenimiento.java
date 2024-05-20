package Media;

import java.time.LocalTime;
import java.util.*;
import Controlador.Controlador;
/**
 * Write a description of class Mantenimiento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P_Mantenimiento extends Personal_Soporte_Hospital 
{
    
 

    /**
     * Constructor for objects of class Mantenimiento
     */
    public P_Mantenimiento(Personal_Soporte_Hospital p)
    {
        super(p);
        p.profesion+="P_Mantenimiento";
    }
    /**
     * Constructor de la clase P_Mantenimiento.
     * 
     * @param edad La edad del personal de cafetería.
     * @param nomComp El nombre completo del personal de cafetería.
     * @param DNI El número de DNI del personal de cafetería.
     * @param fecha_nac_en_String La fecha de nacimiento del personal de cafetería en formato de cadena (dd/MM/yyyy).
     * @param turno El turno de trabajo del personal de cafetería.
     */
    public P_Mantenimiento(int edad,String nomComp,String DNI,String fecha_nac_en_String,String turno)
    {
        // initialise instance variables
        super(edad,nomComp,DNI,fecha_nac_en_String,turno);
        profesion+="P_Mantenimiento";

    }
    /**
     * metodo que da la asigna la lista de mantenimiento a cada empelado
     * @param listaMantenimiento:lista con problemas de mantenimiento en string
     */
    public void listaMantenimiento(ArrayList<String> listaMantenimiento){
        //El String siempre será del tipo cañeria rota uci,es decir será PROBLEMA + ZONA DE REPARACION
          LocalTime horaActual = LocalTime.now();//Cojo la hora actual
        String datos =("Empleado"+nomComp+"Ha recibida lista de arreglos "+ "a la hora de " + horaActual );
        Controlador.MandarDatos(datos);
        for(String e:listaMantenimiento){//Saco la lista de cosas que necesitan mantenimiento
             horaActual = horaActual.plusHours(1);//Tarda una hora en hacer el mantenimiento
             datos="";
            Controlador.MandarDatos(datos);
            datos=("Empleado "+nomComp+" arreglo de"+ e + "a la hora de " + horaActual);
            Controlador.MandarDatos(datos);//Arreglo el problema
            listaMantenimiento.remove(e);//elimino el problema ya que ya se ha arreglado
            
        }
    
    }
}
