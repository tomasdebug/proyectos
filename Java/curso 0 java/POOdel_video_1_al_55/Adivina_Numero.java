import java.util.*;
import java.util.Scanner;

/**
 * Write a description of class Adivina_Numero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Adivina_Numero
{
  public static void main(String[] args){
   
    int aleatorio=(int)(Math.random()*100);
    
    System.out.println(aleatorio);
    
    Scanner entrada= new Scanner(System.in);
    
    int intentos=0;
    
    int numero=0;
     /*con while
    while(numero!=aleatorio){
        
        System.out.println("introduce un número");
        numero=entrada.nextInt();
        
        if(numero>aleatorio){
        
            System.out.println("el numero es más pequeño");
        
        }else{
        
             System.out.println("el numero es más grande");
        }
        
        intentos++;
    
    }
    */
   /*con do while*/
   do{
        
        System.out.println("introduce un número");
        numero=entrada.nextInt();
        
        if(numero>aleatorio){
        
            System.out.println("el numero es más pequeño");
        
        }else{
        
             System.out.println("el numero es más grande");
        }
        
        intentos++;
    
    } while(numero!=aleatorio);
    System.out.println("correcto");
    System.out.println("tus intentos han sido "+ intentos);
    
    }
}
