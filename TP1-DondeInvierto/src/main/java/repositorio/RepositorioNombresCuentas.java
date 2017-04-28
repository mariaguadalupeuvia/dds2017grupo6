package repositorio;

import java.util.ArrayList;
import java.util.List;

public class RepositorioNombresCuentas {
	
	private static List<String> nombresCuentas;
	
	public static void inicializarRepositorio() 
	{
		nombresCuentas = new ArrayList<>();
	}
	
	public static void agregar(String nombreCuenta)
	{
		nombresCuentas.add(nombreCuenta);
	}

	public static void agregarVarios(List<String> nuevosNombresCuentas) 
	{
		nombresCuentas.addAll(nuevosNombresCuentas);
	}
	
	
	
	//PROPIEDADES
	public static List<String> getNombresCuentas() 
	{
		return nombresCuentas;
	}
	
	public static void setNombresCuentas(ArrayList<String> nuevosNombresCuentas) 
	{
		nombresCuentas = nuevosNombresCuentas;
	}
}
