package banco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//Cambio de monedas. 
//Dado un conjunto C de N tipos de monedas con un número ilimitado de
//ejemplares de cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo
//número de ellas. Por ejemplo, un cajero automático dispone de billetes de distintos valores: 100$,
//25$, 10$, 5$ y 1$, si se tiene que pagar 289$, la mejor solución consiste en dar 10 billetes: 2 de
//100$, 3 de 25$, 1 de 10$ y 4 de 1$.

public class Cajero<T> {
	//El conjunto va a tener 100, 25, 10, 5, 1

	/*
	Funcion greedy(conjunto<candidatos> C){ // Inicialmente el conjunto C contiene todos los candidatos
		conjunto<candidatos> S; // Conjunto solución, inicialmente Vacío
		while (!C.vacio() && !solucion(S)) {
			x = seleccionar(C); // determina el mejor candidatos del conjunto a seleccionar
			C.borrar(x);
			if (factible(S,x))
			S.agregar(x);
		}
		if solucion(S)
			return S
		else
			return “No_hay_solucion”;
	}
	*/
	
	private List<Billete> caja;
	
	public Cajero() {
		caja = new ArrayList<Billete>();
	}
	
	public void agregarBillete(Billete b) {
		caja.add(b);		
	}
	
	public List<Integer> extracion(Integer cantidadParaSustraer) {
		
		ordenarCaja();//Ordeno los billetes de mayor a menor para cuando tenga que ir sacando.
		
		//Tengo mis auxiliares para controlar si llego a una solucion o no.
		ArrayList<Integer> solucion = new ArrayList<>();
		Integer contador = 0;
		
		while (!cajeroVacio() && !esSolucion(contador, cantidadParaSustraer)) {
			Integer billete = sacarBillete(contador,cantidadParaSustraer);
			if (billete != null) {
				solucion.add(billete);
				contador += billete;
			}else {
				return Collections.emptyList();
			}
		}
		
		if (esSolucion(contador,cantidadParaSustraer)) {
			return solucion;
		}
		return Collections.emptyList();		
	}
	
	private boolean cajeroVacio() {
		return caja.isEmpty();
	}
	
	private boolean esSolucion(Integer contador, Integer cantidadParaSustraer) {
		return contador.equals(cantidadParaSustraer);
	}
	
	private Integer sacarBillete(Integer contador, Integer cantidadParaSustraer) {
		for (Iterator<Billete> billetes = caja.iterator(); billetes.hasNext();) {
			Billete billete = (Billete) billetes.next();
			if (!billete.disponible() ) {
				return null;
			}
			
			if ((billete.getValor() + contador) <= cantidadParaSustraer) {
				billete.sacar();
				return billete.getValor(); 
			}			
		}
		return null;
	}
	
	private void ordenarCaja() {
		Collections.sort(caja);
	}
	
	
}
