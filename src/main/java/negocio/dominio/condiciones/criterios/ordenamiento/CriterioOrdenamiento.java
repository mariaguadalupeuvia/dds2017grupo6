package negocio.dominio.condiciones.criterios.ordenamiento;

import java.util.stream.Stream;

import negocio.dominio.Empresa;
import negocio.dominio.Indicador;
import negocio.dominio.Periodo;
import negocio.dominio.excepciones.NoSePudoAplicarCriterioException;

public abstract class CriterioOrdenamiento {

	public Integer comparar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador indicador, Integer cantidadPeriodos) throws NoSePudoAplicarCriterioException {
		
		Stream<Periodo> periodosDeInteresUnaEmpresa;
		Stream<Periodo> periodosDeInteresOtraEmpresa;
		
		try 
		{
			periodosDeInteresUnaEmpresa = unaEmpresa.getPeriodos().stream().skip(unaEmpresa.getPeriodos().size() - cantidadPeriodos);
		} 
		catch (IllegalArgumentException e) {

			throw new NoSePudoAplicarCriterioException(
					"La empresa: " + unaEmpresa + " no posee " + cantidadPeriodos + " periodos cargados");
		}

		try 
		{
			periodosDeInteresOtraEmpresa = otraEmpresa.getPeriodos().stream().skip(otraEmpresa.getPeriodos().size() - cantidadPeriodos);
		} 
		catch (IllegalArgumentException e) {

			throw new NoSePudoAplicarCriterioException(
					"La empresa: " + otraEmpresa + " no posee " + cantidadPeriodos + " periodos cargados");
		}

		return aplicarCriterio(indicador, periodosDeInteresUnaEmpresa, periodosDeInteresOtraEmpresa);
	}

	public abstract Integer aplicarCriterio(Indicador indicador, Stream<Periodo> periodosDeInteresUnaEmpresa, Stream<Periodo> periodosDeInteresOtraEmpresa) throws NoSePudoAplicarCriterioException;
	
	public abstract String toString();
}
