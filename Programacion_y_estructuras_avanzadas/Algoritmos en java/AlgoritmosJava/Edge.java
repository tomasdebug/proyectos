import java.util.*;
/*
   Clase Edge:
Esta clase define una arista en el grafo.
 Tiene campos para el origen (src), destino (dest) y peso (weight). 
 Implementa la interfaz Comparable para poder ordenar las aristas por peso.
   */
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
/*
   Clase Graph:

int V, E; Edge[] edges;: Estas variables representan el número de vértices (V),
 el número de aristas (E) y un arreglo de aristas (edges).
   */
class Graph {
    int V, E;// Número de vértices y aristas
    Edge[] edges;// Arreglo de aristas


    /*
       Graph(int v, int e): 
       El constructor inicializa el grafo con el número dado de vértices y aristas.
       */
    Graph(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];// Inicializar el arreglo de aristas
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge();// Crear objeto para cada arista
    }
    /*
       
       La función find se utiliza para encontrar la raíz de un conjunto dado un nodo i.
       Recorre el camino desde i hasta la raíz del árbol, usando parent[i] para avanzar hacia arriba en el árbol 
       hasta encontrar el nodo raíz (parent[root] = -1).
       
       */
    int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
    /*
       La función union une dos conjuntos. Dados dos nodos x e y, primero se encuentra la raíz de sus conjuntos utilizando find.
       Luego, se actualiza parent[x] o parent[y] para apuntar a la raíz del otro conjunto, lo que une los conjuntos.
       */
    void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;// Actualizar el padre de xSet como ySet
    }
    /*
       void kruskalMST(): Implementa el algoritmo de Kruskal para encontrar el árbol de expansión mínima.
       Funcionamiento del algoritmo de Kruskal:

    Se ordenan las aristas en orden ascendente según sus pesos.
    Se inicializa un arreglo parent para realizar operaciones de conjuntos disjuntos.
    Se recorren las aristas ordenadas y se verifica si añadir cada arista al árbol formará un ciclo o no. Si no forma un ciclo, se añade al árbol resultante.
    El algoritmo se detiene cuando se han incluido V-1 aristas en el árbol, donde V es el número de vértices en el grafo original.
           
       */
    void kruskalMST() {
        Edge[] result = new Edge[V];// Arreglo para almacenar el MST
        int e = 0;// Índice para recorrer el resultado
        int i = 0;// Índice para recorrer las aristas
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edges); // Ordenar las aristas por peso

        int[] parent = new int[V];
        Arrays.fill(parent, -1);//La línea Arrays.fill(parent, -1) llena el arreglo parent con el valor -1. 
        /*
           Cada elemento en el arreglo parent se utiliza para representar un conjunto o una "rama" del árbol. Inicializar todo el arreglo con -1 al inicio del algoritmo
           significa que cada vértice se considera inicialmente como un conjunto independiente, sin conexiones con otros vértices.
           Durante la ejecución del algoritmo, los valores en el arreglo parent se actualizan para representar las relaciones entre los vértices.
           Cuando se une un vértice x con un vértice y, el valor en parent[x] (o parent[y]) se actualiza para apuntar al otro vértice, indicando la conexión entre ellos.

            Por ejemplo, después de realizar una unión entre dos conjuntos (vértices) x e y, si parent[x] es -1 (representando un conjunto independiente) y parent[y] es -1,
             el algoritmo actualiza uno de los valores, digamos parent[x] para que apunte a y o parent[y] para que apunte a x, indicando la conexión entre estos vértices.
                       
           */

        i = 0;
        while (e < V - 1) {
            Edge nextEdge = edges[i++];
            int x = find(parent, nextEdge.src);// Encontrar la raíz del conjunto que contiene src
            int y = find(parent, nextEdge.dest); // Encontrar la raíz del conjunto que contiene dest

            if (x != y) {// Si src y dest no están en el mismo conjunto
                result[e++] = nextEdge;// Agregar la arista al resultado
                union(parent, x, y);// Unir los conjuntos de src y dest
            }
        }

        // Display the result
        System.out.println("Edges in the MST:");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
    }
    
    /*
       Raíz de un conjunto: En esta implementación, la raíz de un conjunto es aquel nodo cuyo valor en parent es -1. Este nodo es considerado como la raíz del árbol o subárbol formado por ese conjunto de nodos.

    Nodos a los que apuntan: Cuando un nodo no es la raíz de su conjunto (es decir, parent[i] no es -1), está apuntando al nodo que es el "padre" en la estructura del árbol. Por lo tanto, si parent[i] tiene un valor diferente a -1, ese valor indica el índice del nodo al que i está conectado.
    
    Siguiendo el arreglo parent = [0, 0, 3, 0] del ejemplo anterior:
    
    La raíz del árbol es el nodo 0.
    El nodo 1 está conectado al nodo 0.
    El nodo 2 está conectado al nodo 3.
    El nodo 3 está conectado al nodo 0.
       
       
       
       */
    /*
       main(String[] args): Aquí se crea un grafo con un número específico de vértices, se definen las aristas con sus respectivos pesos 
       y se llama al método 
       */
    public static void main(String[] args)  {
        int V = 4; // Number of vertices
        int E = 5; // Number of edges

        Graph graph = new Graph(V, E);

        // Add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;

        // Add edge 0-2
        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;

        // Add edge 0-3
        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;

        // Add edge 1-3
        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 15;

        // Add edge 2-3
        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 4;

        graph.kruskalMST(); // Encontrar el MST utilizando Kruskal
    }
}