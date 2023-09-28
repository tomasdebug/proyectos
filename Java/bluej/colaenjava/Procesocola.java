
/**
 * Write a description of class Procesocola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Procesocola implements cola
{
    /*
     * la forma más fácil de hacer una cola es por medio de nodos que apuntan a otros nodos
     */
    private class NodoProceso//creo una clase privada para poder indicar que esto es un nodo dentro de la cola
    {
        public Libro libro;//creo un puntero a mi libro
        
        public NodoProceso siguiente;//creo un puntero a mi siguiente
        
        public NodoProceso(Libro libro)//para crear el nodo 
        {
            this.libro = libro;
            this.siguiente = null;
        }
    }
    
    private NodoProceso cabeza,ultimo;//creo los dos punteros mas importantes el primero y el ultimo´
    
    
    
    @Override
    public void encolar(Libro l)
    {
        NodoProceso nuevoNodo = new NodoProceso(l);
        
       if (cabeza == null)//si mi cabeza no apunta a nada entonces la cola está vacia 
       {
           
        cabeza = nuevoNodo;
        
        }else//si la cola no está vacia
        {
            
        ultimo.siguiente = nuevoNodo;//el nuevo nodo que he creado se agrega despues del ultimo
        
        }
        
         ultimo = nuevoNodo;//actualizo el ultimo para que apunte a mi nuevo nodo
    }
    @Override
    public void eliminar()
    {
        if(cabeza != null)//si la lista no está vacia
        {
            
            NodoProceso eliminar = cabeza;//hago una referencia al nodo que voy a eliminar
            
            cabeza=cabeza.siguiente;//actualizo el puntero para que apunte a su siguiente
            
            eliminar.siguiente=null;//hago que el siguiente del nodo que voy a eliminar apunte a null
            
        }
        if(cabeza ==null)//si la lista está vacia
        {
            ultimo=null;//hago que su ultimo tambien apunte a null
        }
        
    
    }
    @Override
    public Libro obtenerLibro()
    {
        if(cabeza == null)//si la cola está vacia
        {
           return null; 
        }else//si no lo está
        {
         return cabeza.libro;
        }
    }
}
