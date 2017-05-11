package dominio;

import dominio.interfases.OrigenDatos;
import dominio.interfases.ParserDatos;
import dominio.manejoDeArchivos.excel.DatosExcel;
import dominio.manejoDeArchivos.txt.DatosTxt;
import excepciones.ImportadorException;

public class Importador 
{
	OrigenDatos datos;
	
	public void cargarDatosDe(String rutaDelArchivo, ParserDatos unParser)
	{
		if(rutaDelArchivo == null)
		{
			throw new ImportadorException("Especifique la ruta del archivo a cargar");
		}
		
		leerDesde(rutaDelArchivo, unParser);
		datos.cargarDatosDe(rutaDelArchivo);
	}
	
	private void leerDesde(String rutaDelArchivo, ParserDatos unParser)
	{
		String extension = rutaDelArchivo.substring(rutaDelArchivo.length() - 3);
		if (extension.equalsIgnoreCase("txt"))
		{
			datos = new DatosTxt(unParser);
		}
		else
		{
			if (extension.equalsIgnoreCase("xls"))
			{
				datos = new DatosExcel(unParser);
			}
			else
			{
				
				throw new ImportadorException("No se reconocio la extension del archivo solicitado");
			}
		}
		
	}
}
