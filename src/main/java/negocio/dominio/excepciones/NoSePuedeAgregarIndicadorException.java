package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class NoSePuedeAgregarIndicadorException extends RuntimeException {

	public NoSePuedeAgregarIndicadorException(String mensaje) {

		super(mensaje);
	}
}
