package repositorio;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import dominio.Indicador;

public class RepositorioIndicadores {

private static List<Indicador> indicadores;
	
	public static void inicializarRepositorio() 
	{
		indicadores = new ArrayList<>();
	}
	
	public static void agregar(Indicador indicador)
	{
		indicadores.add(indicador);
	}

	public static void agregarVarios(List<Indicador> nuevosIndicadores) 
	{
		indicadores.addAll(nuevosIndicadores);
	}
	
	
	//PROPIEDADES
	public static List<Indicador> getIndicadores() 
	{
		Set<Indicador> linkedHashSet = new LinkedHashSet<Indicador>();
		linkedHashSet.addAll(indicadores);
		indicadores.clear();
		indicadores.addAll(linkedHashSet);
		return indicadores;
	}
	
	public static List<String> getNombresIndicadores() 
	{
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		List<String> nombresIndicadores = indicadores.stream().map(indicador -> indicador.getNombre())
				.collect(Collectors.toList());
		linkedHashSet.addAll(nombresIndicadores);
		return nombresIndicadores;
	}
	
	public static void setIndicadores(ArrayList<Indicador> nuevosIndicadores) 
	{
		indicadores = nuevosIndicadores;
	}
	
	public static void setNombresIndicadores(ArrayList<String> nuevosNombresIndicadores) 
	{
		// TODO Auto-generated method stub
	}



}
