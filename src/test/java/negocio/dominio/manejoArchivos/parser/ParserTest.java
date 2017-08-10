package negocio.dominio.manejoArchivos.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import negocio.dominio.Empresa;
import negocio.dominio.excepciones.FilaConFormatoIncorrectoException;
import negocio.dominio.manejoArchivos.parser.ParserArchivo;

public class ParserTest {

	private ParserArchivo parser = new ParserArchivo(' ');

	@Test(expected = FilaConFormatoIncorrectoException.class)
	public void parsearUnaFilaVaciaTieneQueDarError() {
	
		parser.parsear("");
	}
	
	@Test(expected = FilaConFormatoIncorrectoException.class)
	public void parsearUnaFilaNULLTieneQueDarError() {
		parser.parsear(null);
	}
	
	@Test
	public void parsearUnaFilaCorrectaCreaUnaEmpresaCorrecta() {
		Empresa empresa = parser.parsear("facebook ebidata 2017.0 1200000.0");
		
		assertEquals(empresa.getNombre(), "facebook");
		assertTrue(empresa.getPeriodos().get(0).getAño() == 2017);
		assertEquals(empresa.getPeriodos().get(0).getCuentas().get(0).getNombre(), "ebidata");
		assertTrue(empresa.getPeriodos().get(0).getCuentas().get(0).getValor() == 1200000d);
	}
	
	@Test(expected = FilaConFormatoIncorrectoException.class)
	public void parsearUnaFilaConMenosCamposTieneQueDarError() {
		parser.parsear("facebook");
	}
	
	@Test(expected = FilaConFormatoIncorrectoException.class)
	public void parsearUnaFilaConMasCamposTieneQueDarError() {
		parser.parsear("facebook ebitda 2017.0 1200000.0 campoExtra");
	}
	
	@Test(expected = FilaConFormatoIncorrectoException.class)
	public void parsearUnaFilaConCamposDeDistintoTipoTieneQueDarError() {
		parser.parsear("facebook ebitda acaSeEsperabaUnInteger acaSeEsperabaUnDouble");
	}
}
