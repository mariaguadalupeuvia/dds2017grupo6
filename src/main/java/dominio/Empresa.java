package dominio;

import java.util.List;

public class Empresa {
	private List<Periodo> periodos;
	private String nombre;

	public Empresa(String nombre, List<Periodo> periodos)
	{
		this.nombre = nombre;
		this.periodos = periodos;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarPeriodo(Periodo unPeriodo)
	{
		periodos.add(unPeriodo);
	}
}
