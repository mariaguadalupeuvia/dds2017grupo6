package dominio;

import java.util.ArrayList;
import java.util.List;

public class DatosExcelCargaMasiva {
	private List<EstructuraEsperadaExcel> registros = new ArrayList<EstructuraEsperadaExcel>();

	public List<EstructuraEsperadaExcel> getRegistros() {
		return registros;
	}
	
	public void setRegistro(EstructuraEsperadaExcel registro) {
		registros.add(registro);
	}

	public List<String> empresas(){
		List<String> empresas = new ArrayList<String>();
		registros.forEach(registro->empresas.add(registro.getEmpresa()));
		return empresas;
	}
	
	public List<String> periodos(){
		List<String> periodos = new ArrayList<String>();
		registros.forEach(registro->periodos.add(registro.getPeriodo()));
		return periodos;
	}

	
	public List<String> cuentas(){
		List<String> cuentas = new ArrayList<String>();
		registros.forEach(cuenta->cuentas.add(cuenta.getPeriodo()));
		return cuentas;
	}
	
}
