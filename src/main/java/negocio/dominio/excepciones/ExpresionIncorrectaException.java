package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class ExpresionIncorrectaException extends RuntimeException {
	
	public ExpresionIncorrectaException(String mensaje) 
	{
		super(mensaje);
	}
}