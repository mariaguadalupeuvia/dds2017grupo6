package vm.carga.cuenta;

import org.uqbar.commons.utils.Observable;
import dominio.Importador;
import dominio.ParserCuenta;
import repositorio.RepositorioCuentas;
import repositorio.RepositorioEmpresas;
import repositorio.RepositorioNombresCuentas;
import repositorio.RepositorioPeriodos;


@Observable
public class CargaMasivaVM 
{
	private String rutaDelArchivo;
	private Importador importador = new Importador();
	
	public String getRutaDelArchivo() {
		return rutaDelArchivo;
	}

	public void setRutaDelArchivo(String rutaDelArchivo) {
		this.rutaDelArchivo = rutaDelArchivo;
	}

	public void cargarDatos() 
	{
		RepositorioNombresCuentas.resetNombresCuentas();
		RepositorioPeriodos.resetPeriodos();
		RepositorioCuentas.resetCuentas();
		RepositorioEmpresas.resetEmpresas();
		importador.cargarDatosDe(rutaDelArchivo, new ParserCuenta());
	}

}