package negocio.dominio.manejoArchivos.fuente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import negocio.dominio.excepciones.FuenteInvalidaException;

public class FuenteTxt implements Fuente 
{
	private List<String> datos = new ArrayList<>();
	
	@Override
	public void leerDatos(String ruta)
	{
		try 
		{
			datos = Files.lines(Paths.get(ruta)).collect(Collectors.toList());
		} 
		catch (IOException | InvalidPathException e)
		{
			throw new FuenteInvalidaException("Se produjo un error al acceder al archivo, es posible que la ruta no sea valida");
		}
	}

	@Override
	public List<String> getDatos() 
	{
		return datos;
	}
}