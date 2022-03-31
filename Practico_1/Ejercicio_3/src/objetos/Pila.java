package objetos;

/*
Ejercicio 3.
	Implemente una Pila utilizando la Lista del ejercicio 1. A una pila se le pueden agregar
	elementos utilizando el método push(T o). Para retirar elementos de la colección se utiliza el
	método pop(), que retorna el último elemento agregado a la colección y lo elimina de la
	misma. Es posible consultar el tope de la pila (sin eliminarlo) utilizando el método top(). Por
	último, es posible invertir el orden de los elementos de la pila mediante el método reverse().

*/
public class Pila<T> {

	private ListaSimple<T> lista;
	
	public Pila() {
		lista = new ListaSimple<T>();
	}
	
	public void push(T objeto) {
		lista.insertFront(objeto);
	}
	
	public T pop() {
		return lista.extractFront();
	}
	
	public T top() {
		return lista.get(1);
	}
	
	public void reverse() {
		ListaSimple<T> lista_resultado = new ListaSimple<T>();
		int size = lista.size();
		for (int i = 0; i < size; i++) {
			lista_resultado.insertFront(lista.extractFront());
		}
		lista = lista_resultado;
	}
	
	@Override
	public String toString() {
		return lista.toString();
	}
}
