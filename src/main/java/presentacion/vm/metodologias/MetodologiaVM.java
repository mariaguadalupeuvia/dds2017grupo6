package presentacion.vm.metodologias;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Metodologia;
import negocio.repositorio.RepositorioEmpresas;
import negocio.repositorio.RepositorioMetodologias;

@Observable
public class MetodologiaVM 
{
	private List<Metodologia> metodologias;
	private Metodologia metodologiaSeleccionada;
	
	private List<EmpresaEvaluada> empresasEvaluadas;

	
	public MetodologiaVM()
	{
		metodologias = RepositorioMetodologias.getMetodologias();
		empresasEvaluadas = new ArrayList<>();
	}
	
	public void aplicarMetodologia() 
	{
		 metodologiaSeleccionada
		 .evaluar(RepositorioEmpresas.getEmpresas())
		 .forEach( empresa -> empresasEvaluadas.add(new EmpresaEvaluada(empresa.getNombre())));
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

	public List<EmpresaEvaluada> getEmpresasEvaluadas() {
		return empresasEvaluadas;
	}

	public void setEmpresasEvaluadas(List<EmpresaEvaluada> empresasEvaluadas) {
		this.empresasEvaluadas = empresasEvaluadas;
	}	
}