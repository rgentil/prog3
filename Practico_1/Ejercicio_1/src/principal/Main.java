package principal;

import resolucion.ListaSimple;

public class Main {
/*
Ejercicio 1.
Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría
(insertFront, extractFront, isEmpty, size, toString). Agregar también el método: T get(index)
*/
	public static void main(String[] args) {
		ListaSimple<Integer> lista = new ListaSimple<Integer>();
		lista.insertFront(1);
		System.out.println(lista.toString());
		lista.insertFront(22);
		System.out.println(lista.toString());
		lista.insertFront(333);
		System.out.println(lista.toString());
		lista.insertFront(444);
		System.out.println(lista.toString());
		lista.insertFront(555);
		System.out.println(lista.toString());
		
		lista.extractFront();
		System.out.println(lista.toString());
		
	}

}
