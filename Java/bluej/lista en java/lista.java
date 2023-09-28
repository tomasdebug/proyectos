
/**
 * Write a description of class lista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lista
{

    private Nodo cabeza = null;
    
    private int longitud =0;
   private class Nodo
   {
       public libro libro;
   
       public Nodo siguiente;
   
       public Nodo(libro libro)// declaro que va a tener cada nodo
       {
           this.libro=libro;
    
        }

   
    }
    public void InsertarPrincipio(libro libro)
    {
        Nodo nodo= new Nodo(libro);//creo un nuevo nodo que contiene al libro dado en el parametro
        nodo.siguiente=cabeza;//hago que su siguiente apunte al primer elemento(a la actual cabeza)
        cabeza=nodo;//Actualizo el puntero cabeza al nuevo elemento,que va a a ser la cabeza
        longitud++;// aumento la longitud(se aumenta cada vez que se añade un elemento)
    }
    
    public void insertarFinal(libro libro)
    {
        Nodo nodo = new Nodo(libro);//instanciamos un nuevo nodo al final
        if (cabeza==null){//si la lista está vacia(el primer elemento apunta a nada)
             cabeza = nodo;//entonces el elemento que acabamos de declarar será el primer elemento o el elemento cabeza
        }   
        else{
            Nodo puntero = cabeza;// hago un puntero que apunte a la cabeza(es decir que en vez de apuntar al siguiente elemento apunta al anterior)
            //es mi puntero anterior basicamente
            while(puntero.siguiente != null)//avanzará hasta que tenga un puntero que apunte a nada
            {
                puntero = puntero.siguiente;//cojo el puntero declarado anteriormente y hago que apunte al siguiente
            }
            puntero.siguiente = nodo;//hacemos que el ultimo elemento de la lista apunte al nodo recien creado,ya estoy al final de la lista 
            //y de ahí conecto el penultimo con el último
        }
        
        longitud++;//aumento la longitud para ver los elementos de la lista
    
    }
    
    public void insertarDespues(int n,libro libro)//le doy una posicion y un libro de la clase libro
    {
        Nodo nodo= new Nodo(libro);
        if (cabeza==null){//si la cabeza(el primer nodo)apunta a la nada ,es decir la lista está vacía
             cabeza = nodo;//declaro como cabeza el nodo que acabo de declarar
        }   
        else{
            // si la lista no está vacia entonces:
         int contador=0;//indica que numero de libro es el que está apuntado en puntero
         Nodo puntero = cabeza;// el puntero avanzara en el bucle desde el principio hasta el while
                while(contador < n && puntero.siguiente != null)// si no me he pasado del numero en el que le quiero poner y tampoco he llegado al final entonces:
                { 
                    //recorro la lista
                    puntero = puntero.siguiente;
                    contador++;
                }
         nodo.siguiente = puntero.siguiente;//puntero siguiente era mi puntero anterior,por ello hago que mi puntero apunte al elemento que sigue a anterior
         puntero.siguiente = nodo;//actualizo el puntero para que apunte a mi nuevo nodo
        }
        longitud++;
        
    }
    public libro obtener(int n)
    {
        if (cabeza==null)
        {
         return null;
        }else {
            int contador=0;//indica que numero de libro es el que está apuntado en puntero
            Nodo puntero = cabeza;// el puntero avanzara en el bucle desde el principio hasta el while
                while(contador < n && puntero.siguiente != null)
                {
                    puntero = puntero.siguiente;
                    contador++;
                }
                if(contador !=n)
                {
                  return null;  
                }else {
                
                    return puntero.libro;
                }
                
        
        }
       
    }
    public int contar()
    {
        return longitud;
    }
    public boolean estaVacia()
    {
        return cabeza == null;
    }
    public void eliminarPrincipio()
    {
        if(cabeza!= null)//si la lista no está vacia
        {
            Nodo primer = cabeza;//el primer elemento de mi lista será la cabeza
            cabeza= cabeza.siguiente;//declaro cabeza al siguiente de la cabeza de mi lista
            primer.siguiente=null;////hago que el nodo que he quitado en su siguiente apunte a null
            longitud--;
        }
    }
    public void eliminarUltimo()
    {
        
            if (cabeza!=null)// si la lista tiene elementos
            {
                if (cabeza.siguiente == null)// si solo tengo un elemento en la lista hago le quito la conexión que tiene 
                {
                    cabeza = null;
                }
            else
            {
                 Nodo puntero = cabeza;// declaro como puntero a mi cabeza
                 while(puntero.siguiente.siguiente !=null)// recorro la lista mirando si el siguiente del siguiente es nulo (para encontrar el penultimo elemento)
                 {
                     puntero=puntero.siguiente;
                
                 }
                 puntero.siguiente = null;//eliminamos su referencia con el ultimo haciendo que el siguiente del puntero sea null
                 longitud--;
            
                }
            }
        
        
    }
    public void eliminarLibro(int n)
    {
        if (cabeza!= null)// si la lista no está vacía
        {
            if (n == 0)// si quieren eliminar el primer elemento lo eliminamos como en el siguiente
            {
                Nodo primer = cabeza;
                cabeza= cabeza.siguiente;
                primer.siguiente=null;
                longitud--;
            }else if (n<longitud)
            {
            Nodo puntero = cabeza;
            int contador = 0;
            while(contador <(n-1))// recorremos la lista hasta estar en la anterior del elemento que queremos borrar
            {
                puntero = puntero.siguiente;
                contador++;
            }
            Nodo temp = puntero.siguiente;// creo un nodo temporal que apunte al siguiente
            puntero.siguiente =temp.siguiente;//el anterior va a apuntar al siguiente
            temp.siguiente = null;//elimino la referencia del siguiente por si acaso
            longitud--;
            }
        }
    }
    
}
