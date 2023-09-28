
/**
 * Write a description of class manipula_cadenas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class manipula_cadenas
{
    public static void main(String[] args){
        
        String nombre="Tomas";
        
        int longitud_nombre=nombre.length();//declaro y defino la longitud del nombre
        
        char ultima_letra;//declaro la ultima letra
        
         ultima_letra=nombre.charAt(longitud_nombre-1);//defino la ultima letra,que tendrá la ultima posición(el -1 es porque empiezan en 0 por defecto)
        
        char primera_letra=nombre.charAt(0);//defino y declaro la primera letra
        
       
        
        
        System.out.println("tu nombre es "+ nombre);
        
        System.out.println("Mi nombre tiene "+ longitud_nombre +" letras.");
        
        System.out.println("La primera letra de  " + nombre + " es " + primera_letra);
        
        System.out.println("Y la ultima letra es la " + ultima_letra);
        
    
    }
}
