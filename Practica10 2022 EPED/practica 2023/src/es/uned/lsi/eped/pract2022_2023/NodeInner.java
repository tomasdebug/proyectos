package es.uned.lsi.eped.pract2022_2023;

public class NodeInner extends Node {

	private char letter;

	public NodeInner(char l) {
		this.letter = l;
	}
	
	public char getLetter() {
		return this.letter;
	}
		
	public NodeType getNodeType() {
		return Node.NodeType.INNER;
	}

}
