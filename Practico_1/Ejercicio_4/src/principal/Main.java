package principal;

import resolucion.ListaSimple;

public class Main {
/*
Ejercicio 4.
A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
indexOf, que reciba un elemento y retorne el índice donde está almacenado ese elemento, o
-1 si el elemento no existe en la lista.
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
		
		System.out.println("El elemento 22 está en la posición : " + lista.indexOf(22));
		
		System.out.println("El elemento 1 está en la posición : " + lista.indexOf(1));
		
		System.out.println("El elemento 444 está en la posición : " + lista.indexOf(444));
		
		System.out.println("El elemento 555 está en la posición : " + lista.indexOf(555));
		
		
	}

}
