package negocio.dominio.condiciones.criterios.filtrado;

import java.util.stream.Stream;

import negocio.dominio.Empresa;
import negocio.dominio.Indicador;
import negocio.dominio.Periodo;
import negocio.dominio.excepciones.NoSePudoAplicarCriterioException;

public abstract class CriterioFiltrado {

	public Boolean cumple(Empresa unaEmpresa, Indicador indicador, Double valor, Integer cantidadPeriodos) throws NoSePudoAplicarCriterioException {
		
		try {
		
			Stream<Periodo> periodosDeInteres = unaEmpresa.getPeriodos().stream().skip(unaEmpresa.getPeriodos().size() - cantidadPeriodos);
		
			return aplicarCriterio(indicador, valor, periodosDeInteres);
		}
		catch(IllegalArgumentException e) {
			
			throw new NoSePudoAplicarCriterioException("La empresa: " + unaEmpresa + " no posee " + cantidadPeriodos + " periodos cargados"); 
		}
	}

	public abstract Boolean aplicarCriterio(Indicador indicador, Double valor, Stream<Periodo> periodosDeInteres) throws NoSePudoAplicarCriterioException;

	public abstract String toString();
}