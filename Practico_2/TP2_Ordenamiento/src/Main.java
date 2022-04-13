public class Main {

	public static void main(String[] args) {

		Ordenamiento orden = new Ordenamiento();
		
		//Orden por seleccion menor
		System.out.println("Orden por seleccion menor");
		int[] arreglo = {2,6,82,1};
		int[] aOrdenado = orden.seleccion(arreglo);
		for (int i = 0; i < aOrdenado.length; i++) {
			System.out.print(aOrdenado[i] + " ");
		} 		
		System.out.println("------------------------------------------------------------------");
		
		//Orden por burbugeo		
		System.out.println("Orden por burbujeo ");
		int[] arreglo1 = {4,7,8,4,3,2,6,82,1};
		int[] aOrdenado1 = orden.burbujeo(arreglo1);
		for (int i = 0; i < aOrdenado1.length; i++) {
			System.out.print(aOrdenado1[i] + " ");
		} 		
	}

}
