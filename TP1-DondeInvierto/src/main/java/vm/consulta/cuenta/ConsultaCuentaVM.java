package vm.consulta.cuenta;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import dominio.datos.DatosTxt;
import dominio.datos.EstructuraEsperada;
import interfases.IOrigenDatos;

@Observable
public class ConsultaCuentaVM 
{
	IOrigenDatos datosLeidos;
	
	public ConsultaCuentaVM()
	{
		datosLeidos = new DatosTxt();
		datosLeidos.cargarDatos();
	}
	
	public List<String> getEmpresas()
	{
		return datosLeidos.getEmpresas();
	}

	public List<String> getPeriodos()
	{
		return datosLeidos.getPeriodos();
	}

	public List<String> getNombresCuentas()
	{
		return datosLeidos.getNombresCuentas();
	}
	
	public List<EstructuraEsperada> registros()
	{
		return datosLeidos.getRegistros();
	}
}
