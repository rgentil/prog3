package Recorridos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Grafo.Grafo;
import Util.Index;

/*
	DFS (Depth-First Search)
	Recorrido en profundidad
	
 */
public class DFS {

	private Grafo<?> grafo;
	private HashMap<Integer,Index> colores;
	
	public DFS(Grafo<?> g) {
		this.grafo = g;
		this.colores = new HashMap<>();
	}
	
	private void iniciarEstructura() {
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {
			Integer vertice = (Integer) vertices.next();
			colores.put(vertice, Index.BLANCO);
		}
	}
	
	//O(|V|+|A|). Va a pasar una vez por cada vertice y una vez por cada arco.
	public ArrayList<Integer> dfs_recorrido() {		
		this.iniciarEstructura();//Inicializo todas las estructuras 		
		ArrayList<Integer> resultado = new ArrayList<Integer>();		
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {//Obtengo todos los vertices del grafo
			Integer vertice = (Integer) vertices.next();
			if (colores.get(vertice).equals(Index.BLANCO)) {
				resultado.addAll(dfs_recorrido(vertice));//Inicio el recorrido
			}
		}		
		return resultado;
		
	}

	private ArrayList<Integer> dfs_recorrido(Integer vertice) {		
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		colores.put(vertice,Index.AMARILLO);
		resultado.add(vertice);		
		for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice); adyacentes.hasNext();) {
			Integer adyacente = (Integer) adyacentes.next();
			if (colores.get(adyacente).equals(Index.BLANCO)) {
				resultado.addAll(dfs_recorrido(adyacente));
			}			
		}		
		colores.put(vertice,Index.NEGRO);		
		return resultado;
	}
	
	public boolean dfs_tiene_ciclos() {		
		this.iniciarEstructura();//Inicializo todas las estructuras
		boolean tiene_ciclo = false;
		Iterator<Integer> vertices = this.grafo.obtenerVertices();
		while (vertices.hasNext() && !tiene_ciclo) {
			Integer vertice = (Integer) vertices.next();
			tiene_ciclo = dfs_tiene_ciclos(vertice);
		}
		return tiene_ciclo;
		
	}

	private boolean dfs_tiene_ciclos(Integer vertice) {		
		colores.put(vertice,Index.AMARILLO);
		boolean tiene_ciclo = false;		
		Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice);
		while (adyacentes.hasNext() && !tiene_ciclo) {
			Integer adyacente = (Integer) adyacentes.next();
			if (colores.get(adyacente).equals(Index.BLANCO)) {
				tiene_ciclo = dfs_tiene_ciclos(adyacente);
			}else {
				if (colores.get(adyacente).equals(Index.AMARILLO)) {
					tiene_ciclo = true;
				}
			}
		}
		colores.put(vertice,Index.NEGRO);		
		return tiene_ciclo;
	}
	
	
	public boolean existeCamino(int origen, int destino) {
		this.iniciarEstructura();
		return existeCaminoVisitado(origen, destino);		
	}
	
	private boolean existeCaminoVisitado(int origen, int destino) {
		this.colores.put(origen, Index.AMARILLO);
		if (origen == destino) {
			return true;
		}else {
			for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(origen); adyacentes.hasNext();) {
				Integer adyacente = (Integer) adyacentes.next();
				if (this.colores.get(adyacente).equals(Index.BLANCO)) {
					if (existeCaminoVisitado(adyacente, destino)) {
						return true;
					}
				}				
			}
			return false;
		}
	}
	
	public ArrayList<Integer> encontrarCamino(int origen, int destino){
		this.iniciarEstructura();
		return encontrarCaminoEntre(origen, destino);
	}

	private ArrayList<Integer> encontrarCaminoEntre(int verticeActual, int destino) {
		colores.put(verticeActual, Index.AMARILLO);
		ArrayList<Integer> salida = new ArrayList<Integer>();
		if (verticeActual == destino) {
			salida.add(verticeActual);
			return salida;
		}else {
			for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeActual); adyacentes.hasNext();) {
				Integer adyacente = (Integer) adyacentes.next();
				if (colores.get(adyacente).equals(Index.BLANCO)) {
					ArrayList<Integer> camino = encontrarCaminoEntre(adyacente,destino);
					if (!camino.isEmpty()) {
						salida.add(verticeActual);
						salida.addAll(camino);
						return salida;
					}
				}				
			}
			// colores.put(verticeActual, "negro");
			return salida;
		}				
	}
	
	public ArrayList<ArrayList<Integer>> encontrarCaminos(int origen, int destino) {
		iniciarEstructura();
		return encontrarCaminosRecorrido(origen, destino);
	}

	private ArrayList<ArrayList<Integer>> encontrarCaminosRecorrido(int verticeActual, int destino) {
		colores.put(verticeActual, Index.AMARILLO);
		ArrayList<ArrayList<Integer>> salida = new ArrayList<ArrayList<Integer>>();
		if (verticeActual == destino) {
			ArrayList<Integer> caminoUnico = new ArrayList<Integer>();
			caminoUnico.add(verticeActual);
			salida.add(caminoUnico);
			colores.put(verticeActual, Index.BLANCO);
			return salida;
		}
		else {
			for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeActual); adyacentes.hasNext();) {
				Integer adyacente = (Integer) adyacentes.next();
				if (colores.get(adyacente).equals(Index.BLANCO)) {
					ArrayList<ArrayList<Integer>> caminos = encontrarCaminosRecorrido(adyacente,destino);
					for (ArrayList<Integer> camino: caminos) {
						if (!camino.isEmpty()) {
							ArrayList<Integer> caminoCompleto = new ArrayList<Integer>();
							caminoCompleto.add(verticeActual);
							caminoCompleto.addAll(camino);
							salida.add(caminoCompleto);
						}
					}					
				}
			}
			
			colores.put(verticeActual, Index.BLANCO); // IMPORTANTE
			
			return salida;
		}
	}
	
	
	
}
