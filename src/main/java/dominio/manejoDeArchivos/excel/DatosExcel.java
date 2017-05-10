package dominio.manejoDeArchivos.excel;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import dominio.OrigenDatosException;
import dominio.interfases.OrigenDatos;
import dominio.interfases.ParserDatos;


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
				parser.parsear((HSSFRow) filas.next());
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new OrigenDatosException("No se encontro el archivo de datos");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			throw new OrigenDatosException("Se produjo un error al acceder al archivo");
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
	            e2.printStackTrace();
	            throw new OrigenDatosException("Se produjo un error al liberar el recurso usado para leer el archivo");
	         }
	      }
		
	}

}