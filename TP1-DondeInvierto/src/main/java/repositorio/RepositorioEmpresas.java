package repositorio;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import dominio.Empresa;

public class RepositorioEmpresas {

	private static List<Empresa> empresas;
	
	public static void inicializarRepositorio() 
	{
		empresas = new ArrayList<>();
	}
	
	public static void agregar(Empresa empresa)
	{
		empresas.add(empresa);
	}
	
	public static void agregarVarias(List<Empresa> nuevasEmpresas) 
	{
		empresas.addAll(empresas);
	}
	
	//PROPIEDADES
	public static List<Empresa> getEmpresas() 
	{
		Set<Empresa> linkedHashSet = new LinkedHashSet<Empresa>();
		linkedHashSet.addAll(empresas);
		empresas.clear();
		empresas.addAll(linkedHashSet);
		return empresas;
	}
	
	public static List<String> getNombresEmpresas() 
	{
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		List<String> nombresEmpresas = empresas.stream().map(empresa -> empresa.getNombre())
				.collect(Collectors.toList());
		linkedHashSet.addAll(nombresEmpresas);

		return nombresEmpresas;

	}

	public static void setEmpresas(ArrayList<Empresa> nuevasEmpresas) 
	{
		empresas = nuevasEmpresas;
	}

	public static void setNombresEmpresas(ArrayList<String> datosPruebaEmpresas) {
		// TODO Auto-generated method stub
		
	}
}
