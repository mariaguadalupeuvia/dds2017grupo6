package dominio;

import repositorio.RepositorioIndicadores;


public class ParserIndicadorTxt 
{
	public static void parsear(String registro)
	{
	    String[] datos = registro.split(";"); 
	    
	    RepositorioIndicadores.agregar(new Indicador(datos[0], datos[1], datos[2]));
	}

}
