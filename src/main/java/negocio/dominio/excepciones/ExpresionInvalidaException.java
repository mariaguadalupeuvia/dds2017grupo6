package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class ExpresionInvalidaException extends RuntimeException {

	public ExpresionInvalidaException(Throwable e) {
		super(e);
	}
}
