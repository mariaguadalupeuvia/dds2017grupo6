package dominio;

import org.apache.poi.hssf.usermodel.HSSFRow;

import dominio.interfases.ParserDatos;

public class ParserIndicador implements ParserDatos
{
	public void parsear(String registro)
	{
		try
		{
			ParserIndicadorTxt.parsear(registro);
		}
		catch(RuntimeException ex)
		{
			throw new ParserDatosException("Los datos obtenidos del archivo no tienen el formato esperado");
		}
		
	}

	public void parsear(HSSFRow next) 
	{
		// TODO Auto-generated method stub

	}
}