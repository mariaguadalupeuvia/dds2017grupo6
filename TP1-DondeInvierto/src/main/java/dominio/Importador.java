package dominio;

import dominio.interfases.OrigenDatos;
import dominio.interfases.ParserDatos;
import dominio.manejoDeArchivos.excel.DatosExcel;
import dominio.manejoDeArchivos.txt.DatosTxt;

public class Importador 
{
	static OrigenDatos datos;
	
	public static void cargarDatosDe(String rutaDelArchivo, ParserDatos unParser)
	{
		leerDesde(rutaDelArchivo, unParser);
		datos.cargarDatosDe(rutaDelArchivo);
	}
	
	private static void leerDesde(String rutaDelArchivo, ParserDatos unParser)
	{
		String extension = rutaDelArchivo.substring(rutaDelArchivo.length() - 3);
		if (extension.equalsIgnoreCase("txt"))
		{
			datos = new DatosTxt(unParser);
		}
		else
		{
			datos = new DatosExcel(unParser);
		}
	}
}
