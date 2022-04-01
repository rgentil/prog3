package resolucion;
/*
Ejercicio 4.
A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
indexOf, que reciba un elemento y retorne el índice donde está almacenado ese elemento, o
-1 si el elemento no existe en la lista.
*/

public class ListaSimple<T> {
	private Nodo<T> first;
	private int size;
	
	public ListaSimple() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Nodo<T> tmp = new Nodo<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		size++;
	}
	
	public T extractFront() {
		if (!isEmpty()) {
			T result = first.getInfo();
			first = first.getNext();
			size--;
			return result;
		}
		return null;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public T get(int index) {
		if (isEmpty() || size() < index) {
			return null;
		}
		Nodo<T> tmp = first;
		for (int i=1; i<index;i++) {
			tmp = tmp.getNext();
		}
		return tmp.getInfo();
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 1; i <= size(); i++) {
			result += " - " + this.get(i).toString();
		}
		return result;
	}
	
	public int indexOf(T elemento) {
		for (int i = 1; i <= size(); i++) {
			if (this.get(i).equals(elemento)) {
				return i;
			}
		}		
		return -1;
	}
}
