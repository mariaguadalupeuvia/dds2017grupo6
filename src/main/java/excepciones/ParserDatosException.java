package excepciones;

@SuppressWarnings("serial")
public class ParserDatosException extends RuntimeException 
{
	public ParserDatosException() 
	{
		super();
	}

	public ParserDatosException(String mensaje) 
	{
		super(mensaje);
	}
	
	public ParserDatosException(String mensaje, Throwable causa) 
	{
		super(mensaje, causa);
	}
	
}
