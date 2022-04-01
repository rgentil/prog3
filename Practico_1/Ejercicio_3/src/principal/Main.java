package principal;

import objetos.Pila;

public class Main {

	public static void main(String[] args) {
		Pila<Integer> pila = new Pila<Integer>();
		
		pila.push(1);
		System.out.println("Agrego 1 " + pila.toString());

		pila.push(22);
		System.out.println("Agrego 22 " + pila.toString());
		
		pila.push(333);
		System.out.println("Agrego 333 " + pila.toString());
		
		pila.push(4444);
		System.out.println("Agrego 1223334444 " + pila.toString());

		pila.reverse();
		System.out.println("Pila reverse " + pila.toString());
		
		pila.pop();
		System.out.println("Se saca el 4444 " + pila.toString());
		
		
		System.out.println("Valor en top de la pila " + pila.top());

		
	}

}
