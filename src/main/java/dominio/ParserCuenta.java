package dominio;

import dominio.interfases.ParserDatos;
import excepciones.ParserDatosException;
import repositorio.RepositorioCuentas;
import repositorio.RepositorioEmpresas;
import repositorio.RepositorioNombresCuentas;
import repositorio.RepositorioPeriodos;

public class ParserCuenta implements ParserDatos 
{
	public void parsear(String registro) 
	{
		try
		{
		    String[] datos = registro.split(" "); 
		    RepositorioEmpresas.agregarPeriodoCuentaValor(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]));
		    RepositorioNombresCuentas.agregarSiNoExiste(datos[1]);
		    RepositorioPeriodos.agregarSiNoExiste(datos[2]);
		    RepositorioCuentas.agregar(new CuentaEmpresaPeriodo(datos[0], datos[1], datos[2], Double.parseDouble(datos[3])));
		
		}
		catch(RuntimeException ex)
		{
			throw new ParserDatosException("Los datos obtenidos del archivo no tienen el formato esperado",ex.getCause());
		}
	}

}
