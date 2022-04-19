import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Ordenamiento orden = new Ordenamiento();
		
		//Orden por seleccion menor
		System.out.println("Orden por seleccion menor");
		int[] arreglo = {2,6,82,1};
		for (int i = 0; i < arreglo.length; i++) {
			System.out.print(arreglo[i] + " ");
		}
		System.out.println("");
		int[] aOrdenado = orden.seleccion(arreglo);
		for (int i = 0; i < aOrdenado.length; i++) {
			System.out.print(aOrdenado[i] + " ");
		} 		
		
		System.out.println("");
		System.out.println("------------------------------------------------------------------");
		
		//Orden por burbugeo		
		System.out.println("Orden por burbujeo ");
		int[] arreglo1 = {4,7,8,4,3,2,6,82,1};
		for (int i = 0; i < arreglo1.length; i++) {
			System.out.print(arreglo1[i] + " ");
		}
		System.out.println("");
		int[] aOrdenado1 = orden.burbujeo(arreglo1);
		for (int i = 0; i < aOrdenado1.length; i++) {
			System.out.print(aOrdenado1[i] + " ");
		}
		
		System.out.println("");
		System.out.println("------------------------------------------------------------------");
		
		//Orden por mergesort		
		System.out.println("Orden por mergesort ");
		int[] arreglo2 = {2,1,8,5,43,2,2,56,5};
		for (int i = 0; i < arreglo2.length; i++) {
			System.out.print(arreglo2[i] + " ");
		}
		System.out.println("");
		int[] aOrdenado2 = orden.mergesort(arreglo2);
		for (int i = 0; i < aOrdenado2.length; i++) {
			System.out.print(aOrdenado2[i] + " ");
		} 	
		
		System.out.println("");
		System.out.println("------------------------------------------------------------------");

		//Orden por quicksort		
		System.out.println("Orden por quicksort ");
		int[] arreglo3 = {2,1,8,3,9,2,1,2};
		System.out.print( Arrays.toString(arreglo3));
		
		System.out.println("");
		int[] aOrdenado3 = orden.quicksort(arreglo3);
		System.out.print(Arrays.toString(aOrdenado3));
		
		
	}

}
