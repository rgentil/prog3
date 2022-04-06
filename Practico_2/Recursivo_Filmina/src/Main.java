
public class Main {

	public static void main(String[] args) {
		
		Recursividad recursividad = new Recursividad();
		
		System.out.println("Se imprime al aplilar");
		recursividad.imprimirAlApilar(5);
		
		System.out.println("Se imprime al desaplilar");
		recursividad.imprimirAlDesapilar(5);
		
		int n = 3;
		System.out.println("Factorial de " + n + " = " + recursividad.factorial(n));
		
		n = 5;
		int y = 2;
		System.out.println("Potencia de " + n + " al " + y + " = " + recursividad.potencia(n,y));
		
	}

}
