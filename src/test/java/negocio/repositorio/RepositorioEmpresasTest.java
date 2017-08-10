package negocio.repositorio;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import negocio.dominio.Empresa;
import negocio.dominio.Periodo;

public class RepositorioEmpresasTest {

	private Empresa empresaIgual;
	private Empresa empresaDistinta;
	private Empresa empresaNueva;

	@Before
	public void setUp()
	{
		empresaNueva = new Empresa();
		Periodo periodo1 = new Periodo();
		periodo1.setAño(2017);
		empresaNueva.setNombre("Facebook");
		empresaNueva.agregarPeriodo(periodo1);
		
		empresaDistinta = new Empresa();
		Periodo periodo2 = new Periodo();
		periodo2.setAño(2016);
		empresaDistinta.setNombre("Twitter");
		empresaDistinta.agregarPeriodo(periodo2);
		
		empresaIgual = new Empresa();
		Periodo periodo3 = new Periodo();
		periodo3.setAño(2016);
		empresaIgual.setNombre("Facebook");
		empresaIgual.agregarPeriodo(periodo3);
		
		
		RepositorioEmpresas.inicializarRepositorio();
	}
	
	@Test
	public void agregarUnaEmpresa() 
	{
		RepositorioEmpresas.agregarEmpresa(empresaNueva);
		
		assertTrue(RepositorioEmpresas.getEmpresas().equals((Arrays.asList(empresaNueva))));
	}
	
	@Test
	public void agregarDosEmpresasConDistintoNombre() 
	{
		RepositorioEmpresas.agregarEmpresa(empresaNueva);
		RepositorioEmpresas.agregarEmpresa(empresaDistinta);
		
		int cantidadDeEmpresasEnElRepo = RepositorioEmpresas.getEmpresas().size();
		
		assertTrue(cantidadDeEmpresasEnElRepo == 2);
	}
	
	@Test
	public void agregarDosEmpresasConElMismoNombre() 
	{
		RepositorioEmpresas.agregarEmpresa(empresaNueva);
		RepositorioEmpresas.agregarEmpresa(empresaIgual);
		
		int cantidadDeEmpresasEnElRepo = RepositorioEmpresas.getEmpresas().size();
		Empresa empresa = RepositorioEmpresas.getEmpresas().get(0);
		
		assertTrue(cantidadDeEmpresasEnElRepo == 1);
		assertTrue(empresa.getNombre().equals(empresaNueva.getNombre()) && empresa.getNombre().equals(empresaIgual.getNombre()));
		assertTrue(empresa.getPeriodos().containsAll(empresaNueva.getPeriodos()) && empresa.getPeriodos().containsAll(empresaIgual.getPeriodos()));
	}
}