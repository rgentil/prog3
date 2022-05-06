import java.util.ArrayList;
import java.util.List;

//   Integer getRoot(), O(1)
//   boolean hasElem(Integer), O (nlog n) si es un arbol balanceado
//   boolean isEmpty(), O(1) 
//   void insert(Integer), Caso promedio O(Log N) Peor de los casos O(h) h altura
//   boolean delete(Integer), Caso promedio O(Log N) Peor de los casos O(h) h altura
//   int getHeight(), 
//   void printPosOrder(), 
//   void printPreOrder(), 
//   void printInOrder(), 
//   List getLongestBranch(), 
//   List getFrontera(), 
//   Integer getMaxElem(), 
//   List getElemAtLevel(int)

//1. ¿Cuál es la complejidad de cada uno de estos métodos?

public class Tree {
	
	private Nodo raiz;
	
	public Tree() {
		this.raiz = null;
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
	
	private boolean isHoja(Nodo n) {
		return n!=null && n.getIzquierdo() == null && n.getDerecho() == null;
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
	
	//Arbol vacio
	public boolean isEmpty() {
		return this.raiz == null;
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
	public boolean delete(Integer valor) {
		if (!this.isEmpty()) {
			if (this.raiz.getValor() == valor) {//Si lo que voy a eliminar es la raiz
				return this.delete(this.raiz);
			}
			return this.delete(this.raiz,this.raiz, valor);//Si no es la raiz paso un padre y el nodo
		}
		return false;
	}
	
	private boolean delete(Nodo padre, Nodo nodo, Integer valor) {
		if (nodo == null) {
			return false;
		}
		if (valor > nodo.getValor()) { //Va por derecha
			return delete(nodo, nodo.getDerecho(), valor);
		}else {
			if (valor < nodo.getValor()) { //Va por izquierda
				return delete(nodo, nodo.getIzquierdo(), valor);
			}else {
				if (this.isHoja(nodo)) {
					// es hoja
					return this.deleteHoja(padre, valor);					
				}else {
					if (nodo.getIzquierdo() == null && nodo.getDerecho() != null) {
						//uno solo hijo derecho
						return this.deleteNodoDeUnHijo(padre,nodo.getDerecho(),valor);
					}
					else {
						if (nodo.getIzquierdo() != null && nodo.getDerecho() == null) {
							//uno solo hijo izquierdo
							return this.deleteNodoDeUnHijo(padre,nodo.getIzquierdo(),valor);
						}else {
							//Si no es la raiz
							if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
								Nodo aux = getNodoMaxElem(nodo.getIzquierdo());//Del izquierdo tomo el mayor
								delete(aux.getValor()); //Elimino el valor mayor encontrado
								if (padre.getIzquierdo() != null && padre.getIzquierdo().getValor() == valor) {//Si es el hijo izquierdo el que voy a eliminar
									aux.setIzquierdo(nodo.getIzquierdo());
									aux.setDerecho(nodo.getDerecho());
									padre.setIzquierdo(aux);
								}
								
								if (padre.getDerecho() != null && padre.getDerecho().getValor() == valor) {//Si es el hijo derecho el que voy a eliminar
									aux.setIzquierdo(nodo.getIzquierdo());
									aux.setDerecho(nodo.getDerecho());
									padre.setDerecho(aux);
								}
								
							}
							return true;
						}
					}
				}
			}
		}
	}
	
	private boolean deleteNodoDeUnHijo(Nodo padre, Nodo nodo, Integer valor) {
		if (padre.getIzquierdo() != null && padre.getIzquierdo().getValor() == valor) {//Si es el hijo izquierdo el que voy a eliminar 
			padre.setIzquierdo(nodo);
			return true;
		}
		if (padre.getDerecho() != null && padre.getDerecho().getValor() == valor) { //Si es el hijo derecho el que voy a eliminar
			padre.setDerecho(nodo);
			return true;
		}
		return false;
	}

	private boolean deleteHoja(Nodo padre, Integer valor) {
		if (padre.getIzquierdo() != null && padre.getIzquierdo().getValor() == valor) { //Si es el hijo izquierdo el que voy a eliminar
			padre.setIzquierdo(null);
			return true;
		}
		if (padre.getDerecho() != null && padre.getDerecho().getValor() == valor) { //Si es el hijo derecho el que voy a eliminar
			padre.setDerecho(null);
			return true;
		}
		return false;
	}

	private boolean delete(Nodo raiz) {	
		if (raiz.getIzquierdo() == null && raiz.getDerecho() != null) {
			this.raiz = raiz.getDerecho();
		}
		if (raiz.getIzquierdo() != null && raiz.getDerecho() == null) {
			this.raiz = raiz.getIzquierdo();
		}
		if (raiz.getIzquierdo() != null && raiz.getDerecho() != null) {
			Nodo aux = getNodoMaxElem(raiz.getIzquierdo());
			delete(aux.getValor()); //Elimino el valor mayor encontrado
			aux.setDerecho(raiz.getDerecho());
			aux.setIzquierdo(raiz.getIzquierdo());
			this.raiz = aux;			
		}
		return false;
	}
	
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
	
	//Mayor Nodo 
	private Nodo getNodoMaxElem(Nodo n) {
		if (isEmpty()) return null;
		if (n == null || n.getDerecho() == null) {
			return n;
		}else {
			return getNodoMaxElem(n.getDerecho());
		}
	}
	
	//Menor elemento del arbol
	public Integer getMinElem() {
		return getMinElem(this.raiz);
	}
	
	private Integer getMinElem(Nodo n) {
		if (isEmpty()) return -1;
		if (n.getIzquierdo() == null) {
			return n.getValor();
		}else {
			return getMinElem(n.getIzquierdo());
		}
	}
	
	//Menor Nodo 
	/*private Nodo getNodoMinElem(Nodo n) {
		if (isEmpty()) return null;
		if (n == null || n.getIzquierdo() == null) {
			return n;
		}else {
			return getNodoMinElem(n.getIzquierdo());
		}
	}*/
	
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
	
	public int size() {
		return size(this.raiz);
	}
	
	private int size (Nodo n) {
		if (n == null) {
			return 0;
		}
		if (this.isHoja(n)) {
			return 1;
		}else {
			return 1 + size(n.getIzquierdo()) + size(n.getDerecho()) ;
		}
	}
	
	public List<Integer> getFrontera(){
		return getFrontera(this.raiz);
	} 
	
	private List<Integer> getFrontera(Nodo n){
		ArrayList<Integer> aux = new ArrayList<Integer>();
		if (n != null) {
			if (isHoja(n)) {
				aux.add(n.getValor());
			}else {
				aux.addAll(getFrontera(n.getIzquierdo()));
				aux.addAll(getFrontera(n.getDerecho()));
			}
		}
		return aux;
	}

	public int getHeight() {
		return getHeight(this.raiz);
	} 
	
	private int getHeight(Nodo n) {
		if (isHoja(n)) {
			return 0;
		}else {
			int alturaIzq = 0;
			int alturaDer = 0;
			if (n.getIzquierdo() != null && n.getDerecho() == null) {
				alturaIzq = 1 + getHeight(n.getIzquierdo());
			}else {	
				if (n.getIzquierdo() == null && n.getDerecho() != null) {
					alturaDer = 1 + getHeight(n.getDerecho());
				}else {
					if (n.getIzquierdo() != null && n.getDerecho() != null) {
						alturaIzq = 1 + getHeight(n.getIzquierdo());
						alturaDer = 1 + getHeight(n.getDerecho());						
					}	
				}
			}
			return alturaIzq > alturaDer ? alturaIzq : alturaDer;
		}		
	
	}
	
	public List<Integer> getElemAtLevel(int nivel) {
		return getElemAtLevel(this.raiz,0, nivel);
	}
	
	private List<Integer> getElemAtLevel(Nodo n, int nivelActual, int nivel){
		ArrayList<Integer> aux = new ArrayList<Integer>();
		if (n != null) {
			if (nivelActual == nivel) {
				aux.add(n.getValor());			
			}else {
				aux.addAll(getElemAtLevel(n.getIzquierdo(),nivelActual+1,nivel));
				aux.addAll(getElemAtLevel(n.getDerecho(),nivelActual+1,nivel));
			}		
		}
		return aux;
	}
	
	
	public List<Integer> getLongestBranch() {
		return getLongestBranch(this.raiz);
	}
	
	private List<Integer> getLongestBranch(Nodo n) {
		ArrayList<Integer> auxI = new ArrayList<Integer>();
		ArrayList<Integer> auxD = new ArrayList<Integer>();
		if (isHoja(n)) {
			auxI.add(n.getValor());
			auxD.add(n.getValor());
		}else {
			if (n.getIzquierdo() != null && n.getDerecho() == null) {
				auxI.add(n.getValor());
				auxI.addAll(getLongestBranch(n.getIzquierdo()));				
			}else {	
				if (n.getIzquierdo() == null && n.getDerecho() != null) {
					auxD.add(n.getValor());
					auxD.addAll(getLongestBranch(n.getDerecho()));
				}else {
					if (n.getIzquierdo() != null && n.getDerecho() != null) {
						auxI.add(n.getValor());
						auxD.add(n.getValor());
						auxI.addAll(getLongestBranch(n.getIzquierdo()));
						auxD.addAll(getLongestBranch(n.getDerecho()));						
					}	
				}
			}			
		}
		return auxI.size() > auxD.size() ? auxI : auxD;
		
	}
}
