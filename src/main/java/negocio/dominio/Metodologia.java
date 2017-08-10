package negocio.dominio;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import negocio.dominio.condiciones.CondicionFiltrado;
import negocio.dominio.condiciones.CondicionOrdenamiento;
import negocio.dominio.evaluacionEmpresas.LogEmpresasNoEvaluadas;
import negocio.dominio.excepciones.NoSePudoAplicarCriterioException;

public class Metodologia {

	private String nombre;
	private List<CondicionFiltrado> condicionesFiltrado;
	private List<CondicionOrdenamiento> condicionesOrdenamiento;
	
	private LogEmpresasNoEvaluadas log;
	
	public Metodologia(String nombre,  List<CondicionFiltrado> condicionesFiltrado, List<CondicionOrdenamiento> condicionesOrdenamiento) {

		this.nombre = nombre;
		this.condicionesFiltrado = condicionesFiltrado;
		this.condicionesOrdenamiento = condicionesOrdenamiento;
		log = new LogEmpresasNoEvaluadas();
	}


	public List<Empresa> evaluar(List<Empresa> empresasSinEvaluar) {
		
		return empresasSinEvaluar.stream()
				.filter(empresa -> pasaTodosLosFiltros(empresa))
				.sorted((unaEmpresa, otraEmpresa) -> comparar(unaEmpresa, otraEmpresa))
				.collect(Collectors.toList());
	}
	
	
	
	public boolean pasaTodosLosFiltros(Empresa empresa) {
		
		return condicionesFiltrado.stream().allMatch(condicion -> {
			
			try 
			{
				return condicion.cumple(empresa);
			} 
			catch (NoSePudoAplicarCriterioException e) {

				log.informarEmpresaNoFiltrada(empresa, e.getMessage());
				
				return false;
			}
		});
	}
	

	public Integer comparar(Empresa unaEmpresa, Empresa otraEmpresa) {

		List<CondicionOrdenamiento> condiciones = condicionesOrdenamiento
												  .stream()
												  .sorted(Comparator.comparing(CondicionOrdenamiento::getPrioridad))
												  .collect(Collectors.toList());
		int resultado = 0;
		
		for (CondicionOrdenamiento condicion : condiciones) {
			
			if(resultado == 0)
			{
				try 
				{
					resultado = condicion.comparar(unaEmpresa, otraEmpresa);
				} 
				catch (NoSePudoAplicarCriterioException e) 
				{
					log.informarParEmpresasNoComparadas(unaEmpresa, otraEmpresa, e.getMessage());
				}
			}
		}

		return resultado;
	}
	
	@Override
	public String toString() {
		return nombre;
	}

	public LogEmpresasNoEvaluadas getLog() {
		return log;
	}
}