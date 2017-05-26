package negocio.dominio;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
public class Periodo 
{
    private Integer año;
    private List<Cuenta> cuentas = new ArrayList<>();
    
    public void agregarVariasCuentas(List<Cuenta> cuentasNuevas)
    {
    	cuentasNuevas.forEach(cuentaNueva -> agregarCuenta(cuentaNueva));
	}
    
    public void agregarCuenta(Cuenta cuentaNueva)
    {
    	if (!existeCuentaDeNombre(cuentaNueva.getNombre())) 
		{
    		cuentas = new ArrayList<>(cuentas);
    		cuentas.add(cuentaNueva);
		}
		else
		{
			throw new UserException("Cuenta duplicada: '" + cuentaNueva.getNombre() + "' ya existe para esa empresa en el periodo " + this.getAño());
		}
    }
    
    private boolean existeCuentaDeNombre(String nombre) 
    {
    	return cuentas.stream().anyMatch(cuenta -> cuenta.getNombre().equals(nombre) );
    }
	
	

	//PROPIEDADES
    public Integer getAño() {
		return año;
	}
	public void setAño(Integer año) {
		this.año = año;
	}
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	
	@Override
	public String toString()
	{
		return año.toString();
	}
}