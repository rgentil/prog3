import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		//Ordenamiento orden = new Ordenamiento();
		
		//Orden por seleccion menor
		System.out.println("Orden por seleccion menor");
		int[] arreglo = {2,6,82,1};
		System.out.print("Original " + Arrays.toString(arreglo));		
		System.out.println("");
		Ordenamiento.seleccion(arreglo);
		System.out.print("Ordenado " + Arrays.toString(arreglo));	
		
		System.out.println("");
		System.out.println("------------------------------------------------------------------");
		
		//Orden por burbugeo		
		System.out.println("Orden por burbujeo ");
		int[] arreglo1 = {4,7,8,4,3,2,6,82,1};
		System.out.print("Original " + Arrays.toString(arreglo1));		
		System.out.println("");
		Ordenamiento.burbujeo(arreglo1);
		System.out.print("Ordenado " + Arrays.toString(arreglo1));
		
		System.out.println("");
		System.out.println("------------------------------------------------------------------");
		
		//Orden por mergesort		
		System.out.println("Orden por mergesort ");
		int[] arreglo2 = {1,6,9,5,2,3,11,2,1};
		System.out.print( Arrays.toString(arreglo2));		
		System.out.println("");
		Ordenamiento.mergesort(arreglo2);
		System.out.print(Arrays.toString(arreglo2));
		
		System.out.println("");
		System.out.println("------------------------------------------------------------------");

		//Orden por quicksort		
		System.out.println("Orden por quicksort ");
		int[] arreglo3 = {5,6,9,9,4,2,1,3,4,1,2,1};
		System.out.print( Arrays.toString(arreglo3));		
		System.out.println("");
		Ordenamiento.quicksort(arreglo3);
		System.out.print(Arrays.toString(arreglo3));
		
//		Ejercicio 6.
//			Implemente una función que cree un arreglo de tamaño N con números aleatorios. Corra los
//			algoritmos de los ejercicios 3 y 4, 10000 veces consecutivas cada uno, y compruebe el tiempo
//			de ejecución. Haga lo mismo con el método Arrays.sort(...) de Java, y compare los tiempos
//			obtenidos. Investigue cómo está implementado el Array.sort()

		
		for(int j = 0; j <9999; j++) {
			int N = 50;
			int[] a = new int[N];
			for(int i = 0; i <N; i++) {
				int randomValue = (int) (Math.random()*2000);
				a[i] = randomValue;
			}
			System.out.println("Arreglo N Orden por mersort ");
			System.out.print("Original " + Arrays.toString(a));		
			System.out.println("");
			Ordenamiento.mergesort(a);
			System.out.print("Ordenado " + Arrays.toString(a));			
			System.out.println("");
			System.out.println("------------------------------------------------------------------");			
		}
		
		for(int j = 0; j <9999; j++) {
			int N = 50;
			int[] a = new int[N];
			for(int i = 0; i <N; i++) {
				int randomValue = (int) (Math.random()*1000);
				a[i] = randomValue;
			}
			System.out.println("Arreglo N Orden por quicksort ");
			System.out.print("Original " + Arrays.toString(a));		
			System.out.println("");
			Ordenamiento.quicksort(a);
			System.out.print("Ordenado " + Arrays.toString(a));			
			System.out.println("");
			System.out.println("------------------------------------------------------------------");			
		}
		
		for(int j = 0; j <9999; j++) {
			int N = 50;
			int[] a = new int[N];
			for(int i = 0; i <N; i++) {
				int randomValue = (int) (Math.random()*1000);
				a[i] = randomValue;
			}
			System.out.println("Arreglo N Orden por Arrays.sort ");
			System.out.print("Original " + Arrays.toString(a));		
			System.out.println("");
			Ordenamiento.ArraysSort(a);
			System.out.print("Ordenado " + Arrays.toString(a));			
			System.out.println("");
			System.out.println("------------------------------------------------------------------");			
		}
				
	}

}
