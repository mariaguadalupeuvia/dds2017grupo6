package negocio.dominio.condiciones.criterios.deOrden;

import negocio.dominio.Contexto;
import negocio.dominio.Empresa;
import negocio.dominio.Indicador;
import negocio.dominio.condiciones.criterios.Criterio;

public class MayorToMenor implements Criterio {

	@Override
	public Boolean evaluar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador indicador, Double valor, Integer cantidadPeriodos) {

		Double resultadoUnaEmpresa = unaEmpresa
				.getPeriodos()
				.stream()
				.skip(unaEmpresa.getPeriodos().size() - cantidadPeriodos)
				.mapToDouble(p -> indicador.calcularValor(new Contexto(p.getCuentas())))
				.sum();
		
		Double resultadoOtraEmpresa = otraEmpresa
				.getPeriodos()
				.stream()
				.skip(otraEmpresa.getPeriodos().size() - cantidadPeriodos)
				.mapToDouble(p -> indicador.calcularValor(new Contexto(p.getCuentas())))
				.sum();
		
		return resultadoUnaEmpresa < resultadoOtraEmpresa;
	}
	
	@Override
	public String toString() {
		return "Ordenamiento: De mayor a menor";
	}
}