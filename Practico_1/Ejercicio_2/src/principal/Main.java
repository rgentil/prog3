package principal;

/*
Ejercicio 2.
Considerando la implementación de la Lista realizado en el ejercicio anterior, comparar la
complejidad computacional contra un array en las siguientes operaciones:

1.- Insertar al principio.
2.- Buscar un elemento en una posición.
3.- Determinar la cantidad de elementos.
 
 */
public class Main {

	public static void main(String[] args) {
	/*
	Arreglo
	
	1.- Insertar al principio = O(n) Debido a al corrimiento de los valores. O crear un arreglo nuevo si 
		sobrepasa el tamaño declarado.
	2.- Buscar un elemento en una posición = O(1). Se conoce la dirección de memoria
	3.- Determinar la cantidad de elementos = O(1) Se conoce el tamaño
	
	Lista:
	
	1.- Insertar al principio = O(1)
	2.- Buscar un elemento en una posición = O(n)
	3.- Determinar la cantidad de elementos = O(1) Esto si se declara una variable para tener el tamaño actualizado
		caso contrario es O(n) Porque en el peor de los casos se recorre toda la lista.
	*/
		
	}

}
