package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class NoExisteCuentaException extends RuntimeException {

	public NoExisteCuentaException(String mensaje) {
		
		super(mensaje);
	}
}