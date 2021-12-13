package manager;

import exceptions.ExcepcionesBucle;
import exceptions.ExcepcionesInterrumpenPrograma;

public class Manager {

	//vairable que me va contando cuantas veces NO lanzo excepciones
	private int contador;
	
	/*Init es donde debemos capturar las excepciones 
		que interrumpen por completo nuestro programa.
		Nunca debe propagar las excepciones m�s all�
		del init()*/
	public void init() {
		contador = 0;
		try {
			menuEnBucle();
			otrasFunciones();
		} catch (ExcepcionesInterrumpenPrograma e) {
			System.out.println(e.getMessage());
		}
		
	}

	//Quiero el menor n�mero de try/cath, por lo que propago esta excepci�n al init().
	private void otrasFunciones() throws ExcepcionesInterrumpenPrograma {
		otraFuncionMas();
		if (3 < 4) {
			throw new ExcepcionesInterrumpenPrograma(ExcepcionesInterrumpenPrograma.ERROR_0);
			/*esto equivale a: throw new ExcepcionesInterrumpen(0); porque ExcepcionesInterrumpen.ERROR_0
			es una constante.*/
		}
		System.out.println("esto nunca se imprimir�");
	}

	//Quiero el menor n�mero de try/cath, por lo que propago esta excepci�n a otrasFunciones().
	private void otraFuncionMas() throws ExcepcionesInterrumpenPrograma {
		if (true) {
			throw new ExcepcionesInterrumpenPrograma(ExcepcionesInterrumpenPrograma.ERROR_1);
			/*esto evuicale a: throw new ExcepcionesInterrumpen(1); porque ExcepcionesInterrumpen.ERROR_1
			es una constante. */
		}
	}

	/*En esta m�todo quiero capturar solamente las excpeciones de tipo ExcecionesBucle por lo que
		no las propago.
	 Como las excpecionesNoBucle no las quiero capturar porque S� que interrumpen la ejecuci�n 
	 	del programa, las propago al init().*/
	private void menuEnBucle() throws ExcepcionesInterrumpenPrograma  {
		int lectura = 0;
		while (lectura < 10) {
			try {
				lectura++;
				if (lectura % 2 == 0) {
					int valor;
					
					//selecciono el error en funci�n de la variable "lectura"
					if (lectura < 4) valor = ExcepcionesBucle.ERROR_0;
					else if (lectura < 7) valor = ExcepcionesBucle.ERROR_1;
					else valor = ExcepcionesBucle.ERROR_2;
					
					//lanzo el error que he almacenado en la variable "valor"
					throw new ExcepcionesBucle(valor);
				}
				
				if (lectura > 10) {
					otraFuncionMas();
				}
				
				//voy contando cuantas veces no lanzo excpeci�n);
				System.out.println("Excepciones: " + ++contador);
			} catch (ExcepcionesBucle e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
