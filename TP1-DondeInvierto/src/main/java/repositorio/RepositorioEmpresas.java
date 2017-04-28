package repositorio;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RepositorioEmpresas {

	private static List<String> empresas;
	
	public static void inicializarRepositorio() 
	{
		empresas = new ArrayList<>();
	}
	
	public static void agregar(String empresa)
	{
		empresas.add(empresa);
	}
	
	public static void agregarVarias(List<String> nuevasEmpresas) 
	{
		empresas.addAll(empresas);
	}
	
	
	
	//PROPIEDADES
	public static List<String> getEmpresas() 
	{
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.addAll(empresas);
		empresas.clear();
		empresas.addAll(linkedHashSet);
		
		return empresas;
	}

	public static void setEmpresas(ArrayList<String> nuevasEmpresas) 
	{
		empresas = nuevasEmpresas;
	}
}
