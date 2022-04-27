
public class Main {

	public static void main(String[] args) {
		
		Tree tree = new Tree();
		
		System.out.println("--------->>La raiz es " + tree.getRoot() );
		System.out.println("--------->>Cantidad de elementos en el arbol " + tree.size() );
		System.out.println("--------->>Cantidad de elementos en el arbol " + tree.sizee() );
		
		int valor_buscar = 70;
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
		//System.out.println("--------->>CARGA = 6 - 3 - 1 - 5 - 4 - 7 - 9" );
		/*
		tree.insert(6);
		tree.insert(3);
		tree.insert(1);
		tree.insert(5);
		tree.insert(4);
		tree.insert(7);
		tree.insert(9);		
		*/
		
		tree.insert(50);
		tree.insert(40);
		tree.insert(80);
		tree.insert(20);
		tree.insert(45);
		tree.insert(10);
		tree.insert(30);
		tree.insert(25);
		tree.insert(90);
		tree.insert(70);
		tree.insert(60);
		tree.insert(75);
		tree.insert(65);
		

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
		
		System.out.println("--------->>Minimo elemento del arbol " + tree.getMinElem() );
		
		System.out.println("--------->>Cantidad de elementos en el arbol " + tree.size() );
		
		System.out.println("--------->>Cantidad de elementos en el arbol " + tree.sizee() );
		
		System.out.println("--------->>Frontera " + tree.getFrontera() );
		
		System.out.println("--------->>Altura " + tree.getHeight() );
		
		/*System.out.println("           6  ");
		System.out.println("         /   \\ ");
		System.out.println("      3        7");
		System.out.println("    /   \\     / \\ ");
		System.out.println("  1      5         9");
		System.out.println(" / \\   / \\       / \\");
		System.out.println("       4   ");
		System.out.println("      / \\ ");*/
		
		System.out.println(">>>>>>>>>>>>>>>>>>>> EN ORDEN <<<<<<<<<<<<<<<<<<<<");
		tree.printInOrder();
		tree.delete(50);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>> EN ORDEN <<<<<<<<<<<<<<<<<<<<");
		tree.printInOrder();
		
	}

}
