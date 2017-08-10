package presentacion.vm.indicadores;

import org.uqbar.commons.utils.Observable;

@Observable
public class IndicadorEvaluado {
    
	private String nombre;
    private Double valor;
 
    
    
    
	//CONSTRUCTOR Y PROPIEDADES
    public IndicadorEvaluado(String nombre, Double valor) {
    	this.nombre = nombre;
    	this.valor = valor;
    }
       
    public String getNombre() {
		return nombre;
	}
	public Double getValor() {
		return valor;
	}
}