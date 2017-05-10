package dominio;

import org.apache.poi.hssf.usermodel.HSSFRow;

import dominio.interfases.ParserDatos;

public class ParserCuenta implements ParserDatos 
{
	public void parsear(String linea) 
	{
		try
		{
			ParserCuentaTxt.parsear(linea);
		}
		catch(RuntimeException ex)
		{
			throw new ParserDatosException("Los datos obtenidos del archivo no tienen el formato esperado");
		}
	}

	public void parsear(HSSFRow next) 
	{
		try
		{
			ParserCuentasExcel.parsear(next);
		}
		catch(RuntimeException ex)
		{
			throw new ParserDatosException("Los datos obtenidos del archivo no tienen el formato esperado");
		}
	}

}
