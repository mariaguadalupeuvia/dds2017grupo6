package negocio.dominio.manejoArchivos.Parser;

import negocio.dominio.Cuenta;
import negocio.dominio.Empresa;
import negocio.dominio.Periodo;

public class ParserArchivo implements Parser
{
	private Character delimitador;
	
	@Override
	public Empresa parsear(String fila) 
	{
		String [] atributos = fila.split(delimitador.toString());
		
		if(atributos.length > 4)
		{
			throw new IndexOutOfBoundsException();
		}
		
		String nombreEmpresa = atributos[0];
		String nombreCuenta = atributos[1];
		Integer añoPeriodo = Double.valueOf(atributos[2]).intValue();
		Double valorCuenta = Double.valueOf(atributos[3]);
		
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