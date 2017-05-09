package vm.consulta.indicador;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import dominio.Indicador;
import repositorio.RepositorioEmpresas;
import repositorio.RepositorioIndicadores;
import repositorio.RepositorioPeriodos;

@Observable
public class ConsultaIndicadorVM 
{
	private List<String> empresas;
	private List<Integer> periodos;
	private List<String> nombresIndicadores;

	private String empresaSeleccionada;
	private String nombreIndicadorSeleccionado;
	private int periodoSeleccionado;
	private double valor;
	
	private List <Indicador> indicadores;

	public ConsultaIndicadorVM() 
	{
		empresas = RepositorioEmpresas.getNombresEmpresas();
		periodos = RepositorioPeriodos.getPeriodos();
		nombresIndicadores = RepositorioIndicadores.getNombresIndicadores();
	}

	public void consultar() 
	{
		//TODO calcular el valor para cada indicador
		//indicadores = RepositorioIndicadores.filtrarIndicadores(empresaSeleccionada, nombreIndicadorSeleccionado, periodoSeleccionado,valor);
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

	public String getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(String empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
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

	public List<String> getNombresIndicadores() {
		return nombresIndicadores;
	}

	public void setNombresIndicadores(List<String> nombresIndicadores) {
		this.nombresIndicadores = nombresIndicadores;
	}

	public String getNombreIndicadorSeleccionado() {
		return nombreIndicadorSeleccionado;
	}

	public void setNombreIndicadorSeleccionado(String nombreIndicadorSeleccionado) {
		this.nombreIndicadorSeleccionado = nombreIndicadorSeleccionado;
	}

	public List <Indicador> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List <Indicador> indicadores) {
		this.indicadores = indicadores;
	}
}
