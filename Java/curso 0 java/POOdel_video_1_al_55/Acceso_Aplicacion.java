import javax.swing.*;
/**
 * Write a description of class Acceso_aplicacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Acceso_Aplicacion
{
    public static void main(String [] args){
        
        String clave="Tomas";
        
        String pass="";//este String existe unicamente para reservar un espacio para comparar los strings.
        
        while(clave.equals(pass)==false){
        
            pass=JOptionPane.showInputDialog("Introduce la contraseña, por favor");
            
            if(clave.equals(pass)== false){
            
                System.out.println("contraseña incorrecta");
            }
        }
    
    
    }
}
