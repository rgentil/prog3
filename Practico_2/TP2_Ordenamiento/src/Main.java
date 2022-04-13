public class Main {

	public static void main(String[] args) {

		Ordenamiento orden = new Ordenamiento();
		
		int[] arreglo = {2,6,82,1};
		
		int[] aOrdenado = orden.seleccion(arreglo);
		
		for (int i = 0; i < aOrdenado.length; i++) {
			System.out.print(aOrdenado[i] + " ");
		} 		
	}

}
