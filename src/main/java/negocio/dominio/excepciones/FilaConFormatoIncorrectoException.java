package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class FilaConFormatoIncorrectoException extends RuntimeException {

	public FilaConFormatoIncorrectoException(String mensaje) {

		super(mensaje);
	}

}
