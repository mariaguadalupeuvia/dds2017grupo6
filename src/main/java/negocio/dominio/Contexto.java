package negocio.dominio;

import java.util.List;

import negocio.dominio.excepciones.NoExisteCuentaException;
import negocio.dominio.excepciones.NoExisteIndicadorException;
import negocio.dominio.excepciones.NoSePuedeRealizarElCalculoException;
import negocio.repositorio.RepositorioIndicadores;

public class Contexto {

	private List<Cuenta> cuentas;
	
	
	public Double calcularValorDeIncognita(String nombreIncognita) throws NoSePuedeRealizarElCalculoException {
		
		try 
		{
			return buscarCuenta(nombreIncognita).getValor();
		} 
		catch (NoExisteCuentaException e1) 
		{	
			try 
			{
				return RepositorioIndicadores.buscarIndicador(nombreIncognita).calcularValor(this);
			} 
			catch (NoExisteIndicadorException e2) 
			{
				throw new NoSePuedeRealizarElCalculoException(e1.getMessage() + "/" + e2.getMessage());
			}
		}
	}
	
	public Cuenta buscarCuenta(String nombre) throws NoExisteCuentaException {
		 
		 return cuentas.stream().filter(cuenta -> cuenta.getNombre().equals(nombre)).
				 findAny().orElseThrow(() -> new NoExisteCuentaException("La cuenta: " + nombre + " no esta cargada"));
	 }
	
	 
	 
	//CONSTRUCTOR Y PROPIEDADES
	public Contexto(List<Cuenta> cuentas) {
		
		this.cuentas = cuentas;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}
}