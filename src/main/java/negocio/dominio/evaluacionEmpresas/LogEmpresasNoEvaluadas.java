package negocio.dominio.evaluacionEmpresas;

import java.util.ArrayList;
import java.util.List;

import negocio.dominio.Empresa;

public class LogEmpresasNoEvaluadas {

	private List<EmpresaNoFiltrada> empresasNoFiltradas = new ArrayList<>();
	private List<ParEmpresasNoComparadas> empresasNoComparadas = new ArrayList<>();
	
	
	public void informarEmpresaNoFiltrada(Empresa empresa, String motivo) {
		
		empresasNoFiltradas.add(new EmpresaNoFiltrada(empresa, motivo));
	}
	
	public void informarParEmpresasNoComparadas(Empresa unaEmpresa, Empresa otraEmpresa, String motivo) {
		
		empresasNoComparadas.add(new ParEmpresasNoComparadas(unaEmpresa, otraEmpresa, motivo));
	}

	
	public List<EmpresaNoFiltrada> getEmpresasNoFiltradas() {
		return empresasNoFiltradas;
	}

	public List<ParEmpresasNoComparadas> getEmpresasNoComparadas() {
		return empresasNoComparadas;
	}
}
