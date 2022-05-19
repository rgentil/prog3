package Test;

import Grafo.Grafo;
import Grafo.GrafoDirigido;
import Recorridos.DFS;

public class Main {

	public static void main(String[] args) {

		Grafo<String> grafo = new GrafoDirigido<String>();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		
		grafo.agregarArco(1, 2, "1-2");
		grafo.agregarArco(1, 4, "1-4");
		/*grafo.agregarArco(2, 3, "2-3");
		grafo.agregarArco(3, 4, "3-4");
		grafo.agregarArco(3, 2, "3-2");
		grafo.agregarArco(4, 5, "1-2");
		*/
		
		DFS dfs = new DFS(grafo);
		
		System.out.println(dfs.dfs_recorrido());
		
		System.out.println(dfs.dfs_tiene_ciclos());

	}

}
