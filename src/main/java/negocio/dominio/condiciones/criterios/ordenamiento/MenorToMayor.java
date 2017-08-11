package negocio.dominio.condiciones.criterios.ordenamiento;

import java.util.stream.Stream;

import negocio.dominio.Contexto;
import negocio.dominio.Indicador;
import negocio.dominio.Periodo;
import negocio.dominio.excepciones.NoSePudoAplicarCriterioException;
import negocio.dominio.excepciones.NoSePuedeRealizarElCalculoException;

public class MenorToMayor extends CriterioOrdenamiento {

	@Override
	public Integer aplicarCriterio(Indicador indicador, Stream<Periodo> periodosDeInteresUnaEmpresa, Stream<Periodo> periodosDeInteresOtraEmpresa) throws NoSePudoAplicarCriterioException {
		
		Double resultadoUnaEmpresa;
		Double resultadoOtraEmpresa;
		
		try 
		{
			resultadoUnaEmpresa = periodosDeInteresUnaEmpresa
					.mapToDouble(p -> indicador.calcularValor(new Contexto(p.getCuentas())))
					.sum();
		} 
		catch (NoSePuedeRealizarElCalculoException e) {

			throw new NoSePudoAplicarCriterioException(e.getMessage());
		}
		
		try 
		{
			resultadoOtraEmpresa = periodosDeInteresOtraEmpresa
					.mapToDouble(p -> indicador.calcularValor(new Contexto(p.getCuentas())))
					.sum();
		} 
		catch (NoSePuedeRealizarElCalculoException e) {

			throw new NoSePudoAplicarCriterioException(e.getMessage());
		}
			
		return resultadoUnaEmpresa.compareTo(resultadoOtraEmpresa);
	}
	
	@Override
	public String toString() {
		return "Ordenamiento: De menor a mayor";
	}
}