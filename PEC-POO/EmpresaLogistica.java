import java.util.*;

/**
 * Empresa que realizará la logística de los pedidos
 */
public class EmpresaLogistica
{
    private String nombre;
    private double costeKm;
    private HashMap<Integer,Double> importeAnno; //lo que gana la empresa cada año
    //HashMap<Año,Importe>
    
    /**
     * Empresa que realiza logística
     * 
     * @param   CKM coste/km
     */
    public EmpresaLogistica(String n, double CKM) {
        nombre = n;
        costeKm = CKM;
        importeAnno = new HashMap<>();
    }
    
    /**
     * Realiza la logística de un producto y devuelve el precio de dicho servicio
     * 
     * @param   p   precio del producto
     * @param   km  kilómetros de trayecto
     * @param   kg  kilos que lleva el camión
     */
    public double realizarGranLogistica(Producto p, int km, int kg) {
        return (0.5 * p.getPrecio() * kg) + (km * costeKm);
    }
    
    /**
     * Realiza la logística de un producto y devuelve el precio de dicho servicio
     * 
     * @param   km  kilómetros de trayecto
     * @param   kg  kilos que lleva el camión
     */
    public double realizarPeqLogistica(int km, int kg) {
        return costeKm * km * kg;
    }
    
    public void añadirImporte(int year, double importe) {
        if(importeAnno.get(year) != null) {
            importeAnno.put(year, importeAnno.get(year) + importe);
        } else {
            importeAnno.put(year, importe);
        }
    }

    //GETTER
    
    public double getImporte(int year) {
        return importeAnno.get(year);
    }
    
    public String getNombre() {
        return nombre;
    }

    public double getCosteKm() {
        return costeKm;
    }
}
