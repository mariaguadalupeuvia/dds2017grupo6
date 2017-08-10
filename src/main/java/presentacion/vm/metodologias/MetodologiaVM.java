package presentacion.vm.metodologias;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Empresa;
import negocio.dominio.Metodologia;
import negocio.dominio.evaluacionEmpresas.EmpresaNoFiltrada;
import negocio.dominio.evaluacionEmpresas.ParEmpresasNoComparadas;
import negocio.repositorio.RepositorioEmpresas;
import negocio.repositorio.RepositorioMetodologias;

@Observable
public class MetodologiaVM 
{
	private List<Metodologia> metodologias;
	private Metodologia metodologiaSeleccionada;
	
	private List<ParEmpresasNoComparadas> empresasNoComparadas;
	private List<EmpresaNoFiltrada> empresasNoFiltradas;
	private List<Empresa> empresasEvaluadas;
	
	
	public MetodologiaVM()
	{
		metodologias = RepositorioMetodologias.getMetodologias();
	}
	
	public void aplicarMetodologia() 
	{
		setEmpresasEvaluadas(metodologiaSeleccionada.evaluar(RepositorioEmpresas.getEmpresas()));
		
		setEmpresasNoFiltradas(metodologiaSeleccionada.getLog().getEmpresasNoFiltradas());
		
		setEmpresasNoComparadas(metodologiaSeleccionada.getLog().getEmpresasNoComparadas());
	}
	

	//PROPIEDADES
	public Metodologia getMetodologiaSeleccionada() {
		return metodologiaSeleccionada;
	}

	public void setMetodologiaSeleccionada(Metodologia metodologiaSeleccionada) {
		this.metodologiaSeleccionada = metodologiaSeleccionada;
	}
	
	public List<Metodologia> getMetodologias() {
		return metodologias;
	}

	public void setMetodologias(List<Metodologia> metodologias) {
		this.metodologias = metodologias;
	}

	public List<ParEmpresasNoComparadas> getEmpresasNoComparadas() {
		return empresasNoComparadas;
	}

	public void setEmpresasNoComparadas(List<ParEmpresasNoComparadas> empresasNoComparadas) {
		this.empresasNoComparadas = empresasNoComparadas;
	}

	public List<EmpresaNoFiltrada> getEmpresasNoFiltradas() {
		return empresasNoFiltradas;
	}

	public void setEmpresasNoFiltradas(List<EmpresaNoFiltrada> empresasNoFiltradas) {
		this.empresasNoFiltradas = empresasNoFiltradas;
	}

	public List<Empresa> getEmpresasEvaluadas() {
		return empresasEvaluadas;
	}

	public void setEmpresasEvaluadas(List<Empresa> empresasEvaluadas) {
		this.empresasEvaluadas = empresasEvaluadas;
	}
}