package dominio;

@SuppressWarnings("serial")
public class ImportadorException extends RuntimeException 
{
	public ImportadorException() 
	{
		super();
	}

	public ImportadorException(String mensaje) 
	{
		super(mensaje);

	}
	
	public ImportadorException(String mensaje, Throwable causa) 
	{
		super(mensaje, causa);
	}
}
