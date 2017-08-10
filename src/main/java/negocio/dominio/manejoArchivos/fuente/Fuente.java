package negocio.dominio.manejoArchivos.fuente;

import java.util.List;

import negocio.dominio.excepciones.FuenteInvalidaException;

public interface Fuente 
{
	void leerDatos(String ruta) throws FuenteInvalidaException;
	
	List<String> getDatos();
}