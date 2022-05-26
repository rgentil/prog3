package Recorridos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Grafo.Grafo;

/*
	DFS (Depth-First Search)
	Recorrido en profundidad
	
 */
public class DFS {

	private Grafo<?> grafo;
	private HashMap<Integer,String> colores;
	
	public DFS(Grafo<?> g) {
		this.grafo = g;
		this.colores = new HashMap<>();
	}
	
	private void iniciarEstructura() {
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {
			Integer vertice = (Integer) vertices.next();
			colores.put(vertice, "blanco");
		}
	}
	
	public ArrayList<Integer> dfs_recorrido() {		
		this.iniciarEstructura();//Inicializo todas las estructuras 		
		ArrayList<Integer> resultado = new ArrayList<Integer>();		
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {//Obtengo todos los vertices del grafo
			Integer vertice = (Integer) vertices.next();
			if (colores.get(vertice).equals("blanco")) {
				resultado.addAll(dfs_recorrido(vertice));//Inicio el recorrido
			}
		}		
		return resultado;
		
	}

	private ArrayList<Integer> dfs_recorrido(Integer vertice) {		
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		colores.put(vertice,"amarillo");
		resultado.add(vertice);		
		for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice); adyacentes.hasNext();) {
			Integer adyacente = (Integer) adyacentes.next();
			if (colores.get(adyacente).equals("blanco")) {
				resultado.addAll(dfs_recorrido(adyacente));
			}			
		}		
		colores.put(vertice,"negro");		
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
		colores.put(vertice,"amarillo");
		boolean tiene_ciclo = false;		
		Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice);
		while (adyacentes.hasNext() && !tiene_ciclo) {
			Integer adyacente = (Integer) adyacentes.next();
			if (colores.get(adyacente).equals("blanco")) {
				tiene_ciclo = dfs_tiene_ciclos(adyacente);
			}else {
				if (colores.get(adyacente).equals("amarillo")) {
					tiene_ciclo = true;
				}
			}
		}
		colores.put(vertice,"negro");		
		return tiene_ciclo;
	}
	
	
	public boolean existeCamino(int origen, int destino) {
		this.iniciarEstructura();
		return existeCaminoVisitado(origen, destino);		
	}
	
	private boolean existeCaminoVisitado(int origen, int destino) {
		this.colores.put(origen, "amarillo");
		if (origen == destino) {
			return true;
		}else {
			for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(origen); adyacentes.hasNext();) {
				Integer adyacente = (Integer) adyacentes.next();
				if (this.colores.get(adyacente).equals("blanco")) {
					if (existeCaminoVisitado(adyacente, destino)) {
						return true;
					}
				}				
			}
			return false;
		}
	}
	
}
