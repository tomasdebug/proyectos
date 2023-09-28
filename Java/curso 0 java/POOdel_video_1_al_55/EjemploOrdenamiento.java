
import java.util.ArrayList;
import java.util.Collections;

public class EjemploOrdenamiento {

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("banana");
        lista.add("manzana");
        lista.add("kiwi");
        lista.add("naranja");

        // Imprime la lista desordenada
        System.out.println("Lista desordenada: " + lista);

        // Ordena la lista
        Collections.sort(lista);

        // Imprime la lista ordenada
        System.out.println("Lista ordenada: " + lista);
    }
}