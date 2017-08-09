package negocio.dominio.condiciones.criterios.filtrado;

import java.util.stream.Stream;

import negocio.dominio.Contexto;
import negocio.dominio.Indicador;
import negocio.dominio.Periodo;
import negocio.dominio.excepciones.NoSePudoAplicarCriterioException;
import negocio.dominio.excepciones.NoSePuedeRealizarElCalculoException;

public class MayorA extends CriterioFiltrado {

	@Override
	public Boolean aplicarCriterio(Indicador indicador, Double valor, Stream<Periodo> periodosDeInteres) throws NoSePudoAplicarCriterioException {
		
		try 
		{
			return periodosDeInteres.allMatch(periodo -> indicador.calcularValor(new Contexto(periodo.getCuentas())) > valor);
		}
		catch(NoSePuedeRealizarElCalculoException e)
		{
			throw new NoSePudoAplicarCriterioException(e.getMessage());
		}
	}

	@Override
	public String toString() {
		
		return "Filtro: Mayor a X valor";
	}
}