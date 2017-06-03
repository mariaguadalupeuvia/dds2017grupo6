package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class NoExisteMedibleException extends RuntimeException {

	public NoExisteMedibleException(String mensaje) {
		
		super(mensaje);
	}

}