
import java.util.Iterator;

public class Lista implements Iterable<Integer> {

	private Nodo first;
	private Nodo last;
	private int size;

	public Lista() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	public void insertFront(Integer info) { // O(1)
		Nodo tmp = new Nodo(info, null); //Creo el nuevo nodo
		tmp.setNext(this.first);//el siguiente de ese nuevo nodo le inserto el primer nodo para que el nuevo quede como primero
		this.first = tmp;//Vuelvo primero al nuevo nodo
		if (this.last == null) {
			this.last = tmp;//si es la primera insercion el nuevo nodo tambien es el último
		}
		size++;//aumento en 1 el size
	}
	
	public boolean isEmpty() {
		return this.first == null; //si el first es null, esta vacio
	}

	public Integer extractFront() { //Se va a extraer la info del primer nodo y se va a eliminar
		if (!this.isEmpty()) {
			Integer info = this.first.getInfo(); // Si no esta vacio tomo la info del primer nodo
			this.first = this.first.getNext(); // Elimino el primer nodo pisandolo con el siguiente.
			this.size--; // reduzo el tamaño de la lista.
			return info; // devuelvo la información
		} else {
			return null;
		}
	}

	public Integer get(int index) { //O(n)
		if ((0 <= index) && (index < this.size())) {
			Nodo cursor = this.first;
			for (int i = 0; i < this.size(); i++) {
				cursor = cursor.getNext();
			}
			return cursor.getInfo();
		}
		return null;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		String info = "";
		Nodo tmp = this.first;
		for (int i = 0; i < this.size; i++) {
			info += tmp.getInfo();
			tmp = tmp.getNext();
		}
		return info;
	}

	public void insertLast(Integer info) { // O(1)
		Nodo tmp = new Nodo(info, null);
		if (this.last != null) {
			this.last.setNext(tmp);
		} else {
			this.first = tmp;
		}
		this.last = tmp;
		size++;

	}

	public Iterator<Integer> iterator() {
		return new Iterador(this.first);
	}

	public Iterador iteratorGene() {
		return new Iterador(this.first);
	}

}