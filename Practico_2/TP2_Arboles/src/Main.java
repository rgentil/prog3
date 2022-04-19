
public class Main {

	public static void main(String[] args) {
		
		Tree tree = new Tree();
		
		System.out.println("--------->>La raiz es " + tree.getRoot() );
		System.out.println("--------->>Cantidad de elementos en el arbol " + tree.size() );
		System.out.println("--------->>Cantidad de elementos en el arbol " + tree.sizee() );
		
		int valor_buscar = 7;
		if (tree.hasElem(valor_buscar)) {
			System.out.println("--------->>Se encuentra el elemento " + valor_buscar + " =)  " );
		}else{
			System.out.println("--------->>No esta el " + valor_buscar + " =(  " );
		}
		
		/*
		for(int i = 0; i <9; i++) {
			int randomValue = (int) (Math.random()*1000);
			tree.insert(randomValue);
		}
		*/
		System.out.println("--------->>CARGA = 6 - 3 - 1 - 5 - 4 - 7 - 9" );
		tree.insert(6);
		tree.insert(3);
		tree.insert(1);
		tree.insert(5);
		tree.insert(4);
		tree.insert(7);
		tree.insert(9);

		System.out.println(">>>>>>>>>>>>>>>>>>>> PRE ORDEN <<<<<<<<<<<<<<<<<<<");
		tree.printPreOrder();
		
		System.out.println(">>>>>>>>>>>>>>>>>>>> EN ORDEN <<<<<<<<<<<<<<<<<<<<");
		tree.printInOrder();
		
		System.out.println(">>>>>>>>>>>>>>>>>>>> POS ORDEN <<<<<<<<<<<<<<<<<<<");
		tree.printPosOrder();
		
		System.out.println("--------->>La raiz es " + tree.getRoot() );
		
		if (tree.hasElem(valor_buscar)) {
			System.out.println("--------->>Se encuentra el elemento " + valor_buscar + " =)  " );
		}else{
			System.out.println("--------->>No esta el " + valor_buscar + " =(  " );
		}
		
		/*int valor_eliminar = 7;
		if (tree.delete(valor_eliminar)) {
			System.out.println("--------->>Se elimino el " + valor_eliminar + " =) " );
		}else{
			System.out.println("--------->>No se pudo eliminar " + valor_eliminar + " =( " );
		}*/
		
		System.out.println("--------->>Maximo elemento del arbol " + tree.getMaxElem() );
		
		
		System.out.println("--------->>Cantidad de elementos en el arbol " + tree.size() );
		
		System.out.println("--------->>Cantidad de elementos en el arbol " + tree.sizee() );
		

	}

}
