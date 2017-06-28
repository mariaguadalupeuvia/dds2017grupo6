package negocio.repositorio;

import java.util.ArrayList;
import java.util.List;

import negocio.dominio.Indicador;
import negocio.dominio.excepciones.NoExisteIndicadorException;
import negocio.dominio.excepciones.NoSePuedeAgregarIndicadorException;

public class RepositorioIndicadores
{
	private static List<Indicador> indicadores;
	
	
	public static Indicador buscarIndicador(String nombre) throws NoExisteIndicadorException {
		
		return indicadores.stream().filter(indicador -> indicador.getNombre().equals(nombre)).
				findAny().orElseThrow(() -> new NoExisteIndicadorException("El indicador: " + nombre + " no esta cargado"));
	}
	
	
	public static void inicializarRepositorio()
	{
		indicadores = new ArrayList<>();
	}
	
	public static void agregarIndicador(Indicador indicadorNuevo) 
	{
		if(!existeIndicadorDeNombre(indicadorNuevo.getNombre()))
		{
			indicadores.add(indicadorNuevo);
		}			
		else
		{
			throw new NoSePuedeAgregarIndicadorException("Ya existe ese indicador");
		}
	}

	private static boolean existeIndicadorDeNombre(String nombre) 
	{
		return indicadores.stream().anyMatch(indicador -> indicador.getNombre().equals(nombre));
	}
	
	public static void agregarPredefinidos(List<Indicador> indicadoresNuevos)
	{
		indicadores.addAll(indicadoresNuevos);
	}
	
	
	
	//PROPIEDADES
	public static List<Indicador> getIndicadores()
	{
		return indicadores;
	}
	public static void setIndicadores(List<Indicador> indicadoresNuevos)
	{
		indicadores = new ArrayList<>(indicadoresNuevos);
	}
}