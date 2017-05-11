package repositorio;

import java.util.ArrayList;
import java.util.List;


public class RepositorioPeriodos {

	private static List<String> periodos;
	
	public static void inicializarRepositorio() 
	{
		periodos = new ArrayList<>();
	}
	
	public static void agregar(String periodo)
	{
		periodos.add(periodo);
	}
	
	public static void agregarVarios(List<String> nuevosPeriodos) 
	{
		periodos.addAll(nuevosPeriodos);
	}
	
	public static void agregarSiNoExiste(String nombrePeriodo)
	{
		if(!periodos.contains(nombrePeriodo.toLowerCase()))
		{
			periodos.add(nombrePeriodo.toLowerCase());
		}
	}
	
	//PROPIEDADES
	public static List<String> getPeriodos() 
	{
		return periodos;
	}
	
	public static void setPeriodos(ArrayList<String> nuevosPeriodos) 
	{
		periodos = nuevosPeriodos;
	}

	public static void resetPeriodos() {
		periodos.clear();
		
	}

}
