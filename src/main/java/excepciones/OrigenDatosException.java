package excepciones;

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
	
	public OrigenDatosException(String mensaje, Throwable causa) 
	{
		super(mensaje, causa);
	}
	
}