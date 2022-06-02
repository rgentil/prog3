package banco;

public class Billete implements Comparable<Billete>{
	
	private Integer valor;
	private Integer cantidad;
	
	public Billete(Integer valor, Integer cantidad) {
		this.valor = valor;
		this.cantidad = cantidad;
	}
	
	public void addCantidad(Integer cantidad) {
		this.cantidad += cantidad;
	}
	
	public void sacar() {
		this.cantidad --;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public boolean disponible() {
		return cantidad > 0;
	}

	@Override
	public int compareTo(Billete o) {
		return o.getValor().compareTo(this.getValor());
	}
	
	

}
