package presentacion.vm.cuentas;

import java.util.Arrays;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import negocio.dominio.excepciones.FilaConFormatoIncorrectoException;
import negocio.dominio.excepciones.FuenteInvalidaException;
import negocio.dominio.excepciones.NoSePuedeAgregarCuentaException;
import negocio.dominio.manejoArchivos.Importador;
import negocio.dominio.manejoArchivos.fuente.FuenteExcel;
import negocio.dominio.manejoArchivos.fuente.FuenteTxt;
import negocio.dominio.manejoArchivos.parser.ParserArchivo;
import negocio.repositorio.RepositorioEmpresas;

@Observable
public class CargaMasivaCuentaVM 
{
	private String rutaDelArchivo;
	private String tipoArchivoSeleccionado = "Texto Plano";;
	private Importador importador;
	
	public void cargarDatos()
	{	
		if(tipoArchivoSeleccionado.equals("Texto Plano"))
			importador = new Importador(new FuenteTxt(),new ParserArchivo(' '));
		else
			importador = new Importador(new FuenteExcel(),new ParserArchivo(' '));
		
		if(rutaDelArchivo == null)
			throw new UserException("Hace falta cargar la ruta del archivo para continuar");			
		
		try
		{
			importador.obtenerDatos(rutaDelArchivo);
			
			RepositorioEmpresas.agregarVariasEmpresas(importador.parsearDatos());
		}
		catch(NoSePuedeAgregarCuentaException e)
		{
			throw new UserException("Algunas cuentas no se agregaron debido a que estaban duplicadas");
		}
		catch(FuenteInvalidaException | FilaConFormatoIncorrectoException e)
		{
			throw new UserException(e.getMessage());
		}
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