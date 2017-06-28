package presentacion.vm.indicadores;

import org.uqbar.commons.utils.Observable;

@Observable
public class IndicadorNoEvaluado {
    
	private String nombre;
    private String motivo;
 
    
	
    
	//CONSTRUCTOR Y PROPIEDADES
    public IndicadorNoEvaluado(String nombre, String motivo) {
    	this.nombre = nombre;
    	this.motivo = motivo;
    }
       
    public String getNombre() {
		return nombre;
	}
	public String getMotivo() {
		return motivo;
	}
}