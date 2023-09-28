package Graficos;

import javax.swing.*;

import java.awt.*;

/**
 * Write a description of class EscribiendoEnMarco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class escribiendoEnMarco
{
  public static void main(String[] args){
    marcoConTexto mimarco=new marcoConTexto();
    
    mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
 
}
class marcoConTexto extends JFrame{
        public marcoConTexto(){
        
            setVisible(true);
            
            setSize(600,450);//ancho y alto
            
            setLocation(400,200);
            
            setTitle("primer texto");
            
            lamina milamina=new lamina();
            
            add(milamina);//pone por encima la lamina,como si fuera una capa de photoshop
            
        }
    
    }
class lamina extends JPanel{
    
    public void paintComponent(Graphics g){
       
     super.paintComponent(g);//llama al metodo paint component de la clase Jcomponent
        
     g.drawString("estamos aprendiendo swing",100,100);//le pones lo que quieres escribir como string y donde quieres ponerlo en el eje x y en el eje y
    
    
    
    
    }



}
