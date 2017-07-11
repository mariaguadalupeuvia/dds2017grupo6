package presentacion.vm.metodologias;

import org.uqbar.commons.utils.Observable;

@Observable
public class EmpresaEvaluada {

	private String nombre;

	public EmpresaEvaluada(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
