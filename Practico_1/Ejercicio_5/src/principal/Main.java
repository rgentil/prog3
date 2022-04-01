package principal;

import iterador.IteradorLista;
import resolucion.ListaSimple;

public class Main {
/*
Ejercicio 5.
A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
iterator-iterable, para que la lista sea iterable. 


¿Existe alguna ventaja computacional a la
hora de recorrer la lista de principio a fin si se cuenta con un iterador?

Crearía que no, pero habrá que preguntar....

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
		
		//Creación del iterador
    	IteradorLista iterador = lista.getIterador();
    	
    	System.out.println("Valor en la posición actual => " + iterador.actual());  
    	
    	System.out.println("Inicio de iteración - Recorrido con el iterador");
    	
    	while (iterador.hasMore()) {
            System.out.println(" -- " + iterador.getNext());  
    	}
    	
    	System.out.println(" Valor en la posición actual al fina => " + iterador.actual());  
    	
    	System.out.println(" Valor en la posición incial y reinicia el iterador y lo coloca en la primera posción => " + iterador.getFirst());
    	
    	System.out.println(" Por ende el valor en la posición actual => " + iterador.actual());
    	
    	
	}

}
