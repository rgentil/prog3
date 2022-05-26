package Recorridos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Grafo.Grafo;

public class BFS {
	
	private Grafo<?> grafo;
	private HashMap<Integer,Boolean> visitados;
	
	public BFS(Grafo<?> g) {
		this.grafo = g;
		this.visitados = new HashMap<>();
	}
	
	private void iniciarEstructura() {
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {
			Integer vertice = (Integer) vertices.next();
			visitados.put(vertice, false);
		}
	}
	
	public ArrayList<Integer> bfs_recorrido(){
		this.iniciarEstructura();
		ArrayList<Integer> resultado = new ArrayList<Integer>();	
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {
			Integer vertice = (Integer) vertices.next();
			if (!visitados.get(vertice)) {
				resultado.addAll(bfs_recorrido(vertice));
			}			
		}
		return resultado;
	}
	
	private ArrayList<Integer> bfs_recorrido(Integer origen){
		ArrayList<Integer> fila = new ArrayList<>();
		ArrayList<Integer> salida = new ArrayList<>();
		visitados.put(origen,true);//Marcar el vértice origen como VISITADO.
		fila.add(origen);//Agregar origen a la fila F.
		salida.add(origen);
		while(!fila.isEmpty()) {
			int vertice = fila.remove(0); // Tomamos vértice de la fila,
			for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice); adyacentes.hasNext();) {//Para cada vértice adyacente a vertice:
				Integer adyacente = (Integer) adyacentes.next();
				if (!visitados.get(adyacente)) {//Si NO_VISITADO 
					visitados.put(adyacente, true);
					fila.add(adyacente);//Agregar adyacente a la fila F.
					salida.add(adyacente);
				}				
			}
		}
		return salida;
	}
	
}
