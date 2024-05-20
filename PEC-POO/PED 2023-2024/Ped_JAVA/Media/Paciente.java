package Media;
/**
 * Write a description of class Paciente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paciente extends Persona
{

    protected ExpedienteMedico exp;
    protected Cita c;
    protected String Estado;
    /**
     * Constructor de la clase Paciente.
     * 
     * @param edad La edad del paciente.
     * @param nombrecompleto El nombre completo del paciente.
     * @param dni El número de DNI del paciente.
     * @param exp El expediente médico del paciente.
     */
    public Paciente(int edad,String nombrecompleto,String dni,ExpedienteMedico exp)
    {
        super(edad,nombrecompleto,dni);
        this.exp=exp;
    }

   /**
     * Solicita una cita con un médico especialista en una fecha y hora específicas.
     * 
     * @param p El médico especialista con quien se solicita la cita.
     * @param fechaCita La fecha de la cita en formato de cadena (dd/MM/yyyy).
     * @param horaCita La hora de la cita en formato de cadena (HH:mm).
     */
      public void PedirCita(Medicos_Especialistas p,String fechaCita,String horaCita) {
       c= new Cita(p,fechaCita,horaCita,this);
    }
    
    /**
     * Establece el estado del paciente.
     * 
     * @param est El estado del paciente.
     */
     public void setEstado(String est) {
        Estado=est;
    }
    /**
     * Obtiene el expediente médico del paciente.
     * 
     * @return El expediente médico del paciente.
     */
       public String getEstado() {
        return Estado;
    }
    /**
     * Obtiene el expediente médico del paciente.
     * 
     * @return El expediente médico del paciente.
     */
        public ExpedienteMedico obtenerExpediente() {
        return exp;
    }
     /**
     * Obtiene la cita del paciente.
     * 
     * @return La cita del paciente.
     */
    public Cita getCita(){
    
        return c;
    }
}
