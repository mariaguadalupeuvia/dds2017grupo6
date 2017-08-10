package negocio.dominio;

import org.uqbar.commons.utils.Observable;

@Observable
public class Cuenta {
    
	private String nombre;
    private Double valor;
 
    
	
	//PROPIEDADES
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString()
	{
		return nombre;
	}
}