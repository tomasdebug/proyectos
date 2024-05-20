
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
/**
 * Write a description of class robotJava here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


class TCasilla{
             int x;
            
             int y;
        
        public TCasilla(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
public class robotJava
{
    // instance variables - replace the example below with your own
    /*private  char TEdificio[][]={{'L','E','L'},
                                {'L','L','L'},
                                {'L','T','E'}};
                                */
    private char[][] TEdificio;
    private int LARGO;// = TEdificio.length; //Determina el número de las filas
    private int ANCHO;// = TEdificio[0].length; //determina el número de las columnas
     Log log;//declaro la clase auxiliar log(se encargará de administrar entradas y salidas)

    /*={{false,false,false},
                                    {false,false,false},
                                    {false,false,false}};//comprobante de las casillas que puedo selecciona(si estan o no exploradas)
    */
     private int cont;
     private  static Scanner lectura = new Scanner(System.in);

    
     
     TCasilla casilla_inic;
     
     public static void main(String args[]){
        int opcion;
        boolean traza;
        boolean help;
        String Entrada;
        String Salida;
        robotJava rj=new robotJava();
        do {
             rj.cont=0;//contador que se iniciará a 0 cada vez que ejecute este metodo ,sirve para ver la casilla inicial
            // Mostrar el menú
            System.out.println("------ Menú ------");
            System.out.println("1. Iniciar Robot");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Leer la opción del usuario
            //el while sirve para manejar excepciones 
            while (true) {
                try {
                    System.out.print("Seleccione una opción: ");
                    opcion = Integer.parseInt(lectura.nextLine());
                    break; // Si no hay excepción, salimos del bucle
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                }
            }
            // Realizar acciones según la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado la Opción 1.(Iniciar Robot)");
                    
                    // Preguntas de Sí/No
                    System.out.println("Quiere una traza del algoritmo(Y/N)");
                    String respuesta1;
                     do {
                        
                          respuesta1 = lectura.nextLine();
                        if (!(respuesta1.equalsIgnoreCase("y") ||respuesta1.equalsIgnoreCase("n"))) {
                            System.out.println("Por favor, ingrese 'Y' o 'N'.");
                        }
                        
                    } while (!(respuesta1.equalsIgnoreCase("y") ||respuesta1.equalsIgnoreCase("n")));

                        if (respuesta1.equalsIgnoreCase("Y")||respuesta1.equalsIgnoreCase("y")) {
                           traza=true;
                        } else {
                            traza=false;
                        }
                  
                    System.out.println("Quiere que se muestre la ayuda(Y/N)");
                    String respuesta2;
                    do {
                        respuesta2 = lectura.nextLine();
                        if (!(respuesta2.equalsIgnoreCase("y") || respuesta2.equalsIgnoreCase("n"))) {
                            System.out.println("Por favor, ingrese 'Y' o 'N'.");
                        }
                    } while (!(respuesta2.equalsIgnoreCase("y") || respuesta2.equalsIgnoreCase("n")));

                    
                    if (respuesta2.equalsIgnoreCase("Y")||respuesta2.equalsIgnoreCase("y")) {
                        help=true;
                    } else {
                        help=false;
                    }
                    
                    System.out.println("Ingrese el documento de entrada(si no lo tiene solo continue dandole al enter)");
                    Entrada = lectura.nextLine().trim();
                    System.out.println("entrada "+ Entrada + " " +"registrada");

                    System.out.println("Ingrese el documento de salida(si no lo tiene solo continue dandole al enter) ");
                    Salida = lectura.nextLine().trim();
                    System.out.println("Iniciando programa con la configuración pedida");
                         try {
                    rj.java_robot(traza, help, Entrada, Salida);
                } catch (IOException e) {
                    // Manejar la excepción de IOException 
                    System.out.println("(no se puede escribir, ya que el archivo no ha sido encontrado)");
                    e.printStackTrace(); // Da la traza de error para ver dónde me he equivocado
                    return;
                } catch (Exception e) {
                    // Manejar la excepción general
                    System.out.println("Ocurrió una excepción no manejada en el método java_robot");
                    e.printStackTrace();
                    return;
                }
                    break;
        
                    
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
            

        } while (opcion != 0);

        // Cerrar el scanner al salir del bucle
        lectura.close();
       
    
    
    }
      
        public boolean  BuscaTornillo(char TEdificio[][],TCasilla casilla,boolean TEdificioB[][],ArrayList<TCasilla> solucion, boolean exito){
            
            
                if(cont==0){
            
                casilla_inic =casilla;//vemos cual es la casilla inicial
              
            }
            TEdificioB[casilla.x][casilla.y]=true;//la casilla esta explorada
            if(TEdificio[casilla.x][casilla.y]=='T'){//si encuentra el tornillo 
            
                // solucion= new ArrayList();//En el momento que encuentra el tornillo creo un arraylist solucion[me ha sido imposible hacerlo de esta manera puesto que este arraylist no se propagava como el resto]
                 //solucion.add(casilla);//en el que añado la casilla solucion y desde aquí empezaré a rellenar la solucion desde aquí
                 exito=true;//
                // exito=true;
             
            }else{//sino es una casilla solucion empiezo a buscar en sus hijos(izquierda,derecha,arriba,abajo)
             ArrayList<TCasilla> hijos = new ArrayList<TCasilla>();
             hijos=camino(TEdificio, casilla);
            // exito=false;
             exito=false;
             
            while(exito==false && hijos.isEmpty()!=true){
                    
                    TCasilla hijo = hijos.get(0);
                    hijos.remove(0);
                    
                    if(TEdificioB[hijo.x][hijo.y]==false){//si no la he explorado ahora la exploro
                        //solucion.add(hijo);
                        cont++;//solo me interesa la casilla inicial ,por ello cambio la i
                        exito=BuscaTornillo(TEdificio,hijo,TEdificioB, solucion, exito);
                        //solucion.remove(hijo);
                    }
                 
                       
                     }
                  } 
            
            if(exito==true){
            
                solucion.add(casilla);
                if(solucion.contains(casilla_inic)){//si en mi solucion está la casilla inicial ,que es a la que tengo que volver ,significa que ya he terminado el recorrido
                 
                 
                         if(log.getSalida()==""){
               
                  imprimir(solucion);//Sino hay fichero se imprime directamente en la consola
                }else{
                  //for each donde se imprime 1 por 1 cada solucion
                
                      System.out.println("El camino se ha escrito en "+log.getSalida()+".txt");
                  
                  
                  for(int i=0;i<solucion.size();i++){
                    
                    log.escritura(solucion.get(i),true,true);
                
                    }
                    return true;
                }
                }
                return true;
                
            }
 
         return false;
       
    }
    public void help(){
    
        System.out.println("Los argumentos son los siguientes:");
        System.out.println("-t: traza cada paso de manera que se describa la aplicación del algoritmo utilizado. ");
        System.out.println("-h: muestra una ayuda y la sintaxis del comando. " );
        System.out.println("fichero_entrada: es el nombre del fichero del que se leen los datos de entrada." );
        System.out.println("fichero_salida: es el nombre del fichero que se creará para almacenar la salida.");
        
    
    }
     public void traza(boolean TEdificioB[][]){
            System.out.println("La traza está activada se representará el edificio con el camino seguido por el robot");//pintamos una parez
            System.out.println("El camino visualmente se verÍa de esta forma(#=pared o terreno no explorado, x= camino recorrido por el robot)");//pintamos una parez
        for (int i = 0; i < LARGO; i++) {
                    for (int j = 0; j < ANCHO; j++) {
                      if(TEdificioB[i][j]==false)
                      {
                        System.out.print("# ");//pintamos una parez
                        }
                        else{
                        System.out.print("x ");//pintamos una parez
                        }
                    }
                    System.out.println("");//pintamos la siguiente fila
                }
    
    }
    public void imprimir(ArrayList<TCasilla> solucion){
        System.out.println("El camino es:");
        for(TCasilla c:solucion){
           
            System.out.println("("+((c.x)+1)+","+((c.y)+1)+")");
        
        }
    
    
    }
   
           public  ArrayList<TCasilla> camino(char TEdificio[][],TCasilla casilla){
        ArrayList<TCasilla> hijos =new ArrayList<TCasilla>();
        TCasilla casilla_aux;
              if(casilla.x+1<LARGO){
               if(TEdificio[casilla.x+1][casilla.y]!='E'){//saco los hijos posibles
             hijos.add(new TCasilla(casilla.x+1,casilla.y));//si el el camino a la arriba no es una pared ,lo agrego como posible hijo solucion
            
            }
        }
        if(casilla.x-1>=0){
              if(TEdificio[casilla.x-1][casilla.y]!='E'){//saco los hijos posibles
             hijos.add(new TCasilla(casilla.x-1,casilla.y));//si el camino hacia arriba no es una pared ,lo agrego como posible hijo solucion
            
            }
            
            }
            if(casilla.y+1<ANCHO){
               if(TEdificio[casilla.x][casilla.y+1]!='E' ){//saco los hijos posibles//poner que no se pase del largo y ancho
             hijos.add(new TCasilla(casilla.x,casilla.y+1));//si el camino a la derecha no es una pared ,lo agrego como posible hijo solucion
            
            }
        }
        if(casilla.y-1>=0){
             if(TEdificio[casilla.x][casilla.y-1]!='E'){//saco los hijos posibles
             hijos.add(new TCasilla(casilla.x,casilla.y-1));//si el el camino a la izquierda no es una pared ,lo agrego como posible hijo solucion
            
            }
            }
           
            return hijos;
            
    }
       public char [][]  ObtenerEdificio() {
           
        System.out.println("Escribe el largo del edificio:");
        LARGO = lectura.nextInt(); // Determina el número de las filas
        System.out.println("Escribe el ancho del edificio:");
        ANCHO = lectura.nextInt(); // determina el número de las columnas
        
        char[][] TEdificio = new char[LARGO][ANCHO];
       
         
        lectura.nextLine(); // Limpiar el buffer después de leer enter
    
        for (int i = 0; i < LARGO; i++) {
            int j = 0;
            System.out.println("Describe la fila " + (i+1) + " con (L,E o T)separados con (-):");
            String input = lectura.nextLine();
            String[] elementos = input.split("-"); // Separar la entrada por "-"
            
          for (String e : elementos) {
            if (e.length() == 1 && (e.charAt(0) == 'L' || e.charAt(0) == 'E' || e.charAt(0) == 'T')) {
                TEdificio[i][j] = e.charAt(0); // Asignar el carácter si es válido
                j++;
            } else {
                System.out.println("Entrada inválida. Introduce de nuevo.");
                i--; // Volver a pedir la misma fila
                break;
            }
        }
        }
         return TEdificio;
         
    }
        public char[][] ObtenerEdificioConEntrada() throws Exception {
           
           char[][] resultado; 
           resultado=log.ObtenerEdificioConEntrada();
            
            return resultado;
    }
     
    
   public  void java_robot (boolean traza,boolean help,String fEntrada,String fSalida) throws Exception {
      
       LARGO=0;
       ANCHO=0;
       ArrayList<TCasilla> TListaCasillas = new ArrayList<>();//este es el arraylist donde se van a guardar la lista de casillas solucion(creo)
     
      TCasilla casilla=new TCasilla(0,0);//salida
       log=new Log(fEntrada,fSalida);
      if(fEntrada==""){
        TEdificio=ObtenerEdificio();
        }else{
        TEdificio=ObtenerEdificioConEntrada();
        LARGO=log.getLARGO();
        ANCHO=log.getANCHO();
        }
        
     boolean[][] TEdificioB = new boolean[LARGO][ANCHO];
     for (int i = 0; i < LARGO; i++) {
            for (int j = 0; j < ANCHO; j++) {
              TEdificioB[i][j]=false;
            }
        }
     if(help){
        
         help();
        }
      boolean tornillo=BuscaTornillo( TEdificio,casilla,TEdificioB,TListaCasillas, false);
      if(traza){
        
        traza(TEdificioB);
        }
      if(tornillo==false){
        System.out.println("El tornillo no está en el edificio");
        
        
        }
        
    
    }

        }
    
  
