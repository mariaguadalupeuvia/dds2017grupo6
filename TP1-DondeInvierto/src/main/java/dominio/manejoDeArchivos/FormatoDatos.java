package dominio.manejoDeArchivos;

import java.util.List;

import dominio.Cuenta;

public interface FormatoDatos 
{
	void cargarDatosDe(String rutaDelArchivo);

	List<Cuenta> getCuentas();

	List<String> getNombresCuentas();

	List<String> getEmpresas();

	List<Integer> getPeriodos();
}
