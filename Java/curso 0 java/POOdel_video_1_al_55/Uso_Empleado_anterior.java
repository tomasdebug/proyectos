import java.util.*;



/**
 * Write a description of class Uso_empleado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

    
    
    public class Uso_Empleado_anterior
{
       
    /*public static void main(String[] args){
        Empleado empleado1=new Empleado("Paco",85000,1990,12,17);
        
        Empleado empleado2=new Empleado("Lucia",835000,1920,6,7);
        
        Empleado empleado3=new Empleado("Paco",1,2000,2,17);
        
        empleado1.subesueldo(5);
        
        System.out.pritnln("Nombre: "+empleado1.dameNombre()+" Sueldo: " + empleado1.damesueldo()
        + " fecha de Alta: "+ empleado1.dameFechaContrato());*/
       /* Empleado[] misEmpleados=new Empleado[3];
        
        misEmpleados[0]=new Empleado("Paco",85000 ,1990,12,17);
         
      for(int i =0;i>3;i++){
        
            
        
        }
        
        */
        ArrayList<Empleado> listaEmpleados =new ArrayList<Empleado>();
       public void listar(Empleado empleado){
   
           listaEmpleados.add(empleado);
          for(Empleado em: listaEmpleados) {
            System.out.println(em.dameDatos());
        }
        }
    }
     class Jefatura extends Empleado{

        public Jefatura(String nombre, double sueldo, int año, int mes, int dia) {
            super(nombre, sueldo, año, mes, dia);//se llama a este constructor y una vez tenga los parametros de este constructor se le pasa al constructor de la superclase padre
        }
         public void subesueldo(double incentivo) {
        this.incentivo = incentivo;
     }
     public double damesueldo() {
        //double sueldoJefe=damesueldo();// este metodo machaca el metodo que heredda de la clase empleado, este metodo sobreescribe el metodo que ha heredado
        double sueldoJefe=super.DameSueldo();//quiero que el metodo sea del padre 
        return sueldoJefe + incentivo;
     }
     public double incentivo;


     
        
    }

     
     
    

  



