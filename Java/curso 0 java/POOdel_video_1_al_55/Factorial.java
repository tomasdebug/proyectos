import javax.swing.*;
/**
 * Write a description of class Factorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Factorial
{
     public static void main(String[] args){
         int resultado=1;
         
         int numeropedido=Integer.parseInt(JOptionPane.showInputDialog("introduce el lado"));
         
         for(int i=1;i<(numeropedido+1);i++){
             resultado=resultado*(i);
             
         }/*otra forma más intuitiva xd
             for(int=numeropedido;i>0;i--){
                
                ...}
         */
          System.out.println(resultado);
     }
}
