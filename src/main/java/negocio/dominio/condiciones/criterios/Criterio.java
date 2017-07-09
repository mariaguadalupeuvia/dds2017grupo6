package negocio.dominio.condiciones.criterios;

import negocio.dominio.Empresa;
import negocio.dominio.Indicador;

public interface Criterio {

	public String toString();
	
	public Boolean evaluar(Empresa unaEmpresa, Empresa otraEmpresa, Indicador indicador, Double valor, Integer cantidadPeriodos);
}
