
/**
 * Write a description of class manipula_cadenas2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class manipula_cadenas2
{
  public static void main(String[] args){
    
    String frase="Hoy es un estupendo día para aprender a programar en java";
    
    String frase_resumen=frase.substring(0,29) + " irnos a la playa y olvidarnos de todo" + 
    " o "+ frase.substring(29,57);//los espacios en blanco cuentan como caracter
    
    System.out.println(frase_resumen);
      
    }
}
