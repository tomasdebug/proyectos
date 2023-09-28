package Arraylist;

import java.util.GregorianCalendar;
import java.util.*;

/**
 * Write a description of class Uso_Empleado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UsoEmpleado 
{


    /**
     * Constructor for objects of class Uso_Empleado
     */
    public static void main(String[] args){
       /*
        empleado empleado1=new empleado("Tomás",85000,1990,12,17);  
        
        empleado empleado2=new empleado("Ana Lopez",95000,1995,06,02);
        
        empleado empleado3=new empleado("Maria Martin",105000,2002,03,17);
    
        empleado1.SubirSueldo(5); 
   
        empleado2.SubirSueldo(5); 
   
        empleado3.SubirSueldo(5); 

        System.out.println("Nombre: "+ empleado1.GetNombre()+ " sueldo: " +
        empleado1.GetSueldo()+ " Fecha de alta "+ empleado1.GetFechaDeAlta());
        
         System.out.println("Nombre: "+ empleado2.GetNombre()+ " sueldo: " +
        empleado2.GetSueldo()+ " Fecha de alta "+ empleado2.GetFechaDeAlta());
        
        
         System.out.println("Nombre: "+ empleado3.GetNombre()+ " sueldo: " +
        empleado3.GetSueldo()+ " Fecha de alta "+ empleado3.GetFechaDeAlta());
        
       
       
       empleado[] misEmpleados=new empleado[3];
       
       misEmpleados[0]=new empleado("Tomás",19,234113);  
       
       misEmpleados[1]=new empleado("Ana ",17,20000);
       
       misEmpleados[2]=new empleado("Alba",18,23941);
       
         */ 
      
       ArrayList<empleado> misEmpleados=new ArrayList<empleado>();
       
        misEmpleados.ensureCapacity(20);//crea el arraylist originalemente con 20 posiciones uncicamente
        
      /*  
       misEmpleados.add(new empleado("tomas",19,20000));
       
       misEmpleados.add(new empleado("Alba",18,20000));
       
       misEmpleados.add(new empleado("Ana",18,20000));
        
       misEmpleados.add(new empleado("tomas",19,20000));
       
       misEmpleados.add(new empleado("Alba",18,20000));
       
       misEmpleados.add(new empleado("Ana",18,20000));
        
       misEmpleados.add(new empleado("tomas",19,20000));
       
       misEmpleados.add(new empleado("Alba",18,20000));
       
       misEmpleados.add(new empleado("Ana",18,20000));
        
       misEmpleados.add(new empleado("tomas",19,20000));
       
       misEmpleados.add(new empleado("Alba",18,20000));
       
       misEmpleados.add(new empleado("Ana",18,20000));
       
       misEmpleados.set(1,new empleado("Olga",23,2200));//reemplaza a la posicion 1 con un nuevo empleado llamado olga
       */
      // System.out.println(misEmpleados.get(5).GetNombre()); para sacar un elemento en concreto del arraylistt
       
      // misEmpleados.trimToSize();//recorta el espacio que le quede al arraylist libre. 
       
      // System.out.println(misEmpleados.size());
      /*//otra forma para que me imprima todo con el for
       for(int i=0;i<misEmpleados.size();i++){
        
            empleado e =misEmpleados.get(i);
            
            System.out.println(e.GetNombre());
        }
 */
        //si quiero trabajar con un array puedo hacer que el arraylist se meta en un array
       
        /*empleado arrayEmpleados[]= new empleado[misEmpleados.size()];
        
        misEmpleados.toArray(arrayEmpleados);
        
        //otra forma de recorrer un array es con un iterador
        Iterator <empleado> it=misEmpleados.iterator();// llamo al objeto iterador del arraylist
        while(it.hasNext()){
        System.out.println(it.next().GetNombre());//con esto recorremos todo
    }
        */
    //La principal utilidad de los iteradores es que nos permiten eliminar elementos de colecciones dinámicas como por ejemplo los ArrayLists; si intentas eliminar ítems de un ArrayList con un simple bucle for o for each no funcionará correctamente, porque la colección está redimensionándose y reindizándose al mismo tiempo que iteras sobre sus elementos.
    //¿Queréis la prueba? Probad el siguiente código sin iterador y comprobaréis la anomalía:
    ArrayList<empleado> listaEmpleados = new ArrayList<empleado>();
		listaEmpleados.add(new empleado("Phileas Fogg", 50, 2500));
		listaEmpleados.add(new empleado("Cyrus Smith", 52, 3500));
		listaEmpleados.add(new empleado("Otto Lidenbrock", 48, 3100));
		listaEmpleados.add(new empleado("Tom Ayrton", 39, 1050));
		listaEmpleados.add(new empleado("Nemo", 59, 3900));
		listaEmpleados.add(new empleado("Michel Ardan", 43, 4400));

		// No funcionará por el redimensionado dinámico ¡se necesita un iterador!: es verdad
		for (int i = 0; i < listaEmpleados.size(); i++) {
			listaEmpleados.remove(i);
		}

		System.out.println(listaEmpleados.size()); // Queríamos borrar todos los elementos, pero solo se borró la mitad
    
    /*
      for(empleado e:misEmpleados){
        
            e.SubirSueldo(5);
            //e.estableceIncentivo(70000);esto no funciona porque no hay metodo establece incentivo para empleados,por ello no puede realizar una sobrecarga de metodos
            System.out.println("Nombre: "+ e.GetNombre()+ " puesto: "+ " sueldo: " +
            e.GetSueldo());//e se comporta como una variable de tipo empleado cuando salen empleados ,pero como una de jefatura cuando sale jefatura,
            //ya que se puede sustituir una superclase donde se espera ,por una subclase.Esto se puede ver reflejado en el sueldo (se le suma el incentivo)
        
        }
        
       /*   for(int i =0;i<3;i++){
        
              System.out.println("Nombre: "+ misEmpleados[i].GetNombre()+ " sueldo: " +
            misEmpleados[i].GetSueldo()+ " Fecha de alta "+ misEmpleados[i].GetFechaDeAlta());
        
        
        }*/
    }
}
/**
 * Write a description of class empleado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class empleado 
 {
     //si la clase no tuviera constructores se usaria uno por defecto,este está vacio es decir ,no le da ningun parametro en concreto
    private String nombre;
    
    private int edad;
    
    private double sueldo;
    
   
    public empleado(String nom,int edad,double sue)
    {
        nombre=nom;
        this.edad=edad;
        sueldo=sue;
     
    }
   
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String GetNombre()
    {
        return nombre;
    }
    public double GetSueldo() {//si pongo final aquí conseguiría que no se reemplazara el codigo en jefatura
        return sueldo;
    }  
    public void SubirSueldo(double porcentaje){
        double aumento=sueldo*porcentaje/100;
        sueldo += aumento;
    }
     public int GetEdad()
    {
        return edad;
    }
    
    
  }