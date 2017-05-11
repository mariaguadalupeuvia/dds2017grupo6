package dominio.manejoDeArchivos.excel;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import dominio.interfases.OrigenDatos;
import dominio.interfases.ParserDatos;
import excepciones.OrigenDatosException;


public class DatosExcel implements OrigenDatos 
{
	ParserDatos parser;
	
	public DatosExcel(ParserDatos unParser)
	{
		this.parser = unParser;
	}
	
	@Override
	public void cargarDatosDe(String rutaDelArchivo)
	{
		HSSFWorkbook wb = null;
		
		try {

			wb = new HSSFWorkbook(new FileInputStream(rutaDelArchivo));
			HSSFSheet hoja = wb.getSheetAt(0);
			Iterator<Row> filas = hoja.rowIterator();
			
			while (filas.hasNext()) 
			{
				convertirFilaEnString((HSSFRow) filas.next());
			}
		} 
		catch (FileNotFoundException e) 
		{
			throw new OrigenDatosException("No se encontro el archivo de datos");
		} 
		catch (IOException e) 
		{
			throw new OrigenDatosException("Se produjo un error al acceder al archivo");
		} 
		catch (EncryptedDocumentException e) 
		{
			throw new OrigenDatosException("Se produjo un error al intentar acceder a un archivo encriptado");
		} 
		finally
	    {
	         try
	         {                    
	            if( null != wb)
	            {   
	            	wb.close();     
	            }                  
	         }
	         catch (Exception e2)
	         { 
	            throw new OrigenDatosException("Se produjo un error al liberar el recurso usado para leer el archivo");
	         }
	      }
	}
	
	@SuppressWarnings("deprecation")
	public void convertirFilaEnString(HSSFRow fila) 
	{
		HSSFCell celda;
		Iterator<Cell> cells = fila.cellIterator();
		String filaParseable = "";

		while (cells.hasNext()) 
		{
			celda = (HSSFCell) cells.next();
            
			if (celda.getCellType() == HSSFCell.CELL_TYPE_STRING) 
			{
				filaParseable = filaParseable + " " + celda.getStringCellValue().trim();
			} 
			else if (celda.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) 
			{
				filaParseable = filaParseable + " " + String.valueOf(celda.getNumericCellValue());
			}

		}
		parser.parsear(filaParseable.trim());
	}
}