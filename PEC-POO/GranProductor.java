import java.util.*;

/**
 * Tipo de productor con hectáreas totales mayores al límite.
 */
public class GranProductor extends Productor
{
    /**
     * Constructor para objetos de la clase GranProductor
     * 
     * @param   n   nombre del productor
     */
    public GranProductor(String n) {
        super(n);
    }
    
    /**
     * Constructor para objetos de la clase GranProductor
     * 
     * @param   n   nombre del productor
     * @param   p   HashMap<String,Double> con una lista de nombres de productos y las hectáreas que posee
     */
    public GranProductor(String n, HashMap<Producto,Double> p) {
        super(n,p);
    }
}
