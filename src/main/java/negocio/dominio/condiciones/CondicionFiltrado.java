package negocio.dominio.condiciones;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Empresa;
import negocio.dominio.Indicador;
import negocio.dominio.condiciones.criterios.filtrado.CriterioFiltrado;
import negocio.dominio.excepciones.NoSePudoAplicarCriterioException;

@Observable
public class CondicionFiltrado {

	private CriterioFiltrado criterioFiltrado;
	private Indicador indicador;
	private Double valor;
	private Integer cantidadPeriodos;
	
	public Boolean cumple(Empresa unaEmpresa) throws NoSePudoAplicarCriterioException {

		return criterioFiltrado.cumple(unaEmpresa, indicador, valor, cantidadPeriodos);
	}

	
	
	//CONSTRUCTOR Y PROPIEDADES
	public CondicionFiltrado(CriterioFiltrado criterioFiltrado, Indicador indicador, Double valor, Integer cantidadPeriodos) {
		
		this.criterioFiltrado = criterioFiltrado;
		this.indicador = indicador;
		this.valor = valor;
		this.cantidadPeriodos = cantidadPeriodos;
	}

	public CriterioFiltrado getCriterioFiltrado() {
		return criterioFiltrado;
	}

	public void setCriterioFiltrado(CriterioFiltrado criterioFiltrado) {
		this.criterioFiltrado = criterioFiltrado;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}