package presentacion.vm.indicadores.carga;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import negocio.dominio.Formula;
import negocio.dominio.excepciones.NoSePuedeAgregarFormulaException;
import negocio.repositorio.RepositorioFormulas;


@Observable
public class CargaFormulaVM
{
	private String nombreFormula;
	private String expresion;
	

	public void guardarFormula()
	{
		Formula formula = new Formula();
		
		formula.setNombre(nombreFormula);
		formula.setExpresion(expresion);
		
		try
		{
			RepositorioFormulas.agregarFormula(formula);
		}
		catch(NoSePuedeAgregarFormulaException e)
		{
			throw new UserException(e.getMessage());
		}
	}
		

	
	//PROPIEDADES
	public String getNombreFormula() {
		return nombreFormula;
	}
	public void setNombreFormula(String nombre) {
		this.nombreFormula = nombre;
	}
	public String getExpresion() {
		return expresion;
	}
	public void setExpresion(String expresion) {
		this.expresion = expresion;
	}
}