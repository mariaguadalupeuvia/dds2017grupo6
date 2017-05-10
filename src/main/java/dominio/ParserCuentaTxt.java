package dominio;

import repositorio.RepositorioCuentas;
import repositorio.RepositorioEmpresas;
import repositorio.RepositorioNombresCuentas;
import repositorio.RepositorioPeriodos;

public class ParserCuentaTxt
{

	public static void parsear(String registro)
	{
	    String[] datos = registro.split(" "); 
	    RepositorioEmpresas.agregar(new Empresa(datos[0],null));
	    RepositorioNombresCuentas.agregar(datos[1]);
	    RepositorioPeriodos.agregar(Integer.parseInt(datos[2]));
	    RepositorioCuentas.agregar(new CuentaEmpresaPeriodo(datos[0], datos[1], Integer.parseInt(datos[2]), Double.parseDouble(datos[3])));
	}

}
