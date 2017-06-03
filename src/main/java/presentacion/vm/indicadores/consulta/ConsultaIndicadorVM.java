package presentacion.vm.indicadores.consulta;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Empresa;
import negocio.dominio.Periodo;
import negocio.repositorio.RepositorioEmpresas;

@Observable
public class ConsultaIndicadorVM 
{
	private Empresa empresaSeleccionada;
	private Periodo periodoSeleccionado;
	
	private List<Empresa> empresas;	

	public ConsultaIndicadorVM()
	{
		empresas = RepositorioEmpresas.getEmpresas();
		notificarEvento();
	}

	public void notificarEvento() {
		empresas.forEach(empresa -> empresa.onConsultaDeIndicadores());
	}
	
	
	
	// PROPIEDADES
	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
	}

	public Periodo getPeriodoSeleccionado() {
		return periodoSeleccionado;
	}

	public void setPeriodoSeleccionado(Periodo periodoSeleccionado) {
		this.periodoSeleccionado = periodoSeleccionado;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}	
}