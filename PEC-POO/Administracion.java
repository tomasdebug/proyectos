import java.util.*;

/**
 * Administrar almacenes
 */
public abstract class Administracion
{
    public static Fecha fecha = new Fecha();
    public static AlmacenProductos almProductos = new AlmacenProductos();
    public static AlmacenProductores almProductores = new AlmacenProductores();
    public static AlmacenLogistica almLogistica = new AlmacenLogistica();
    
    public static Cliente cons = new Cliente("Consumidor", Cliente.tipo.Consumidor);
    public static Cliente dist = new Cliente("Distribuidor", Cliente.tipo.Distribuidor);
    
    private static HashMap<Integer,HashMap<Producto,Double>> beneficiosProd = new HashMap<>();
    //<Año,HashMap<Productos, BeneficiosGanadosPorEseProducto>>
    
    /**
     * Comprueba si hay suficiente en la Cooperativa para hacer un pedido
     * 
     * @param   pr  productor al que se hace el pedido
     * @param   p   producto que se pide
     * @param   kg  kilos de producto pedidos
     */
    public static boolean comprobarReservas(Productor pr, Producto p, int kg) {
        if(pr instanceof ProductorFede){
            return pr.getExtensionTotal()*p.getRendimiento()*1000 >= kg;
        } else return pr.getExtension(p)*p.getRendimiento()*1000 >= kg;
    }
    
    public static void añadirBeneficioProducto(int year, Producto p, double importe) {
        if(beneficiosProd.get(year) != null) {
            //si en el hashmap beneficiosProd se ha añadido un hashmap de ganancias por producto para ese año
            HashMap<Producto,Double> lista = beneficiosProd.get(year); //se obtiene ese registro
            lista.put(p, importe + lista.get(p)); //y se añade el importe a las ganancias del producto
            beneficiosProd.put(year, lista);
        } else {
            HashMap<Producto,Double> lista = new HashMap<>(); //se crea un nuevo registro
            lista.put(p,importe);//y se comienza las ganancias del producto con ese importe
            beneficiosProd.put(year, lista);
        }
    }
    
    public static double getBeneficioProducto(int year, Producto p) {
        return beneficiosProd.get(year).get(p);
    }
}
