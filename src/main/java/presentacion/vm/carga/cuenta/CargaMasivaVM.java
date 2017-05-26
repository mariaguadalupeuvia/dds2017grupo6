package presentacion.vm.carga.cuenta;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.uqbar.commons.utils.Observable;

import negocio.dominio.manejoArchivos.Importador;
import negocio.dominio.manejoArchivos.Fuente.FuenteExcel;
import negocio.dominio.manejoArchivos.Fuente.FuenteTxt;
import negocio.dominio.manejoArchivos.Parser.ParserArchivo;
import negocio.repositorio.RepositorioEmpresas;

@Observable
public class CargaMasivaVM 
{
	private String rutaDelArchivo;
	private String tipoArchivoSeleccionado;
	private Importador importador;
	
	public void cargarDatos() throws EncryptedDocumentException, InvalidFormatException, IOException
	{	
		if(tipoArchivoSeleccionado.equals("Texto Plano"))
		{
			importador = new Importador(new FuenteTxt(),new ParserArchivo(' '));
		}
		else
		{
			importador = new Importador(new FuenteExcel(),new ParserArchivo(' '));
		}
		
		importador.obtenerDatos(rutaDelArchivo);
		
		RepositorioEmpresas.agregarVariasEmpresas(importador.parsearDatos());	
	}
	
	
	
	//PROPIEDADES
	public List<String>getTiposArchivos()
	{
		return Arrays.asList("Texto Plano", "Excel");
	}
	
	public String getRutaDelArchivo() {
		return rutaDelArchivo;
	}

	public void setRutaDelArchivo(String rutaDelArchivo) {
		this.rutaDelArchivo = rutaDelArchivo;
	}

	public String getTipoArchivoSeleccionado() {
		return tipoArchivoSeleccionado;
	}

	public void setTipoArchivoSeleccionado(String tipoArchivoSeleccionado) {
		this.tipoArchivoSeleccionado = tipoArchivoSeleccionado;
	}
}