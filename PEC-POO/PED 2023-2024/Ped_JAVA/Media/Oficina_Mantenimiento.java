package Media;

import java.util.*;

/**
 * Write a description of class Oficina_Mantenimiento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oficina_Mantenimiento
{
        // instance variables - replace the example below with your own
        private ArrayList<P_Mantenimiento> lis_empleados;
        private ArrayList<String> Problemas_Mantenimiento;
    
    
     /**
     * Constructor de la clase Oficina_Mantenimiento.
     * 
     * @param lis_empleados La lista de empleados de mantenimiento de la oficina.
     */
        public Oficina_Mantenimiento(ArrayList<P_Mantenimiento> lis_empleados)
        {
            // initialise instance variables
            this.lis_empleados=lis_empleados;
            Problemas_Mantenimiento=new ArrayList<String>();
            
        }
        //Metodo para añadir notificar un problema de mantenimiento
    /**
     * Añade un problema de mantenimiento a la lista de problemas de mantenimiento.
     * 
     * @param ProblemaMantenimiento El problema de mantenimiento que se añadirá a la lista.
     */
          public void AnnadirProblemaDeMantenimiento(String ProblemaMantenimiento)
        {
            // initialise instance variables
           Problemas_Mantenimiento.add(ProblemaMantenimiento);
        }
        //RPMEEMP=REPARTIR PROBLEMAS MANTENIMIENTO ENTRE EMPLEADOS
    /**
    * Metodo para repartir problemas de mantenimiento entre empleados
    */
           public void RPMEEMP()
        {
            // initialise instance variables
            int TamannoPlantilla = lis_empleados.size();
            int numProblemas = Problemas_Mantenimiento.size();
            int problemasCadaUno = numProblemas / TamannoPlantilla;
            int problemasRestantes = numProblemas % TamannoPlantilla;
    
            int problemaActual = 0; // indice del problema actual
            for (P_Mantenimiento p : lis_empleados) {
                ArrayList<String> problemasAsignados = new ArrayList<>();
                // Asignar problemas base a cada empleado
                for (int i = 0; i < problemasCadaUno; i++) {
                    problemasAsignados.add(Problemas_Mantenimiento.get(problemaActual));
                    problemaActual++;
                }
                // Asignar problemas restantes uno a uno hasta que se agoten
                while (problemasRestantes > 0) {
                    problemasAsignados.add(Problemas_Mantenimiento.get(problemaActual));
                    problemaActual++;
                    problemasRestantes--;
                }
                // Asignar los problemas al empleado actual
                p.listaMantenimiento(problemasAsignados);
        }
    }
}
