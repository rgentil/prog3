

//   Integer getRoot(), O(1)
//   boolean hasElem(Integer), O (nlog n) 
//   boolean isEmpty(), O(1) 
//   void insert(Integer), Caso promedio O(Log N) Peor de los casos O(h) h altura
//   --boolean delete(Integer), Caso promedio O(Log N) Peor de los casos O(h) h altura
//   --int getHeight(), 
//   void printPosOrder(), 
//   void printPreOrder(), 
//   void printInOrder(), 
//   --List getLongestBranch(), 
//   --List getFrontera(), 
//   Integer getMaxElem(), 
//   --List getElemAtLevel(int)

//1. ¿Cuál es la complejidad de cada uno de estos métodos?

public class Tree {
	
	private Nodo raiz;
	private int auxContador;
	
	public Tree() {
		this.raiz = null;
	}
	
	//Arbol vacio
	public boolean isEmpty() {
		return this.raiz == null;
	}
	
	//Consultar la raiz del arbol
	public Integer getRoot() {
		if (!isEmpty()) {
			return getRootTree();
		}else {
			return -1;
		}
	}
	
	private Integer getRootTree(){
		return this.raiz.getValor();
	}

	//Cnsulta si existe un elemento en el arbol
	public boolean hasElem(Integer valor) {
		return hasElem(this.raiz, valor);
	}
	
	private boolean hasElem(Nodo nodo, Integer valor) {
		if (nodo == null) {
	        return false;
	    }
		if(nodo.getValor() == valor) {
			return true;
		}else {
			if (valor < nodo.getValor()) {
				return hasElem(nodo.getIzquierdo(),valor);
			}else {
				return hasElem(nodo.getDerecho(),valor);
			}	
		}
				
	}
	
	//Inserta un elemento en el arbol
	public void insert(Integer valor) {
		if (isEmpty()) {
			Nodo nuevo = new Nodo(valor);
			raiz = nuevo;
		}else {
			this.insert(this.raiz, valor);
		}
	}

	private void insert(Nodo nodo, Integer valor) {
		if (valor < nodo.getValor() ) { //va para la izquierda
			if (nodo.getIzquierdo() == null) { //si es null inserto
				Nodo nuevo = new Nodo(valor);
				nodo.setIzquierdo(nuevo);
			}else {
				insert(nodo.getIzquierdo(),valor);//sino sigo buscando
			}
		}else {
			if (nodo.getValor() < valor) { //va para la derecha
				if (nodo.getDerecho() == null) { //si es null inserto
					Nodo nuevo = new Nodo(valor);
					nodo.setDerecho(nuevo);
				}else {
					insert(nodo.getDerecho(),valor);//sino sigo buscando por la derecha
				}
			}
		}
	}
	
	//Eliminar un elemento
	/*public boolean delete(Integer valor) {
		return this.delete (this.raiz, valor);
	}
	
	private boolean delete(Nodo nodo, Integer valor) {
		if (nodo == null) {
			return false;
		}
		if (valor > nodo.getValor()) { //Va por izquierda
			return delete(nodo.getIzquierdo(), valor);
		}else {
			if (valor < nodo.getValor()) { //Va por izquierda
				return delete(nodo.getDerecho(), valor);
			}else {
				if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
					// es hoja
				}else {
					if (nodo.getIzquierdo() == null && nodo.getDerecho() != null) {
					//	uno solo
					}
					else {
						if (nodo.getIzquierdo() != null && nodo.getDerecho() == null) {
							//uno solo
						}else {
							//complejo
						}
					}
				}
				
			}
		}
	}
	*/

	//Mayor elemento del arbol
	public Integer getMaxElem() {
		return getMaxElem(this.raiz);
	}
	
	private Integer getMaxElem(Nodo n) {
		if (isEmpty()) return -1;
		if (n.getDerecho() == null) {
			return n.getValor();
		}else {
			return getMaxElem(n.getDerecho());
		}
	}
	
	//Imprimi de la forma pre roden
	public void printPreOrder() {
	    this.printPreOrder(this.raiz);
	    System.out.println("");
	    System.out.println("-----------------------------------------------------------------");
	}
	
	private void printPreOrder(Nodo nodo) {
	    if (nodo != null) {
	        nodo.imprimirValor();
	        printPreOrder(nodo.getIzquierdo());
	        printPreOrder(nodo.getDerecho());
	    }
	}

	//Imprimi de la forma in roden
	public void printInOrder() {
	    this.printInOrder(this.raiz);
	    System.out.println("");
	    System.out.println("-----------------------------------------------------------------");
	}
	
	private void printInOrder(Nodo n) {
	    if (n != null) {
	    	printInOrder(n.getIzquierdo());
	        n.imprimirValor();
	        printInOrder(n.getDerecho());
	    }
	}
	
	//Imprimi de la forma pos roden
	public void printPosOrder() {
	    this.printPosOrder(this.raiz);
	    System.out.println("");
	    System.out.println("-----------------------------------------------------------------");
	}
	
	private void printPosOrder(Nodo n) {
	    if (n != null) {
	    	printPosOrder(n.getIzquierdo());
	    	printPosOrder(n.getDerecho());
	        n.imprimirValor();
	    }
	}
	
	public int sizee() {
		return sizee(this.raiz);
	}
	
	private int sizee (Nodo n) {
		if (n != null) {
			return 1 + sizee(n.getIzquierdo()) + sizee(n.getDerecho()) ;
		}else {
			return 0;
		}
	}

	public int size() {
		setAuxContador(0);
		size(this.raiz);
		return getAuxContador();
	}
	
	private void size (Nodo n) {
		if (n != null) {
			aumentarAuxiliarContador();
			size(n.getIzquierdo());
			size(n.getDerecho());
		}
	}
	
	private void aumentarAuxiliarContador() {
		this.auxContador++;		
	}

	public int getAuxContador() {
		return auxContador;
	}

	public void setAuxContador(int auxContador) {
		this.auxContador = auxContador;
	}
	

}
