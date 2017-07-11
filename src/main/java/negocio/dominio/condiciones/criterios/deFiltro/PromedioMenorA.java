package negocio.dominio.condiciones.criterios.deFiltro;

import negocio.dominio.Contexto;
import negocio.dominio.Empresa;
import negocio.dominio.Indicador;
import negocio.dominio.condiciones.criterios.Criterio;

public class PromedioMenorA implements Criterio {
	
	@Override
	public Boolean evaluar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador indicador, Double valor, Integer cantidadPeriodos) {
		
		return unaEmpresa.getPeriodos()
				.stream()
				.skip(unaEmpresa.getPeriodos().size() - cantidadPeriodos)
				.mapToDouble(p -> indicador.calcularValor(new Contexto(p.getCuentas())))
				.average()
				.orElse(0d) < valor;
	}
	
	@Override
	public String toString() {
		return "Filtro: Promedio Menor a X valor";
	}
}