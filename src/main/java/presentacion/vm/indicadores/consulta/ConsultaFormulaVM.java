package presentacion.vm.indicadores.consulta;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Formula;
import negocio.repositorio.RepositorioFormulas;

@Observable
public class ConsultaFormulaVM 
{
	private Formula formulaSeleccionada;
	
	private List<Formula> formulas;	

	public ConsultaFormulaVM()
	{
		formulas = RepositorioFormulas.getFormulas();
	}

	
	
	//PROPIEDADES
	public Formula getFormulaSeleccionada() {
		return formulaSeleccionada;
	}

	public void setFormulaSeleccionada(Formula formulaSeleccionada) {
		this.formulaSeleccionada = formulaSeleccionada;
	}

	public List<Formula> getFormulas() {
		return formulas;
	}

	public void setFormulas(List<Formula> formulas) {
		this.formulas = formulas;
	}



	public void filtrarFormulas() 
	{
		
	}
}