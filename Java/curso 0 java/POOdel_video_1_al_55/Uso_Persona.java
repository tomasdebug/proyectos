import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Write a description of class Uso_Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Uso_Persona
{
    public static void main(String[] args){
    
     persona[] lasPersonas=new persona[2];
    
     lasPersonas[0]=new empleado2("tomas","administracion",2000800,2003,01,23);
    
     lasPersonas[1]=new alumno("Paco","informatica");
    
     for(persona p:lasPersonas){
        
        System.out.println(p.GetNombre() +", "+ p.dameDescripcion());
        
        }
    }
}
abstract class persona{

    private String nombre;
    
    public persona(String nom){

     nombre=nom;
  
    }
     public String GetNombre()
    {
        return nombre;
    }
    public abstract String dameDescripcion();
}
class empleado2 extends persona //se pone un 2 para no confundirla con la clase que tengo de antes
 {
     //si la clase no tuviera constructores se usaria uno por defecto,este está vacio es decir ,no le da ningun parametro en concreto
    
    private String puesto;
    
    private double sueldo;
    
    private Date altaContrato;
    
    private int id;//la creo como statica(es decir se va a compartir por entre los objetos)
    
    private static int idSiguiente=1;
    
    public empleado2(String nombre,String puesto,double sue,int agno ,int mes,int dia)
    {
        super(nombre);
        this.puesto=puesto;
        sueldo=sue;
        GregorianCalendar calendario=new GregorianCalendar(agno,mes-1,dia);
        altaContrato=calendario.getTime();
        id=idSiguiente;
     
        idSiguiente++;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double GetSueldo() {//si pongo final aquí conseguiría que no se reemplazara el codigo en jefatura
        return sueldo;
    }
    public Date GetFechaDeAlta(){
        return altaContrato;
    }
       public String GetPuesto() {
        return puesto;
    }
    public void SubirSueldo(double porcentaje){
        double aumento=sueldo*porcentaje/100;
        sueldo += aumento;
    }
    public String dameDescripcion(){
        return "este empleado tiene un Id="+id+"con un sueldo de "+ sueldo;
    }
  }
class alumno extends persona{
    
    private String carrera;
    
    public alumno(String nombre,String carrera){
     super(nombre);
     this.carrera=carrera;
    }
    public String dameDescripcion(){
    
     return "Este alumno está estudiando la carrera de "+ carrera;
    
    }
}
