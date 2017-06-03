package negocio.repositorio;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import negocio.dominio.Formula;
import negocio.dominio.excepciones.NoSePuedeAgregarFormulaException;

public class RepositorioFormulasTest {
	
	private Formula formulaNueva;
	private Formula formulaRepetida;
	private Formula formulaValida;
	
	
	@Before
	public void setUp(){
		
		formulaNueva = new Formula();
		formulaNueva.setNombre("SUMA");
		formulaNueva.setExpresion("X+Y*4/2");
		
		formulaRepetida = new Formula();
		formulaRepetida.setNombre("SUMA");
		formulaRepetida.setExpresion("otra expresion");
		
		formulaValida = new Formula();
		formulaValida.setNombre("REST");
		formulaValida.setExpresion("-4*3+X");
		
		
		RepositorioFormulas.inicializarRepositorio();	
		
	}
	
	@Test
	public void testAgregarUnaFormula() 
	{
		RepositorioFormulas.agregarFormula(formulaNueva);
		
		assertTrue(RepositorioFormulas.getFormulas().equals((Arrays.asList(formulaNueva))));
	}
	
	@Test
	public void testAgregarDosFormulasConDistintoNombre() 
	{
		RepositorioFormulas.agregarFormula(formulaNueva);
		RepositorioFormulas.agregarFormula(formulaValida);
		
		int cantidadDeFormulasEnElRepo = RepositorioFormulas.getFormulas().size();
		
		assertTrue(cantidadDeFormulasEnElRepo == 2);
	}
	
	
	@Test(expected = NoSePuedeAgregarFormulaException.class)
	public void testNoSeagreganDosFormulasConElMismoNombre()
	{	
		RepositorioFormulas.agregarFormula(formulaNueva);
		RepositorioFormulas.agregarFormula(formulaRepetida);
		
	}
	
	
//TEST PARA EXCEPCION CUANDO SE INGRESA UNA FORMULA QUE NO ES VALIDA	
//	@Test(expected = UserException.class)       
//	public void testNoSeAgregaFormulaInvalida()
//	{	
//	
//		RepositorioFormulas.agregarFormula(formulaInvalida);
//		
//		
//	}
}