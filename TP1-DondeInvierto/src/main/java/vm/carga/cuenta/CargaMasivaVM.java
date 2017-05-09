package vm.carga.cuenta;

import org.uqbar.commons.utils.Observable;
import dominio.Importador;
import dominio.ParserCuenta;


@Observable
public class CargaMasivaVM 
{
	private String rutaDelArchivo;

	public String getRutaDelArchivo() {
		return rutaDelArchivo;
	}

	public void setRutaDelArchivo(String rutaDelArchivo) {
		this.rutaDelArchivo = rutaDelArchivo;
	}

	public void cargarDatos() 
	{
		Importador.cargarDatosDe(rutaDelArchivo, new ParserCuenta());
	}

}