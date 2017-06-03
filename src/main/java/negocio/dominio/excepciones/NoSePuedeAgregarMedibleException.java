package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class NoSePuedeAgregarMedibleException extends RuntimeException {

	public NoSePuedeAgregarMedibleException(String mensaje) {

		super(mensaje);
	}

}
