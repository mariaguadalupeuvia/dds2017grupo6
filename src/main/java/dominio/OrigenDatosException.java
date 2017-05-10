package dominio;

@SuppressWarnings("serial")
public class OrigenDatosException extends RuntimeException 
{

	public OrigenDatosException() 
	{
		super();
	}

	public OrigenDatosException(String mensaje) 
	{
		super(mensaje);
	}
}