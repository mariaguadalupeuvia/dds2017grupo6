package negocio.repositorio;

import java.util.ArrayList;
import java.util.List;

import negocio.dominio.condiciones.criterios.filtrado.CriterioFiltrado;
import negocio.dominio.condiciones.criterios.ordenamiento.CriterioOrdenamiento;

public class RepositorioCriterios {


	private static List<CriterioFiltrado> criteriosFiltrado;
	private static List<CriterioOrdenamiento> criteriosOrdenamiento;
	
	public static void inicializarRepositorio()
	{
		criteriosFiltrado = new ArrayList<>();
		criteriosOrdenamiento = new ArrayList<>();
	}
	
	public static void agregarCriteriosFiltradoPredefinidos(List<CriterioFiltrado> criteriosFiltradoNuevos)
	{
		criteriosFiltrado.addAll(criteriosFiltradoNuevos);
	}
	
	public static void agregarCriteriosOrdenamientoPredefinidos(List<CriterioOrdenamiento> criteriosOrdenamientoNuevos)
	{
		criteriosOrdenamiento.addAll(criteriosOrdenamientoNuevos);
	}
	
		
	
	//PROPIEDADES
	public static List<CriterioFiltrado> getCriteriosFiltrado() {
		return criteriosFiltrado;
	}

	public static void setCriteriosFiltrado(List<CriterioFiltrado> criteriosFiltrado) {
		RepositorioCriterios.criteriosFiltrado = criteriosFiltrado;
	}

	public static List<CriterioOrdenamiento> getCriteriosOrdenamiento() {
		return criteriosOrdenamiento;
	}

	public static void setCriteriosOrdenamiento(List<CriterioOrdenamiento> criteriosOrdenamiento) {
		RepositorioCriterios.criteriosOrdenamiento = criteriosOrdenamiento;
	}
}