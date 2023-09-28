
import java.util.ArrayList;

public class EjemploOrdenamiento_sin_sort {

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("banana");
        lista.add("manzana");
        lista.add("kiwi");
        lista.add("naranja");

        // Ordena la lista alfabéticamente utilizando el algoritmo de selección
        for (int i = 0; i < lista.size() - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(j).compareTo(lista.get(indiceMinimo)) < 0) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                String temp = lista.get(i);
                lista.set(i, lista.get(indiceMinimo));
                lista.set(indiceMinimo, lista.get(i));
            }
        }

        // Muestra la lista ordenada
        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }
}
