package repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dominio.CuentaEmpresaPeriodo;

public class RepositorioCuentas 
{
	private static List<CuentaEmpresaPeriodo> cuentas;
	
	public static void inicializarRepositorio()
	{
		cuentas = new ArrayList<>();
	}
	
	public static void agregar(CuentaEmpresaPeriodo cuenta) 
	{
		cuentas.add(cuenta);
	}
	
	public static List<CuentaEmpresaPeriodo> filtrarCuentas(String empresa, String nombreCuenta,String periodo, Double valor) 
	{
		List<CuentaEmpresaPeriodo> cuentasFiltradas = cuentas;
		
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
		if (periodo != null)
		{
			cuentasFiltradas =  cuentasFiltradas.stream().filter(cuenta -> cuenta.getPeriodo().equals(periodo))
					.collect(Collectors.toList());
		}
		
		return cuentasFiltradas;
	}
	
	public static void agregarVarias(List<CuentaEmpresaPeriodo> nuevasCuentas) 
	{
		cuentas.addAll(nuevasCuentas);
	}
	
	
	
	//PROPIEDADES
	public static List<CuentaEmpresaPeriodo> getCuentas() 
	{
		return cuentas;
	}

	public static void setCuentas(List<CuentaEmpresaPeriodo> nuevasCuentas) 
	{
		cuentas = nuevasCuentas;
	}

	public static void resetCuentas() {
	cuentas.clear();
		
	}
}
