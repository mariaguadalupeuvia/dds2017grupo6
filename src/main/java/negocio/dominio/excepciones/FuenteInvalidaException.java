package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class FuenteInvalidaException extends RuntimeException {

	public FuenteInvalidaException(String mensaje) {
		
		super(mensaje);
	}

}