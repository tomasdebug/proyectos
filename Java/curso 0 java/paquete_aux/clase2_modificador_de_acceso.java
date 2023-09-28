package paquete_aux;

import Pruebas_modificador_acceso.clase3_modificador_de_acceso;
/**
 * Write a description of class clase1_modificador_de_acceso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class clase2_modificador_de_acceso
{
   public static void main(String[] args){
    
     clase1_modificador_de_acceso miobj=new clase1_modificador_de_acceso();
     System.out.println(miobj.miMetodo());//se ve mimetodo,tengo que imprimirlo 
     /*
       si tengo eso el valor se descarta porque el metodo no hace nada con el
       
       MiClase instancia = new MiClase();
        instancia.obtenerMensaje(); // El valor devuelto se descarta
        
        el return se devuelve donde se llamó el metodo,es por eso que sino haces nada con el valor devuelto se descarta y no se muestra
        */
     clase3_modificador_de_acceso miobj2=new clase3_modificador_de_acceso();//si importamos el paquete podemos crear instancias de este,ya que se VEN por el modificador de acceso predeterminado
     
     
     
    }
}