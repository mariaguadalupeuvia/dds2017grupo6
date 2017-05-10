package dominio;

import org.uqbar.commons.utils.Observable;

@Observable
public class Indicador extends Cuenta
{
	private String formula;
	public Indicador(String formula, String codigo, String nombre)
	{
		this.formula = formula;
		super.setCodigo(codigo);
		super.setNombre(nombre);
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public Double getValor() {
		return null;
	}

}
