package negocio.dominio;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.excepciones.NoSePuedeRealizarElCalculoException;
import negocio.dominio.manejoExpresiones.arbol.Expresion;

@Observable
public class Indicador {

	private String nombre;
	private Expresion expresion;
	private String formula;

	public Double calcularValor(Contexto contexto) throws NoSePuedeRealizarElCalculoException {
		
		return expresion.evaluate(contexto);			
	}
	
	
	
	//PROPIEDADES Y CONSTRUCTOR
	public Indicador(String nombre, Expresion expresion, String formula) 
	{
		this.nombre = nombre;
		this.expresion = expresion;
		this.formula = formula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	@Override
	public String toString() {
		return nombre;
	}
}