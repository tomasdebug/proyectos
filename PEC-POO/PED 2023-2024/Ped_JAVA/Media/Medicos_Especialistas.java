package Media;
import java.util.ArrayList;

/**
 * Write a description of class Medicos_Especialista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medicos_Especialistas extends Personal_Sanitario
{

    protected String especialidad;
    private ArrayList<Cita> citasesp;
      //Constructores para crear Medicos_Especialistas
    /**
    * Contructor para crear un medico especialista con una especialidad a partir de personal sanitario generico
    * @param esp: especialidad del medico especialista
    * @param p: personal sanitario elegido
    */
       
    public Medicos_Especialistas(Personal_Sanitario p,String esp)
    {
        super(p);
        profesion+="Medico_Especialista";
        especialidad=esp;
        citasesp= new ArrayList<Cita>();
    }
    /**
     * Constructor de la clase Medicos_Especialistas.
     * 
     * @param edad La edad del médico especialista.
     * @param nomComp El nombre completo del médico especialista.
     * @param DNI El número de DNI del médico especialista.
     * @param fecha_nac_en_String La fecha de nacimiento del médico especialista en formato de cadena (dd/MM/yyyy).
     * @param esp La especialidad del médico especialista.
     * @param turno El turno de trabajo del médico especialista.
     */
        public Medicos_Especialistas(int edad,String nomComp,String DNI,String fecha_nac_en_String,String esp ,String turno)
    {
        super(edad,nomComp,DNI,fecha_nac_en_String,turno);
        profesion+="Medico_Especialista";
        especialidad=esp;
        citasesp= new ArrayList<Cita>();
    }
     /**
     *Getter de la especialidad
     */
    public void addCita(Cita c)
    {
         citasesp.add(c);
    }
    /**
     *Getter de la especialidad
     */
    public String getEsp()
    {
       
        return especialidad;
    }
    /**
     *Getter de para coger la lista de citas
     */
    public ArrayList<Cita> getListaCitas()
    {
        return citasesp;
    }
    /**
     *Getter de citas
     */
    public Cita getCita(int num)
    {
        return citasesp.get(num);
    }
}
