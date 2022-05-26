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
	
	//O(|V|+|A|). Va a pasar una vez por cada vertice y una vez por cada arco.
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
		visitados.put(origen,true);//Marcar el v�rtice origen como VISITADO.
		fila.add(origen);//Agregar origen a la fila F.
		salida.add(origen);
		while(!fila.isEmpty()) {
			int vertice = fila.remove(0); // Tomamos v�rtice de la fila,
			for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice); adyacentes.hasNext();) {//Para cada v�rtice adyacente a vertice:
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
	
	public ArrayList<Integer> encontrarCaminoCorto(int origen, int destino){
		this.iniciarEstructura();
		return encontrarCaminoCortoRecorrido(origen, destino);
	}

	private ArrayList<Integer> encontrarCaminoCortoRecorrido(int origen, int destino) {
		ArrayList<Integer> fila = new ArrayList<>();
		HashMap<Integer,Integer> padres = new HashMap<>();
		visitados.put(origen, true);
		fila.add(origen);
		boolean llegue = false;
		while(!fila.isEmpty() && !llegue) {
			int vertice = fila.remove(0); // Tomamos v�rtice de la fila,
			Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice);
			while (adyacentes.hasNext() && !llegue) {
				int adyacente = adyacentes.next(); // Para cada v�rtice adyacente:
				if (!this.visitados.get(adyacente)) { // Si y es NO_VISITADO 
					this.visitados.put(adyacente, true); // Marcar el adyacente como VISITADO.
					fila.add(adyacente); // Agregar adyacente a la fila F.
					padres.put(adyacente, vertice);
					if (adyacente == destino) {
						llegue = true;
					}
				}				
			}
		}
		
		if (llegue) {
			ArrayList<Integer> salida = new ArrayList<>();
			Integer aux = destino;
			while( aux != null) {
				salida.add(0,aux);
				aux = padres.get(aux);
			}
			return salida;
		}
		else {
			return null;			
		}
	}
	
	
	
}
