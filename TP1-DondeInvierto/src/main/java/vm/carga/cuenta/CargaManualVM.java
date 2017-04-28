package vm.carga.cuenta;

import java.util.List;
import org.uqbar.commons.utils.Observable;
import dominio.datos.DatosTxt;
import interfases.IOrigenDatos;

@Observable
public class CargaManualVM 
{
	IOrigenDatos datosLeidos;
	public CargaManualVM()
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
}
