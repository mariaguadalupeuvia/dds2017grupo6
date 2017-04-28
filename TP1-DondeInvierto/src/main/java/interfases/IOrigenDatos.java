package interfases;

import java.util.List;

import dominio.datos.EstructuraEsperada;

public interface IOrigenDatos 
{
	public List<String> getEmpresas();
	public List<String> getPeriodos();
	public List<String> getNombresCuentas();
	public void cargarDatos();
	public List<EstructuraEsperada> getRegistros();
	public void cargarDatosDe(String rutaArchivo);
}
