
public class Ordenamiento {

	public Ordenamiento() {}
	
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
	
	
	
}


