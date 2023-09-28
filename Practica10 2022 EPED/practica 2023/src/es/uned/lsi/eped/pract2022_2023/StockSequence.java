package es.uned.lsi.eped.pract2022_2023;

import es.uned.lsi.eped.DataStructures.*;
import java.util.ArrayList;
import java.lang.String;



public class StockSequence implements StockIF {

    protected SequenceIF<StockPair> stock;
    ListIF<StockPair> StockList;
     public StockSequence() {
        
         StockList = new List<StockPair>();
         StockList.insert(1,new StockPair("tom",32));
         StockList.insert(2,new StockPair("paco",10));
         StockList.insert(3,new StockPair("sexo",2));
        
       
    }
    
    @Override 
     public int retrieveStock(String p){
        //me creo una lista auxiliar que dar� en el momento que encuentre algo
        System.out.println(StockList.size());
        //esto funciona
        for (int i = 1; i < StockList.size(); i++) {//recorre la lista
             String nombre= StockList.get(i).getProducto();
             System.out.println(nombre);
            
           //si se encuentra el producto entonces

                if (p.equalsIgnoreCase(nombre)){//pillo la posicion
                    int numero = StockList.get(i).getUnidades();//pillo las unidades de ese stock en concreto y retorno el numero
   
                    return numero;
                  
                   }
            
          
                
               
            }
        
        return -1;
        }
        
    
     @Override
     public void updateStock(String p, int u)
     {  
       //buscar  el elemento al que pertenece p
            
       for (int i = 0; i < StockList.size(); i++) {
        String nombre= StockList.get(i).getProducto();
       
       
           if (p.equalsIgnoreCase(nombre)){//pillo la posicion
               StockList.set(i,new StockPair(nombre,u));
              
               }

        
        }
    }
     
    @Override
     public SequenceIF<StockPair> listStock(String prefix)
     {     // Recorre la lista y muestra los elementos que empiezan por la cadena buscada
        /*for (StockPair e : StockList) {
            int n=1;
            if (e.toLowerCase().startsWith(prefix.toLowerCase())){
                
                System.out.println(StockList.get(n).toString());
                n++;
                */
    /*
                 for (int i = 1; i < StockList.size(); i++)  {
                    int n=1;
                    if (e.getProducto().toLowerCase().startsWith(prefix.toLowerCase())){
                        
                        System.out.println(StockList.get(n).toString());
                        n++;
                    }
            }
          */
        
            IteratorIF<StockPair> miIterador = StockList.iterator();
            while (miIterador.hasNext()) {
          
                StockPair Stock_actual= miIterador.getNext();
                String nombre= Stock_actual.getProducto().toLowerCase();
                
                if (nombre.startsWith(prefix)){
                    //.toLowerCase()
                   
                   
                    System.out.println(Stock_actual.toString());
                   return new Sequence<StockPair>();
                }
                  /*String tnombre = StockList.get(i).getProducto();//guardo el nombre del primer elemento de la lista en una variable temporal antes de cambiarlo por el segundo 
                  int tunidades = StockList.get(i).getUnidades();
                  */
            }
        
           
        }
          
  
   
     public void insertStock(String p, int u){

         System.out.println(StockList.size());
         StockList.insert(1,new StockPair(p,u));//no funciona?
         System.out.println(StockList.size());

            // Ordena la lista alfabéticamente utilizando el algoritmo de burbuja mejorado(funciona)
        boolean intercambio = true;
        int n = StockList.size();
        while (intercambio) {
            intercambio = false;
            
            for (int i = 1; i < StockList.size(); i++) {
                if (StockList.get(i).getProducto().compareToIgnoreCase(StockList.get(i + 1).getProducto()) > 0) {// vamos a realizar un cambio de posiciones en la lista
                    String tnombre = StockList.get(i).getProducto();//guardo el nombre del primer elemento de la lista en una variable temporal antes de cambiarlo por el segundo 
                    int tunidades = StockList.get(i).getUnidades();
                    StockList.set(i, StockList.get(i + 1));//he sobreescrito el primer elemento de la lista
                    StockList.set(i + 1, new StockPair(tnombre,tunidades));
                    intercambio = true;
                }
                n--;//el elemento más grande ya está en su posición correcta, por lo que no es necesario compararlo en las siguientes iteraciones.(para optimizarlo más)
            }
        }
     //ordenar el stock
       /*   for (int i = 1; i < StockList.size()-1; i++) {
            int indiceMinimo = i;//para cada elemento del stocklist se compara con su siguiente
            for (int j = i + 1; j < StockList.size(); j++) {
                if (StockList.get(j).getProducto().compareToIgnoreCase(StockList.get(indiceMinimo).getProducto()) < 0) {//al compararlo con su siguiente veo cual va antes en la escala lexicogramatica, es decir cual tiene un indice menor en esa escala
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {//si una palabra va antes de la otra...
                //String producto = StockList.get(i).getProducto();//cojo el elemento de i
                //int unidades = StockList.get(i).getUnidades();//cojo el elemento de i
                StockList.set(i, StockList.get(indiceMinimo));//pone el elemento de j en la posicion de i
                //stocklist.set(indiceMinimo, producto,unidades);
                StockList.set(indiceMinimo, StockList.get(i));//meto el elemento i en la posicion de j
            }
        }
    */
        // Muestra la lista ordenada no funciona
         for (int i = 1; i < StockList.size()+1; i++) {
            System.out.println(StockList.get(i).toString());
      
        }
    }
}








       
   
    

