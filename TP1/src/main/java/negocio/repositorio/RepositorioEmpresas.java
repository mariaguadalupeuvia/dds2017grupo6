package negocio.repositorio;

import java.util.ArrayList;
import java.util.List;

import negocio.dominio.Empresa;

public class RepositorioEmpresas 
{
	private static List<Empresa> empresas;
	
	public static void inicializarRepositorio()
	{
		empresas = new ArrayList<>();
	}
	
	public static void agregarVariasEmpresas(List<Empresa> empresasNuevas) 
	{
		empresasNuevas.forEach(empresaNueva -> agregarEmpresa(empresaNueva));
	}
	
	public static void agregarEmpresa(Empresa empresaNueva) 
	{
		if (!existeEmpresaDeNombre(empresaNueva.getNombre())) 
		{
			empresas.add(empresaNueva);			
		}
		else
		{
			empresas.forEach(empresa -> {
				
				if(empresa.getNombre().equals(empresaNueva.getNombre()))
				{
					empresa.agregarVariosPeriodos(empresaNueva.getPeriodos());
				}
			});
		}
	}

	private static boolean existeEmpresaDeNombre(String nombre) 
	{
		return empresas.stream().anyMatch(empresa -> empresa.getNombre().equals(nombre));
	}
	
	
	
	//PROPIEDADES
	public static List<Empresa> getEmpresas()
	{
		return empresas;
	}
	public static void setEmpresas(List<Empresa> empresasNuevas)
	{
		empresas = empresasNuevas;
	}
}
