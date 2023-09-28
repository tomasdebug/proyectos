 

class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();//constructor del primer nodo ,por ello se le llama raiz
    }

    void insert(String word) {
        TrieNode current = root;

        for (char l : word.toCharArray()) {
       
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
            /*
            
       //current.getChildren() obtiene un Map que representa los hijos del nodo actual en el Trie.
        computeIfAbsent(l, c -> new TrieNode()) comprueba si existe un hijo para la letra actual l en el Trie. 
        Si existe, devuelve ese hijo. Si no existe,
        crea un nuevo nodo TrieNode para esa letra y lo agrega como hijo del nodo actual. 
        La línea completa establece current en el nuevo hijo o en el hijo existente para la letra actual.
         */
    }
        current.setEndOfWord(true);
    }

    boolean delete(String word) {// llama al metodo boolean delete y si este da true puede borrar la palabra
        return delete(root, word, 0);//borra la raiz que contiene la palabra
    }

    boolean containsNode(String word) {//dice si la palabra está contenida en algun nodo
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }
//nos dice si el arbol está vacío
    boolean isEmpty() {
        return root == null;
    }
//borra una palabra del trie 
/*current es el nodo actual en el que nos encontramos word la palabra a eliminar e index es la posición de la letra que estamos procesando.
 *
 */
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {// sí index es igual a la longitud de la palabra,entonces hemos llegado al final de la palabra.
            if (!current.isEndOfWord()) {//Sin embargo si el nodo actual no marca el final  de una palabra
              
                return false;// devuelve false,ya que la palabra no estará en el trie. endOfWord indica si el nodo actual es el final de una palabra.
            }
            current.setEndOfWord(false);//Si el nodo actual marca el final de una palabra, se establece la bandera endOfWord en falso para indicar que la palabra ha sido eliminada.
            return current.getChildren().isEmpty();// Luego, se verifica si el mapa de hijos del nodo actual está vacío. Si es así, entonces el nodo actual debe eliminarse y se devuelve true.
            // Si el mapa de hijos no está vacío, el nodo actual no debe eliminarse y se devuelve false. 
        }
        /*
       
        Si el nodo hijo se elimina, se verifica si el mapa de hijos del nodo actual está vacío. Si es así, entonces el nodo actual debe eliminarse y se devuelve true. 
        */
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);//Si la letra l en la posición index de la palabra word tiene un nodo hijo, se llama recursivamente a este método con el nodo hijo como nodo actual.
        if (node == null) { //cogemos el nodo hijo si no existe retornamos false(ya que no existe)
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
}
