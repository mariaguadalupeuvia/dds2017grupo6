package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class NoSePudoAplicarCriterioException extends Exception {

	public NoSePudoAplicarCriterioException(String mensaje) {

		super(mensaje);
	}
}
