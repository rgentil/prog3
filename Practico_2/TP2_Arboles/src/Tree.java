import java.util.ArrayList;
import java.util.List;

//   Integer getRoot(), O(1)
//   boolean hasElem(Integer), O (nlog n) 
//   boolean isEmpty(), O(1) 
//   void insert(Integer), Caso promedio O(Log N) Peor de los casos O(h) h altura
//   boolean delete(Integer), Caso promedio O(Log N) Peor de los casos O(h) h altura
//   --int getHeight(), 
//   void printPosOrder(), 
//   void printPreOrder(), 
//   void printInOrder(), 
//   --List getLongestBranch(), 
//   List getFrontera(), 
//   Integer getMaxElem(), 
//   --List getElemAtLevel(int)

//1. ¿Cuál es la complejidad de cada uno de estos métodos?

public class Tree {
	
	private Nodo raiz;
	private int auxContador;
	private int altura;
	
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
	public boolean delete(Integer valor) {
		if (!this.isEmpty()) {
			if (this.raiz.getValor() == valor) {//Si lo que voy a eliminar es la raiz
				return this.delete(this.raiz,valor);
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
				if (this.esHoja(nodo)) {
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

	private boolean delete(Nodo raiz, Integer valor) {
		if (raiz == null) {
			return false;
		}		
		if (this.esHoja(raiz)) {
			this.raiz = null;
		}
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
	
	//Saber el tamanio del arbol sin usar una variable de clase
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

	//Saber el tamanio del arbol sin usando variable de clase auxContador
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
	
	public List<Integer> getFrontera(){
		ArrayList<Integer> aux = new ArrayList<Integer>();
		return getFrontera(aux,this.raiz);
	} 
	
	private List<Integer> getFrontera(ArrayList<Integer> aux, Nodo n){
		if (n == null) {
			return aux;
		}
		if (esHoja(n)) {
			aux.add(n.getValor());
		}else {
			getFrontera(aux,n.getIzquierdo());
			getFrontera(aux,n.getDerecho());
		}
		return aux;
	}

	private boolean esHoja(Nodo n) {
		return n!=null && n.getIzquierdo() == null && n.getDerecho() == null;
	}

	public int getHeight() {
		altura = 0;
		getHeight(this.raiz,altura);
		return altura;
	} 
	
	private void getHeight(Nodo n ,int nivel) {
		if (n != null) {		
			if (altura < nivel) {
				altura = nivel;
			}
			getHeight(n.getIzquierdo(), nivel+1);
			getHeight(n.getDerecho(), nivel+1);			
		}		
	}
	
}
