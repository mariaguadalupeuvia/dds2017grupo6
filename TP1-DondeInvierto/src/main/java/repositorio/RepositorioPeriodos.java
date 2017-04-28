package repositorio;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RepositorioPeriodos {

	private static List<Integer> periodos;
	
	public static void inicializarRepositorio() 
	{
		periodos = new ArrayList<>();
	}
	
	public static void agregar(Integer periodo)
	{
		periodos.add(periodo);
	}
	
	public static void agregarVarios(List<Integer> nuevosPeriodos) 
	{
		periodos.addAll(nuevosPeriodos);
	}
	
	
	
	//PROPIEDADES
	public static List<Integer> getPeriodos() 
	{
		Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
		linkedHashSet.addAll(periodos);
		periodos.clear();
		periodos.addAll(linkedHashSet);
		
		return periodos;
	}
	
	public static void setPeriodos(ArrayList<Integer> nuevosPeriodos) 
	{
		periodos = nuevosPeriodos;
	}

}
