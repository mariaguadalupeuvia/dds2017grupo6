package negocio.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.excepciones.NoSePuedeAgregarCuentaException;

@Observable
public class Empresa 
{
	private String nombre;
	private List<Periodo> periodos = new ArrayList<>();
	
	
	public void agregarVariosPeriodos(List<Periodo> periodosNuevos) throws NoSePuedeAgregarCuentaException
	{
		periodosNuevos.forEach(periodoNuevo -> agregarPeriodo(periodoNuevo));
	}
	
	public void agregarPeriodo(Periodo periodoNuevo) throws NoSePuedeAgregarCuentaException
	{
		if (!existePeriodoDeA�o(periodoNuevo.getA�o())) 
		{
			periodos.add(periodoNuevo);
		}
		else
		{
			periodos.forEach(periodo -> {
				
				if(periodo.getA�o().equals(periodoNuevo.getA�o()))
				{
					periodo.agregarVariasCuentas(periodoNuevo.getCuentas());
				}
			});
		}
	}

	private boolean existePeriodoDeA�o(Integer a�o)
	{
		return periodos.stream().anyMatch(periodo -> periodo.getA�o().equals(a�o));
	}



	//PROPIEDADES
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Periodo> getPeriodos() {
		 
		periodos.sort(Comparator.comparing(Periodo::getA�o));
		 
		return periodos;
	}
	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
	
	@Override
	public String toString()
	{
		return nombre;
	}
}