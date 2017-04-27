package dominio;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class DatosExcelCargaMasiva {
	private List<EstructuraEsperadaExcel> registros = new ArrayList<EstructuraEsperadaExcel>();

	public List<EstructuraEsperadaExcel> getRegistros() {
		return registros;
	}

	public List<EstructuraEsperadaExcel> getRegistros(String empresa) {
		return registros.stream()
				.filter(registro -> registro.getEmpresa().equals(empresa))
				.collect(Collectors.toList());
	}

	public List<EstructuraEsperadaExcel> getRegistros(String empresa,String periodo) {
		return registros.stream()
				.filter(registro->registro.getEmpresa().equals(empresa) && registro.getPeriodo().equals(periodo))
				.collect(Collectors.toList());
	}
	
	public void setRegistro(EstructuraEsperadaExcel registro) {
		registros.add(registro);
	}

	public List<String> empresas(){
		List<String> empresas = new ArrayList<String>();
		registros.forEach(registro->empresas.add(registro.getEmpresa()));
		return eliminarDuplicadosLista(empresas);
	}
	
	public List<String> periodos(){
		List<String> periodos = new ArrayList<String>();
		registros.forEach(registro->periodos.add(registro.getPeriodo()));
		return eliminarDuplicadosLista(periodos);
	}
	
	public List<String> Nombrecuentas(){
		List<String> cuentas = new ArrayList<String>();
		registros.forEach(cuenta->cuentas.add(cuenta.getNombreCuenta()));
		return eliminarDuplicadosLista(cuentas);	
	}
	
	private List<String> eliminarDuplicadosLista(List<String> lista){
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		lhs.addAll(lista);
		lista.clear();
		lista.addAll(lhs);
		return lista;
	}
	
}
