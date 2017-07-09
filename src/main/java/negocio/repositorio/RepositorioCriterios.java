package negocio.repositorio;

import java.util.ArrayList;
import java.util.List;

import negocio.dominio.condiciones.criterios.Criterio;

public class RepositorioCriterios {


	private static List<Criterio> criterios;
	
	public static void inicializarRepositorio()
	{
		criterios = new ArrayList<>();
	}
	
	public static void agregarPredefinidos(List<Criterio> criteriosNuevos)
	{
		criterios.addAll(criteriosNuevos);
	}
	
	
	//PROPIEDADES
	public static void setCriterios(List<Criterio> criteriosNuevos)
	{
		criterios = criteriosNuevos;
	}
	public static List<Criterio> getCriterios() {
		
		return criterios;
	}
}