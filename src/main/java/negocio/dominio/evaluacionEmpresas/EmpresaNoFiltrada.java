package negocio.dominio.evaluacionEmpresas;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Empresa;

@Observable
public class EmpresaNoFiltrada {

	private Empresa empresa;
	private String motivo;
	
	public EmpresaNoFiltrada(Empresa empresa, String motivo) {
		
		this.setEmpresa(empresa);
		this.setMotivo(motivo);
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
