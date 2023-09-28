package paquete_aux;

/**
 * Write a description of class clase1_modificador_de_acceso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class clase1_modificador_de_acceso
{
    // instance variables - replace the example below with your own
    protected int mivar=5;//se cambia la privacidad a protected para que la clase 3,que hereda de esta ,pueda usar sus variables 
    
    protected int mivar2=7;
   //el constructor es el que hay por defecto 
    /**
     * metodo para ver el funcionamiento del modificador por defecto que me dejará invocar este metodo en esta 
     * clase y por otras clases del mismo paquete pero no por otras de otro paquete
     */
     public String miMetodo()
    {
        return "El valor de mi var2 es: 2"; 
    }
}
