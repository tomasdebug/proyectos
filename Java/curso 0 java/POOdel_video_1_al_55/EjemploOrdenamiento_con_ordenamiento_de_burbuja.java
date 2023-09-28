
import java.util.ArrayList;

public class EjemploOrdenamiento_con_ordenamiento_de_burbuja {

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("banana");
        lista.add("manzana");
        lista.add("kiwi");
        lista.add("naranja");

        // Ordena la lista alfabéticamente utilizando el algoritmo de burbuja mejorado
        boolean intercambio = true;
        int j = 0;
        while (intercambio) {
            intercambio = false;
            j++;
            for (int i = 0; i < lista.size() - j; i++) {
                if (lista.get(i).compareTo(lista.get(i + 1)) > 0) {
                    String temp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, temp);
                    intercambio = true;
                }
            }
        }

        // Muestra la lista ordenada
        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }
}

