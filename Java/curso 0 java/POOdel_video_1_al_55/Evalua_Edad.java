
/**
 * Write a description of class Evalua_Edada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Evalua_Edad
{
    int edad;
    public static void main(String[] args){
        
        /*el tio lo hace así:
         * Scanner entrada = new Scanner(System.in);
         * 
         * int edad= entreada.nextInt();
         * 
         * if...
           
           */
    
       
    }
    public void comparar_edad(int edad){
    
       
         edad=this.edad;
        
         if(edad>=18){
             
             System.out.println("eres mayor de edad");
            
            }else if(edad<40){
            
             System.out.println("eres joven");
             
            }
            
            else if(edad<65){
            
             System.out.println("eres maduro");
             
            }
            else{
                System.out.println("cuidate");
            }
           
           
           
          
    
    }
}
