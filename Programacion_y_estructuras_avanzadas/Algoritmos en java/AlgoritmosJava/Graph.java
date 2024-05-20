import java.util.*;

class Graph {
    private int V;
    private List<List<Edge>> adj;

    // Constructor para inicializar el grafo
    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; ++i)
            adj.add(new ArrayList<>()); // Crea listas de adyacencia para cada vértice
    }

    // Clase para representar una arista
    class Edge implements Comparable<Edge> {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    // Método para agregar una arista al grafo (grafo no dirigido)
    void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(dest, weight);
        adj.get(src).add(edge); // Agrega arista de src a dest
        edge = new Edge(src, weight);
        adj.get(dest).add(edge); // Agrega arista de dest a src (grafo no dirigido)
    }

    // Algoritmo de Prim para encontrar el MST
    void primMST() {
        boolean[] inMST = new boolean[V]; // Para marcar los vértices incluidos en el MST
        int[] parent = new int[V]; // Para almacenar el MST resultante
        int[] key = new int[V]; // Almacena el peso de la arista más pequeña que conecta el vértice i con el MST
        Arrays.fill(key, Integer.MAX_VALUE); // Inicializa todas las claves con un valor infinito

        PriorityQueue<Edge> pq = new PriorityQueue<>(V, Comparator.comparingInt(e -> e.weight));// Cola de prioridad para seleccionar la arista de menor peso
        /*
        Esta línea crea una PriorityQueue de tipo Edge y utiliza un comparador basado en el peso de la arista (weight) para ordenar las aristas en función de su peso y 
        seleccionar la de menor peso en cada paso del algoritmo de Prim.
           */
        key[0] = 0; // La clave del vértice inicial es 0
        pq.add(new Edge(0, key[0])); // Agrega el vértice inicial a la cola de prioridad
        parent[0] = -1; // El primer vértice no tiene padre en el MST

        while (!pq.isEmpty()) {
            int u = pq.poll().dest; // Obtiene el vértice con la clave mínima
            inMST[u] = true; // Marca el vértice como incluido en el MST

            // Explora los vértices adyacentes de u
            for (Edge e : adj.get(u)) {
                int v = e.dest; // Obtiene el vértice adyacente
                int weight = e.weight; // Obtiene el peso de la arista entre u y v
                if (!inMST[v] && weight < key[v]) { // Si v no está en el MST y la arista u-v tiene menor peso que la clave actual
                    parent[v] = u; // Establece u como el padre de v en el MST
                    key[v] = weight; // Actualiza el peso de la arista
                    pq.add(new Edge(v, key[v])); // Agrega v a la cola de prioridad con la nueva clave
                }
            }
        }

        // Mostrar las aristas en el MST
        System.out.println("Edges in the MST:");
        for (int i = 1; i < V; ++i)
            System.out.println(parent[i] + " - " + i);
    }

    public static void main(String[] args) {
        int V = 5; // Número de vértices
        Graph graph = new Graph(V); // Crear un nuevo grafo con 5 vértices

        // Agregar aristas al grafo con sus pesos
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        graph.primMST(); // Encontrar el MST utilizando Prim
    }
}
