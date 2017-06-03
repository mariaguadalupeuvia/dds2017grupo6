package negocio.repositorio;

import java.util.ArrayList;
import java.util.List;

import negocio.dominio.Formula;
import negocio.dominio.excepciones.NoSePuedeAgregarFormulaException;

public class RepositorioFormulas
{
	private static List<Formula> formulas;
	
	public static void inicializarRepositorio()
	{
		formulas = new ArrayList<>();
	}
	
	public static void agregarFormula(Formula formulaNueva) 
	{
		if(!existeFormulaDeNombre(formulaNueva.getNombre()))
		{
			if(formulaNueva.esExpresionValida())	
				formulas.add(formulaNueva);
			else
				throw new NoSePuedeAgregarFormulaException("Formula invalida");
		}			
		else
		{
			throw new NoSePuedeAgregarFormulaException("Ya existe esa formula");
		}
	}

	private static boolean existeFormulaDeNombre(String nombre) 
	{
		return formulas.stream().anyMatch(formula -> formula.getNombre().equals(nombre));
	}
	
	
	
	//PROPIEDADES
	public static List<Formula> getFormulas()
	{
		return formulas;
	}
	public static void setFormulas(List<Formula> formulasNuevas)
	{
		formulas = formulasNuevas;
	}
}