package Graficos;

import java.awt.*;//para usar la clase graphics

import javax.swing.*;//para usar la clase jpanel
/**
 * Write a description of class PruebaDibujo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PruebaDibujo
{
  public static void main(String args[]){
    
    marcoConDibujos mimarco=new marcoConDibujos();
    
    mimarco.setVisible(true);
    
    mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class marcoConDibujos extends JFrame{

    public marcoConDibujos(){
    
        setTitle("Prueba de dibujo");
        
        setSize(400,400);
    
        laminaConFiguras milamina= new laminaConFiguras();
        
        add(milamina);
    }


}
class laminaConFiguras extends JPanel{

    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
    
        //g.drawRect(50,50,200,200);//se le da 50 en la x ,50 en la y y el ancho y la altura.Es decir se le da posicion y ancho y altura,dibujo rectanguulos
    
        //g.drawLine(100,100,300,200)//me piden x e y del primer punto y x e y del segundo punto que unen las lineas
    
        g.drawArc(50,100,100,200,120,150);//coordenada x,coordenada y,ancho de arco,alto de arco,angulo de inicio ,arco de angulo
    }




}
/*Otra forma
 *  class DibujandoMarco extends JFrame {
    
    public DibujandoMarco() {
        
        setTitle("Prueba de dibujo en Marco");
        
        setSize(400, 450);
                
        LaminaPintada rayas=new LaminaPintada();
        
        add(rayas);
    }
}


class LaminaPintada extends JPanel {
    
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        g.drawLine(50, 50, 250, 300);
        
        g.drawLine(50, 30, 125, 300);
        
        g.drawLine(50, 30, 325, 200);
        
    }
    
}
   
   
   
 *
 */