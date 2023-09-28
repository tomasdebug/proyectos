package es.uned.lsi.eped.pract2022_2023;

import es.uned.lsi.eped.DataStructures.*;
 
/**
 * Write a description of class da here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class da
{
    
   
protected GTreeIF<Node> stock; /* El stock es un árbol general de nodos */
private ListIF<GTreeIF<Node>> children;
GTreeIF<Node> subtree;
private NodeRoot root;
    
    /* Constructor de la clase */
public da(){
 
    stock = new GTree<Node>();
    }
 
public void subTree(String p) {
    subtree = new GTree<Node>();
    GTreeIF<Node> currentNode = subtree;
    for (char l : p.toCharArray()) {
        Node nodo_letra = new NodeInner(l);
        currentNode.addChild(0,nodo_letra);
        currentNode = nodo_letra;
    }
}
 public NodeInfo findNodeByPrefix(String prefix) {
        Node current = root;
        int i = 0;
        while (current != null && i < prefix.length()) {
            char c = prefix.charAt(i);
            if (current.getNodeType() == Node.NodeType.INNER) {
                NodeInner inner = (NodeInner) current;
                current = inner.getChild(c);
                i++;
            } else {
                return null;
            }
        }
        if (current != null && current.getNodeType() == Node.NodeType.INFO) {
            return (NodeInfo) current;
        } else {
            return null;
        }
    }



public void insertSubtree(String p, GTreeIF<Node> subtree) {
  
       
        stock.addChild(children.size(),subtree);

      
    }
}
