package repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dominio.Cuenta;
import dominio.Empresa;
import dominio.Periodo;

public class RepositorioEmpresas {

	private static List<Empresa> empresas;
	
	public static void inicializarRepositorio() 
	{
		empresas = new ArrayList<>();
	}
	
	public static void agregar(Empresa empresa)
	{
		empresas.add(empresa);
	}
	
	public static void agregarVarias(List<Empresa> nuevasEmpresas) 
	{
		empresas.addAll(empresas);
	}
	
	public static void agregarPeriodoCuentaValor(String nombreEmpresa, String nombreCuenta,String periodoBuscado, Double valor) 
	{
		Empresa empresa = buscarYagregarEmpresaSiNoExiste(nombreEmpresa);
		Periodo periodo = buscarYagregarPeriodoSiNoExiste(periodoBuscado, empresa);
		Cuenta cuenta = buscarYagregarCuentaSiNoExiste(nombreCuenta, periodo);
		cuenta.setValor(valor);
	}
	
	public static Empresa buscarYagregarEmpresaSiNoExiste(String nombre) 
	{
		Empresa empresa = empresas.stream().filter(unaEmpresa -> unaEmpresa.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
		if (empresa == null)  
		{
			empresa = new Empresa(nombre.toLowerCase(), new ArrayList<Periodo>());
			agregar(empresa);
		}
		return empresa;
	}
	public static Periodo buscarYagregarPeriodoSiNoExiste(String nombre, Empresa empresa) 
	{
		Periodo periodo = empresa.getPeriodos().stream().filter(unPeriodo -> unPeriodo.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
		if (periodo == null)  
		{
			periodo = new Periodo(nombre.toLowerCase(), new ArrayList<Cuenta>());
			empresa.agregarPeriodo(periodo);
		}
		return periodo;
	}
	public static Cuenta buscarYagregarCuentaSiNoExiste(String nombre, Periodo periodo) 
	{
		Cuenta cuenta = periodo.getCuentas().stream().filter(unaCuenta -> unaCuenta.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
		if (cuenta == null)  
		{
			cuenta = new Cuenta(nombre.toLowerCase());
			periodo.agregarCuenta(cuenta);
		}
		return cuenta;
	}
	//PROPIEDADES
	public static List<Empresa> getEmpresas() 
	{
		return empresas;
	}
	
	public static List<String> getNombresEmpresas() 
	{
		return empresas.stream()
				.map(empresa -> empresa.getNombre())
				.collect(Collectors.toList());
	}

	public static void setEmpresas(ArrayList<Empresa> nuevasEmpresas) 
	{
		empresas = nuevasEmpresas;
	}

	public static void setNombresEmpresas(ArrayList<String> datosPruebaEmpresas) 
	{
		// TODO Auto-generated method stub
	}

	public static void resetEmpresas() {
		empresas.clear();
		
	}

}
