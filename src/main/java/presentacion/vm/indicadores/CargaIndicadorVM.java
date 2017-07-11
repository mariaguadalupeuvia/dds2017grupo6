package presentacion.vm.indicadores;

import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import negocio.dominio.Indicador;
import negocio.dominio.excepciones.ExpresionInvalidaException;
import negocio.dominio.excepciones.NoSePuedeAgregarIndicadorException;
import negocio.dominio.manejoExpresiones.ParserExpresionesAdapter;
import negocio.dominio.manejoExpresiones.arbol.Expresion;
import negocio.repositorio.RepositorioIndicadores;

@Observable
public class CargaIndicadorVM {

	private List<Indicador> indicadores;
	
	private String nombreIndicador;
	private String expresionPlana;
	
	public CargaIndicadorVM()
	{
		indicadores = RepositorioIndicadores.getIndicadores();
	}
	
	public void guardarIndicador()
	{
		if (expresionPlana == null || nombreIndicador == null)
			throw new UserException("Completar los campos obligatorios");
		
		try
		{
			Expresion expresion = new ParserExpresionesAdapter().parsear(expresionPlana);
		
			Indicador indicador = new Indicador(nombreIndicador, expresion, expresionPlana);
		
			RepositorioIndicadores.agregarIndicador(indicador);
			
			ObservableUtils.firePropertyChanged(this, "indicadores");
		}
		catch(NoSePuedeAgregarIndicadorException e)
		{
			throw new UserException(e.getMessage());
		} 
		catch (ExpresionInvalidaException e) 
		{
			throw new UserException("Debe ingresar una expresion valida: " + e.getMessage());
		} 
	}
	
	
	
	//PROPIEDADES
	public String getNombreIndicador() {
		return nombreIndicador;
	}
	
	public void setNombreIndicador(String nombre) {
		this.nombreIndicador = nombre;
	}
	
	public String getExpresionPlana() {
		return expresionPlana;
	}
	
	public void setExpresionPlana(String expresionPlana) {
		this.expresionPlana = expresionPlana;
	}
	public List<Indicador> getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}
}