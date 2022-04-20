public class Main {

	public static void main(String[] args) {

		//Ordenamiento orden = new Ordenamiento();
		
		Timer reloj = new Timer();
		reloj.start();
		double tiempo = reloj.stop();
		System.out.println("Prueba time: " + tiempo);
		
		//Orden por seleccion menor
//		System.out.println("Orden por seleccion menor");
//		int[] arreglo = {2,6,82,1};
//		System.out.print("Original " + Arrays.toString(arreglo));		
//		System.out.println("");
//		Ordenamiento.seleccion(arreglo);
//		System.out.print("Ordenado " + Arrays.toString(arreglo));	
//		
//		System.out.println("");
//		System.out.println("------------------------------------------------------------------");
		
		//Orden por burbugeo		
//		System.out.println("Orden por burbujeo ");
//		int[] arreglo1 = {4,7,8,4,3,2,6,82,1};
//		System.out.print("Original " + Arrays.toString(arreglo1));		
//		System.out.println("");
//		Ordenamiento.burbujeo(arreglo1);
//		System.out.print("Ordenado " + Arrays.toString(arreglo1));
//		
//		System.out.println("");
//		System.out.println("------------------------------------------------------------------");
//		
		//Orden por mergesort		
//		System.out.println("Orden por mergesort ");
//		int[] arreglo2 = {1,6,9,5,2,3,11,2,1};
//		System.out.print( Arrays.toString(arreglo2));		
//		System.out.println("");
//		Ordenamiento.mergesort(arreglo2);
//		System.out.print(Arrays.toString(arreglo2));
//		
//		System.out.println("");
//		System.out.println("------------------------------------------------------------------");

		//Orden por quicksort		
//		System.out.println("Orden por quicksort ");
//		int[] arreglo3 = {5,6,9,9,4,2,1,3,4,1,2,1};
//		System.out.print( Arrays.toString(arreglo3));		
//		System.out.println("");
//		Ordenamiento.quicksort(arreglo3);
//		System.out.print(Arrays.toString(arreglo3));
		
//		Ejercicio 6.
//			Implemente una funci�n que cree un arreglo de tama�o N con n�meros aleatorios. Corra los
//			algoritmos de los ejercicios 3 y 4, 10000 veces consecutivas cada uno, y compruebe el tiempo
//			de ejecuci�n. Haga lo mismo con el m�todo Arrays.sort(...) de Java, y compare los tiempos
//			obtenidos. Investigue c�mo est� implementado el Array.sort()
		
		reloj = new Timer();
		reloj.start();
		for(int j = 0; j <9999; j++) {
			int N = 50;
			int[] a = new int[N];
			for(int i = 0; i <N; i++) {
				int randomValue = (int) (Math.random()*2000);
				a[i] = randomValue;
			}
//			System.out.println("Arreglo N Orden por mersort ");
//			System.out.print("Original " + Arrays.toString(a));		
//			System.out.println("");
			Ordenamiento.mergesort(a);
//			System.out.print("Ordenado " + Arrays.toString(a));			
//			System.out.println("");
//			System.out.println("------------------------------------------------------------------");			
		}
		tiempo = reloj.stop();
		System.out.println("Ordenamiento por mergesort tardo: " + tiempo);		
		
		reloj = new Timer();
		reloj.start();
		for(int j = 0; j <9999; j++) {
			int N = 50;
			int[] a = new int[N];
			for(int i = 0; i <N; i++) {
				int randomValue = (int) (Math.random()*1000);
				a[i] = randomValue;
			}
//			System.out.println("Arreglo N Orden por quicksort ");
//			System.out.print("Original " + Arrays.toString(a));		
//			System.out.println("");
			Ordenamiento.quicksort(a);
//			System.out.print("Ordenado " + Arrays.toString(a));			
//			System.out.println("");
//			System.out.println("------------------------------------------------------------------");			
		}
		tiempo = reloj.stop();
		System.out.println("Ordenamiento por quicksort tardo: " + tiempo);
		
		reloj = new Timer();
		reloj.start();
		for(int j = 0; j <9999; j++) {
			int N = 50;
			int[] a = new int[N];
			for(int i = 0; i <N; i++) {
				int randomValue = (int) (Math.random()*1000);
				a[i] = randomValue;
			}
//			System.out.println("Arreglo N Orden por Arrays.sort ");
//			System.out.print("Original " + Arrays.toString(a));		
//			System.out.println("");
			Ordenamiento.arraysSort(a);
//			System.out.print("Ordenado " + Arrays.toString(a));			
//			System.out.println("");
//			System.out.println("------------------------------------------------------------------");			
		}
		tiempo = reloj.stop();
		System.out.println("Ordenamiento por Arrays.sort(a) tardo: " + tiempo);
				
	}

}
