package negocio.dominio;

import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.excepciones.NoExisteMedibleException;

@Observable
public class Indicador implements Medible
{
	private Periodo periodo;
	private Formula formula;

	@Override
	public String getNombre() {
		return formula.getNombre();
	}
	
	@Override
	public Double getValor() {
		
		List<Double> valores;
		
		try 
		{
			valores = obtenerValoresDeIncognitas();
		}
		catch (NoExisteMedibleException e) 
		{
			return null;
		}
		
		return formula.calcularExpresion(valores);
	}
	
	private List<Double> obtenerValoresDeIncognitas() throws NoExisteMedibleException {

		return formula.getIncognitas().stream()
				.map(incognita ->periodo.buscarMedible(incognita).getValor())
				.collect(Collectors.toList());
	}

	
	
	//PROPIEDADES
	public Indicador(Periodo periodo, Formula formula) {
		
		this.periodo = periodo;
		this.formula = formula;
	}
	
	public Formula getFormula() {
		return formula;
	}
		
	@Override
	public String toString()
	{
		return formula.getNombre();
	}
}