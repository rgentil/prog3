
public class Util {
	
	public Util() {}
	
	public Lista listaElementosEnComun(Lista lista1, Lista lista2 ){
		
		Lista resultado = new Lista();
		
		Iterador iterador1 = lista1.iteratorGene();
		Iterador iterador2 = lista2.iteratorGene();
		
		while(iterador1.hasNext() && iterador2.hasNext()) {
			if(iterador2.valor() < iterador1.valor()) {
				iterador2.avanzar();
			}
			if(iterador1.valor()<iterador2.valor()) {
				iterador1.avanzar();
			}
			if((iterador1.valor())==(iterador2.valor())) {
				Integer valorX = iterador1.valor();
				resultado.insertLast(valorX);
				iterador1.avanzar();
				iterador2.avanzar();	
			}
		}
		
		return resultado;
		
	}

}
