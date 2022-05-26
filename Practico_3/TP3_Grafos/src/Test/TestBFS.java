package Test;

import Grafo.Grafo;
import Grafo.GrafoDirigido;
import Recorridos.BFS;

public class TestBFS {

	public static void main(String[] args) {

		Grafo<String> grafo = new GrafoDirigido<String>();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		
		grafo.agregarArco(1, 2, "1-2");
		grafo.agregarArco(1, 4, "1-4");
		grafo.agregarArco(2, 3, "2-3");
		grafo.agregarArco(3, 4, "3-4");
		//grafo.agregarArco(3, 2, "3-2");
		grafo.agregarArco(4, 5, "4-5");
		//grafo.agregarArco(3, 3, "3-3");
		//grafo.agregarArco(5, 1, "5-1");
			
		BFS bfs = new BFS(grafo);
		
		System.out.println(bfs.bfs_recorrido());
		
		/*
		System.out.println("Tiene ciclos ---> " + dfs.dfs_tiene_ciclos());
		
		int origen = 3;
		int destino = 5;
		System.out.println("Existe camino entre " + origen + " y " + destino + "  --- > " + dfs.existeCamino(origen,destino));
		*/

	}

}
