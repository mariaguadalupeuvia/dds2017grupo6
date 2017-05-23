package negocio.dominio.manejoArchivos.Fuente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuenteTxt implements Fuente 
{
	private List<String> datos = new ArrayList<>();
	
	@Override
	public void leerDatos(String ruta) throws IOException
	{
		datos = Files.lines(Paths.get(ruta)).collect(Collectors.toList());
	}

	@Override
	public List<String> getDatos() 
	{
		return datos;
	}
}