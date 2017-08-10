package negocio.dominio.evaluacionEmpresas;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Empresa;

@Observable
public class ParEmpresasNoComparadas {

	private Empresa unaEmpresa;
	private Empresa otraEmpresa;
	private String motivo;
	
	public ParEmpresasNoComparadas(Empresa unaEmpresa, Empresa otraEmpresa, String motivo) {

		this.setUnaEmpresa(unaEmpresa);
		this.setOtraEmpresa(otraEmpresa);
		this.setMotivo(motivo);
	}

	public Empresa getUnaEmpresa() {
		return unaEmpresa;
	}

	public void setUnaEmpresa(Empresa unaEmpresa) {
		this.unaEmpresa = unaEmpresa;
	}

	public Empresa getOtraEmpresa() {
		return otraEmpresa;
	}

	public void setOtraEmpresa(Empresa otraEmpresa) {
		this.otraEmpresa = otraEmpresa;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}