package negocio.dominio.manejoArchivos;

import java.util.ArrayList;
import java.util.List;

import negocio.dominio.Empresa;
import negocio.dominio.excepciones.NoSePuedeAgregarCuentaException;
import negocio.dominio.manejoArchivos.fuente.Fuente;
import negocio.dominio.manejoArchivos.parser.Parser;

public class Importador 
{
	private Fuente fuente;
	private Parser parser;
	
	public void obtenerDatos(String ruta)
	{
		fuente.leerDatos(ruta);
	}
	
	public List<Empresa> parsearDatos()
	{
		List<Empresa> empresas = new ArrayList<>();
		
		fuente.getDatos().forEach(fila -> {
			
			try 
			{
				Empresa empresa = parser.parsear(fila);
				empresas.add(empresa);
			} 
			catch (NoSePuedeAgregarCuentaException e) 
			{
				//Aca se desidió no debe hacer nada
			}
		});
		
		return empresas;
	}
	
	
	
	//PROPIEDADES
	public Importador(Fuente fuente, Parser parser)
	{
		this.fuente = fuente;
		this.parser = parser;
	}
	
	public Fuente getFuente() {
		return fuente;
	}
	public void setFuente(Fuente fuente) {
		this.fuente = fuente;
	}
	public Parser getParser() {
		return parser;
	}
	public void setParser(Parser parser) {
		this.parser = parser;
	}
}