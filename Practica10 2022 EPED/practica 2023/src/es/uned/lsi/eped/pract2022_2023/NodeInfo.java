package es.uned.lsi.eped.pract2022_2023;

public class NodeInfo extends Node {

	private int unidades;
	
	public NodeInfo(int u) {
		setUnidades(u);
	}
	
	public void setUnidades(int u) {
		this.unidades = u;
	}
	
	public int getUnidades() {
		return this.unidades;
	}
	
	public NodeType getNodeType() {
		return Node.NodeType.INFO;
	}
}
