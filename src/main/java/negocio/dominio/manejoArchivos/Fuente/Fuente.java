package negocio.dominio.manejoArchivos.Fuente;

import java.util.List;

public interface Fuente 
{
	void leerDatos(String ruta);
	
	List<String> getDatos();
}