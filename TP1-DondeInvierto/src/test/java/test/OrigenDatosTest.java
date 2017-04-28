package test;
import org.junit.Before;
import org.junit.Test;
import com.sun.jersey.api.client.ClientResponse;
import static org.junit.Assert.*;
import domain.RequestService;

import dominio.datos.DatosTxt;
import dominio.datos.EstructuraEsperada;
import interfases.IOrigenDatos;

import static org.junit.Assert.*;

import java.util.List;


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
	    
	    @Test
	    public void obtenerArchivoQueNoExiste() throws Exception 
	    {
	    	//no deberia encontrar el archivo y deberia tirar una ioexception
	    	IOrigenDatos datosLeidos = new DatosTxt();
	    	datosLeidos.cargarDatosDe("algunArchivoQueNoExiste.txt");
	        assertTrue(datosLeidos.getRegistros().isEmpty());
	    }
	    
	    @Test
	    public void obtenerArchivoVacio() throws Exception 
	    {//deberia romper al no encontrar registros en el archivo
	    	IOrigenDatos datosLeidos = new DatosTxt();
	    	datosLeidos.cargarDatosDe("vacio.txt");
	        assertTrue(datosLeidos.getRegistros().);
	    }
	    
	    @Test
	    public void obtenerRegistrosSinEstructuraEsperada() throws Exception 
	    {//deberia romper al no poder convertir los tipos (de string a double) de registros los en el archivo
	    	IOrigenDatos datosLeidos = new DatosTxt();
	    	datosLeidos.cargarDatosDe("raro.txt");
	        assertTrue(datosLeidos.getRegistros().);
	    }
	    
	   

}
