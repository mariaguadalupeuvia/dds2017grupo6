package presentacion.vm.metodologias.condiciones;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Indicador;
import negocio.dominio.condiciones.CondicionFiltrado;
import negocio.dominio.condiciones.criterios.filtrado.CriterioFiltrado;
import negocio.repositorio.RepositorioCriterios;
import negocio.repositorio.RepositorioIndicadores;

@Observable
public class CargaCondicionFiltradoVM {

	private List<Indicador> indicadores;
	private Indicador indicadorSeleccionado;
	
	private List<CriterioFiltrado> criteriosFiltrado;
	private CriterioFiltrado criterioFiltradoSeleccionado;
	
	private Double valor;
	private Integer cantidadPeriodos;
	
	public CargaCondicionFiltradoVM() {
		
		indicadores = RepositorioIndicadores.getIndicadores();
		criteriosFiltrado = RepositorioCriterios.getCriteriosFiltrado();
	}
	
	public CondicionFiltrado agregarCondicionFiltrado() 
	{	
		return new CondicionFiltrado(criterioFiltradoSeleccionado, indicadorSeleccionado, valor, cantidadPeriodos);
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

	public List<CriterioFiltrado> getCriteriosFiltrado() {
		return criteriosFiltrado;
	}

	public void setCriteriosFiltrado(List<CriterioFiltrado> criteriosFiltrado) {
		this.criteriosFiltrado = criteriosFiltrado;
	}

	public CriterioFiltrado getCriterioFiltradoSeleccionado() {
		return criterioFiltradoSeleccionado;
	}

	public void setCriterioFiltradoSeleccionado(CriterioFiltrado criterioFiltradoSeleccionado) {
		this.criterioFiltradoSeleccionado = criterioFiltradoSeleccionado;
	}
}