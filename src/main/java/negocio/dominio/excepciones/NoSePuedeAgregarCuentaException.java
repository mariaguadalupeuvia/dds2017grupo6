package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class NoSePuedeAgregarCuentaException extends RuntimeException {

	public NoSePuedeAgregarCuentaException(String mensaje) {

		super(mensaje);
	}

}
