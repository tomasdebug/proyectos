import java.util.*;

/**
 * Productos que se obtienen y venden.
 * Cada objeto tiene un nombre, un tipo, un rendimiento, un precio y un registro de precios
 */
public class Producto
{
    private final String nombre;
    private final boolean perecedero; //true si es, false si no lo es
    private final double rendimiento; //toneladas por hectarea que se pueden obtener
    private double precio; //precio actual del producto 
    private HashMap<Integer, Double[]> precioEvol;
    //Mapa con las listas de precios por año
    //HashMap<Año,preciosCadaSemana>
    private HashMap<Integer, Integer> ventasAnno;
    //Mapa con las listas de ventas por año
    //HashMap<Año,NumeroVentasDeEsteProducto>
    
    /**
     * Constructor para objetos de la clase Producto
     * 
     * @param   n   nombre del producto
     * @param   p   ¿es perecedero? (true / false)
     * @param   r   toneladas/hectarea
     * @param   v   €/kg (sin IVA)
     */
    public Producto(String n, boolean p, double r, double v)
    {
        nombre = n;
        perecedero = p;
        rendimiento = r;
        precio = v;
        precioEvol = new HashMap<>();
        Double[] precios = new Double[53];
        precios[Administracion.fecha.getWeekOfTheYear()] = v;
        precioEvol.put(Administracion.fecha.getYear(), precios);
        ventasAnno = new HashMap<>();
    }

    /**
     * Cambia el precio de un solo producto y añade ese precio al registro
     * de precios
     * 
     * @precon  Tiene que haber pasado una semana
     * @param   v   €/kg (sin IVA)
     */
    public void cambiarPrecio(double v){
        precio=v;
        
        Double[] precios = precioEvol.get(Administracion.fecha.getYear());
        if(precios == null) precios = new Double[53];
        precios[Administracion.fecha.getWeekOfTheYear()] = v;
        precioEvol.put(Administracion.fecha.getYear(), precios);
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public boolean esPerecedero() {
        return perecedero;
    }
    
    public String getTipo(){
        if(perecedero){
            return "Perecedero";
        } else {
            return "No perecedero";
        }
    }

    public double getRendimiento() {
        return rendimiento;
    }

    public double getPrecio() {
        return precio;
    }

    public Double[] getPrecioEvol(int year) {
        return precioEvol.get(year);
    }

    public void registrarPrecio(int year, int semana) {
        if(precioEvol.containsKey(year)) {
            //si en el hashmap precioEvol se ha añadido una lista de precios para ese año, entonces simplemente registrar el precio para esa semana
            Double[] registro = precioEvol.get(year);
            registro[semana] = precio;
            precioEvol.put(year,registro);
        } else { //si no, crear nuevo registro y registrar el precio de esa semana
            Double[] registro = new Double[53];
            registro[semana] = precio;
            precioEvol.put(year,registro);
        }
    }

    public void aumentarVentas(int year) {
        if(ventasAnno.get(year) != null) { //si ya hay un valor para ese año, entonces simplemente sumar 1
            ventasAnno.put(year, ventasAnno.get(year)+1);
        } else { //si no hay valores para ese año, empezar el conteo
            ventasAnno.put(year, 1);
        }
    }

    public int getVentas(int year) {
        return ventasAnno.get(year);
    }
}