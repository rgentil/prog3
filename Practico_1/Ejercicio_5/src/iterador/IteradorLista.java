package iterador;

import resolucion.ListaSimple;

public class IteradorLista implements Iterador{

	private ListaSimple<?> lista;
    private int posicion_actual;
	
    public IteradorLista(ListaSimple<?> lista) {
    	this.lista = lista;
    	posicion_actual = 1;
    }
    
	@Override
	public Object getFirst() {
		Object valor = null;
		if(!lista.isEmpty()){
			posicion_actual = 1;
	        valor = lista.get(posicion_actual);
		}
		return valor;
	}

	@Override
	public Object getNext() {
		Object valor = null;
        if(this.hasMore()){
        	valor = lista.get(posicion_actual);
            posicion_actual ++;
        }
        return valor;
	}

	@Override
	public boolean hasMore() {
		return posicion_actual <= lista.size();
	}

	@Override
	public Object actual() {
		Object valor = null;
		if(hasMore()){
			valor = lista.get(posicion_actual);
        }
        return valor;
	}

}
