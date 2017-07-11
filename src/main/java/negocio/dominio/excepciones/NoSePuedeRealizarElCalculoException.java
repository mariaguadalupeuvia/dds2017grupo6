package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class NoSePuedeRealizarElCalculoException extends RuntimeException {

	public NoSePuedeRealizarElCalculoException(String mensaje) {
		
		super(mensaje);
	}
}