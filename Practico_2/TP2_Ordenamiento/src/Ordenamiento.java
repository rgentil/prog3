
public class Ordenamiento {

	public Ordenamiento() {
	}

	/*
	 * El m�todo de ordenaci�n por selecci�n consiste en repetir los siguientes
	 * pasos: Se busca el elemento m�s peque�o del array y se coloca en la primera
	 * posici�n. Entre los restantes, se busca el elemento m�s peque�o y se coloca
	 * en la segunda posici�n. Entre los restantes se busca el elemento m�s peque�o
	 * y se coloca en la tercera posici�n.
	 */

	// Tiempo de ejecuci�n O(n2)
	public int[] seleccion(int a[]) {
		for (int i = 0; i < a.length - 1; i++) { // Voy a recorrer todo el arreglo
			int menor = a[i]; // Tomo como menor el primero y guardo el valor y la posicion en el que esta
			int pos_menor = i;
			for (int y = i + 1; y < a.length; y++) {// Empiezo a recorrer el arreglo
				if (a[y] < menor) {// si encuentro un menor guardo el valor menor y la posicion del menor
					menor = a[y];
					pos_menor = y;
				}
				if (pos_menor != i) { // Si resulta que encontre un menor por lo tanto cambio la posicion. pongo el
										// valor menor primero.
					int aux = a[i];
					a[i] = a[pos_menor];
					a[pos_menor] = aux;
				}
			}
		}
		return a;
	}

	/*
	 * Consiste en comparar pares de elementos adyacentes en un array y si est�n
	 * desordenados intercambiarlos hasta que est�n todos ordenados. El elemento
	 * mayor sube como una burbuja hacia la posici�n m�s alta.
	 */
	// Tiempo de ejecuci�n O(n2)
	public int[] burbujeo(int a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int y = i + 1; y < a.length; y++) {
				if (a[i] > a[y]) {
					int aux = a[i];
					a[i] = a[y];
					a[y] = aux;
				}
			}
		}
		return a;
	}

	/*
	 * Funcionamiento del m�todo MergeSort es el siguiente: - Si la longitud del
	 * array es menor o igual a 1 entonces ya est� ordenado. - El array a ordenar se
	 * divide en dos mitades de tama�o similar. - Cada mitad se ordena de forma
	 * recursiva aplicando el m�todo MergeSort. - A continuaci�n las dos mitades ya
	 * ordenadas se mezclan formando una secuencia ordenada.
	 */
	
	public int[] mergesort(int a[]) {
		return this.mergesort(a, 0, a.length-1);
	}
	
	public int[] mergesort(int a[], int izq, int der) {
		if (izq < der) {
			int medio = (izq + der) / 2;
			mergesort(a, izq, medio);
			mergesort(a, medio + 1, der);
			return merge(a, izq, medio, der);
		}
		return null;
	}

	/*
	El m�todo ordena un array a de enteros desde la posici�n izq hasta la posici�n der. 
	En la primera llamada al m�todo recibir� los valores izq = 0, der = ELEMENTOS-1. 
	Primero se calcula el elemento central m. A continuaci�n la primera parte del array, 
	desde izq hasta m y la segunda parte del array, desde m+1 hasta der, 
	se mezclan mediante llamadas recursivas al m�todo mergesort. 
	La recursi�n termina cuando izq == der, es decir, cuando un subarray contiene solamente un elemento. 
	La operaci�n principal de mezcla la realiza el m�todo merge. 
	*/
	// Tiempo de ejecuci�n O(n log2n)
	private int[] merge(int a[], int izq, int medio, int der) {
		int i, j, k;
		int[] b = new int[a.length]; // array auxiliar
		for (i = izq; i <= der; i++) { // copia ambas mitades en el array auxiliar
			b[i] = a[i];
		}

		i = izq;
		j = medio + 1;
		k = izq;

		while (i <= medio && j <= der) { // copia el siguiente elemento m�s grande
			if (b[i] <= b[j]) {
				a[k++] = b[i++];
			}
			else {
				a[k++] = b[j++];
			}
		}

		while (i <= medio) { // copia los elementos que quedan de la
			a[k++] = b[i++]; // primera mitad (si los hay)
		}
		return a;
	}

}
