import java.util.*;

/**
 * Tipo de productores con hectáreas totales menores al límite.
 * Pueden tener máximo 5 tipos de productos.
 */
public class PeqProductor extends Productor
{
    /**
     * Constructor para objetos de la clase PeqProductor
     * 
     * @param   n   nombre del productor
     */
    public PeqProductor(String n) {
        super(n);
    }
    
    /**
     * Constructor para objetos de la clase PeqProductor
     * 
     * @param   n   nombre del productor
     * @param   p   HashMap<String,Double> con una lista de nombres de productos y las hectáreas que posee
     */
    public PeqProductor(String n, HashMap<Producto,Double> p) {
        super(n,p);
        if(p.size() > 5) {
            //Si el pequeño productor tiene más de 5 productos, entonces no cumple con la condición para ser pequeño productor
            listaProd = new HashMap<>();
            extensionTotal = 0;
            System.out.println("Un pequeño productor no puede tener más de 5 productos diferentes, no fue posible añadirlos. Por favor, añada los productos de nuevo.");
        }
    }
    
    /**
     * Añadir producto y extensión
     */
    @Override
    public void addProducto(Producto producto, double extension){
        if(listaProd.size() < 5) super.addProducto(producto, extension);
    }
}
