

public class SparseArraySequence<E> extends Collection<E> implements SparseArrayIF<E> {

	// Declaracion de la lista de pares indexados
	protected List<IndexedPair<E>> sequence = new List<>();

	public SparseArraySequence() {
		super();
	}

	@Override
	public IteratorIF<E> iterator() {
		QueueIF<E> colaAux = new Queue<>(); //creamos una cola auxiliar

		IteratorIF<IndexedPair<E>> it = sequence.iterator();
		while (it.hasNext()) {
			colaAux.enqueue(it.getNext().getValue());
		}

		return colaAux.iterator();
	}

	
	@Override
	
	//insertamos los elementos directamente ordenados 
	public void set(int pos, E elem) {
		final IteratorIF<IndexedPair<E>> it = sequence.iterator(); // creamos un itnerador sobre una secuencia 
		int posActual = 1;
		IndexedPair<E> nodoObjetivo = null;

		while (it.hasNext()) {
			final IndexedPair<E> elemento = it.getNext();
			if (pos < elemento.getIndex()) {
				// si encontramos un elemento con un indice mayor del buscado 
				// Paramos porque el indice no existe
				// Creamos un nuevo elemento en la posicion actual 
				break;
			} else if (pos == elemento.getIndex()) {
				nodoObjetivo = elemento;
				break;
			}
			posActual++;
		}

		if (nodoObjetivo == null) { //si no existe, lo creamos y actualizamos su tamaño 
			this.sequence.insert(posActual, new IndexedPair<>(pos, elem));
			this.size++;
		} else { // si no existe, lo guardamos en la posicion 
			nodoObjetivo.setValue(elem);
		}
	}

	@Override
	public E get(int pos) {
		IteratorIF<IndexedPair<E>> iterador = sequence.iterator();
		while (iterador.hasNext()) {
			IndexedPair<E> elemento = iterador.getNext();
			if (elemento.getIndex() == pos) {
				return elemento.getValue();
			}

			if (elemento.getIndex() > pos) {
				break;
			}
		}
		return null;
	}

	@Override
	public void delete(int pos) {
		IteratorIF<IndexedPair<E>> iterador = sequence.iterator();
		int posActual = 1;
		while (iterador.hasNext()) {
			IndexedPair<E> elemento = iterador.getNext();
			if (elemento.getIndex() == pos) {
				sequence.remove(posActual);
				this.size--;
				return;
			}

			posActual++;
		}
	}

	@Override
	public IteratorIF<Integer> indexIterator() {
		QueueIF<Integer> colaAux = new Queue<>(); //creamos cola auxiliar

		IteratorIF<IndexedPair<E>> it = sequence.iterator(); 
		while (it.hasNext()) {
			colaAux.enqueue(it.getNext().getIndex()); //encolamos el siguiente elemento 
		}

		return colaAux.iterator();
	}

	@Override
	public boolean contains(E e) {
		IteratorIF<E> it = iterator();
		while (it.hasNext()) { //comprueba si hay un elemento siguiente
			if (it.getNext().equals(e)) { //Lo coge y lo compara con el elemento 
				return true;
			}
		}
		return false;
	}

	@Override
	//Reimplementacion de size
	public void clear() {
		super.clear();
		sequence.clear();
	}
}
