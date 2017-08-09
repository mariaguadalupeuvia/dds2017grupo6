package presentacion.vm.metodologias;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Empresa;
import negocio.dominio.EmpresaNoEvaluada;
import negocio.dominio.Metodologia;
import negocio.repositorio.RepositorioEmpresas;
import negocio.repositorio.RepositorioMetodologias;

@Observable
public class MetodologiaVM 
{
	private List<Metodologia> metodologias;
	private Metodologia metodologiaSeleccionada;
	
	
	public MetodologiaVM()
	{
		metodologias = RepositorioMetodologias.getMetodologias();
	}
	
	public void aplicarMetodologia() 
	{
		setEmpresasEvaluadas(metodologiaSeleccionada.evaluar(RepositorioEmpresas.getEmpresas()));
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
}