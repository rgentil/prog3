import java.util.Iterator;

public class Iterador implements Iterator<Integer>{
	
	private Nodo cursor;
	
	public Iterador(Nodo cursor) {//cada vez que lo instancien, decime desde donde arrancan
		this.cursor = cursor;
	}

	@Override
	public boolean hasNext() {//le dice al de afuera que hay elementos para iterar
		if(this.cursor!=null)
			return true;
		else
			return false;
	}

	@Override
	public Integer next() {
		Integer valor = this.cursor.getInfo();
		this.cursor = this.cursor.getNext();
		return valor;
	}
	
	public Integer valor() {
		return this.cursor.getInfo();
	}
	
	public void avanzar() {
		this.cursor = this.cursor.getNext();
	}
	

}

