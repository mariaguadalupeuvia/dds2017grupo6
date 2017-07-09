package negocio.dominio.condiciones;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Empresa;
import negocio.dominio.Indicador;
import negocio.dominio.condiciones.criterios.Criterio;

@Observable
public class Condicion {

	private Criterio criterio;

	private Indicador indicador;
	private Double valor;
	private Integer cantidadPeriodos;
	private Integer prioridad;
	
	public Boolean evaluar(Empresa unaEmpresa, Empresa otraEmpresa) {

		return criterio.evaluar(unaEmpresa, otraEmpresa, indicador, valor, cantidadPeriodos);
	}

	
	
	//PROPIEDADES
	public Condicion(Criterio criterio, Indicador indicador, Double valor, Integer cantidadPeriodos, Integer prioridad) {
		
		this.criterio = criterio;
		this.indicador = indicador;
		this.valor = valor;
		this.cantidadPeriodos = cantidadPeriodos;
		this.prioridad = prioridad;
	}

	public Criterio getCriterio() {
		return criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	public Indicador getIndicador() {
		return indicador;
	}

	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
