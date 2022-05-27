
public class TestBacktraking {

	public static void main(String[] args) {
/*		
 		Backtraking (estado e)
			{
			Condici�n de Corte:
				�e es una posible soluci�n?
				SI:
					operar con la soluci�n
					Ej: fijarse si es la mejor hasta el momento,
					agregarla a una lista de soluciones,
					imprimir, etc ,etc
				NO:
					Generar Candidatos (hijos) a Partir del estado e
						Para cada hijo c:
							SELECCIONAR(c)
							Backtraking(c) /// EXPLORAR recursivamente a partir de c
							DES-SELECCIONAR(c)
			}
*/
	
/*	

		BACK (estado e, solucion *sol)
		\\ e: nodo del �rbol de soluciones
		\\sol: soluci�n que retorna
		{
			if ( SOLUCION (e))
				OperarSobreSoluci�n (e, sol);
			else {
				int nrohijo = 1;
				estado siguiente;
				while ( HIJOS (nrohijo, e, siguiente ) )
					{ if ( !PODA ( siguiente, sol) )
						{ AgregarASolucion(siguiente, sol);
						  BACK ( siguiente, sol);
						  QuitarDeSolucion(siguiente, sol);
						}
						++nrohijo;
					}
				}
			}


*/
	}

}
