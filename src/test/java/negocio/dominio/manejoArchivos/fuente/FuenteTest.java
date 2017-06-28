package negocio.dominio.manejoArchivos.fuente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.apache.poi.ss.usermodel.Cell;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import negocio.dominio.manejoArchivos.fuente.FuenteExcel;

@SuppressWarnings("deprecation")
public class FuenteTest {

	@Mock private Cell celdaExcelMock;
	private FuenteExcel fuenteExcel;
	
	@Before 
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	//TESTS FuenteExcel
	//TESTEO EL MENSAJE "formatearCelda", LOS DEMAS SON TRIVIALES
	@Test
	public void testformatearCeldaTipoNumerico() {
		
		fuenteExcel = new FuenteExcel();
		
		when(celdaExcelMock.getCellType()).thenReturn(0);
		when(celdaExcelMock.getNumericCellValue()).thenReturn(100d);
		
		assertEquals(fuenteExcel.formatearCelda(celdaExcelMock), "100.0");
	}
	
	@Test
	public void testformatearCeldaTipoString() {
		
		fuenteExcel = new FuenteExcel();
		
		when(celdaExcelMock.getCellType()).thenReturn(1);
		when(celdaExcelMock.getStringCellValue()).thenReturn("unString");
		
		assertEquals(fuenteExcel.formatearCelda(celdaExcelMock), "unString");
	}

	@Test
	public void testformatearCeldaTipoBlanco() {
	
		fuenteExcel = new FuenteExcel();
	
		when(celdaExcelMock.getCellType()).thenReturn(3);
		
		assertEquals(fuenteExcel.formatearCelda(celdaExcelMock), "");
	}

	@Test
	public void testformatearCeldaTipoBool() {
	
		fuenteExcel = new FuenteExcel();
	
		when(celdaExcelMock.getCellType()).thenReturn(4);
		when(celdaExcelMock.getBooleanCellValue()).thenReturn(true);
		
		assertEquals(fuenteExcel.formatearCelda(celdaExcelMock), "true");
	}
}
