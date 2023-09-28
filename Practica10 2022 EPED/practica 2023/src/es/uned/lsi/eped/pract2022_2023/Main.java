package es.uned.lsi.eped.pract2022_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import es.uned.lsi.eped.DataStructures.IteratorIF;

public class Main {

	private static void printUsage() {
		System.err.println("Error en los parámetros de entrada:");
		System.err.println("-Primer parámetro: estructura a utilizar (SEQUENCE/TREE)");
		System.err.println("-Segundo parámetro: fichero con las operaciones a realizar sobre el stock");
		System.err.println("-Tercer parámetro: fichero donde volcar la salida de la ejecución");
	}
	
	/* Comprueba que el fichero de entrada exista y puede ser leido */
	public static Boolean checkInput(String file) {
		File f = new File(file);
		// Se comprueba que el fichero existe y es, realmente, un fichero
		if ( !f.exists() || !f.isFile() ) {
			System.out.println("ERROR: no existe el fichero de entrada "+file+".");
			return false;
		}
		// Se comprueba que el fichero puede ser leido
		if ( !f.canRead() ) {
			System.out.println("ERROR: el fichero de entrada "+file+" no puede leerse.");
			return false;
		}
		return true;
	}
	
	/* Comprueba que se puede crear el fichero de salida */
	public static Boolean checkOutput(String file) {
		File f = new File(file);
		f=f.getAbsoluteFile();
		// Se comprueba que la carpeta para escribir el fichero de salida existe
		if ( !f.getParentFile().exists() ) {
			System.out.println("ERROR: no existe la carpeta del fichero de salida "+f.getParent()+".");
			return false;
		}
		// Se comprueba que la carpeta para escribir el fichero de salida tenga permisos de escritura
		if ( !f.getParentFile().canWrite() ) {
			System.out.println("ERROR: no se puede escribir en la carpeta del fichero de salida "+f.getParent()+".");
			return false;
		}
		// Si el fichero de salida existe...
		if ( f.exists() ) {
			// Se comprueba que sea un fichero
			if ( !f.isFile() ) {
				System.out.println("ERROR: la salida "+file+" no es un fichero.");
				return false;
			}
			// Se comprueba que pueda sobreescribirse
			if ( !f.canWrite() ) {
				System.out.println("ERROR: el fichero de salida "+file+" no puede sobreescribirse");
				return false;
			}
		}
		return true;
	}
	
	/*Convierte un iterador en cadena de caracteres
	 * @param it: iterador
	 */
	public static <E> String toString(IteratorIF<E> it){
		StringBuilder result = new StringBuilder();
		while ( it.hasNext() ){
			result.append(it.getNext().toString());
			if( it.hasNext() ){
				result.append(" ");
			}
		}
		return result.toString();
	}
	
	
	public static void main(String[] args) throws IOException {
		
		if ( args.length != 3 ) {
			printUsage();
			return;
		}

		/* Implementacion Stock. Posibles valores: 
		 *   - SEQUENCE 
		 *   - BTREE
		 */
		String typeStock = args[0]; 
		StockIF stock;
		switch (typeStock) {
		case "SEQUENCE":
			// Stock basado en secuencias
			stock = new StockSequence();
			break;
		case "TREE":
			// Stock basado en arboles
			stock = new StockTree();
			break;
		default:
			System.out.println("ERROR: el primer argumento debe ser SEQUENCE o TREE.");
			return;
		}

		// Fichero de entrada
		String input = args[1]; 
		if ( !checkInput(input) ) { return; }	
		
		// Fichero de salida
		String output = args[2];
		if ( !checkOutput(output) ) { return; }

		// Salto de linea
		String lineFeed = System.getProperty("line.separator");
		// Se abre la lectura del fichero de entrada
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input), "utf-8"));		
		// Se abre la escritura en el fichero de salida
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "utf-8"));
		
		String line;
		String result = "";
		long t0 = System.currentTimeMillis();
		while ((line = br.readLine())!=null) {
			// Cada linea del fichero de entrada es una operacion sobre el stock.
			// Separa la linea en tokens por espacios en blancos
			StringTokenizer st = new StringTokenizer(line, " ");
			// El primer token contiene la operacion (compra/venta/listado)
			String op = st.nextToken().toLowerCase();
			// El segundo token se usa para recuperar el producto a vender/comprar o el prefijo del listado
			String pr;
			// Variables a utilizar en las operaciones compra/venta
			int un,unInStock;
			// Ejecucion de operaciones
			switch(op){
				// Operacion de compra
				case "compra":
					// El segundo token contiene el producto a comprar
					pr = st.nextToken().toLowerCase();
					// Tiene un segundo parámetro, que es el número de unidades
					un = Integer.parseInt(st.nextToken());
					unInStock = stock.retrieveStock(pr);
					if ( unInStock == -1 ) stock.updateStock(pr,un);
					else stock.updateStock(pr, unInStock+un);
					result = "Compra realizada, stock actualizado.";
					break;
				// Operacion de venta
				case "venta":
					// El segundo token contiene el producto a vender
					pr = st.nextToken().toLowerCase();
					// Tiene un segundo parámetro, que es el número de unidades
					un = Integer.parseInt(st.nextToken());
					unInStock = stock.retrieveStock(pr);
					if ( unInStock == -1 ) result = "Venta fallida: el producto nunca ha estado en stock";
					else {
						if ( unInStock < un ) result = "Venta fallida: no hay suficientes unidades del producto para vender";
						else {
							stock.updateStock(pr, unInStock-un);
							result = "Venta realizada, stock actualizado.";
						}
					}
					break;
				// Operación de consulta de stock
				case "unidades":
					// El segundo token contiene el producto a consultar
					pr = st.nextToken().toLowerCase();
					unInStock = stock.retrieveStock(pr);
					if ( unInStock == -1 ) result = "Error: el producto nunca ha estado en stock";
					else {
						if ( unInStock == 0 ) result = "El producto ha estado en stock, pero ahora no hay unidades";
						else {
							String plural = (unInStock != 1)?"es":"";
							result = "El producto está en stock y hay "+Integer.toString(unInStock)+" unidad"+plural;
						}
					}
					break;
				// Operacion de listado
				case "listado":
					// El segundo token contiene el prefijo a partir del cual listar
					// Si no hay segundo token, se considera la cadena vacía como prefijo
					if ( st.hasMoreTokens() ) pr = st.nextToken().toLowerCase();
					else pr = "";
					// No tiene parámetros adicionales
					result = toString(stock.listStock(pr).iterator());
					break;
			}
			// Se escribe la salida en el fichero de salida 
			bw.write(line+": ");
			bw.write(result);
			bw.write(lineFeed);
		} 
		long t1 = System.currentTimeMillis() - t0;
		// Muestra por consola el tiempo de ejecucion en milisegundos
		System.out.println(t1+" ms");
		// Se cierra el buffer de lectura
		br.close();
		// Se cierra el buffer de escritura
		bw.close();
	}
}
