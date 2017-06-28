package negocio.dominio;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;
import negocio.dominio.excepciones.NoSePuedeAgregarCuentaException;

@Observable
public class Periodo 
{
    private Integer año;
    private List<Cuenta> cuentas = new ArrayList<>();
    
    public void agregarVariasCuentas(List<Cuenta> cuentasNuevas)
    {
    	cuentasNuevas.forEach(cuentaNueva -> {
			try 
			{
				agregarCuenta(cuentaNueva);
			} 
			catch (NoSePuedeAgregarCuentaException e) {
				//Aca se desidió no debe hacer nada
			}
		});
	}
    
    public void agregarCuenta(Cuenta cuentaNueva) throws NoSePuedeAgregarCuentaException
    {
    	if (!existeCuentaDeNombre(cuentaNueva.getNombre())) 
		{		
    		cuentas.add(cuentaNueva);
		}
		else
		{
			throw new NoSePuedeAgregarCuentaException("Dato duplicado: '" + cuentaNueva.getNombre() + "' ya existe para esa empresa en el periodo " + this.getAño());
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
	public void setCuentas(List<Cuenta> unasCuentas)
	{
		this.cuentas = unasCuentas;
	}
	@Override
	public String toString()
	{
		return año.toString();
	}
}