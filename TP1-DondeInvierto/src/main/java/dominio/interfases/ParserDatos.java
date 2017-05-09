package dominio.interfases;

import org.apache.poi.hssf.usermodel.HSSFRow;

public interface ParserDatos 
{
	void parsear(String linea);

	void parsear(HSSFRow next);
}
