
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;
import java.awt.Toolkit;

public class PruebaTemporizador2
{
   public static void main(String[] args) {
  
       reloj mireloj = new reloj();//invocamos al constructor por defecto
       
       mireloj.enMarcha(3000,true);
       
       JOptionPane.showMessageDialog(null,"Pulsa aceptar para terminar");
       
       System.exit(0);

 }
}
 class reloj
 {
    
    // int intervalo;
     
    // boolean sonido;
     /*
     public reloj(int intervalo,boolean sonido){
        
        this.intervalo=intervalo;
        this.sonido=sonido;

    }
    */
    public void enMarcha(int intervalo,final boolean sonido){//clase interna local.Para que la clase interna local acceda al argumento necesito el final
    
              class DameLaHora2 implements ActionListener{//me estoy ahorrando setters y getters ya que la clase interna puede acceder a
            //los campos de ejemplar(variables) de las clases que las engloba
            
            public void actionPerformed(ActionEvent evento){
            
                Date hora=new Date();
                System.out.println("Hora cada 3 sg"+hora);
                if(sonido){
                
                    Toolkit.getDefaultToolkit().beep();//hace un sonido
                
                }
            }
            
         }
            ActionListener oyente=new DameLaHora2();//Aún no tenemos la clase damelahora2
            
            Timer mitemporizador=new Timer(intervalo,oyente);
            
            mitemporizador.start();
        
   
    }/*
    private class DameLaHora2 implements ActionListener{//me estoy ahorrando setters y getters ya que la clase interna puede acceder a
        //los campos de ejemplar(variables) de las clases que las engloba
        
        public void actionPerformed(ActionEvent evento){
        
            Date hora=new Date();
            System.out.println("Hora cada 3 sg"+hora);
            if(sonido){
            
                Toolkit.getDefaultToolkit().beep();//hace un sonido
            
            }
        }
        
    }
    */

    }
 

