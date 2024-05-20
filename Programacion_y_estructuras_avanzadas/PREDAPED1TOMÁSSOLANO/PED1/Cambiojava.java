import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

/**
 * Programa para dar cambio en Java
 * 
 * @Tomás Solano Campos
 * @V1.1
 */
public class Cambiojava
{
   
  
  private static Scanner lectura = new Scanner(System.in);//escaner usado para leer datos por terminal
  
  private static int  lvect;//vector longitud para elegir el tamaño del vector monedas(indica cuantas monedas tienes)
  
  private static int monedas[];
  
  private static int c;//el dinero que quiero cambiar
  
  private static Cambiojava cam=new Cambiojava();//inicializo la clase
  
  Log log;//declaro la clase auxiliar log(se encargará de administrar entradas y salidas)
 
  public static void main(String args[]){
        int opcion;
        boolean traza;
        boolean help;
        String Entrada;
        String Salida;
        Cambiojava cj= new Cambiojava();
        do {
            // Mostrar el menú
            System.out.println("------ Menú ------");
            System.out.println("1. Dar Cambio");
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
                    System.out.println("Ha seleccionado la Opción 1.(Dar Cambio)");
                    
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
                    

                   cj.java_cambio_dinamica(traza,help,Entrada,Salida);
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
    
  public  void java_cambio_dinamica(boolean _t,boolean _h, String F_entrada, String F_salida){
          //si la función help está activada se pone el menú
           if(_h==true){
            cam.help();
            }
            //si tengo un archivo de entrada valido lo uso
             log=new Log(F_entrada,F_salida);
            if(F_entrada==""){
                darCambioSinFicherodeentrada(_t);
            
            }else{
                darCambioConFicheroDeEntrada(_t);
            
            }
           
           
         
    }
    
      //menú de help
    public void help(){
        System.out.println("Los argumentos son los siguientes:");
        System.out.println("-t: traza cada paso de manera que se describa la aplicación del algoritmo utilizado. ");
        System.out.println("-h: muestra una ayuda y la sintaxis del comando. " );
        System.out.println("fichero_entrada: es el nombre del fichero del que se leen los datos de entrada." );
        System.out.println("fichero_salida: es el nombre del fichero que se creará para almacenar la salida.");
        System.out.println("recordar que cualquier numero por encima de 21474836 simboliza infinito ,gracias");
        
    
    }
   

    //si no hay fichero de entrada
     public  int[][] darCambioSinFicherodeentrada(boolean _t){
            
         
       // Leemos el int y lo almacenamos en el vector 
             System.out.println("Escribe el tamaño del vector:");
             lvect=lectura.nextInt();//declaramos un tamaño que usaremos para el vector
             monedas=new int[lvect];
            
            
            System.out.println("Escribe el valor a devolver:");
             c=lectura.nextInt();//valor a devolver
            //recogemos el valor de cada moneda
            for(int i=0;i<lvect;i++){
          
            System.out.println("Escribe el valor de la moneda" + i +":");
            monedas[i]=lectura.nextInt();
        
        }      
           //variables auxiliares
            int i,j;
            int N=monedas.length;
            //seleccion se usará para printar las monedas más adelantes
            int seleccion[]=new int[N];
            //t será la tabla a retornar
            int[][] t =new int[N+1][c+1];//creamos la tabla
        
           for(i =0;i<=N;i++){//meto una columna de 0s al vector
               t[i][0]=0;
            }
           for(j =1;j<=c;j++){//repito el proceso hasta quedarme sin cambio
              for(i=1;i<=N;i++){//itero hasta quedarme cada moneda
                if(i==1 && monedas[i-1]>j){
                
                    t[i][j]=21474836;//represento ese numero como infinito
     
                }else if(i==1 && t[i][j]!=21474836){//si con ambas monedas tengo los mismos resultados...
                    t[i][j]=1+t[1][j-monedas[i-1]];//cambio 
                }else if(j<monedas[i-1]&& t[i][j]!=21474836){//si lo que me queda de cambio es menor que mi moneda actual le bajo la moneda y sigo intentandolo
                    t[i][j]=t[i-1][j];
                
                }else {//
                    t[i][j] = Math.min(t[i - 1][j], t[i][j - monedas[i - 1]] + 1);
                
                }
                
                }
            }
            if(_t==true){
           for (int x=0; x < t.length; x++) {
              System.out.print("|");
              for (int y=0; y < t[x].length; y++) {
                System.out.print (t[x][y]);
                if (y!=t[x].length-1) System.out.print("\t");
              }
              System.out.println("|");
            }
        }
            seleccionar_monedas(c,monedas,t,seleccion);
            return t;
             
 }
 //Dar cambio con fichero de entrada
  public  int[][] darCambioConFicheroDeEntrada(boolean _t){
            
      
          monedas=log.LeerVectorMonedas();
          c=log.LeerCambio();
      
          int[][] resultado = new int[0][0]; // matriz para sacar t 

       // Leemos el fichero y sacamos sus datos
      
          

            int i,j;
            int N=monedas.length;
            int seleccion[]=new int[N];
            int[][] t =new int[N+1][c+1];//creamos la tabla
        
           for(i =0;i<=N;i++){//meto una columna de 0s al vector
               t[i][0]=0;
            }
           for(j =1;j<=c;j++){//meto una columna de 0s al vector
              for(i=1;i<=N;i++){
                if(i==1 && monedas[i-1]>j){
                
                    t[i][j]=21474836;//represento ese numero como infinito
     
                }else if(i==1 && t[i][j]!=21474836){//si con ambas monedas tengo los mismos resultados...
                    t[i][j]=1+t[1][j-monedas[i-1]];//cambio 
                }else if(j<monedas[i-1]&& t[i][j]!=21474836){//si lo que me queda de cambio es menor que mi moneda actual le bajo la moneda y sigo intentandolo
                    t[i][j]=t[i-1][j];
                
                }else {//
                    t[i][j] = Math.min(t[i - 1][j], t[i][j - monedas[i - 1]] + 1);
                
                }
                
                }
            }
            if(_t==true){
           for (int x=0; x < t.length; x++) {
               System.out.print("|");
              for (int y=0; y < t[x].length; y++) {
                System.out.print (t[x][y]);
                if (y!=t[x].length-1) System.out.print("\t");
              }
              System.out.println("|");
            }
        }
         seleccionar_monedas(c,monedas,t,seleccion);
         resultado=t;
             
          
            
        
         return resultado;
      
 }
 
 
 
 public  void seleccionar_monedas(int cambio,int monedas[],int t[][],int seleccion[]){
     int i,j;
     //int z=0;
     int N=monedas.length;
     boolean cambiodelinea;//se usará en escritura para realizar un cambio de linea cada vez que cambiemos de moneda
     boolean borrar_contenido_anterior;//se usa en escritura para borrar el contenido anterior de un archivo
     
     for(i = 0 ; i <= N ;i++){
         t[i][0]=0;
        }
        
    //declaramos variables auxiliares
     i=N;
     j=cambio;
     while(j > 0){//mientras el cambio siga siendo mayor que 0 ,agregamos monedas a la cantidad a devolver y se lo restamos al cambio
        if(i >1 && (t[i][j]==t[i-1][j])){
            i=i-1;
            }else {
        
            seleccion[i-1]=seleccion[i-1]+1;
            j=j-monedas[i-1];
           
        }
        
        }
     if(j<0){//si despues de haber realizado el cambio ,tengo algún numero negativo...
             System.out.println("sin solución:" );
             return;
             
        }
        //printo las monedas
      for(i = 0 ; i < N ;i++){
        System.out.println("Las monedas seleccionadas son:" );
        System.out.println("de " +monedas[i] + " tenemos: "+ seleccion[i] );
        
     }
 
   
      for(i = 0 ; i < N ;i++){
        for(int x =0;x<seleccion[i];x++){
        //printo y escribo las monedas con un espacio de diferencia 6 6 6 ...
        
         int mon_act=monedas[i];
          if(log.getSalida()==""){
             if(x==0&&i==0){System.out.println("es decir:" );}//si estoy en la primera iteración
            System.out.print( mon_act +" "  );
        }else{
         String num_enString= Integer. toString(monedas[i]);
         /*
          * Decidí comentar está parte ,es la indicada de borrar el contenido anterior,y dejé por defecto que se quede
          * el contenido anterior para comparar iteraciones
         if(z==0){//si acabo de empezar borramos el contenido anterior
            
            mantener_contenido_anterior=true;
            z++;
            }
            else{
            mantener_contenido_anterior=false;
            z++;
            }
            */
            if(log.getSalida()!=""){//hago que solo escriba si tengo un fichero con nombre
            if(x==0&&i==0){System.out.println("se escribirá en: "+ log.getSalida()+".txt");}//si estoy en la primera iteración
         if(x+1==seleccion[i]){
         cambiodelinea=true;
         log.escritura(num_enString + " ",true,cambiodelinea);
        }else{
         cambiodelinea=false;
         log.escritura(num_enString + " ",true,cambiodelinea);
        }
        }
        }
        }
         System.out.println(" "  );
     }
    
    
}
     
}

