package dominio;

import org.apache.poi.hssf.usermodel.HSSFRow;

import dominio.interfases.ParserDatos;

public class ParserCuenta implements ParserDatos 
{
	@Override
	public void parsear(String linea) 
	{
		ParserCuentaTxt.parsear(linea);
	}

	@Override
	public void parsear(HSSFRow next) 
	{
		ParserCuentasExcel.parsear(next);
	}

}
