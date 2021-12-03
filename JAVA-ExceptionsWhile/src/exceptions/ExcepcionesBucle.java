package exceptions;
import java.util.Arrays;
import java.util.List;

public class ExcepcionesBucle extends Exception{

	//estas constantes me marcan la posición en el array "message"
	public static final int ERROR_0 = 0;
	public static final int ERROR_1 = 1;
	public static final int ERROR_2 = 2;
	
	private int value;

	/*al hacer el new de la excepción le paso el valor del array
		del error*/
	public ExcepcionesBucle (int value) {
		this.value = value;
	}

	/*aquí defino todos los mensajes. Accederé a ellos por posición
		con las constantes*/
	private List<String> message = Arrays.asList(
				"Este es mi error 0 de ExcepcionesBucle",
				"Este es mi error 1 de ExcepcionesBucle",
				"Este es mi error 2 de ExcepcionesBucle"
			);
			
	
	@Override
	public String getMessage() {
		return message.get(value);
	}
}
