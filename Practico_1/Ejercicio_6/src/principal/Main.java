package principal;

import lista.ListaSimple;
import util.UtilList;
/*
Ejercicio 6.
	Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
	suponiendo que: 
	a) Las listas están desordenadas y la lista resultante debe quedar ordenada. 
	b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
*/
public class Main {

	public static void main(String[] args) {
		ListaSimple<String> lista1 = new ListaSimple<String>();
		lista1.insertFront("ALARMA");
		lista1.insertFront("CABEZA");
		lista1.insertFront("ORO");
		lista1.insertFront("PLATA");
		lista1.insertFront("ALMANAQUE");
		System.out.println("Lista 1 " + lista1.toString());
		
		ListaSimple<String> lista2 = new ListaSimple<String>();
		lista2.insertFront("PERRO");
		lista2.insertFront("GATO");
		lista2.insertFront("ORO");
		lista2.insertFront("HIJO");
		lista2.insertFront("TERMO");
		lista2.insertFront("ZORRO");
		lista2.insertFront("CABEZA");
		System.out.println("Lista 2 " + lista2.toString());

		UtilList util = new UtilList(lista1, lista2);
		ListaSimple<Object> union = util.union();
		System.out.println("Unión " + union);

	}

}
