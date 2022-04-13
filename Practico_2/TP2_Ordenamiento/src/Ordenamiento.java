
public class Ordenamiento {

	public Ordenamiento() {}
	
	/*
	El método de ordenación por selección consiste en repetir los siguientes pasos:
		Se busca el elemento más pequeño del array y se coloca en la primera posición.
		Entre los restantes, se busca el elemento más pequeño y se coloca en la segunda posición.
		Entre los restantes se busca el elemento más pequeño y se coloca en la tercera posición.
	*/
	
	//Tiempo de ejecución O(n2)
	public int[] seleccion(int a[]) {
		for(int i=0; i < a.length-1; i++) { //Voy a recorrer todo el arreglo
			int menor = a[i]; //Tomo como menor el primero y guardo el valor y la posicion en el que esta
			int pos_menor = i;
			for(int y = i+1; y < a.length; y++) {//Empiezo a recorrer el arreglo
				if (a[y]<menor) {//si encuentro un menor guardo el valor menor y la posicion del menor
					menor = a[y];
					pos_menor = y;
				}
				if(pos_menor != i) { //Si resulta que encontre un menor por lo tanto cambio la posicion. pongo el valor menor primero. 
					int aux = a[i];
					a[i] = a[pos_menor];
					a[pos_menor] = aux;
				}
			}
		}			
		return a;		 	
	}
	

	/*
	Consiste en comparar pares de elementos adyacentes en un array y si
	están desordenados intercambiarlos hasta que estén todos ordenados.
	El elemento mayor sube como una burbuja hacia la posición más alta. 
	*/
	//Tiempo de ejecución O(n2)
	public int[] burbujeo(int a[]) {
		for (int i=0; i<a.length-1;i++) {
			for (int y=i+1; y<a.length;y++) {
				if (a[i] > a[y]) {
					int aux = a[i];
					a[i] = a[y];
					a[y] = aux;
				}
			}			
		}
		return a;
		
	}
	
	
}


