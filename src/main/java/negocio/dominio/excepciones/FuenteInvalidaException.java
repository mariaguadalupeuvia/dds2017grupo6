package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class FuenteInvalidaException extends Exception {

	public FuenteInvalidaException(String mensaje) {
		
		super(mensaje);
	}

}