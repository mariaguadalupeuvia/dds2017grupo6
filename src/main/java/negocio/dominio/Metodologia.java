package negocio.dominio;

import java.util.List;

import negocio.dominio.condiciones.CondicionFiltrado;
import negocio.dominio.condiciones.CondicionOrdenamiento;

public class Metodologia {

	private String nombre;
	private List<CondicionFiltrado> condicionesFiltrado;
	private List<CondicionOrdenamiento> condicionesOrdenamiento;
	
	public Metodologia(String nombre,  List<CondicionFiltrado> condicionesFiltrado, List<CondicionOrdenamiento> condicionesOrdenamiento) {

		this.nombre = nombre;
		this.condicionesFiltrado = condicionesFiltrado;
		this.condicionesOrdenamiento = condicionesOrdenamiento;
	}


//	public void evaluar(List<Empresa> empresasSinEvaluar) {
//		
//		empresasSinEvaluar.stream()
//		.filter(empresa -> pasaTodosLosFiltros(empresa))
//		.sorted((unaEmpresa, otraEmpresa) -> comparar(unaEmpresa, otraEmpresa))
//		.collect(Collectors.toList());
//	}
//	
//	
//	private boolean pasaTodosLosFiltros(Empresa empresa) {
//		
//		return condicionesFiltrado.stream().allMatch(filtro -> filtro.cumple(empresa));
//	}
//	
//	
//	//ARREGLAR ESTO QUE ES UN ASCO
//	private Integer comparar(Empresa unaEmpresa, Empresa otraEmpresa) {
//
//		return 0;
//		condicionesOrdenamiento.sort(Comparator.comparing(CondicionOrdenamiento::getPrioridad));
//		
//		int i = 0;
//		int resultado = 0;
//		
//		if (condicionesOrdenamiento.size() > 0) {
//			
//			while (resultado == 0) {
//				
//				CondicionOrdenamiento condicion = condicionesOrdenamiento.get(i);
//				
//				resultado = condicion.comparar(unaEmpresa, otraEmpresa);
//
//				i++;
//			}
//		}
//		return resultado;
//	}
	
	@Override
	public String toString() {
		return nombre;
	}
}