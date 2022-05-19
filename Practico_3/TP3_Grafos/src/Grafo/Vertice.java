package Grafo;
import java.util.ArrayList;

public class Vertice<T> {
	
	private int id;
	
	private ArrayList<Arco<T>> arcos;
	
	public Vertice(int id){
		this.id = id;
		this.arcos = new ArrayList<Arco<T>>();
	}
	
	public int getId(){
		return this.id;
	}
	
	public ArrayList<Arco<T>> getArco(){
		return arcos;
	}
	
	public void addArco(Arco<T> arco){
		arcos.add(arco);
	}
	
	public String toString(){
		return "Id vertice " + id + " Arcos: " + arcos.toString();
	}
	
}
