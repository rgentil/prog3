
public class Nodo {

	private Integer valor;
	private Nodo izquierdo;
	private Nodo derecho;
	
	public Nodo(Integer valor) {
		this.valor = valor;
		this.izquierdo = null;
		this.derecho = null;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Nodo getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(Nodo izquierdo) {
		this.izquierdo = izquierdo;
	}

	public Nodo getDerecho() {
		return derecho;
	}

	public void setDerecho(Nodo derecho) {
		this.derecho = derecho;
	}	
	
	public void imprimirValor() {
		System.out.print("(" + this.getValor() + ")");
		if (this.getIzquierdo() == null) {
			System.out.print("-");
		}
		if (this.getDerecho() == null) {
			System.out.print("-");
		}
	}
	
}
