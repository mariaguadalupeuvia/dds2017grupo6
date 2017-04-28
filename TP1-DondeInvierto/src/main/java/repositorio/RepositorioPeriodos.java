package repositorio;

import java.util.ArrayList;
import java.util.List;

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
		return periodos;
	}
	
	public static void setPeriodos(ArrayList<Integer> nuevosPeriodos) 
	{
		periodos = nuevosPeriodos;
	}

}
