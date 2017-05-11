package test;

import org.junit.Before;
import org.junit.Test;

import dominio.Importador;
import dominio.ParserCuenta;
import excepciones.ImportadorException;
import fixture.Fixture;
import repositorio.RepositorioNombresCuentas;
import java.lang.StringIndexOutOfBoundsException;
import static org.junit.Assert.*;

public class ImportadorTest 
{
	private Importador importador;

    @Before
    public void setUp() throws Exception 
    {
    	Fixture.generarJuegoDeDatos();
        this.importador = new Importador();
    }
	
    @Test
    public void obtenerCuentasConDatosTxtYCargarRepo() throws Exception 
    {//deberia funcionar ok cargando el repositorio de nombres cuentas con datos obtenidos de un  archivo .txt
    	
    	RepositorioNombresCuentas.resetNombresCuentas();
    	int cantidadCuentasInicial = RepositorioNombresCuentas.getNombresCuentas().size();
    	assertEquals(0, cantidadCuentasInicial);//chequeo que el repo este vacio
    	
    	importador.cargarDatosDe("src/test/resources/prueba_txt.txt", new ParserCuenta());//cargo el repo con los datos de cuentas del archivo 
    	int cantidadCuentasFinal = RepositorioNombresCuentas.getNombresCuentas().size();//obtengo la cantidad de registros leidos y guardados
    	
    	 assertTrue(cantidadCuentasFinal > 0);
    	 assertEquals(4, cantidadCuentasFinal);//chequeo que el repo tenga las 4 cuentas distintas que tengo en el archivo
    }
    
    @Test
    public void obtenerCuentasConDatosXlsYCargarRepo() throws Exception 
    {//deberia funcionar ok cargando el repositorio de nombres cuentas con datos obtenidos de un  archivo .xls

    	RepositorioNombresCuentas.resetNombresCuentas();
    	int cantidadCuentasInicial = RepositorioNombresCuentas.getNombresCuentas().size();
    	assertEquals(0, cantidadCuentasInicial);//chequeo que el repo este vacio
    	
    	importador.cargarDatosDe("src/test/resources/prueba_excel.xls", new ParserCuenta());//cargo el repo con los datos de cuentas del archivo 
    	int cantidadCuentasFinal = RepositorioNombresCuentas.getNombresCuentas().size();//obtengo la cantidad de registros leidos y guardados
    	
    	 assertTrue(cantidadCuentasFinal > 0);
    	 assertEquals(4, cantidadCuentasFinal);//chequeo que el repo tenga las 4 cuentas distintas que tengo en el archivo
    }
    
    @Test(expected = ImportadorException.class)  
    public void pedirImportarExtensionQueNoEntiende() throws Exception 
    {
    	//deberia romper al no entender la extension, por ahora solo entiende .txt y .xls
    	importador.cargarDatosDe("algo.psd", new ParserCuenta());
    }
    
    @Test(expected = StringIndexOutOfBoundsException.class)
    public void pedirNombreArchivoInvalido() throws Exception 
    {
    	//deberia romper al no poder obtener un substring valido de la ruta "xx" como para reconocer una de las extensiones soportadas (txt o xls)
    	importador.cargarDatosDe("xx", new ParserCuenta());
    }
		  
    @Test(expected = ImportadorException.class)
    public void pedirCargarDatosDesdeRutaNull() throws Exception 
    {
    	//deberia romper
    	importador.cargarDatosDe(null, new ParserCuenta());
    }
}
