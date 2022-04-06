
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
		if (n>1) { //Condicion de corte
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
	
}
