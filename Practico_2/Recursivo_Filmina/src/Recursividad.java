
public class Recursividad {
	
	public void imprimirAlApilar(int x) {
		if(x>0) {
			System.out.println(x);
			imprimirAlApilar(x-1);
		}
	}

	public void imprimirAlDesapilar(int x) {
		if(x>0) {
			imprimirAlApilar(x-1);
			System.out.println(x);
		}
	}
	
	public int factorial(int n) {
		if (n>1) { //Condición de corte
			return n * factorial(n-1);
		}else {
			return 1;//Deja de calcular y empieza a desapilar
		}	
	}
	
	public int potencia (int n, int y) {
		if (y <= 0) {
			return 1;
		}else {
			return n * potencia(n, y-1);
		}
	}
	
	public int busquedaBinaria(int[] arr, int x, int inicio, int fin) {
		if (inicio > fin) {//Condición de corte
			return -1;
		}else {
			int medio = (inicio + fin)/2;
			if (x < arr[medio]) {
				return busquedaBinaria(arr, x, inicio, medio - 1);//Recursivo con la primer mitad del arrelgo
			}else {
				if (x > arr[medio]) {
					return busquedaBinaria(arr, x, medio + 1, fin);//Recursivo con la segunda mitad del arreglo
				}else {
					return medio;//Me retorna la posición del valor en el arreglo
				}
			}			
		}
	}
	
	public boolean arregloOrdenado(int[] arr, int x) {
		if (arr == null || arr.length <= 1 || arr.length <= x+1) {//Condición de corte
			return true;
		}
		if (arr[x] > arr[x+1]) {//Condición de corte
			return false;
		}else {
			return arregloOrdenado(arr, x+1);			
		}
	}
	
}
