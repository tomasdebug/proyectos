package es.uned.lsi.eped.pract2022_2023;

/* Representa un par <producto,unidades> del Stock */
public class StockPair {
	private String producto;
	private int unidades;
  
	/* Constructor */
	public StockPair(String p, int u) {
		this.producto = p;
		setUnidades(u);
	}
  
	/* Modifica el número de unidades del par
	 * @PRE: u >= 0
	 */	
	public void setUnidades(int u) {
		this.unidades = u;
	}

	/* Devuelve el nombre del producto */
	public String getProducto() {
		return this.producto;
	}
  
	/* Devuelve el número de unidades */
	public int getUnidades() {
		return this.unidades;
	}
  
	/* Construye una cadena para representar el par */
	public String toString() {
		return "("+this.producto+","+Integer.toString(this.unidades)+")";
	}
}
