import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String producto;
    private int unidades;

    public Stock(String producto, int unidades) {
        this.producto = producto;
        this.unidades = unidades;
    }

    public String getProducto() {
        return producto;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public static void main(String[] args) {
        List<Stock> stockList = new ArrayList<>();
        
       
        // Obtener valor asignado a un producto
        String productoBuscado = "producto1";
        for (Stock stock : stockList) {
            if (stock.getProducto().equals(productoBuscado)) {
                System.out.println("El valor asignado al producto " + productoBuscado + " es: " + stock.getUnidades());
            }
        }
        
        // Modificar valor asignado a un producto
        productoBuscado = "producto2";
        int nuevoValor = 8;
        for (Stock stock : stockList) {
            if (stock.getProducto().equals(productoBuscado)) {
                stock.setUnidades(nuevoValor);
            }
        }
        
        // Listar todos los productos que empiezan por una cadena
        String cadenaBuscada = "pro";
        for (Stock stock : stockList) {
            if (stock.getProducto().startsWith(cadenaBuscada)) {
                System.out.println("Producto que empieza por " + cadenaBuscada + ": " + stock.getProducto());
            }
        }
    }
     
        
        public static boolean compararPalabras(String palabra1, String palabra2) {
    if (palabra1.equals(palabra2)) {
        return true;
    } else {
        return false;
    }
}

}



