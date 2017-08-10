package presentacion.vm.metodologias.condiciones;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Indicador;
import negocio.dominio.condiciones.CondicionOrdenamiento;
import negocio.dominio.condiciones.criterios.ordenamiento.CriterioOrdenamiento;
import negocio.repositorio.RepositorioCriterios;
import negocio.repositorio.RepositorioIndicadores;

@Observable
public class CargaCondicionOrdenamientoVM {

	private List<Indicador> indicadores;
	private Indicador indicadorSeleccionado;
	
	private List<CriterioOrdenamiento> criteriosOrdenamiento;
	private CriterioOrdenamiento criterioOrdenamientoSeleccionado;
	
	private Integer cantidadPeriodos;
	private Integer prioridad;
	
	public CargaCondicionOrdenamientoVM() {
		
		indicadores = RepositorioIndicadores.getIndicadores();
		criteriosOrdenamiento = RepositorioCriterios.getCriteriosOrdenamiento();
	}
	
	public CondicionOrdenamiento agregarCondicionOrdenamiento() 
	{	
		return new CondicionOrdenamiento(criterioOrdenamientoSeleccionado, indicadorSeleccionado, cantidadPeriodos, prioridad);
	}
	
	
	
	
	//PROPIEDADES
	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}

	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}

	public void setIndicadorSeleccionado(Indicador indicadorSeleccionado) {
		this.indicadorSeleccionado = indicadorSeleccionado;
	}

	public Integer getCantidadPeriodos() {
		return cantidadPeriodos;
	}

	public void setCantidadPeriodos(Integer cantidadPeriodos) {
		this.cantidadPeriodos = cantidadPeriodos;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public List<CriterioOrdenamiento> getCriteriosOrdenamiento() {
		return criteriosOrdenamiento;
	}

	public void setCriteriosOrdenamiento(List<CriterioOrdenamiento> criteriosOrdenamiento) {
		this.criteriosOrdenamiento = criteriosOrdenamiento;
	}

	public CriterioOrdenamiento getCriterioOrdenamientoSeleccionado() {
		return criterioOrdenamientoSeleccionado;
	}

	public void setCriterioOrdenamientoSeleccionado(CriterioOrdenamiento criterioOrdenamientoSeleccionado) {
		this.criterioOrdenamientoSeleccionado = criterioOrdenamientoSeleccionado;
	}
}