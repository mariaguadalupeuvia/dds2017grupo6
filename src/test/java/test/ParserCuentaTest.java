package test;

import org.junit.Before;
import org.junit.Test;

import dominio.ParserCuenta;
import excepciones.ParserDatosException;
import fixture.Fixture;


public class ParserCuentaTest 
{
	private ParserCuenta parser;
	
	@Before
	public void setUp() throws Exception 
	{
	    this.parser = new ParserCuenta();
	    Fixture.generarJuegoDeDatos();
	}
	
	@Test
	public void parsearStringEsperado() throws Exception 
	{//deberia funcionar ok reconociendo una estructura "string,string,string,double" 
		
		parser.parsear("facebook ebitda 2017 100.0");
	}
	
	@Test
	public void parsearStringNumerico() throws Exception 
	{//deberia funcionar ok reconociendo un formato "string,string,string,double" 
		parser.parsear("12 12 12 12");
	}
	
	@Test
	public void parsearStringEsperadoConMasCampos() throws Exception 
	{//deberia funcionar ok reconociendo la estructura esperada en las 4 primeras posiciones del array "string, string, string, double" 
		
		parser.parsear("facebook ebitda 2017 100.0 facebook facebook facebook");
	}

	@Test(expected = ParserDatosException.class)//enmascara un NumberFormatException
	public void intentarParsearStringADouble() throws Exception 
	{//deberia fallar al no poder parsear el String "algoMal" a Double
		parser.parsear("facebook ebitda 2017 algoMal");
	}
	
	@Test(expected = ParserDatosException.class)//enmascara un ArrayIndexOutOfBoundsException
	public void intentarParsearFormatoInesperado() throws Exception 
	{//deberia fallar al no poder obtener el array de 4 posiciones esperada despues de hacer el split de la cadena recibida 
		parser.parsear("facebook ebitda");
	}
	
	@Test(expected = ParserDatosException.class)//enmascara un NullPointerException
	public void intentarParsearStringVacio() throws Exception 
	{//deberia fallar al no poder hacer el split del string
		parser.parsear(null);
	}
}
