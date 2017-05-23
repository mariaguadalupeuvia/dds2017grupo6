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
		if (!existePeriodoDeA�o(periodoNuevo.getA�o())) 
		{
			periodos = new ArrayList<>(periodos);
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
		return periodos;
	}
	
	@Override
	public String toString()
	{
		return nombre;
	}
}