
/**
 * Write a description of class Constantes_Uso_Final here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Constantes_Uso_Final_y_estatic
{
 public static void main(String[] args){
    
    Empleados trabajador1=new Empleados("Tomás");
    
    Empleados trabajador2=new Empleados("Paco");
    
    Empleados trabajador3=new Empleados("Antonio");
    
    Empleados trabajador4=new Empleados("Maria");
    
     trabajador1.CambiarSeccion("RRHH");
     
     System.out.println("Su nombre es:"+ trabajador1.GetNombre() + "La seccion es: " +trabajador1.GetSeccion()+" id:"+trabajador1.GetID() );
     
     System.out.println("Su nombre es:"+ trabajador2.GetNombre() + "La seccion es: " +trabajador2.GetSeccion()+" id:"+trabajador2.GetID() );
      
     System.out.println("Su nombre es:"+ trabajador3.GetNombre() + "La seccion es: " +trabajador3.GetSeccion()+" id:"+trabajador3.GetID() );
  
     System.out.println("Su nombre es:"+ trabajador4.GetNombre() + "La seccion es: " +trabajador4.GetSeccion()+" id:"+trabajador4.GetID() );
  
    
    }
}
 class Empleados{
     
    private final String nombre;
    
    private String seccion;
    
    private int id;//la creo como statica(es decir se va a compartir por entre los objetos)
    
    private static int idSiguiente=1;
    public Empleados(String nom){
    
     nombre=nom;
    
     seccion="Administración";//todos empiezan en la seccion de administracion
    
     id=idSiguiente;
     
     idSiguiente++;
    }
    public void CambiarSeccion(String seccion){
        
        this.seccion=seccion;
    
    }
    /*  public void CambiaNombre(String nombre){
    
     this.nombre=nombre;
    }
     da error porque es el nombre es una constante(tiene final) no se puede modificar*/
    public String GetNombre(){
    
     return nombre;
    }
    public String GetSeccion(){
    
     return seccion;
    }
    public int GetID(){
    return id;
    }
}

