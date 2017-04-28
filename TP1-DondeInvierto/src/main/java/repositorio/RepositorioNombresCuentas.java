package repositorio;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.addAll(nombresCuentas);
		nombresCuentas.clear();
		nombresCuentas.addAll(linkedHashSet);
		
		return nombresCuentas;
	}
	
	public static void setNombresCuentas(ArrayList<String> nuevosNombresCuentas) 
	{
		nombresCuentas = nuevosNombresCuentas;
	}
}
