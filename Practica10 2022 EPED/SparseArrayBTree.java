

public class SparseArrayBTree<E> extends Collection<E> implements SparseArrayIF<E> {
	
	//Creamos un nuevo arbol

	protected BTreeIF<IndexedPair<E>> btree = new BTree<>();

	public SparseArrayBTree() {
		super();
	}

	//Funcion que convierte de decimal a binario y lo mete en una pila 
	private StackIF<Boolean> num2bin(int n) {
		Stack<Boolean> salida = new Stack<Boolean>();
		if (n == 0) {
			salida.push(false);
		} else {
			while (n != 0) {
				salida.push((n % 2) == 1);
				n = n / 2;
			}
		}
		return salida;
	}

	@Override
	public IteratorIF<E> iterator() {
		QueueIF<E> auxCola = new Queue<>(); //Creamos una cola auxiliar 
		IteratorIF<IndexedPair<E>> auxIter = this.btree.iterator(BTreeIF.IteratorModes.BREADTH); //Recorremos en anchura para que nos de los indices directamente ordenados
        //Si hay un elemento siguiente, se lo pedimos, y lo metemos en la cola 
		while (auxIter.hasNext()) {
			IndexedPair<E> iP = auxIter.getNext();
			if (iP != null) {
				auxCola.enqueue(iP.getValue());
			}
		}
		return auxCola.iterator();
	}

	@Override
	public void set(int pos, E elem) {
		// TODO Auto-generated method stub
		StackIF<Boolean> pilaDeBinarios = num2bin(pos); 

		BTreeIF<IndexedPair<E>> nodoActual = this.btree;

		while (true) {
			boolean x = pilaDeBinarios.getTop();
			if (x == true) // por derecha
			{
				// nos fijamos si tiene un hijo a drecha, si no, lo creamos
				if (nodoActual.getRightChild() == null) {
					// lo creamos
					BTreeIF<IndexedPair<E>> nuevoNodo = new BTree<>();
					nodoActual.setRightChild(nuevoNodo);
					nodoActual = nuevoNodo;
				} else {
					// nos posicionamos en el
					nodoActual = nodoActual.getRightChild();
				}
			} else // por izquierda
			{
				// nos fijamos si tiene un hijo a izquierda, si no, lo creamos
				if (nodoActual.getLeftChild() == null) {
					// lo creamos
					BTreeIF<IndexedPair<E>> nuevoNodo = new BTree<>();
					nodoActual.setLeftChild(nuevoNodo);
					nodoActual = nuevoNodo;
				} else {
					nodoActual = nodoActual.getLeftChild();
				}
			}
			pilaDeBinarios.pop();
			if (pilaDeBinarios.isEmpty())
				break; // indica que sale del bucle

		} // Fin del bucle while

		IndexedPair<E> auxElem = new IndexedPair<E>(pos, elem);
		if (nodoActual.getRoot() == null)
			size++; //actualizamos variable 

		nodoActual.setRoot(auxElem); // coste log base 2 de pos

	}

	@Override
	public E get(int pos) {
		// TODO Auto-generated method stub

		StackIF<Boolean> pilaDeBinarios = num2bin(pos);

		BTreeIF<IndexedPair<E>> nodoActual = this.btree;

		while (true) {
			boolean x = pilaDeBinarios.getTop();
			if (x == true) // por derecha
			{
				// nos fijamos si tiene un hijo a drecha, si no, retornamos null
				if (nodoActual.getRightChild() == null) {
					// no existe en la secuencia, retornamos null
					return null;
				} else {
					// nos posicionamos en el
					nodoActual = nodoActual.getRightChild();
				}
			} else // por izquierda
			{
				// nos fijamos si tiene un hijo a izquierda, si no, retornamos null
				if (nodoActual.getLeftChild() == null) {
					// no existe en la secuencia, retornamos null
					return null;
				} else {
					nodoActual = nodoActual.getLeftChild();
				}
			}
			pilaDeBinarios.pop();
			if (pilaDeBinarios.isEmpty())
				break; // indica que sale del bucle

		} // Fin del bucle while
		if (nodoActual.getRoot() == null)
			return null;
		else
			return nodoActual.getRoot().getValue(); // el coste es log base 2 de pos
	}

	@Override
	public void delete(int pos) {
		// TODO Auto-generated method stub

		StackIF<Boolean> pilaDeBinarios = num2bin(pos);
		StackIF<Boolean> pilaCamino = new Stack<>(); //controlamos si hemos venido por la derecha o la izquierda
		StackIF<BTreeIF<IndexedPair<E>>> pilaNodos = new Stack<>();

		BTreeIF<IndexedPair<E>> nodoActual = this.btree;
		BTreeIF<IndexedPair<E>> nodoPadre = null;
		boolean camino = false;

		// Comprobar si existe pos

		if (!(this.get(pos) == null)) {
			// nos colocamos sobre pos, sin olvidar quien es el padre

			while (true) {
				boolean x = pilaDeBinarios.getTop();
				camino = x;
				if (x == true) // por derecha
				{
					nodoPadre = nodoActual;
					nodoActual = nodoActual.getRightChild();
				} else // por izquierda
				{
					nodoPadre = nodoActual;
					nodoActual = nodoActual.getLeftChild();
				}
				pilaCamino.push(camino);
				pilaNodos.push(nodoActual);

				pilaDeBinarios.pop();
				if (pilaDeBinarios.isEmpty())
					break; // indica que sale del bucle

			} // Fin del bucle while
			nodoActual.setRoot(null);
			size--;

			// comienzo de poda
			// si no tiene hijos se borra el puntero en el padre
			// si no, se detiene la poda
			while (true) {
				camino = pilaCamino.getTop();
				nodoActual = pilaNodos.getTop();
				pilaNodos.pop();
				pilaCamino.pop();
				if (pilaNodos.isEmpty()) {
					// System.out.println("pilaNodosVacia");
					break;
				} else {
					nodoPadre = pilaNodos.getTop();
					// siempre que el actual no tenga ramas

					if ((nodoActual.getLeftChild() == null) && (nodoActual.getRightChild() == null)
							&& (nodoActual.getRoot() == null)) {
					
						if (camino == true) {
							// llego al hijo por derecha, linkderecha = null
					
							nodoPadre.setRightChild(null);
						} else {
							// llego al hijo por izquierda, linkizquierda = null
							nodoPadre.setLeftChild(null);
						}
					} else {
						break;
					}
				}
			}
		}
	}

	@Override
	public IteratorIF<Integer> indexIterator() {
		// Crear una lista
		// recorrer el arbol
		// por cada nodo guardar el index
	
		QueueIF<Integer> auxCola = new Queue<>();
		IteratorIF<IndexedPair<E>> auxIter = this.btree.iterator(BTreeIF.IteratorModes.BREADTH);

		while (auxIter.hasNext()) {
			IndexedPair<E> iP = auxIter.getNext();
			if (iP != null)
				auxCola.enqueue(iP.getIndex());
		}
		return auxCola.iterator();
	}

	@Override
	public boolean contains(E e) { // iterador porque igualmente tenemos que recorrer todos los elementos
		// TODO Auto-generated method stub

		IteratorIF<E> iterador = iterator();

		while (iterador.hasNext()) {
			E iP = iterador.getNext();
			if (e.equals(iP)) {
				// encontramos el objetto
				return true;
			}
		}
		return false;
	}

	@Override
	//Reimplementacion de metodo clear 
	public void clear() {
		size = 0;
		this.btree.clear();
	}

}

