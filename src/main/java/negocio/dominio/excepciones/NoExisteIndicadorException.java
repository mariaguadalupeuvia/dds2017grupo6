package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class NoExisteIndicadorException extends RuntimeException {

	public NoExisteIndicadorException(String mensaje) {
		
		super(mensaje);
	}

}