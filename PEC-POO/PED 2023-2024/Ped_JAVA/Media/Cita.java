package Media;
import java.util.ArrayList;
import Controlador.Controlador;

/**
 * Write a description of class cita here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cita
{
    private Medicos_Especialistas s;
    private Fecha fecha_cita;
    private int  hora_cita;
    private Paciente paciente;
    /**
     * Constructor for objects of class cita
     */
    public Cita(Medicos_Especialistas p,String fechacita,String horacita,Paciente pa)
    {
        
        Fecha F_cita = new Fecha(fechacita);//fecha que compararemos    
        // Obtener el ArrayList de citas
        ArrayList<Cita> c = p.getListaCitas();
         // Si la lista de citas es null,
        if (c == null) {
            String datos = "Error: no se pudo acceder a la lista de citas";
            Controlador.MandarDatos(datos);
            return;
        }
        // Si el especialista tiene citas
        if (!c.isEmpty()) {
            for (Cita e : c) {
                // Comprueba si la fecha y hora de la cita ya están ocupadas
                String feciact=e.getFechacita().getFecha_String();
                int horacitact=e.getHoracita();
                if (fechacita.equals(feciact) && Integer.parseInt(horacita) ==horacitact) {
                    String datos = "Fecha ocupada, por favor elige otra fecha";
                    Controlador.MandarDatos(datos);
                    return; // Sal del método si la fecha está ocupada
                }
            }
        }

        // Si llegamos aquí, significa que la fecha no está ocupada, así que agrega la nueva cita
        s = p;
        fecha_cita = new Fecha(fechacita);
        hora_cita = Integer.parseInt(horacita);
        paciente=pa;
        p.addCita(this);//se le añade la lista
        String datos = "Cita solicitada con éxito";
        Controlador.MandarDatos(datos);
    }
      /**
     * Getter del personal medico seleccionado
     */
    public Medicos_Especialistas getPersonal(){
    
        return s;
    }
      /**
     * Getter de fechacita
     */
    public Fecha getFechacita(){
    
        return fecha_cita;
    }
      /**
     * Getter de la hora de la cita
     */
      public int getHoracita() {
        return hora_cita;
    }
    public Paciente getPaciente(){
        return paciente;
    }
}
