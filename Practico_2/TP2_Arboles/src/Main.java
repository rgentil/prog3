
public class Main {

	public static void main(String[] args) {
		
		Tree tree = new Tree();
		
		System.out.println("--------->>La raiz es " + tree.getRoot() );
		System.out.println("--------->>Cantidad de elementos en el arbol " + tree.size() );
		
		int valor_buscar = 50;
		if (tree.hasElem(valor_buscar)) {
			System.out.println("--------->>Se encuentra el elemento " + valor_buscar + " =)  " );
		}else{
			System.out.println("--------->>No esta el " + valor_buscar + " =(  " );
		}
		
		
		for(int i = 0; i <50; i++) {
			int randomValue = (int) (Math.random()*100);
			tree.insert(randomValue);//No entra valores duplicados. Porque va por la rama si es mayor o menor. Nunca se analiza el igual
		}
		
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
		/*
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
		*/

		System.out.println(">>>>>>>>>>>>>>>>>>>> PRE ORDEN <<<<<<<<<<<<<<<<<<<");
		tree.printPreOrder();
		
		System.out.println(">>>>>>>>>>>>>>>>>>>> EN ORDEN <<<<<<<<<<<<<<<<<<<<");
		tree.printInOrder();
		
		System.out.println(">>>>>>>>>>>>>>>>>>>> POS ORDEN <<<<<<<<<<<<<<<<<<<");
		tree.printPosOrder();
		
		System.out.println("--------->>La raiz es " + tree.getRoot() );
		
		System.out.println("--------->>Maximo elemento del arbol " + tree.getMaxElem() );
		
		System.out.println("--------->>Minimo elemento del arbol " + tree.getMinElem() );
		
		System.out.println("--------->>Cantidad de elementos en el arbol " + tree.size() );
		
		System.out.println("--------->>Frontera " + tree.getFrontera() );
		
		System.out.println("--------->>Altura = " + tree.getHeight() );
		
		System.out.println("--------->>Elementos en Nivel 0 " + tree.getElemAtLevel(0) );
		System.out.println("--------->>Elementos en Nivel 1 " + tree.getElemAtLevel(1) );
		System.out.println("--------->>Elementos en Nivel 2 " + tree.getElemAtLevel(2) );
		System.out.println("--------->>Elementos en Nivel 3 " + tree.getElemAtLevel(3) );
		System.out.println("--------->>Elementos en Nivel 4 " + tree.getElemAtLevel(4) );
		System.out.println("--------->>Elementos en Nivel 5 " + tree.getElemAtLevel(5) );
		
		
		System.out.println("--------->>Rama mas larga  " + tree.getLongestBranch() );
		
		
		if (tree.hasElem(valor_buscar)) {
			System.out.println("--------->>Se encuentra el elemento " + valor_buscar + " =)  y se va a eliminar" );
		}else{
			System.out.println("--------->>No esta el " + valor_buscar + " =(  " );
		}
		
		System.out.println(">>>>>>>>>>>>>>>>>>>> EN ORDEN <<<<<<<<<<<<<<<<<<<<");
		tree.printInOrder();
		tree.delete(50);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>> EN ORDEN <<<<<<<<<<<<<<<<<<<<");
		tree.printInOrder();
		
	}

}
