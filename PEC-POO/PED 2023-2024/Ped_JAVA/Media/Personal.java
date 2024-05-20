package Media;
import Controlador.Controlador;
import java.time.LocalDate;

public class Personal extends Persona
{
    // instance variables - replace the example below with your own
    protected String profesion="";
    protected String turno;
      protected String fecha_de_incorporacion;
       protected Fecha f;
    /**
     * Constructor de la clase Personal.
     * 
     * @param p Objeto de tipo Persona que representa al personal.
     * @param turno El turno de trabajo del personal.
     * @param fecha_de_incorporacion La fecha de incorporación del personal en formato de cadena (dd/MM/yyyy).
     */
    public Personal(Persona p ,String turno,String fecha_de_incorporacion)
    {
        super(p.edad,p.nomComp,p.DNI);
        String t=turno.toLowerCase();
         f=new Fecha(fecha_de_incorporacion);
        this.fecha_de_incorporacion = fecha_de_incorporacion;  
        String datos;
        switch (t) {
            case "mañana":
            case "tarde":
            case "noche":
            turno=t;
                break;
            default:
            datos=(" Por favor, ingrese un turno válido.");
            Controlador.MandarDatos(datos);
        }
        
    }
    /**
     * Constructor de la clase Personal.
     * 
     * @param edad La edad del personal.
     * @param nombreCompleto El nombre completo del personal.
     * @param DNI El número de DNI del personal.
     * @param fecha_de_incorporacion La fecha de incorporación del personal en formato de cadena (dd/MM/yyyy).
     * @param turno El turno de trabajo del personal.
     */
     public Personal(int edad,String nombreCompleto,String DNI, String fecha_de_incorporacion,String turno )
    {
        super(edad,nombreCompleto,DNI);
         String t=turno.toLowerCase();
         String datos;
        switch (t) {
            case "mañana":
            case "tarde":
            case "noche":
            this.turno=t;
                break;
            default:
               datos=(" Por favor, ingrese un turno válido.");
            Controlador.MandarDatos(datos);
        }
         f=new Fecha(fecha_de_incorporacion);
        this.fecha_de_incorporacion = fecha_de_incorporacion;  
    }
    /**
     * Getter para coger la profesion
     */
    public String getProf(){
    
        return profesion;
    }
    /**
     * Getter para turno
     */
    public String getTurno(){
    
        return turno;
    }
    /**
     * Getter coger la fehca de incorporacion
     */
     public LocalDate getFechaIncorporacion()
    {
        return f.getFecha();
    }
    /**
     * Setter para poner un turno
     */
     public void setTurno(String turno){
         String datos;
        if(turno.toLowerCase().equals("mañana")||turno.toLowerCase().equals("tarde")){
            this.turno=turno;
        }
        else{
             datos=(" turno no valido,introduciendo turno por defecto");
            Controlador.MandarDatos(datos);
             turno="tarde";
        }
        }
}
