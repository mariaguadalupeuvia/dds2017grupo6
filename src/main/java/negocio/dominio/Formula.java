package negocio.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.excepciones.ExpresionIncorrectaException;
import negocio.dominio.manejoExpresiones.Automata;


@Observable
public class Formula 
{
	private String nombre;
	private String expresion;
	private Automata automata = new Automata();
	
	public Boolean esExpresionValida()
	{
		if (expresion == null)
			return false;

		return automata.reconocerExpresion(expresion + ";");
	}

	public String tipoMsjExpresion()
	{
		automata.reconocerExpresion(expresion + ";");
		return automata.getMsjError();
	}
	
	public Double calcularExpresion(List<Double> valores)
	{
		if (!this.esExpresionValida()) {
			
			throw new ExpresionIncorrectaException(this.tipoMsjExpresion());
		}
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result=0;
		
		try {
			result = engine.eval(this.setearValoresFormula(valores));
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return Double.parseDouble(result.toString());
	}
	
	public List<String> getIncognitas()
	{ 
		List<String> identificadores = new ArrayList<>(Arrays.asList(expresion.replaceAll("(?!\\w)[\\s\\(\\)\\*\\+0-9./]+",";").split(";")));
		identificadores.removeAll(Arrays.asList("", null));
		return identificadores;
	}
	
	//funciones auxiliares ----------------------------------------------------
	private String setearValoresFormula(List<Double> valores)
	{
		if (!this.esExpresionValida()) {
			
			throw new ExpresionIncorrectaException(this.tipoMsjExpresion());
		}
		
		String criterioReemplazo = "[a-zA-Z]+[0-9]*";
		
		String formula = expresion;
		
		for (Double valor: valores)
		{
			formula = formula.replaceFirst(criterioReemplazo, valor.toString());
		}
		
		return formula;
	}
	
	
	//PROPIEDADES
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getExpresion() {
		return expresion;
	}
	public void setExpresion(String expresion) {
		this.expresion = expresion;
	}
	
	@Override
	public String toString()
	{
		return this.nombre;
	}	
}