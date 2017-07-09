package presentacion.vm.indicadores;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import negocio.dominio.Contexto;
import negocio.dominio.Empresa;
import negocio.dominio.Indicador;
import negocio.dominio.Periodo;
import negocio.dominio.excepciones.NoSePuedeRealizarElCalculoException;
import negocio.repositorio.RepositorioEmpresas;
import negocio.repositorio.RepositorioIndicadores;

@Observable
public class IndicadorVM 
{
	private Empresa empresaSeleccionada;
	private Periodo periodoSeleccionado;
	
	private List<Empresa> empresas;
	private List<Indicador> indicadores;
	
	private List<IndicadorNoEvaluado> indicadoresNoEvaluados = new ArrayList<>();;
	private List<IndicadorEvaluado> indicadoresEvaluados = new ArrayList<>();;
	

	public IndicadorVM()
	{
		empresas = RepositorioEmpresas.getEmpresas();
		indicadores = RepositorioIndicadores.getIndicadores();
	}
	
	public void calcularIndicadores() 
	{
		if (periodoSeleccionado == null)
		{
			throw new UserException("Hace falta seleccionar un periodo y una empresa para continuar");
		}
		else 
		{
			indicadores.forEach(indicador -> clasificarIndicador(indicador));
		}
	}
	
	private void clasificarIndicador(Indicador indicador) {
		
		Contexto contexto = new Contexto(periodoSeleccionado.getCuentas());
		
		try 
		{	
			indicadoresEvaluados.add(new IndicadorEvaluado(indicador.getNombre(), indicador.calcularValor(contexto)));
		}
		catch(NoSePuedeRealizarElCalculoException e)
		{
			indicadoresNoEvaluados.add(new IndicadorNoEvaluado(indicador.getNombre(), e.getMessage()));
		}
	}

	
	

	//PROPIEDADES
	
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

	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}
	
	public List<IndicadorEvaluado> getIndicadoresEvaluados() {
		return indicadoresEvaluados;
	}

	public void setIndicadoresEvaluados(List<IndicadorEvaluado> indicadoresEvaluados) {
		this.indicadoresEvaluados = indicadoresEvaluados;
	}

	public List<IndicadorNoEvaluado> getIndicadoresNoEvaluados() {
		return indicadoresNoEvaluados;
	}

	public void setIndicadoresNoEvaluados(List<IndicadorNoEvaluado> indicadoresNoEvaluados) {
		this.indicadoresNoEvaluados = indicadoresNoEvaluados;
	}
}