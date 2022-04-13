
public class Main {

	public static void main(String[] args) {
		Lista miLista = new Lista();
		miLista.insertFront(7);
		miLista.insertFront(5);
		miLista.insertFront(4);
		miLista.insertFront(2);
		miLista.insertFront(0);
		
		Lista miLista2 = new Lista();
		miLista2.insertFront(7);
		miLista2.insertFront(6);
		miLista2.insertFront(4);
		miLista2.insertFront(2);
		miLista2.insertFront(0);
		
		Util util = new Util();
		
		Lista listaOrdenada = util.listaElementosEnComun(miLista, miLista2);
		
		for (Integer valor: listaOrdenada) {// Al hacer este forech, java internamente entiende lo de abajo comentado
			System.out.print(valor + " - ");//Integer valor = iterador.next();
		}
	}

}
