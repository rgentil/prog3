package test;

import banco.Billete;
import banco.Cajero;


//Cambio de monedas. 
//Dado un conjunto C de N tipos de monedas con un número ilimitado de
//ejemplares de cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo
//número de ellas. Por ejemplo, un cajero automático dispone de billetes de distintos valores: 100$,
//25$, 10$, 5$ y 1$, si se tiene que pagar 289$, la mejor solución consiste en dar 10 billetes: 2 de
//100$, 3 de 25$, 1 de 10$ y 4 de 1$.

public class Test {

	public static void main(String[] args) {
		
		Cajero cajero = new Cajero();
		
		Billete b100 = new Billete(100,5000);
		Billete b25 = new Billete(25,5000);
		Billete b10 = new Billete(10,5000);
		Billete b5 = new Billete(5,5000);
		Billete b1 = new Billete(1,5000);
		//Billete b1 = new Billete(1,000);
		
		cajero.agregarBillete(b5);
		cajero.agregarBillete(b1);
		cajero.agregarBillete(b25);
		cajero.agregarBillete(b100);
		cajero.agregarBillete(b10);
		
		System.out.println(cajero.extracion(289));
		

	}

}
