package vm.carga.cuenta;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import dominio.Cuenta;
import dominio.manejoDeArchivos.FormatoDatos;
import dominio.manejoDeArchivos.excel.DatosExcel;
import dominio.manejoDeArchivos.txt.DatosTxt;
import repositorio.RepositorioCuentas;
import repositorio.RepositorioEmpresas;
import repositorio.RepositorioNombresCuentas;
import repositorio.RepositorioPeriodos;

@Observable
public class CargaMasivaVM 
{
	private String rutaDelArchivo;
	private FormatoDatos datos;

	public String getRutaDelArchivo() {
		return rutaDelArchivo;
	}

	public void setRutaDelArchivo(String rutaDelArchivo) {
		this.rutaDelArchivo = rutaDelArchivo;
	}

	public void cargarDatos() 
	{
		//datos = new DatosTxt();
		datos = new DatosExcel();
		datos.cargarDatosDe(rutaDelArchivo);

		
		List<Cuenta> nuevasCuentas = datos.getCuentas();
		List<String> nuevasEmpresas = datos.getEmpresas();
		List<String> nuevosNombresCuentas = datos.getNombresCuentas();
		List<Integer> nuevosPeriodos = datos.getPeriodos();
		
		
		RepositorioCuentas.agregarVarias(nuevasCuentas);
		
		RepositorioEmpresas.agregarVarias(nuevasEmpresas);	
		
		RepositorioNombresCuentas.agregarVarios(nuevosNombresCuentas);
		
		RepositorioPeriodos.agregarVarios(nuevosPeriodos);
	}

	public FormatoDatos getDatos() {
		return datos;
	}

	public void setDatos(FormatoDatos datos) {
		this.datos = datos;
	}	
}