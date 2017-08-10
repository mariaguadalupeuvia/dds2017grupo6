package negocio.dominio.manejoArchivos.fuente;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import negocio.dominio.excepciones.FuenteInvalidaException;

@SuppressWarnings("deprecation")
public class FuenteExcel implements Fuente 
{
	private List<String> datos = new ArrayList<>();
	
	@Override
	public void leerDatos(String ruta) throws FuenteInvalidaException 
	{
		Sheet hoja = null;
		
		try 
		{
			hoja = WorkbookFactory.create(new File(ruta)).getSheetAt(0);
		} 
		catch (InvalidFormatException | IOException e) 
		{
			throw new FuenteInvalidaException("Se produjo un error al acceder al archivo, es posible que la ruta no sea valida");
		}
		catch (EncryptedDocumentException e2)
		{
			throw new FuenteInvalidaException("Se produjo un error al leer el archivo debido a que esta encriptado");
		}

		hoja.forEach(filaSinFormato -> datos.add(formatearFila(filaSinFormato)));
	}

	@Override
	public List<String> getDatos() 
	{
		return datos;
	}
	
	
	public String formatearFila(Row filaSinFormato)
	{
		StringBuffer linea = new StringBuffer();
		
		filaSinFormato.forEach(celdaSinFormato -> linea.append(formatearCelda(celdaSinFormato) + " "));
		
		return linea.toString();
	}
	
	public String formatearCelda(Cell celdaSinFormato) 
	{
		switch (celdaSinFormato.getCellType()) 
		{
			case Cell.CELL_TYPE_BOOLEAN:
				return String.valueOf(celdaSinFormato.getBooleanCellValue());
			case Cell.CELL_TYPE_NUMERIC:
				return String.valueOf(celdaSinFormato.getNumericCellValue());
			case Cell.CELL_TYPE_STRING:
				return  String.valueOf(celdaSinFormato.getStringCellValue());
			case Cell.CELL_TYPE_BLANK:
				return "";
			default:
				return String.valueOf(celdaSinFormato);
		}
	}
}