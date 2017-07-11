package negocio.repositorio;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import negocio.dominio.Indicador;
import negocio.dominio.excepciones.NoSePuedeAgregarIndicadorException;

public class RepositorioIndicadoresTest {
	
	private Indicador indicadorNuevo;
	private Indicador indicadorRepetido;
	private Indicador indicadorValido;
	
	
	@Before
	public void setUp() {
		
		indicadorNuevo = new Indicador("SUMA",null,"");
		indicadorRepetido = new Indicador("SUMA",null,"");
		indicadorValido = new Indicador("REST", null,"");
		
		RepositorioIndicadores.inicializarRepositorio();
	}
	
	@Test
	public void testAgregarUnIndicador() 
	{
		RepositorioIndicadores.agregarIndicador(indicadorNuevo);
		
		assertTrue(RepositorioIndicadores.getIndicadores().equals((Arrays.asList(indicadorNuevo))));
	}
	
	@Test
	public void testAgregarDosIndicadoresConDistintoNombre() 
	{
		RepositorioIndicadores.agregarIndicador(indicadorNuevo);
		RepositorioIndicadores.agregarIndicador(indicadorValido);
		
		int cantidadDeIndicadorsEnElRepo = RepositorioIndicadores.getIndicadores().size();
		
		assertTrue(cantidadDeIndicadorsEnElRepo == 2);
	}
	
	
	@Test(expected = NoSePuedeAgregarIndicadorException.class)
	public void testNoSeAgreganDosIndicadoresConElMismoNombre()
	{	
		RepositorioIndicadores.agregarIndicador(indicadorNuevo);
		RepositorioIndicadores.agregarIndicador(indicadorRepetido);
		
	}
}