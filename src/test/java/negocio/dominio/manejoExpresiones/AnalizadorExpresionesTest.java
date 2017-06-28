package negocio.dominio.manejoExpresiones;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AnalizadorExpresionesTest {
	/*
	@Test
	public void esExpresionValidaFaltaParametro() {
		
		String valordePrueba = "DDD+AA";
		formula.setExpresion(valordePrueba);
		assertTrue(formula.esExpresionValida());
		
		valordePrueba = "a+";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());
		
		valordePrueba = "*a";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());
		
		valordePrueba = "a*";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());
		
		valordePrueba = "/a";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());
		
		valordePrueba = "a/";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());
		
		valordePrueba = "a-";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());
	}
	
	@Test
	public void esExpresionValidaParentesisErroneos() {
		
		String valordePrueba = "(d+c";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());
		
		valordePrueba = "a+b)";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());

		valordePrueba = "(a+b+(c*d))";
		formula.setExpresion(valordePrueba);
		assertTrue(formula.esExpresionValida());
		
		valordePrueba = "(a+b+(c*d)";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());
		
		valordePrueba = "(a+b+c*d))";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());
		
		valordePrueba = "Facebook+0.3+(((jones*5)+Facebook1)*0.3)*google/";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());
		
		valordePrueba = "Facebook+0.3+(((jones*5)+)*0.3)*google/Price";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());
		
		valordePrueba = "Facebook+0.3+(((*5)+Facebook1)*0.3)*google/Price";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());	
		
		valordePrueba = "+0.3+(((jones*5)+Facebook1)*0.3)*google/Price";
		formula.setExpresion(valordePrueba);
		assertFalse(formula.esExpresionValida());		
	}

	@Test
	public void esExpresionValidaParentesisCorrectos() {
		
		String valordePrueba = "(a+b)";
		formula.setExpresion(valordePrueba);
		assertTrue(formula.esExpresionValida());
		
		valordePrueba = "Facebook+0.3+(((jones*5)+facebook)*0.3)";
		formula.setExpresion(valordePrueba);
		assertTrue(formula.esExpresionValida());
		
		valordePrueba = "Facebook+0.3+(((jones*5)+Facebook1)*0.3)*google/Price";
		formula.setExpresion(valordePrueba);
		assertTrue(formula.esExpresionValida());
	}
	
	@Test
	public void calcularExpresion() {
		
		String valordePrueba = "Facebook+0.3+(((jones*5)+Facebook1)*0.3)*google/Price";
		formula.setExpresion(valordePrueba);
		
		List<Double> valores = new ArrayList<Double>();
		valores.add(4.0);
		valores.add(5.0);
		valores.add(6.0);
		valores.add(7.0);
		valores.add(8.0);
		
		assertTrue(formula.calcularExpresion(valores)==12.4375);
	}
	
	@Test
	public void getIdentificadores() {
		
		String expresion = "Facebook+0.3+(((jones*5)+Facebook1)*0.3)*google/Price";
		formula.setExpresion(expresion);
		
		List<String> valordePrueba = new ArrayList<String>();
		valordePrueba.add("Facebook");
		valordePrueba.add("jones");
		valordePrueba.add("Facebook1");
		valordePrueba.add("google");
		valordePrueba.add("Price");
		assertArrayEquals(formula.getIncognitas().toArray(),valordePrueba.toArray());
		
		
		expresion = "Facebook+ 0.3+((    (jones*5)+Facebook1)*0.3)* google / Price";
		formula.setExpresion(expresion);
		assertArrayEquals(formula.getIncognitas().toArray(),valordePrueba.toArray());
		
		expresion = "Facebook+ 0.3+((    (jones				*5)+				Facebook1)*0.3)* google / Price";
		formula.setExpresion(expresion);
		assertArrayEquals(formula.getIncognitas().toArray(),valordePrueba.toArray());
	}
	*/
}