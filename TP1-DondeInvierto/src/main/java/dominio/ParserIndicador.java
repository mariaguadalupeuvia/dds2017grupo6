package dominio;

import org.apache.poi.hssf.usermodel.HSSFRow;

import dominio.interfases.ParserDatos;

public class ParserIndicador implements ParserDatos
{
	@Override
	public void parsear(String registro)
	{
		ParserIndicadorTxt.parsear(registro);
	}

	@Override
	public void parsear(HSSFRow next) 
	{
		// TODO Auto-generated method stub

	}
}