package dominio;

import java.util.List;
//Por lo que hablamos, quizás No es necesario para esta entrega

public class Empresa {
	
	private int cuit; //Opcional, quizás nos sirva luego
	private String nombre;
    private List<Cuenta> cuentas;
    
	public int getCuit() {
		return cuit;
	}
	
	public void setCuit(int cuit) {
		this.cuit = cuit;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	public void agregarCuenta(Cuenta cuenta) {
		this.cuentas.add(cuenta);
	}


	
    
   

}
