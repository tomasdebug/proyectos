
/**
 * Write a description of class MiPila here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiPila implements Pila
{
    //creamos mi nodo
    private class Nodo{
        public URL url;//va a tener una url y su siguiente va a empezar inicializado a null ,es decir 
        //que se tiene en cuenta si está vacía
        
        public Nodo siguiente = null;
    
    public Nodo(URL url)
    {
        this.url=url;
    }
    }
     private Nodo cima=null;
     
     private int longitud;
     
    @Override
    
    public void apilar(URL url)
    {
        Nodo nodo = new Nodo(url);//creo un nuevo nodo y le introduzco la url
        nodo.siguiente=cima;//hago que su siguiente se convierta en la cima
        cima=nodo;//gracias al puntero tengo el nodo en lo más alto
        longitud++;
    }
    @Override
    public void desapilar()
    {
        if(cima!=null)
        {
            Nodo eliminar = cima;
            cima=cima.siguiente;
            eliminar.siguiente = null;
            longitud--;
        
        }
    
    }
    @Override
    public URL obtener()
    {
        if(cima == null)
        {
            return null;
        
        }
        else 
        {
            return cima.url;
        
        }
    }
    @Override
    public int longitud()
    
    {
            return longitud;
    }
    @Override
    public boolean vacia()
    
    {
        return longitud==0;

    }
    
}
