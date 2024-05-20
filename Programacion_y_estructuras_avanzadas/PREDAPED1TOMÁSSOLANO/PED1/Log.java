import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

/**
 * Write a description of class Log here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Log
{
    // Clase destinada a hacer entradas y salidas
    private int x;
    
    private  int monedas[];
    
    private int c;
    
    private String doc;
    
    private String docSalida;
    
  
    /**
     * Constructor de Log
     */
    public Log(String doc,String docSalida)
    {
        // initialise instance variables
        this.doc=doc;
        this.docSalida=docSalida;
    }

    /**
     * Metodo de escritura
     */
 
        public void escritura(String txt,boolean mantenertxt,boolean cambiodelinea ){
        //escribir archivos
         String fileName = docSalida+".txt";//sacamos el nombre del archivo con su extension
             
     
          try{
            
              Scanner sc = new Scanner(new File(fileName));//detecto el archivo
            
              FileWriter archivo=new FileWriter(fileName,mantenertxt);//el bolean mantenertxt sobreescribira cuando sea falso ,sino lo es se concadenará
              BufferedWriter flujo=new BufferedWriter(archivo);//creo el flujo para escribir en el archivo
            //
            PrintWriter escribir=new PrintWriter(flujo);//inicializo el printwriter con el flujo
            if(cambiodelinea==false){
                escribir.print(txt);
            }else{
             escribir.println(txt);
            }
            escribir.flush();//limpio despues de cada iteración para evitar errores
            }   catch (NoSuchElementException e){
             
            //Si no se encuentra se printa esto
             System.out.println("archivo vacio o no encontrado");
        }
        catch (IOException e) {
            //A cualquier otra excepcion se printa esto otro
           System.out.print("(no se puede escribir,ya que el archivo no ha sido encontrado)");
           e.printStackTrace();//Da la traza de error para ver donde mehe equivocado
           return;
           
        }  
          
    }
        public  int[] LeerVectorMonedas(){
         String fileName = doc+".txt";//sacamos el nombre del archivo con su extension
             
     
           // Leemos el fichero y sacamos sus datos
            try {
               
                Scanner sc = new Scanner(new File(fileName));
                 
                int lvect = sc.nextInt(); 
                
                sc.nextLine();
                String line = sc.nextLine();//1linea
                String elementos[]=line.split(" ");//moneda
                monedas=new int[lvect];
              
                c=sc.nextInt();//cambio
             
                  for(int i=0;i<lvect;i++){
                  
                    monedas[i]=Integer.parseInt(elementos[i]);
                
                }              
    
            }      
               catch (NoSuchElementException e){
                 
                // Mostramos este mensaje 
                 System.out.println("archivo vacio o no encontrado");
            }
            catch (IOException e) {
               System.out.println("archivo vacio o no encontrado");
                e.printStackTrace();
               
            }      
             return monedas;
    }
         public  int LeerCambio(){
                
              String fileName = doc+".txt";//sacamos el nombre del archivo con su extension
             
    
           // Leemos el fichero y sacamos sus datos
            try {
               
                Scanner sc = new Scanner(new File(fileName));
                 
                 
                
                sc.nextLine();
                String line = sc.nextLine();//1linea
                c=sc.nextInt();//cambio
             
               
            }      
               catch (NoSuchElementException e){
                 
                // Mostramos este mensaje 
                 System.out.println("archivo vacio o no encontrado");
            }
            catch (IOException e) {
               System.out.println("archivo vacio o no encontrado");
                e.printStackTrace();
               
            }      
             return c;
    }
    public String getSalida(){
    
        return docSalida;
    
    }
}
