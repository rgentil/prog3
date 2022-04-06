package util;

import lista.ListaSimple;

import iterador.IteradorLista;

/*
Ejercicio 6.
	Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
	suponiendo que: 
	a) Las listas están desordenadas y la lista resultante debe quedar ordenada. 
	b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
*/
public class UtilList {
	
	IteradorLista l1;
	IteradorLista l2;
		
	public UtilList(ListaSimple<?> l1, ListaSimple<?> l2) {
		this.l1 = l1.getIterador();
		this.l2 = l2.getIterador();
	}

	public ListaSimple<Object> union() {
		ListaSimple<Object> resultado = new ListaSimple<Object>();		
		while(l1.hasMore()) {
			Object valor1 = l1.getNext();
			l2.getFirst();
			while (l2.hasMore()) {
				Object valor2 = l2.getNext();
				if (valor1.equals(valor2)) {
					resultado.insertFront(valor1);
					//resultado.insertOrdenado(valor1);
				}
			}
		}
			
		return resultado;
	}
	
}
