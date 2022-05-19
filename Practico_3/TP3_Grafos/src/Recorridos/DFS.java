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
		this.colores = new HashMap<Integer, String>();
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
			resultado.addAll(dfs_recorrido(vertice));//Inicio el recorrido
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
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {//Obtengo todos los vertices del grafo
			Integer vertice = (Integer) vertices.next();
			return dfs_tiene_ciclos(vertice);//Inicio el recorrido
		}		
		return false;
		
	}

	private boolean dfs_tiene_ciclos(Integer vertice) {		
		colores.put(vertice,"amarillo");
		for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice); adyacentes.hasNext();) {
			Integer adyacente = (Integer) adyacentes.next();
			if (colores.get(adyacente).equals("blanco")) {
				dfs_recorrido(adyacente);
			}else {
				return true;
			}
		}		
		colores.put(vertice,"negro");		
		return false;
	}
	
	
	
	
}
