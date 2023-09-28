import java.util.*;
import javax.swing.*;

/**
 * Write a description of class Areas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Areas
{
  public static void main(String[] args){
    
      Scanner entrada= new Scanner(System.in);
      
      System.out.println("Elige una opción:\n 1 Cuadrado \n 2 Rectángulo \n 3 Triángulo \n 4 círculo");
      
      int figura=entrada.nextInt();
      
      switch(figura){
        
        case 1:
            //cuadrado
            int lado=Integer.parseInt(JOptionPane.showInputDialog("introduce el lado"));//el joption pane es estático,por ello no necesita crearme un objeto sino que se utiliza un nombre de la clase ,parse int(perteneciente a la clase integer) convierte un string a entero
            
            System.out.println("selecciona el lado");
            
            double Area_Cuadrado= Math.pow(lado,2);
            
            System.out.println("el area de un cuadrado es "+  Area_Cuadrado);
            
            break;
        
    
        case 2:
            int base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
            
            int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
            
            int Area_Rectangulo = base * altura;
            
            System.out.println("El area del rectangulo es "+ Area_Rectangulo);
            break;
            
        case 3:
            
            base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
            
            altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
            
            int Area_Triangulo = (base * altura)/2;
            
            System.out.println("El area del rectangulo es "+ Area_Triangulo);
            break;
            
        case 4:
            
            int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce radio"));
            
            double Area_Circulo= Math.PI * (Math.pow(radio,2));
            
            System.out.print("El area del circulo es" );
           
            System.out.printf("1.2f"+Area_Circulo );
            
            break;
            
            default:
                
            System.out.print("La elección no es correcta" );
        }
    
       
    }
}
