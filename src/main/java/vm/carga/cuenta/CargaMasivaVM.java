package vm.carga.cuenta;

import org.uqbar.commons.utils.Observable;
import dominio.Importador;
import dominio.ParserCuenta;


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
		importador.cargarDatosDe(rutaDelArchivo, new ParserCuenta());
	}

}