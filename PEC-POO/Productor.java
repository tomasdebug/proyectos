import java.util.*;

/**
 * Informacion basica de un productor; en base de las caracteristicas
 * aportadas, se clasificara en gran productor, pequeño productor y productor
 * federado.
 *
 * Esta relacionado con la clase producto.
 */
public abstract class Productor
{
    protected final String nombre;
    protected double extensionTotal; //Hectareas totales que tiene de todos los productos
    protected static int limiteExt = 5; //Limite de hectareas para decidir el tipo, varia cada año
    protected HashMap<Producto,Double> listaProductores; 
    //Guarda una lista de productos (cultivados por el productor) con su extensión
    //<NombreProducto, Extension>
    protected HashMap<Integer,HashMap<Producto,Double>> importeProductor;
 
    //<Producto, Importe>>

    /**
     * Constructor clase Productor
     * 
     */
    public Productor(String n)
    {
        nombre=n;
        extensionTotal = 0;
        listaProductores = new HashMap<>();
        listaProductores = new HashMap<>();
    }

    /**
     * Constructor clase Productor(Productor con productos)
     * 
     * 
     */
    public Productor(String n, HashMap<Producto,Double> p)
    {
        //Para crear un productor con los productos ya añadidos, le podemos pasar un HashMap<Producto,Extension> que podríamos crear en AlmacenProductores 
        nombre=n;
        extensionTotal = 0;
        listaProductores = p;
        //Tomamos todos los pares producto-extension y sumamos las extensiones
        for (HashMap.Entry<Producto, Double> entrada : p.entrySet()){
            
           extensionTotal += entrada.getValue();
            listaProductores = new HashMap<>();
          }
    }
    
    /**
     * "Constructor" alterno para valorar a que tipo de productor pertenece
     * 
     * @param   n   nombre del productor
     * @param   p   HashMap<Producto,Double> con una lista de productos y las hectáreas que posee
     */
    public static Productor newProductor(String n, HashMap<Producto,Double> p) {
        Productor prod;
        double hectTotal = 0;
        for (HashMap.Entry<Producto, Double> entrada : p.entrySet()) hectTotal += entrada.getValue();
        if(hectTotal > limiteExt) {
            prod = new GranProductor(n, p);
        } else {
            prod = new PeqProductor(n, p);
            //se comprueba si cumple con el limite de productos en pequeño productor
        }
        return prod;
    }

    /**
     * Añadir producto y extensión
     */
    public void addProducto(Producto producto, double extension){
        listaProd.put(producto, extension);
        extensionTotal += extension; //actualizamos la extensionTot a la vez
    }

    //GETTER

    /**
     * Se obtiene un HashMap<Producto,ExtensionProducto>
     */
    public HashMap<Producto, Double> getListaProd(){
        return listaProd;
    }

    /**
     * Se obtiene el nombre del productor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtenemos la extension de un producto en concreto para el productor en cuestión
     */
    public double getExtension(Producto producto){
        if (listaProd.containsKey(producto)){
            //comprobamos si el producto existe dentro de la lista de productors del productor
            return listaProd.get(producto);
        } else {
            return 0; //no existe extensión del producto indicado
        }
    }

    /**
     * Obtenemos la extension total del productor (suma de todas las extensiones de cada producto)
     */
    public double getExtensionTotal() {
        return extensionTotal;
    }
    
    /**
     * Obtenemos el limite, que varía cada año
     */
    public static int getLimiteExtension() {
        return limiteExt;
    }
    
    public ArrayList<PeqProductor> getProductores() {
        //para ProductorFede solo (se hace override)
        return null;
    }
    
    //SETTER
    
    /**
     * Establece un limite de extension nuevo
     */
    public static void setLimiteExtension(int limExt) {
        limiteExt = limExt;
    }
    
    /**
     * Añadir un importe a los beneficios/ganancias obtenidas por un producto en un cierto año
     */
    public void añadirImporteProducto(int year, Producto p, double importe) {
        if(importeProd.get(year) != null) {
            HashMap<Producto,Double> lista = importeProd.get(year);
            lista.put(p, importe + lista.get(p));
            importeProd.put(year, lista);
        } else {
            HashMap<Producto,Double> lista = new HashMap<>();
            lista.put(p,importe);
            importeProd.put(year, lista);
        }
    }
    
    public double getImporteProducto(int year, Producto p) {
        return importeProd.get(year).get(p);
    }
}