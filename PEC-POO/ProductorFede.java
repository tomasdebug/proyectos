import java.util.*;

/**
 * Federación de pequeños productores que unen las hectareas de un mismo producto.
 * El total de hectáreas no puede sobrepasar el límite
 */
public class ProductorFede extends Productor
{
    private Producto producto; //Producto del que se encarga el productor federado (solo un productor federado por grupo)
    private ArrayList<PeqProductor> productores; //Lista de productores involucrados
    private double extensionConjunto; //extensión total entre todos los productoresInvolucrados

    /**
     * Constructor para objetos de la clase ProductorFede
     * Productor vacío (sin productores involucrados añadidos)
     * 
     * @param   n   nombre del productor
     * @param   p   producto que comparten
     */
    public ProductorFede(String n, Producto p) {
        super(n);
        producto = p;
        productores = new ArrayList<>();
    }

    /**
     * Constructor para objetos de la clase ProductorFede
     * Productor con productores involucrados añadidos
     * 
     * @param   n   nombre del productor
     * @param   p   producto que comparten
     * @param   pI  Lista de pequeños productores que lo forman
     */
    public ProductorFede(String n, Producto p, ArrayList<PeqProductor> pI) {
        //Se le pasa un ArrayList ya inicializado de tal forma que los productoresInvolucrados lo copien
        //Ese array que se le va a pasar, puede crearse en el AlmacenProductores
        super(n);
        producto = p;
        productores = pI;
        for(PeqProductor prod: pI) {
            //se recorre el arraylist de productores involucrados y se suma las extensiones para un mismo producto de todos ellos
            extensionConjunto += prod.getExtension(producto);
        }
        if(extensionConjunto > super.getLimiteExtension()) {
            //si la extension es mayor que el limite, entonces dar error y establecer la extension total a 0
            productores = new ArrayList<>();
            extensionConjunto = 0;
            System.out.println("Las hectáreas conjuntas de los productores añadidos sobrepasan el límite, no fue posible añadirlos. Por favor, añada los productores de nuevo.");
        }
    }

    /**
     Añade un productor pequeño a la lista de productores que en conjunto son productor federado
     * 
     * @precon El productor a añadir debe tener el producto de la federacion 
     * @precon La suma de la extensión (de un producto) de los productores pequeños no debe superar el limite de extension
     * @postcon No puede haber solo un productor involucrado en ser productor federado
     */
    public void addProductor(PeqProductor prod) {
        if(prod.getListaProd().containsKey(producto) && extensionConjunto + prod.getExtension(producto) <= super.getLimiteExtension()) {
            //Primero comprobamos si el productor tiene el producto de la federacion 
            //Luego comprobamos si la extension del producto que se va a añadir + extensionConjunto no supera el limite
            productores.add(prod);
            extensionConjunto += prod.getExtension(producto);
        }
    }

    public void removeProductor(Productor prod) {
        //Si se encuentra y elimina el productor, entonces se resta esa extension del producto del productor federado
        if(productores.remove(prod)) extensionConjunto -= prod.getExtension(producto);
    }
    
    public void comprobarProductores() {
        for(Productor p: productores) {
            //Se recorre los productores involucrados
            if(p instanceof GranProductor) removeProductor(p);
            //y si un productor es gran productor, entonces eliminarlo
            //De esta forma, nos aseguramos de que todo sean pequeños productores
        }
    }
    
    //GETTERS
    
    public Producto getProducto() {
        return producto;
    }
    
    public ArrayList<PeqProductor> getProductores() {
        return productores;
    }
    
    public double getExtensionTotal() {
        return extensionConjunto;
    }
}
