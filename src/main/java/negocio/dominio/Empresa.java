package negocio.dominio;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Empresa 
{
	private String nombre;
	private List<Periodo> periodos = new ArrayList<>();
	
	
	public void agregarVariosPeriodos(List<Periodo> periodosNuevos)
	{
		periodosNuevos.forEach(periodoNuevo -> agregarPeriodo(periodoNuevo));
	}
	
	public void agregarPeriodo(Periodo periodoNuevo)
	{
		if (!existePeriodoDeAño(periodoNuevo.getAño())) 
		{
			periodos.add(periodoNuevo);
		}
		else
		{
			periodos.forEach(periodo -> {
				
				if(periodo.getAño().equals(periodoNuevo.getAño()))
				{
					periodo.agregarVariasCuentas(periodoNuevo.getCuentas());
				}
			});
		}
	}

	private boolean existePeriodoDeAño(Integer año)
	{
		return periodos.stream().anyMatch(periodo -> periodo.getAño().equals(año));
	}



	//PROPIEDADES
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Periodo> getPeriodos() {
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