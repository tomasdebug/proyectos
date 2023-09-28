package Graficos;
import javax.swing.*;


public class CreandoMarcos
{
   
    public static void main(String[] args){
    
        miMarco marco1=new miMarco();
        
        marco1.setVisible(true);
        
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Le digo que al cerrar la ventana que se cierre
    
    }
   
}
class miMarco extends JFrame{
        public miMarco(){
            
            //setSize(500,300);//tiene un width(ancho) y un heigth(altura)
            
            //setLocation(500,300);//500 es la x y 300 es la y
            
            setBounds(500,300,250,250);//con esto primero pongo la ubicacion y luego pongo el tamaño del cuadrado
            
            //setResizable(false);//por si no quiero cambiar el tamaño 
            
            //setExtendedState(JFrame.MAXIMIZED_BOTH);//Para cuando lo maximices controlar su comportamiento
            
            setTitle("mi ventana");
        }
    }
