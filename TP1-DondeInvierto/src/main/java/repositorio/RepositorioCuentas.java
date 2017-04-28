package repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dominio.Cuenta;

public class RepositorioCuentas 
{
	private static List<Cuenta> cuentas;
	
	public static void inicializarRepositorio()
	{
		cuentas = new ArrayList<>();
	}
	
	public static void agregar(Cuenta cuenta) 
	{
		cuentas.add(cuenta);
	}
	
	public static List<Cuenta> filtrarCuentas(String empresa, String nombreCuenta,Integer periodo, Double valor) 
	{
		List<Cuenta> cuentasFiltradas = cuentas;
		
		if (empresa != null) 
		{
			cuentasFiltradas = cuentasFiltradas.stream().filter(cuenta -> cuenta.getEmpresa().equals(empresa))
					.collect(Collectors.toList());
		}
		if (nombreCuenta != null)
		{
			cuentasFiltradas =  cuentasFiltradas.stream().filter(cuenta -> cuenta.getNombreCuenta().equals(nombreCuenta))
					.collect(Collectors.toList());
		}
		if (periodo != 0)
		{
			cuentasFiltradas =  cuentasFiltradas.stream().filter(cuenta -> cuenta.getPeriodo().equals(periodo))
					.collect(Collectors.toList());
		}
		
		
		return cuentasFiltradas;
	}
	
	public static void agregarVarias(List<Cuenta> nuevasCuentas) 
	{
		cuentas.addAll(nuevasCuentas);
	}
	
	
	
	//PROPIEDADES
	public static List<Cuenta> getCuentas() 
	{
		return cuentas;
	}

	public static void setCuentas(List<Cuenta> nuevasCuentas) 
	{
		cuentas = nuevasCuentas;
	}
}
