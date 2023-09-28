
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;
public class PruebaTemporizador {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  
  DameLaHora oyente=new DameLaHora();//inicializo el metodo que va a entrar en el timer
  
  Timer miTemporizador= new Timer(5000, oyente);//cada 5 segundos al objeto oyente,le decimos que cada 5 seg ejecute el codigo de oyente ,que es de tipo interfaz actionlistiner 
  
  miTemporizador.start();//empieza el temporizador
  
  JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");//va a sacar una pestaña para detenerlo
  
  System.exit(0); //acaba la ejecucion del programa

 }

}
class DameLaHora implements ActionListener{
 
 public void actionPerformed(ActionEvent e) {//cada 5 segundos se ejecuta este metodo 

  Date ahora=new Date();//almaceno en ahora la fecha de ese instante
  
  System.out.println("Te pongo la hora cada 5 sg: "+ ahora);
 }
  
}