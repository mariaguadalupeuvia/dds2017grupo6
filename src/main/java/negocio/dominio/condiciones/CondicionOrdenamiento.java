package negocio.dominio.condiciones;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Empresa;
import negocio.dominio.Indicador;
import negocio.dominio.condiciones.criterios.ordenamiento.CriterioOrdenamiento;
import negocio.dominio.excepciones.NoSePudoAplicarCriterioException;

@Observable
public class CondicionOrdenamiento {

	private CriterioOrdenamiento criterioOrdenamiento;
	private Indicador indicador;
	private Integer cantidadPeriodos;
	private Integer prioridad;
	
	public Integer comparar(Empresa unaEmpresa, Empresa otraEmpresa) throws NoSePudoAplicarCriterioException {

		return criterioOrdenamiento.comparar(unaEmpresa, otraEmpresa, indicador, cantidadPeriodos);
	}
	
	
	
	//CONSTRUCTOR Y PROPIEDADES
	public CondicionOrdenamiento(CriterioOrdenamiento criterioOrdenamiento, Indicador indicador, Integer cantidadPeriodos, Integer prioridad) {
		
		this.criterioOrdenamiento = criterioOrdenamiento;
		this.indicador = indicador;
		this.cantidadPeriodos = cantidadPeriodos;
		this.prioridad = prioridad;
	}

	public CriterioOrdenamiento getCriterioOrdenamiento() {
		return criterioOrdenamiento;
	}

	public void setCriterioOrdenamiento(CriterioOrdenamiento criterioOrdenamiento) {
		this.criterioOrdenamiento = criterioOrdenamiento;
	}

	public Indicador getIndicador() {
		return indicador;
	}

	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
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
}