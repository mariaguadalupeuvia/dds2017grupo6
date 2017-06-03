package negocio.dominio;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import negocio.dominio.excepciones.NoSePuedeAgregarMedibleException;

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
		periodo.agregarMedible(cuentaNueva);
		
		assertTrue(periodo.getMedibles().equals(Arrays.asList(cuentaNueva)));
	}
	
	@Test
	public void agregarDosCuentasConDistintoNombre() 
	{	
		periodo.agregarMedible(cuentaNueva);
		periodo.agregarMedible(cuentaDistinta);
		
		int cantidadCuentasEnElPeriodo = periodo.getMedibles().size();
		
		assertTrue(cantidadCuentasEnElPeriodo == 2);
	}
	
	@Test(expected = NoSePuedeAgregarMedibleException.class)
	public void agregarDosCuentasConElMismoNombre() 
	{	
		periodo.agregarMedible(cuentaNueva);
		periodo.agregarMedible(cuentaIgual);
	}
}
