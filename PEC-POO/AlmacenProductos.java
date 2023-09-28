
/**
 * Guardar productos y cambiar el precio de los productos
 */
public class AlmacenProductos
{
    private Producto[] productos; //lo creamos como array porque van a haber 10 productos creados

    /**
     * Instancia
     */
    public AlmacenProductos()
    {
        //Creamos los productos
        productos = new Producto[10];
        /************ Inicialización de productos por defecto ************/ 
        productos[0] = new Producto("Aceitunas",false,2,0.2);
        productos[1] = new Producto("Pistachos",false,1,0.1);
        productos[2] = new Producto("Naranjas",true,2.5,0.35);
        productos[3] = new Producto("Melocotones",true,2,0.3);
        productos[4] = new Producto("Melones",true,1,0.5);
        productos[5] = new Producto("Uvas",true,1.5,0.25);
        productos[6] = new Producto("Aceite",false,2,0.5);
        productos[7] = new Producto("Ciruelas",true,1,0.15);
        productos[8] = new Producto("Algodon",false,2,0.3);
        productos[9] = new Producto("Trigo",false,2,0.5);
    }
    
    /**
     * Cambia el precio de todos los productos a una cantidad aleatoria
     * entre 0.1 y 2
     * 
     * @precon  Tiene que haber pasado una semana
     */
    public void cambiarPreciosProducutos(){
        for (Producto producto : productos) {
            producto.cambiarPrecio((Math.round(Math.random()*500+1))/100); //los precios estaran entre 0.1 y 5€/kg
        }
    }
    
    //GETTER

    /**
     * Obtener un producto del arraylist
     *
     * @param   nombre   nombre del producto buscado
     */
    public Producto getProducto(String nombre)
    {
        for (Producto producto : productos) { //recorremos el array
            if (producto.getNombre().equals(nombre)) { 
                //si coincide con el producto buscado, se devuelve el objeto
                return producto;
            }
        }
        return null; //si no se encuentra, se devuelve null
    }
    
    /**
     * Devuelve el producto de una posicion del array determinada
     * 
     * @return  productos[i]
     */
    public Producto getProducto(int i){
        return productos[i];
    }
    
    /**
     * Devuelve un array con todos los productos
     * 
     * @return  Producto[]
     */
    public Producto[] getProductos(){
        return productos;
    }

}