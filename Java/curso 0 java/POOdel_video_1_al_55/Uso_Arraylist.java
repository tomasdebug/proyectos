package POOdel_video_1_al_55;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Write a description of class Uso_Arraylist here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

 

public class Uso_Arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Empleado listaEmpleados[] = new Empleado[3];
		
		listaEmpleados[0] = new Empleado("Ana", 45, 2500);
		listaEmpleados[1] = new Empleado("Antonio", 55, 2000);
		listaEmpleados[2] = new Empleado("María", 25, 2600);
		
		  */
         
            // TODO Auto-generated method stub
          ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
         listaEmpleados.ensureCapacity(20);// Creamos una lista con 20 elementos
          listaEmpleados.add(new Empleado("Ana", 45, 2500));
          listaEmpleados.add(new Empleado("Antonio", 55, 2000));
          listaEmpleados.add(new Empleado("María", 25, 2600));
          listaEmpleados.add(new Empleado("Ana", 45, 2500));
          listaEmpleados.add(new Empleado("Antonio", 55, 2000));
          listaEmpleados.add(new Empleado("María", 25, 2600));
          listaEmpleados.add(new Empleado("Ana", 45, 2500));
          listaEmpleados.add(new Empleado("Antonio", 55, 2000));
          listaEmpleados.add(new Empleado("María", 25, 2600));
          listaEmpleados.add(new Empleado("Ana", 45, 2500));
          listaEmpleados.add(new Empleado("Antonio", 55, 2000));
          listaEmpleados.set(1,new Empleado("María", 25, 2600));//pones la posicion y luego el empleado
          System.out.println(listaEmpleados.get(1).dameDatos());
          // Si quieres insertar un nuevo elemento pero sin eliminar el que había se hace indicando el indicie en add:listaEmpleados.add(1, new Empleado ("Olga", 22, 2200));
          listaEmpleados.size();
          //voy a utilizar los metodos set y get (set reemplaza un elemento de la lista en una posicion y get saca el elemento de una posicion )
      
		/*for(Empleado e: listaEmpleados) {
			System.out.println(e.dameDatos());
		}*/
  //Tambien se puede utilizar el for convencional
       /*  for(int i = 0; i < listaEmpleados.size(); i++) {
            Empleado e = listaEmpleados.get(i);

            System.out.println(e.dameDatos());
           //System.out.println(listaEmpleados.get(i).dameDatos());
        }
        */
        //o se puede utilizar un iterador para recorrer el arraylist
        /*Iterator<Empleado> mi_iterador = listaEmpleados.iterator();

        while(mi_iterador.hasNext()) {
            //System.out.println(mi_iterador.next);//me devuelve los objetos de la lista empleado peron o me lo pasa a texto(para ello uso el dameDatos)
            Empleado e = mi_iterador.next();
            System.out.println(e.dameDatos());
        }*/
        //sino queremos utilizar el arrayñlist  se puede utilizar el array normal
        /*Empleado arrayEmpleados[] = listaEmpleados.toArray(new Empleado[listaEmpleados.size]);
         así declaro un array con el tamaño del arraylist en la misma linea o bien puedo diversificarlo*/
        // Empleado arrayEmpleados[]= new Empleado[listaEmpleados.size];

         //listaEmpleados.toArray(arrayEmpleados);//paso el arraylist a un array y ya puedo trabajar con el array sin problemas
        //arhora se puede declarar con este for 
        /* for(int i = 0; i < arrayEmpleados.length; i++) {
             System.out.println(arrayEmpleados[i].dameDatos());
         }
          */
          /*La principal utilidad de los iteradores es que nos permiten eliminar elementos de colecciones dinámicas como por ejemplo los ArrayLists; si intentas eliminar ítems de un ArrayList con un simple bucle for o for each no funcionará correctamente, 
          porque la colección está redimensionándose y reindizándose al mismo tiempo que iteras sobre sus elementos. 
          ¿Queréis la prueba? Probad el siguiente código sin iterador y comprobaréis la anomalía: */
        
          listaEmpleados.add(new Empleado("Phileas Fogg", 50, 2500));
          listaEmpleados.add(new Empleado("Cyrus Smith", 52, 3500));
          listaEmpleados.add(new Empleado("Otto Lidenbrock", 48, 3100));
          listaEmpleados.add(new Empleado("Tom Ayrton", 39, 1050));
          listaEmpleados.add(new Empleado("Nemo", 59, 3900));
          listaEmpleados.add(new Empleado("Michel Ardan", 43, 4400));
  
          // No funcionará por el redimensionado dinámico ¡se necesita un iterador!:
          for (int i = 0; i < listaEmpleados.size(); i++) {
              listaEmpleados.remove(i);
          }
  
          System.out.println(listaEmpleados.size()); // Queríamos borrar todos los elementos, pero solo se borró la mitad
        }


}

class Empleado{
	
	public Empleado(String nombre, int edad, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}
	
	public String dameDatos() {
		return "El empleado se llama" + nombre + ". Tiene" + edad + "años. " + " Y un salario de " + salario;
	}
	
	private String nombre;
	
	private int edad;
	
	private double salario;
	
}

