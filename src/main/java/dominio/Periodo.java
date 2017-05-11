package dominio;

import java.util.ArrayList;
import java.util.List;

public class Periodo 
{
	private List<Cuenta> cuentas;
    private String nombre;
    
    public Periodo(String nombre, ArrayList<Cuenta> cuentas)
    {
    	this.nombre = nombre;
    	this.cuentas = cuentas;
    }
    
	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarCuenta(Cuenta unaCuenta) 
	{
		cuentas.add(unaCuenta);
	}
}
