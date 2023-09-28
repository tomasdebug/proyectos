
public class MainMediciones {
    public static void main(String[] args) {
        System.out.println("SPARSEARRAYSEQUENCE");
        System.out.println("-------------------");
        System.out.println("\nMetodo set:");

        for (int i = 1000; i <= 16000; i += 1000) {
            medirSetSecuencia(i);
        }

        System.out.println("\nMetodo get:");
        for (int i = 1000; i <= 16000; i += 1000) {
            medirGetSecuencia(i);
        }

        System.out.println("\n\nSPARSEARRAYBTREE");
        System.out.println("-------------------");
        System.out.println("\nMetodo set:");

        for (int i = 1; i < 26; i ++) {
            medirSetArbol(i);
        }

        System.out.println("\nMetodo get:");
        for (int i = 1; i < 26; i ++) {
            medirGetArbol(i);
        }
    }

    private static SparseArrayIF<Integer> rellenar(SparseArrayIF<Integer> array, int size) {
        for (int i = size; i > 0; --i) {
            array.set(i, i+3);
        }
        return array;
    }

    private static void medirSetSecuencia(int size) {
        SparseArrayIF<Integer> seq = rellenar(new SparseArraySequence<>(), size);
        final int repeticiones = 1000;
        final long start = System.nanoTime();
        for (int i = 0; i < repeticiones; ++i) {
            seq.set(size, i);
        }
        final long end = System.nanoTime();
        System.out.printf("%d elementos: %.2f ns%n", size, (end - start)/(float)repeticiones);
    }

    private static void medirGetSecuencia(int size) {
        SparseArrayIF<Integer> seq = rellenar(new SparseArraySequence<>(), size);
        final int repeticiones = 1000;
        final long start = System.nanoTime();
        for (int i = 0; i < repeticiones; ++i) {
            seq.get(size);
        }
        final long end = System.nanoTime();
        System.out.printf("%d elementos: %.2f ns%n", size, (end - start)/(float)repeticiones);
    }

    private static void medirSetArbol(int bits) {
        SparseArrayIF<Integer> arbol = rellenar(new SparseArrayBTree<>(), 15000);
        final int repeticiones = 1000;
        final long start = System.nanoTime();
        for (int i = 0; i < repeticiones; ++i) {
            arbol.set(1 << bits - 1, i);
        }
        final long end = System.nanoTime();
        System.out.printf("%d bits: %.2f ns%n", bits, (end - start)/(float)repeticiones);
    }

    private static void medirGetArbol(int bits) {
        SparseArrayIF<Integer> arbol = rellenar(new SparseArrayBTree<>(), 1 << bits);
        final int repeticiones = 1000;
        final long start = System.nanoTime();
        for (int i = 0; i < repeticiones; ++i) {
            arbol.get(1 << bits - 1);
        }
        final long end = System.nanoTime();
        System.out.printf("%d bits: %.2f ns%n", bits, (end - start)/(float)repeticiones);
    }
}
