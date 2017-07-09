package negocio.dominio.condiciones.criterios.deFiltro;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Ordering;

import negocio.dominio.Contexto;
import negocio.dominio.Empresa;
import negocio.dominio.Indicador;
import negocio.dominio.condiciones.criterios.Criterio;

public class SiempreDecreciente implements Criterio {
	
	@Override
	public Boolean evaluar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador indicador, Double valor, Integer cantidadPeriodos) {
		
		List<Double> valores = unaEmpresa.getPeriodos().stream()
				.map(p -> indicador.calcularValor(new Contexto(p.getCuentas())))
				.collect(Collectors.toList());
		
		return Ordering.natural().reverse().isOrdered(valores);
	}
	
	@Override
	public String toString() {
		return "Filtro: Siempre decreciente";
	}
}