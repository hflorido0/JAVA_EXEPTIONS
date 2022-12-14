package exceptions;
import java.util.Arrays;
import java.util.List;

public class ExcepcionesInterrumpenPrograma extends Exception{
	
	//estas constantes me marcan la posici?n en el array "message"
	public static final int ERROR_0 = 0;
	public static final int ERROR_1 = 1;
	public static final int ERROR_2 = 2;
	
	private int value;
	
	/*al hacer el new de la excepci?n le paso el valor del array
		del error*/
	public ExcepcionesInterrumpenPrograma (int value) {
		this.value = value;
	}
	
	/*aqu? defino todos los mensajes. Acceder? a ellos por posici?n
		con las constantes*/
	private List<String> message = Arrays.asList(
				"Este es mi error 0 de ExcepcionesInterrumpen",
				"Este es mi error 1 de ExcepcionesInterrumpen",
				"Este es mi error 2 de ExcepcionesInterrumpen"
			);
			
	
	@Override
	public String getMessage() {
		return message.get(value);
	}
}
