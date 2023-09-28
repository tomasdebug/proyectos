import java.util.*;

/**
 * Aqui se gestionan los datos necesarios para la creacion de un pedido.
 * Se realizan las operaciones necesarias para hacer la factura
 */
public class Pedido
{
    private static int cont = 1; //variable auxiliar que nos ayudará a crear una id global
    private int id; //id global
    private Fecha fechaPedido; //fecha actual -> la del pedido
    private Fecha fechaEntrega; //fecha en la que se entrega el pedido (10 dias despues de pedir)
    private Cliente.tipo tipoC; //enum
    private Producto producto;
    private Productor productor;
    private int kgProd; //kg del pedido
    private int kmTrans; //km totales transporte
    private EmpresaLogistica empGran; //empresa que se encarga de la gran logistica
    private EmpresaLogistica empPeq; //empresa que se encarga de la pequeña logistica
    private double incrementoPrecio; //precio extra que pagan los clientes (varia segun consumidor o distribuidor)
    private double costeProd; //Precio del producto en el momento en el que se pide
    private HashMap<Productor,Double> importeProductor; 
    //HashMap <Productor,ImportePorCadaProductor>
    
    /**
     * Pedido realizado
     * 
     * @param   t   tipo de cliente (Distribuidor / Consumidor)
     * @param   p   producto pedido
     * @param   pr  productor al que se hizo el pedido
     * @param   kg  kilos de producto pedidos
     * @param   km  distancia de la cooperativa al destino
     * @param   eg  empresa que hará la gran logística
     * @param   ep  empresa que hará la pequeña logística
     */
    public Pedido(Cliente.tipo t, Producto p, Productor pr, int kg, int km, EmpresaLogistica eg, EmpresaLogistica ep) {
        id = cont++; //asigna y suma
        fechaPedido = Administracion.fecha;
        fechaEntrega = Administracion.fecha.addDays(10);
        tipoC = t;
        producto = p;
        productor = pr;
        kgProd = kg;
        kmTrans = km;
        empGran = eg;
        empPeq = ep;
        costeProd = producto.getPrecio();
        switch(tipoC) {
            case Distribuidor:
                incrementoPrecio = 0.05;
                break;
            case Consumidor:
                incrementoPrecio = 0.15;
                break;
        }
        importeProductor = new HashMap<>();
        añadirBeneficios();
    }
    
    public double calcularCosteProducto() {
        return costeProd * (1 + incrementoPrecio) * kgProd;
    }
    
    public double calcularCosteLogistica() {
        return AlmacenLogistica.realizarLogística(empGran, empPeq, producto, kmTrans, kgProd);
    }
    
    public double calcularIVA() { //Solo se calcula para los consumidores
        double IVA = 0;
        if(tipoC == Cliente.tipo.Consumidor) IVA = (calcularCosteProducto() + calcularCosteLogistica()) * 0.1;
        return IVA;
    }
    
    public double calcularCosteTotal() {
        return calcularCosteProducto() + calcularCosteLogistica() + calcularIVA();
    }
    
    /**
     * Aumenta ventas de productos, otorga el importe ganado a los productores, calculamos beneficios de la logistica y las añadimos donde hacen falta
     */
    public void añadirBeneficios() {
        //Añadimos una venta al producto
        producto.aumentarVentas(fechaPedido.getYear());
        //Añadimos los beneficios de cada productor
        if(productor instanceof ProductorFede) {
            ArrayList<PeqProductor> productores = productor.getProductores();
            for(Productor prod: productores) {
                prod.añadirImporteProducto(fechaPedido.getYear(), producto, costeProd * kgProd * (prod.getExtension(producto) / productor.getExtensionTotal()));
                if(importeProductor.containsKey(prod)) {
                    importeProductor.put(prod, importeProductor.get(prod) + costeProd * kgProd * (prod.getExtension(producto) / productor.getExtensionTotal()));
                } else {
                    importeProductor.put(prod, costeProd * kgProd * (prod.getExtension(producto) / productor.getExtensionTotal()));
                }
            }
        } else {
            productor.añadirImporteProducto(fechaPedido.getYear(), producto, costeProd * kgProd);
            if(importeProductor.containsKey(productor)) {
                    importeProductor.put(productor, importeProductor.get(productor) + costeProd * kgProd);
                } else {
                    importeProductor.put(productor, costeProd * kgProd);
                }
        }
        //Calculamos y añadimos el beneficio de la gran logística y de la pequeña logística por separado
        int kg = kgProd, km = kmTrans;
        if(producto.esPerecedero()) {
            while(kg >= 1000) {
                if(km >= 100) {
                    empGran.añadirImporte(fechaPedido.getYear(), empGran.realizarGranLogistica(producto, (int)(km/100)*100, 1000));
                    empPeq.añadirImporte(fechaPedido.getYear(), empPeq.realizarPeqLogistica(km%100, 1000));
                } else {
                    empPeq.añadirImporte(fechaPedido.getYear(), empPeq.realizarPeqLogistica(km, 1000));
                }
                kg -= 1000;
            }
            if(km >= 100) {
                empGran.añadirImporte(fechaPedido.getYear(), empGran.realizarGranLogistica(producto, (int)(km/100)*100, kg));
                empPeq.añadirImporte(fechaPedido.getYear(), empPeq.realizarPeqLogistica(km%100, kg));
            } else {
                empPeq.añadirImporte(fechaPedido.getYear(), empPeq.realizarPeqLogistica(km, kg));
            }
        } else {
            while(kg >= 1000) {
                while(km >= 50) {
                    empGran.añadirImporte(fechaPedido.getYear(), empGran.realizarGranLogistica(producto, 50, 1000));
                    km -= 50;
                }
                empPeq.añadirImporte(fechaPedido.getYear(), empPeq.realizarPeqLogistica(km, 1000));
                kg -= 1000;
            }
            while(km >= 50) {
                empGran.añadirImporte(fechaPedido.getYear(), empGran.realizarGranLogistica(producto, 50, kg));
                km -= 50;
            }
            empPeq.añadirImporte(fechaPedido.getYear(), empPeq.realizarPeqLogistica(km, kg));
        }
        //Calculamos y añadimos el beneficio de la corporativa
        Administracion.añadirBeneficioProducto(fechaPedido.getYear(), producto, costeProd * incrementoPrecio * kgProd);
    }
    
    //GETTER
    
    public int getID() { return id; }
    public static int getUltimaID() { return cont; }
    public Fecha getFechaPedido() { return fechaPedido; }
    public Fecha getFechaEntrega() { return fechaEntrega; }
    public Cliente.tipo getCliente() { return tipoC; }
    public Producto getProducto() { return producto; }
    public Productor getProductor() { return productor; }
    public ArrayList<PeqProductor> getProductores() { 
        if(productor instanceof ProductorFede) return productor.getProductores();
        return null;
    }
    public int getKg() { return kgProd; }
    public int getKm() { return kmTrans; }
    public EmpresaLogistica getEmpresaGranLogistica() { return empGran; }
    public EmpresaLogistica getEmpresaPeqLogistica() { return empPeq; }
    private double getImporteProductor(Productor p) { return importeProductor.get(p); }
}
