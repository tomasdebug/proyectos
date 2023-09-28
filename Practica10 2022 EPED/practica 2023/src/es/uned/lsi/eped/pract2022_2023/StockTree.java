package es.uned.lsi.eped.pract2022_2023;

import es.uned.lsi.eped.DataStructures.*;

public class StockTree implements StockIF {

    protected GTreeIF<Node> stock; /* El stock es un árbol general de nodos */
    private ListIF<GTreeIF<Node>> children;//te devuelve una lista de los subarboles nodo
    private list<Node> nodes;//devuelve una lista de los nodos que están contenido los subarboles
	
    
    /* Constructor de la clase */
    public StockTree() {
        children= new ListIF<GTreeIF<Node>>();//declaro a los hijos(una lista que contiene los subarboles que a su vez contienen a sus propios hijos nodos)
        stock = new GTree<Node>();//declaro el arbol principal stock cuyos nodos serán los nodos que están contenido en la lista de subarboles
    }

    /*void insert(String word) {
        NodeRoot current = root;

        for (char l : word.toCharArray()) {
       
            current = current.getChildren().computeIfAbsent(l, c -> new NodeInner());
            /*
            
       //current.getChildren() obtiene un Map que representa los hijos del nodo actual en el Trie.
        computeIfAbsent(l, c -> new TrieNode()) comprueba si existe un hijo para la letra actual l en el Trie. 
        Si existe, devuelve ese hijo. Si no existe,
        crea un nuevo nodo TrieNode para esa letra y lo agrega como hijo del nodo actual. 
        La línea completa establece current en el nuevo hijo o en el hijo existente para la letra actual.
        
    } */
    /* 
    @Override
    public int retrieveStock(String p) {
        if (p == null || p.isEmpty()) {
            throw new IllegalArgumentException("Invalid index");
        }
        
        StockPair pair = new StockPair(p, 0);
        GTreeNode<StockPair> node = tree.findNode(pair);
        
        if (node == null) {
            return -1;
        } else {
            return node.getData().getUnits();
        }

    }
    */
    @Override 
     public int retrieveStock(String p){

        return 1;


     }
     @Override
     public void updateStock(String p, int u)
     {  

     }
     @Override
     public SequenceIF<StockPair> listStock(String prefix){
         return Sequenstock;

     }

    /*  public void insertStock(String p, int u){

        GTreeIF<Node> subtree;
        for (char l : p.toCharArray()) {
       
            GTreeIF<Node>  nuevoSubarbol = new  GTreeIF<Node> (new Node("nuevo nodo"));
        }

        tree.addChild(children.size(),tree);
  
    
        NodeRoot current = root;
        */ 
     

    public void crear_Nodos(String word, int unidades){
/*Para crear un arbol
    1.Lo instancio en el constructor 
    2.llamo a su metodo setRoot(Nodo nodo) en el cual establezco el primer nodo como raiz
    3.Una vez establecida la raiz utilizo la lista de subarboles children para agregarle los nodos hijos que tienen
    4.Una vez agregado todos los nodos el ultimo nodo debera de tener las unidades del stock
    5.Lo instancio y lo agrego al arbol principal 
    6.para agregarlo utilizaré el metodo addChild(int posicion, GTreeIF<Node> nodo)
    7.Me voy a tomar libertad creativa para crear ese arbol
 */

    for(char l:Word.chattoArray()){

        int i =1;
        if(i==1){//si i es igual a 1 es que estoy en el primer caracter de todos

            Node root=new node(l);
            nodes.insert(0,root);//lo estoy almacenando en la lista del subarbol 
            i++;//llevo la cuenta de los nodos que estoy almacenando
            
        }
            //Instanciamos los nodos
            NodeInner nletra = new NodeInner(l)//instancio los nodos de que almacenan letras
            Children.insert(children.size(),nletra)//los inserto en la lista en la ultima posicion
            I++;//para llevar el conteo
            Else if (i==word.length()){ //si el número de nodos ha alcanzado la longitud total de la palabra entonces podemos poner los nodos de unidades
            NodeInfo nunidades = new Node (unidades);//instancio los nodos de unidades
            Children.insert(children.size(),nunidades);//inserto el nodo al final de la lista 
}
//Ya tengo la lista de nodos de una palabra creada ahora solo falta meterla al árbol creo.
}
//Una vez que tengo los nodos puedo hacer pruebas con los demás
    }

}
  /*     
    public void insertSubtree(String p, GTreeIF<Node> subtree) {
  
        for (char l : p.toCharArray()) {
       
          children.insert(l, subtree);
        }

        tree.addChild(children.size(),subtree);

      
    }
    */  

}
