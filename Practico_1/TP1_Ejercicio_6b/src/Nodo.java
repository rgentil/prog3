public class Nodo{
	private Integer info;
	private Nodo next;

	public Nodo() {
		this.info = null;
		this.next = null;
	}
	
	public Nodo(Integer info, Nodo next) {
		this.setInfo(info);
		this.setNext(next);
	}
	
	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}


}

