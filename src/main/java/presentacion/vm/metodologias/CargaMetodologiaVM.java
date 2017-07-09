package presentacion.vm.metodologias;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import negocio.dominio.Indicador;
import negocio.dominio.Metodologia;
import negocio.dominio.condiciones.Condicion;
import negocio.dominio.condiciones.criterios.Criterio;
import negocio.repositorio.RepositorioCriterios;
import negocio.repositorio.RepositorioIndicadores;
import negocio.repositorio.RepositorioMetodologias;

@Observable
public class CargaMetodologiaVM 
{
	private String nombreMetodologia;
	
	private List<Indicador> indicadores;
	private Indicador indicadorSeleccionado;
	
	private List<Criterio> criterios;
	private Criterio criterioSeleccionado;
	
	private Double valor;
	private Integer cantidadPeriodos;
	private Integer prioridad;
	
	private List<Condicion> condiciones = new ArrayList<>();
	
	
	public CargaMetodologiaVM() {
		
		indicadores = RepositorioIndicadores.getIndicadores();
		criterios = RepositorioCriterios.getCriterios();
	}
	
	public void guardarMetodologia() 
	{
		RepositorioMetodologias.agregarMetodologia(new Metodologia(nombreMetodologia, condiciones));
	}


	public void agregarCondicion() 
	{	
		condiciones.add(new Condicion(criterioSeleccionado, indicadorSeleccionado, valor, cantidadPeriodos, prioridad));
		
		ObservableUtils.firePropertyChanged(this, "condiciones");
	}

	
	
	
	//PROPIEDADES
	public String getNombreMetodologia() {
		return nombreMetodologia;
	}

	public void setNombreMetodologia(String nombreMetodologia) {
		this.nombreMetodologia = nombreMetodologia;
	}

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

	public List<Criterio> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
	}

	public Criterio getCriterioSeleccionado() {
		return criterioSeleccionado;
	}

	public void setCriterioSeleccionado(Criterio criterioSeleccionado) {
		this.criterioSeleccionado = criterioSeleccionado;
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

	public List<Condicion> getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(List<Condicion> condiciones) {
		this.condiciones = condiciones;
	}
}