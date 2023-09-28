import javax.swing.*;

/**
 * Write a description of class Peso_Ideal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Peso_Ideal
{
   public static void main(String[] args){
    
        String genero="";
        
        String mujer="M";
        
        String hombre="H";
        
        int altura;
        
        int terminado=0;
        
        do{
            
            genero=JOptionPane.showInputDialog("Introduce genero, por favor(H/M)");
            
          }while(genero.equalsIgnoreCase(mujer)==false && genero.equalsIgnoreCase(hombre)==false);
             altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura en cm pls"));
            
            if(genero.equalsIgnoreCase(mujer)){
                
                int pim= altura -120;
            
                System.out.println("tu peso ideal es "+ pim);
            
                terminado=1;
            }
        
              else if(genero.equalsIgnoreCase(hombre)){
                
                int pim=altura -110;
            
                System.out.println("tu peso ideal es "+ pim);
            
                terminado=1;
            }
            else{
                System.out.println("porfavor sea serio");
            }
        
        
    
    
    }
}
