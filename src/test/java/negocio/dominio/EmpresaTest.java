package negocio.dominio;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class EmpresaTest {

	private Empresa empresa;
	private Periodo periodoNuevo;
	private Periodo periodoDistinto;
	private Periodo periodoIgual;

	@Before
	public void setUp()
	{
		empresa = new Empresa();
		
		periodoNuevo = new Periodo();
		periodoNuevo.setAño(2017);
		Cuenta cuenta1 = new Cuenta();
		cuenta1.setNombre("ebidata");
		cuenta1.setValor(100d);
		periodoNuevo.agregarCuenta(cuenta1);
		
		periodoDistinto = new Periodo();
		periodoDistinto.setAño(2016);
		Cuenta cuenta2 = new Cuenta();
		cuenta2.setNombre("ebidata");
		cuenta2.setValor(200d);
		periodoDistinto.agregarCuenta(cuenta2);
		
		periodoIgual = new Periodo();
		periodoIgual.setAño(2017);
		Cuenta cuenta3 = new Cuenta();
		cuenta3.setNombre("cashflow");
		cuenta3.setValor(300d);
		periodoIgual.agregarCuenta(cuenta3);
	}
	
	@Test
	public void agregarUnPeriodo() 
	{
		empresa.agregarPeriodo(periodoNuevo);
		
		assertTrue(empresa.getPeriodos().equals(Arrays.asList(periodoNuevo)));
	}
	
	@Test
	public void agregarDosPeriodosConDistintoAño() 
	{	
		empresa.agregarPeriodo(periodoNuevo);
		empresa.agregarPeriodo(periodoDistinto);
		
		int cantidadPeriodosEnLaEmpresa = empresa.getPeriodos().size();
		
		assertTrue(cantidadPeriodosEnLaEmpresa == 2);
	}
	
	@Test
	public void agregarDosPeriodosConElMismoAño() 
	{	
		empresa.agregarPeriodo(periodoNuevo);
		empresa.agregarPeriodo(periodoIgual);
		
		int cantidadPeriodosEnLaEmpresa = empresa.getPeriodos().size();
		Periodo periodo = empresa.getPeriodos().get(0);
		
		assertTrue(cantidadPeriodosEnLaEmpresa == 1);
		assertTrue(periodo.getAño().equals(periodoNuevo.getAño()) && periodo.getAño().equals(periodoIgual.getAño()));
		assertTrue(periodo.getCuentas().containsAll(periodoNuevo.getCuentas()) && periodo.getCuentas().containsAll(periodoIgual.getCuentas()));
	}
}