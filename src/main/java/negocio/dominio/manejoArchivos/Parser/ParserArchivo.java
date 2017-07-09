package negocio.dominio.manejoArchivos.parser;

import negocio.dominio.Cuenta;
import negocio.dominio.Empresa;
import negocio.dominio.Periodo;
import negocio.dominio.excepciones.FilaConFormatoIncorrectoException;

public class ParserArchivo implements Parser
{
	private Character delimitador;
	
	@Override
	public Empresa parsear(String fila)
	{
		String[] atributos;
		
		try
		{
			atributos = fila.split(delimitador.toString());
		}
		catch(NullPointerException e) 
		{
			throw new FilaConFormatoIncorrectoException("No se puede parsear una fila nula");
		}
		
		if(atributos.length > 4) 
		{
			throw new FilaConFormatoIncorrectoException("Formato incorrecto: existen columnas extra");
		}
		
		String nombreEmpresa;
		String nombreCuenta;
		Integer añoPeriodo;
		Double valorCuenta;
		
		try
		{
			nombreEmpresa = atributos[0];
			nombreCuenta = atributos[1];
			añoPeriodo = Double.valueOf(atributos[2]).intValue();
			valorCuenta = Double.valueOf(atributos[3]);
		}
		catch(IllegalArgumentException | IndexOutOfBoundsException e) 
		{
			throw new FilaConFormatoIncorrectoException("Formato incorrecto: faltan columnas o el tipo no coincide");
		}
		
		Empresa empresa = new Empresa();
		Periodo periodo = new Periodo();
		Cuenta cuenta = new Cuenta();
			
		cuenta.setNombre(nombreCuenta);
		cuenta.setValor(valorCuenta);
		periodo.setAño(añoPeriodo);
		periodo.agregarCuenta(cuenta);
		empresa.setNombre(nombreEmpresa);
		empresa.agregarPeriodo(periodo);
			
		return empresa;
	}
	
	
	
	
	//CONSTRUCTOR Y PROPIEDADES
	public ParserArchivo(Character delimitador) {
		this.delimitador = delimitador;
	}
}