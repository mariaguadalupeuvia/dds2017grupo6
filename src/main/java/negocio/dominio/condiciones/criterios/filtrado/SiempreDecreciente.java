package negocio.dominio.condiciones.criterios.filtrado;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Ordering;

import negocio.dominio.Contexto;
import negocio.dominio.Indicador;
import negocio.dominio.Periodo;
import negocio.dominio.excepciones.NoSePudoAplicarCriterioException;
import negocio.dominio.excepciones.NoSePuedeRealizarElCalculoException;

public class SiempreDecreciente extends CriterioFiltrado {
	
	
	@Override
	public Boolean aplicarCriterio(Indicador indicador, Double valor, Stream<Periodo> periodosDeInteres) throws NoSePudoAplicarCriterioException {
		
		try 
		{
			List<Double> valores = periodosDeInteres.map(periodo -> indicador.calcularValor(new Contexto(periodo.getCuentas()))).collect(Collectors.toList());
		
			return Ordering.natural().reverse().isOrdered(valores);
		} 
		catch (NoSePuedeRealizarElCalculoException e) {
			
			throw new NoSePudoAplicarCriterioException(e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		return "Filtro: Siempre decreciente";
	}
}