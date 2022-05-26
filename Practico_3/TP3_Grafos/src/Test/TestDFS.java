package Test;

import Grafo.Grafo;
import Grafo.GrafoDirigido;
import Recorridos.DFS;

public class TestDFS {

	public static void main(String[] args) {

		Grafo<String> grafo = new GrafoDirigido<String>();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		
		grafo.agregarArco(1, 2, "1-2");
		grafo.agregarArco(1, 4, "1-4");
		grafo.agregarArco(2, 3, "2-3");
		grafo.agregarArco(3, 4, "3-4");
		grafo.agregarArco(3, 2, "3-2");
		grafo.agregarArco(4, 5, "4-5");
		grafo.agregarArco(3, 3, "3-3");
		grafo.agregarArco(5, 1, "5-1");
		grafo.agregarArco(5, 6, "5-6");
		grafo.agregarArco(2, 6, "2-6");
			
		DFS dfs = new DFS(grafo);
		
		System.out.println(dfs.dfs_recorrido());
		
		System.out.println("Tiene ciclos ---> " + dfs.dfs_tiene_ciclos());
		
		int origen = 1;
		int destino = 6;
		System.out.println("Existe camino entre " + origen + " y " + destino + "  --- > " + dfs.existeCamino(origen,destino));
		
		System.out.println("Camino entre " + origen + " y " + destino + "  --- > " + dfs.encontrarCamino(origen,destino));
		
		System.out.println("Caminos entre " + origen + " y " + destino + "  --- > " + dfs.encontrarCaminos(origen,destino));

	}

}
