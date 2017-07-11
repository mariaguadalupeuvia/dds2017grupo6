package negocio.dominio;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import negocio.dominio.condiciones.Condicion;


public class Metodologia {

	private String nombre;
	
	private List<Condicion> condicionesDeFiltro;
	private List<Condicion> condicionesDeOrden;
	
	public Metodologia(String nombre,  List<Condicion> condiciones) {

		this.nombre = nombre;
		this.condicionesDeFiltro = condiciones.stream().filter(c -> c.getPrioridad() == 0).collect(Collectors.toList());
		this.condicionesDeOrden = condiciones.stream().filter(c ->  c.getPrioridad() != 0).collect(Collectors.toList());
	}

	public List<Empresa> evaluar(List<Empresa> empresasDesordenadas) {
		
		return empresasDesordenadas.stream()
				.filter(e -> pasaTodosLosFiltros(e))
				.sorted((e1, e2) -> comparar(e1, e2)).collect(Collectors.toList());
		
	}
	
	
	private boolean pasaTodosLosFiltros(Empresa e) {

		return condicionesDeFiltro.stream().allMatch(filtro -> filtro.evaluar(e, null));
	}
	
	
	private Integer comparar(Empresa unaEmpresa, Empresa otraEmpresa) {

		condicionesDeOrden.sort(Comparator.comparing(Condicion::getPrioridad));
		
		int i = 0;
		int resultado = 0;
		
		if (condicionesDeOrden.size() > 0) {
			while (resultado == 0) {
				Condicion condicion = condicionesDeOrden.get(i);
				if(condicion.evaluar(unaEmpresa, otraEmpresa))
					resultado = 1;
				else if(condicion.evaluar(otraEmpresa,unaEmpresa))
					resultado = -1;
				else
					resultado = 0;

				i++;
			}
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}