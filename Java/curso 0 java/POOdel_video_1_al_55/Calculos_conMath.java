
/**
 * Write a description of class Calculos_conMath here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calculos_conMath
{
  
    public static void main(String[] args){
    
        double raiz=Math.sqrt(9);//la raiz debe ser double siempre
        
        System.out.println(raiz);
        
        double num1=5.85;
        
         //int resultado=(int)Math.round(num1);//hago una refundición ver en fundamentos de poo con java.
        
        //System.out.println(resultado);
        
        

  double base=5;
  double exponente=3;
  
  int resultado=(int)Math.pow(base,exponente);
  
 System.out.println("el resultado de "+base+ " elevado a "+exponente+" es "+resultado);
    
    }
}
