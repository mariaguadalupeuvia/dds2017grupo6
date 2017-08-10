package presentacion.vm.metodologias;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Metodologia;
import negocio.dominio.condiciones.CondicionFiltrado;
import negocio.dominio.condiciones.CondicionOrdenamiento;

import negocio.repositorio.RepositorioMetodologias;

@Observable
public class CargaMetodologiaVM 
{
	private String nombreMetodologia;
	
	private List<CondicionFiltrado> condicionesFiltrado = new ArrayList<>();
	private List<CondicionOrdenamiento> condicionesOrdenamiento = new ArrayList<>();
	
	public void agregarCondicionFiltrado(CondicionFiltrado condicionFiltrado) 
	{
		condicionesFiltrado.add(condicionFiltrado);
	}
	
	public void agregarCondicionOrdenamiento(CondicionOrdenamiento condicionOrdenamiento) 
	{
		condicionesOrdenamiento.add(condicionOrdenamiento);
	}
	
	public void guardarMetodologia() 
	{
		RepositorioMetodologias.agregarMetodologia(new Metodologia(nombreMetodologia, condicionesFiltrado, condicionesOrdenamiento));
	}
	
	
	
	//PROPIEDADES
	public String getNombreMetodologia() {
		return nombreMetodologia;
	}

	public void setNombreMetodologia(String nombreMetodologia) {
		this.nombreMetodologia = nombreMetodologia;
	}

	public List<CondicionFiltrado> getCondicionesFiltrado() {
		return condicionesFiltrado;
	}

	public void setCondicionesFiltrado(List<CondicionFiltrado> condicionesFiltrado) {
		this.condicionesFiltrado = condicionesFiltrado;
	}

	public List<CondicionOrdenamiento> getCondicionesOrdenamiento() {
		return condicionesOrdenamiento;
	}

	public void setCondicionesOrdenamiento(List<CondicionOrdenamiento> condicionesOrdenamiento) {
		this.condicionesOrdenamiento = condicionesOrdenamiento;
	}
}