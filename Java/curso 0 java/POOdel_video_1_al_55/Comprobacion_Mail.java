import java.util.*;
import javax.swing.*;
/**
 * Write a description of class Comprobacion_Mail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comprobacion_Mail
{
    
 public static void main(String[] args){
     
      int arroba = 0;
      
      boolean punto=false;
     
     String mail=JOptionPane.showInputDialog("Introduce mail, por favor");
     
     int numerocaracteres=mail.length();
     
         for(int i=0;i<numerocaracteres;i++){
             if(mail.charAt(i)=='@')  {
                
                arroba++;
                
                }   
                 if(mail.charAt(i)=='.')  {
                
                    punto=true;
                
             }  
         }
         if(arroba==1 && punto==true){
            System.out.println("Es correcto");
            }else{
            System.out.println("No es correcto");
            
            }
     
 
     
     
 }
}
