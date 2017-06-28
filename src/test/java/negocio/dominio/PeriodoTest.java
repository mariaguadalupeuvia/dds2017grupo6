package negocio.dominio;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import negocio.dominio.excepciones.NoSePuedeAgregarCuentaException;

public class PeriodoTest {

	private Periodo periodo;
	private Cuenta cuentaNueva;
	private Cuenta cuentaDistinta;
	private Cuenta cuentaIgual;

	@Before
	public void setUp()
	{
		periodo = new Periodo();
		
		cuentaNueva = new Cuenta();
		cuentaNueva.setNombre("Ebidata");
		cuentaNueva.setValor(100d);
		
		cuentaDistinta  = new Cuenta();
		cuentaDistinta.setNombre("Cashflow");
		cuentaDistinta.setValor(200d);
		
		cuentaIgual = new Cuenta();
		cuentaIgual.setNombre("Ebidata");
		cuentaIgual.setValor(100d);
	}
	
	@Test
	public void agregarUnaCuenta() 
	{
		periodo.agregarCuenta(cuentaNueva);
		
		assertTrue(periodo.getCuentas().equals(Arrays.asList(cuentaNueva)));
	}
	
	@Test
	public void agregarDosCuentasConDistintoNombre() 
	{	
		periodo.agregarCuenta(cuentaNueva);
		periodo.agregarCuenta(cuentaDistinta);
		
		int cantidadCuentasEnElPeriodo = periodo.getCuentas().size();
		
		assertTrue(cantidadCuentasEnElPeriodo == 2);
	}
	
	@Test(expected = NoSePuedeAgregarCuentaException.class)
	public void agregarDosCuentasConElMismoNombre() 
	{	
		periodo.agregarCuenta(cuentaNueva);
		periodo.agregarCuenta(cuentaIgual);
	}
}
