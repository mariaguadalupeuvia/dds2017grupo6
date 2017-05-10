package vm.consulta.cuenta;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import dominio.CuentaEmpresaPeriodo;
import repositorio.RepositorioCuentas;
import repositorio.RepositorioEmpresas;
import repositorio.RepositorioNombresCuentas;
import repositorio.RepositorioPeriodos;

@Observable
public class ConsultaCuentaVM 
{
	private List<String> empresas;
	private List<Integer> periodos;
	private List<String> nombresCuentas;

	private String empresaSeleccionada;
	private String nombreCuentaSeleccionada;
	private int periodoSeleccionado;
	private double valor;
	
	private List <CuentaEmpresaPeriodo> cuentas;

	public ConsultaCuentaVM() 
	{
		empresas = RepositorioEmpresas.getNombresEmpresas();
		periodos = RepositorioPeriodos.getPeriodos();
		nombresCuentas = RepositorioNombresCuentas.getNombresCuentas();
	}

	public void consultar() 
	{
		cuentas = RepositorioCuentas.filtrarCuentas(empresaSeleccionada, nombreCuentaSeleccionada, periodoSeleccionado,valor);
	}

	
	// PROPIEDADES
	public List<String> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<String> empresas) {
		this.empresas = empresas;
	}

	public List<Integer> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Integer> periodos) {
		this.periodos = periodos;
	}

	public List<String> getNombresCuentas() {
		return nombresCuentas;
	}

	public void setNombresCuentas(List<String> nombresCuentas) {
		this.nombresCuentas = nombresCuentas;
	}

	public String getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(String empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
	}

	public String getNombreCuentaSeleccionada() {
		return nombreCuentaSeleccionada;
	}

	public void setNombreCuentaSeleccionada(String nombreCuentaSeleccionada) {
		this.nombreCuentaSeleccionada = nombreCuentaSeleccionada;
	}

	public int getPeriodoSeleccionado() {
		return periodoSeleccionado;
	}

	public void setPeriodoSeleccionado(int periodoSeleccionado) {
		this.periodoSeleccionado = periodoSeleccionado;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<CuentaEmpresaPeriodo> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<CuentaEmpresaPeriodo> cuentas) {
		this.cuentas = cuentas;
	}
}
