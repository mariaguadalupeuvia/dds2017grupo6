package vm.carga.indicador;

import org.uqbar.commons.utils.Observable;
import dominio.Importador;
import dominio.ParserIndicador;


@Observable
public class CargaMasivaIndicadoresVM 
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
		importador.cargarDatosDe(rutaDelArchivo, new ParserIndicador());	
	}

}
