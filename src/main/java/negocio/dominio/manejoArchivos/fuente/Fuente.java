package negocio.dominio.manejoArchivos.fuente;

import java.util.List;

public interface Fuente 
{
	void leerDatos(String ruta);
	
	List<String> getDatos();
}