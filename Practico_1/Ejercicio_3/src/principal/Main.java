package principal;

import objetos.Pila;

public class Main {

	public static void main(String[] args) {
		Pila<Integer> pila = new Pila<Integer>();
		
		pila.push(1);
		System.out.println(pila.toString());

		pila.push(22);
		System.out.println(pila.toString());
		
		pila.push(333);
		System.out.println(pila.toString());
		
		pila.push(4444);
		System.out.println(pila.toString());

		pila.reverse();
		System.out.println(pila.toString());
		
		pila.pop();
		System.out.println(pila.toString());
		
		pila.top();
		System.out.println(pila.toString());

		
	}

}
