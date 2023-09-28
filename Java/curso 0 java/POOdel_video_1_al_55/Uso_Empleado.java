import java.util.GregorianCalendar;
import java.util.*;

/**
 * Write a description of class Uso_Empleado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Uso_Empleado 
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
        
       */ 
       Jefatura jefe_RRHH=new Jefatura("Tomas","Jefazo",20000,2003,01,20);
    
       jefe_RRHH.estableceIncentivo(234130);      
       
       empleado[] misEmpleados=new empleado[6];
       
       misEmpleados[0]=new empleado("Tomás","puto amo",85000,1990,12,17);  
       
       misEmpleados[1]=new empleado("Ana ","payaso ",95000,1995,06,02);
       
       misEmpleados[2]=new empleado("Maria ","tecnica ",105000,2002,03,17);
       
       misEmpleados[3]=new empleado("Maria ");
       
       misEmpleados[4]=jefe_RRHH;//polimorfismo en accion ,principio de sustitucion
       
       misEmpleados[5]=new Jefatura("Marta","tocapelotas/la mas puta",1,1999,04,21);
       
       Jefatura Jefa_Marta=(Jefatura)misEmpleados[5];//hacemos un casting para hacer que la variable empleado se comporte como una de jefatura
       //es decir me deja almacenar la variable jefatura en un array de empleados ,pero porque jefatura es una subclase 
       Jefa_Marta.estableceIncentivo(70000);//el casting se puede hacer porque un jefe es un empleado
       
       empleado director_comercial=new Jefatura("Sandra","jefe porrera",49321,2002,02,03);
       
      
       
       System.out.println("jefe:"+director_comercial.GetNombre()+"con un bonus de:" +director_comercial.establece_bonus(200));
       
        System.out.println("empleado:"+ misEmpleados[2].GetNombre()+"con un bonus de:" + misEmpleados[2].establece_bonus(200));
       
       Comparable ejemplo=new empleado("Eli","h",96000,2011,03,04);
       
       System.out.println(Jefa_Marta.tomarDecisiones("Dar mas dias de vacaciones a los empleados"));
       /*
       if(director_comercial instanceof empleado){

        System.out.println("Es de tipo Jefatura");
        
        }
       if(ejemplo instanceof Comparable){
        
         System.out.println("implementa la interfaz comparable");
        }
       */
      // Jefatura jefe_compras=(Jefatura) misEmpleados[1];esto da error un empleado no siempre es un jefe
      /* for(int i =0;i<3;i++){
        
        misEmpleados[i].SubirSueldo(5);
        
        }
        */
       Arrays.sort(misEmpleados);
       for(empleado e:misEmpleados){
        
            e.SubirSueldo(5);
            //e.estableceIncentivo(70000);esto no funciona porque no hay metodo establece incentivo para empleados,por ello no puede realizar una sobrecarga de metodos
            System.out.println("Nombre: "+ e.GetNombre()+ " puesto: "+e.GetPuesto()+ " sueldo: " +
            e.GetSueldo()+ " Fecha de alta "+ e.GetFechaDeAlta());//e se comporta como una variable de tipo empleado cuando salen empleados ,pero como una de jefatura cuando sale jefatura,
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
class empleado implements Comparable,trabajadores//para conseguir el metodo sort necesito que los objetos del array hereden de Comparable
 {
     //si la clase no tuviera constructores se usaria uno por defecto,este está vacio es decir ,no le da ningun parametro en concreto
    private String nombre;
    
    private String puesto;
    
    private double sueldo;
    
    private Date altaContrato;
    
    private int id;//la creo como statica(es decir se va a compartir por entre los objetos)
    
    private static int idSiguiente=1;
    
    public empleado(String nom,String puesto,double sue,int agno ,int mes,int dia)
    {
        nombre=nom;
        this.puesto=puesto;
        sueldo=sue;
        GregorianCalendar calendario=new GregorianCalendar(agno,mes-1,dia);
        altaContrato=calendario.getTime();
        id=idSiguiente;
     
        idSiguiente++;
    }
    public empleado(String nom)//sobrecarga de constructores 
    {
     this(nom,"Administracion",30000,2000,01,01);//este this llama se usa para llamar al constructor de arriba con unos parametros predeterminados
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
    public int compareTo(Object miObjeto){
    
        empleado otroEmpleado=(empleado) miObjeto;
        if(this.sueldo<otroEmpleado.sueldo){
        
            return -1;
        
        }
            if(this.sueldo>otroEmpleado.sueldo){
        
            return 1;
        
        }
        return 0;
    }
     public double establece_bonus(double gratificacion){
        
        return gratificacion+trabajadores.bonus_base;
        
        }
  }
final class Jefatura extends empleado implements jefes{//final indica que es el final del arbol genealogico,es decir que no se va a heredar más
        //si quito el constructor , me da error diciendo que falta un constructor implicito,porque 
            //se cree que usa el constructor por defecto,al irse a la otra clase se da cuenta de que no hay constructor sin parametros dando error
        private double incentivo;
        
        public Jefatura(String nom,String puesto,double sue,int agno,int mes,int dia){
        
            super(nom,puesto,sue,agno,mes,dia);
            
            
            
        }
        public void estableceIncentivo(double b){
        
            incentivo=b;
        
        }
        public double GetSueldo(){//este metodo reemplaza el metodo heredado de la clase empleado (lo machaca )
        
            //double sueldoJefe=getSueldo(); esto está mal ya que va a repetir ESTE METODO haciendo una ieracion
    
            double sueldoJefe=super.GetSueldo();//Arreglado
            
            return sueldoJefe + incentivo;
        }
        public String tomarDecisiones(String decision){
        
         return "Un miembro de la direccion a tomado una decision de:"+ decision;
        }
        public double establece_bonus(double gratificacion){
        
         double tasaJefes=2000;
            
         return trabajadores.bonus_base+tasaJefes+ gratificacion ;
        
        }
    }


