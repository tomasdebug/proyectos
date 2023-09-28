import java.util.*;//para poder usar la clase scanner
/**
 * Write a description of class TiposEnumerados here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TiposEnumerados
{
    /*
   enum Talla{MINI,MEDIANO,GRANDE,MUY_GRANDE//Le decimos que solo puede crear estos valores.}
    */
   enum Talla{
    
      MINI("S"),MEDIANO("M"),GRANDE("L"),MUY_GRANDE("XL");
       
       private String abreviatura;
        
     
       private Talla(String abreviatura){//Si le pasamos la s por ejemplo pondra MINI.
           //El constructor tiene que ser privado ya que no se pueden crear instancias desde fuera 
    
        this.abreviatura=abreviatura;
    
    }
    public String dameAbreviatura(){
 
     return abreviatura;
    
    }
    }
    public static void main(String args[])
    {
        /*
        Talla s=Talla.MINI;
        
        Talla M=Talla.MEDIANO;
        
        Talla l=Talla.GRANDE;
    
        Talla xl=Talla.MUY_GRANDE;
        */
       Scanner entrada=new Scanner(System.in);
       
       System.out.println("Escribe talla:MINI,MEDIANO,GRANDE,MUY_GRANDE");
       
       String entrada_datos=entrada.next().toUpperCase();
       
       Talla la_talla=Enum.valueOf(Talla.class,entrada_datos);//nos devuelve el nombre de la constante enumerada introducida en la entrada de datos
       
       System.out.println("Talla="+ la_talla);
       
       System.out.println("Abreviatura="+ la_talla.dameAbreviatura());
       
    }
    
}
