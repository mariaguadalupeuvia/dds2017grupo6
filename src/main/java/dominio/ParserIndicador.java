package dominio;

import dominio.interfases.ParserDatos;
import excepciones.ParserDatosException;

public class ParserIndicador implements ParserDatos
{
	public void parsear(String registro)
	{
		ParserIndicadorTxt parser= new ParserIndicadorTxt();
		try
		{
			parser.parsear(registro);
		}
		catch(RuntimeException ex)
		{
			throw new ParserDatosException("Los datos obtenidos del archivo no tienen el formato esperado");
		}
		
	}
}