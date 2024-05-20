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
    
    private String doc;
    
    private String docSalida;
    
    private int LARGO;
    
    private int ANCHO;
    
  
    /**
     * Constructor for objects of class Log
     */
    public Log(String doc,String docSalida)
    {
        // initialise instance variables
        this.doc=doc;
        this.docSalida=docSalida;
    }

    public void escritura(TCasilla casilla,boolean mantenertxt,boolean cambiodelinea ){
            //escribir archivos
            String fileName = docSalida+".txt";
              try{
                
                  Scanner sc = new Scanner(new File(fileName));
                
                FileWriter archivo=new FileWriter(fileName,mantenertxt);//el bolean mantenertxt sobreescribira cuando sea falso ,sino lo es se concadenará
                BufferedWriter flujo=new BufferedWriter(archivo);
                //
                String conjunto="("+String.valueOf(casilla.x+1)+","+String.valueOf(casilla.y+1)+")";
                PrintWriter escribir=new PrintWriter(flujo);
                if(cambiodelinea==false){
                    escribir.print(conjunto);
                }else{
                   escribir.println(conjunto);
                }
                escribir.flush();
                }   catch (NoSuchElementException e){
                 
                // Mostramos este mensaje 
                 System.out.println("archivo vacio o no encontrado");
                 System.exit(1);//acabo el programa
            }
            catch (IOException e) {
                
               System.out.print("(no se puede escribir,ya que el archivo no ha sido encontrado)");
               e.printStackTrace();
               System.exit(1);//acabo el programa
               
            }  
              
        }
        
         public char[][] ObtenerEdificioConEntrada() throws Exception {
           
                      
              String fileName = doc+".txt";
              char[][] resultado = new char[0][0]; // matriz para sacar el resultado
    
           // Leemos el fichero y sacamos sus datos
                try {
                   
                    Scanner sc = new Scanner(new File(fileName));
                     
                     LARGO  = sc.nextInt(); 
                     ANCHO = sc.nextInt();
                     sc.nextLine(); // Consumir el salto de línea después de los números
                     char[][] TEdificio = new char[LARGO][ANCHO];
                    
                    
                   for (int i = 0; i < LARGO; i++) {
                        int j = 0;
                        String line = sc.nextLine();//1linea
                        String elementos[] = line.split(" ");//L L L ...
                      
                        for (String e : elementos) {
                            if (e.length() == 1 && (e.charAt(0) == 'L' || e.charAt(0) == 'E' || e.charAt(0) == 'T')) {
                                TEdificio[i][j] = e.charAt(0); // Asignar el carácter si es válido
                                j++;
                            } else {
                                System.out.println("Entrada invalida");
                                throw new Exception("Entrada inválida");
                            }
                        }
                    }
                   resultado= TEdificio;     
              
                
            }
               catch (NoSuchElementException e){
                 
                // Mostramos este mensaje 
                 System.out.println("archivo vacio o no encontrado");
                 System.exit(1);//salgo del programa si me quedan cosas
            }
            catch (IOException e) {
               System.out.println("archivo vacio o no encontrado");
                e.printStackTrace();
                System.exit(1);//salgo del programa si me quedan cosas
               
            }
            return resultado;
    }
    public String getSalida(){
    
        return docSalida;
    
    }
    public int getLARGO(){
    
        return LARGO;
    
    }
    public int getANCHO(){
    
        return ANCHO;
        
    }
}

