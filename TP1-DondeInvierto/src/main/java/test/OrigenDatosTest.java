package test;
import org.junit.Test;
import static org.junit.Assert.*;

import dominio.datos.DatosTxt;
import interfases.IOrigenDatos;

public class OrigenDatosTest 
{
	    @Test
	    public void obtenerRegistros() throws Exception 
	    {
	    	//deberia encontrar registros en el archivo por defecto
	    	IOrigenDatos datosLeidos = new DatosTxt();
	    	datosLeidos.cargarDatos();
	        assertTrue(!datosLeidos.getRegistros().isEmpty());
	    }
	    
	    @Test //(expected=typeof(java.io.FileNotFoundException))
	    public void obtenerArchivoQueNoExiste() throws Exception 
	    {
	    	//no deberia encontrar el archivo y deberia tirar una FileNotFoundException
	    	IOrigenDatos datosLeidos = new DatosTxt();
	    	datosLeidos.cargarDatosDe("algunArchivoQueNoExiste.txt");
	        assertTrue(datosLeidos.getRegistros().isEmpty());
	    }
	    
	    @Test
	    public void obtenerArchivoVacio() throws Exception 
	    {//deberia romper al no encontrar registros en el archivo
	    	IOrigenDatos datosLeidos = new DatosTxt();
	    	datosLeidos.cargarDatosDe("vacio.txt");
	        assertTrue(datosLeidos.getRegistros().stream().findFirst().isPresent());
	    }
	    
	    @Test
	    public void obtenerRegistrosSinEstructuraEsperada() throws Exception 
	    {//deberia romper al no poder convertir los tipos (de string a double) de los registros  en el archivo
	    	IOrigenDatos datosLeidos = new DatosTxt();
	    	datosLeidos.cargarDatosDe("raro.txt");
	        assertTrue(datosLeidos.getRegistros().isEmpty());
	    }
	    
	   

}