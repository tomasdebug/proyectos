    import java.util.*;
    
/**
 * Write a description of class Introducir_informacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Introducir_informacion
{
    public static void main(String[] args){
        Scanner entrada= new Scanner(System.in);//creo un objeto de la calse escaner llamado entrada que tendra la informacion que entra por consola
        
        System.out.println("introduce tu nombre");
        
        String nombre_usuario=entrada.nextLine();//invoco un metodo del objeto creado antes y guardo el valor que retonra en una variable
        
        System.out.println("introduce la edad");
        
        int edad=entrada.nextInt();//hago lo mismo pero con un int
        
        System.out.println("Hola "+ nombre_usuario +". El año que viene tendrás" + (edad+1) + "años");
    
    }
    
}
