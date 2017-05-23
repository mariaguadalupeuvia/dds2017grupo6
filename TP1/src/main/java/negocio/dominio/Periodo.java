package negocio.dominio;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
public class Periodo 
{
    private Integer a�o;
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
			throw new UserException("Cuenta duplicada: '" + cuentaNueva.getNombre() + "' ya existe para esa empresa en el periodo " + this.getA�o());
		}
    }
    
    private boolean existeCuentaDeNombre(String nombre) 
    {
    	return cuentas.stream().anyMatch(cuenta -> cuenta.getNombre().equals(nombre) );
    }
	
	

	//PROPIEDADES
    public Integer getA�o() {
		return a�o;
	}
	public void setA�o(Integer a�o) {
		this.a�o = a�o;
	}
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	
	@Override
	public String toString()
	{
		return a�o.toString();
	}
}