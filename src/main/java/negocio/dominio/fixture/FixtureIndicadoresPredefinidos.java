package negocio.dominio.fixture;

import java.util.Arrays;
import java.util.List;

import negocio.dominio.Indicador;
import negocio.dominio.manejoExpresiones.arbol.Expresion;
import negocio.dominio.manejoExpresiones.arbol.Incognita;
import negocio.dominio.manejoExpresiones.arbol.operaciones.Division;
import negocio.dominio.manejoExpresiones.arbol.operaciones.Resta;
import negocio.dominio.manejoExpresiones.arbol.operaciones.Suma;

public class FixtureIndicadoresPredefinidos 
{

	public List<Indicador> getIndicadores()
	{
		return Arrays.asList(getRoe(),getIngresoNeto(),getIS(),getIL(), getIndiceEndeudamiento());
	}
	
	private Indicador getRoe()
	{
		Expresion numerador = new Resta(new Incognita("ingreso_neto"), new Incognita("dividendos"));
		Expresion denominador =  new Incognita("capital_total");
		return new Indicador("ROE", new Division(numerador, denominador), "(ingreso_neto - dividendos) / capital_total");
	}
	
	private Indicador getIngresoNeto()
	{
		return new Indicador("Ingreso_neto", new Suma(new Incognita("ingreso_neto_op_discontinuas"),
													  new Incognita("ingreso_neto_op_continuas")), "ingreso_neto_op_discontinuas + ingreso_neto_op_continuas");
	}
	
	private Indicador getIS()
	{
		return new Indicador("Indice_solvencia", new Division(new Incognita("activo_cte"), 
				                                              new Incognita("pasivo_cte")),"activo_cte / pasivo_cte");
	}
	
	private Indicador getIL()
	{
		Expresion numerador = new Resta(new Incognita("activo_cte"), new Incognita("bienes_cambio"));
		Expresion denominador =  new Incognita("pasivo_cte");
		return new Indicador("Indice_Liquidez", new Division(numerador, denominador), "(activo_cte - bienes_cambio) / pasivo_cte");
	}
	
	private Indicador getIndiceEndeudamiento()
	{
		return new Indicador("Indice_endeudamiento", new Division(new Incognita("pasivo"), 
				                                              new Incognita("activo")), "pasivo / activo");
	}
}