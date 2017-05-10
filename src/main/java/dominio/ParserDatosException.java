package dominio;

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

}
