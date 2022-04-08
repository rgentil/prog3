
public class Main {

	public static void main(String[] args) {
		
		Recursividad recursividad = new Recursividad();
		
		System.out.println("Se imprime al aplilar");
		recursividad.imprimirAlApilar(5);
		
		System.out.println("Se imprime al desaplilar");
		recursividad.imprimirAlDesapilar(5);
		
		int n = 3;
		System.out.println("Factorial de " + n + " = " + recursividad.factorial(n));
		
		n = 50;
		int y = 2;
		System.out.println("Potencia de " + n + " al " + y + " = " + recursividad.potencia(n,y));
		
		int[] arr = {1,2,3,5,8,9,11,12,16,18,19,20,24,26,27,29,32,35,40,41,45,48,49,50};
		
		System.out.println("Arreglo size " + arr.length);
		
		System.out.println("El valor " + n + " se encuentra en la posición " + recursividad.busquedaBinaria(arr, n, 0, arr.length));
	
		
		/*
		Ejercicio 1.
		Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
			1. ¿Qué complejidad O tiene? (La complejidad en el peor caso) O(n)
			2. ¿Trae algún problema hacerlo recursivo? ¿Cuál? No
			3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo? Nada.

		*/
		int[] arrOrdenado = {1,3,3,4,6,7,8};
		int[] arrDesordenado= {1,2,9,5,8,9};
		System.out.println("El arreglo esta ordenado? " + recursividad.arregloOrdenado(arrOrdenado));
		
		System.out.println("El arreglo esta ordenado? " + recursividad.arregloOrdenado(arrDesordenado));
	}

}
