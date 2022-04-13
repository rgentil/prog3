package iterador;

import java.util.Iterator;

import resolucion.ListaSimple;

public class IteratorList implements Iterator<Object>{
	
	private ListaSimple<?> lista;
    private int pos;
	
	public IteratorList(ListaSimple<?> lista) {
		this.lista = lista;
		this.pos = 1;
	}
	
	@Override
	public boolean hasNext() {
		return pos <= lista.size();
	}

	@Override
	public Object next() {
		Object valor = null;
	    if(this.hasNext()){
	    	valor = lista.get(pos);	
	        pos ++;
	    }
	    return valor;
	}

}
