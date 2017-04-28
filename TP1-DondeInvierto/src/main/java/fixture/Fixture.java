package fixture;

import java.util.ArrayList;
import java.util.Arrays;

import repositorio.RepositorioCuentas;
import repositorio.RepositorioEmpresas;
import repositorio.RepositorioNombresCuentas;
import repositorio.RepositorioPeriodos;

public class Fixture 
{
	public static void generarJuegoDeDatos()
	{
		//INICIALIZO TODOS LOS REPOSITORIOS
		ArrayList<String>datosPruebaEmpresas = new ArrayList<String>(Arrays.asList("facebook", "twitter", "pinterest"));
		ArrayList<String>datosPruebaNombresCuentas = new ArrayList<String>(Arrays.asList("ebidata","fds","cashflow", "margenes"));
		ArrayList<Integer>datosPruebaPeriodos = new ArrayList<Integer>(Arrays.asList(2015,2016,2017));
		
		RepositorioCuentas.inicializarRepositorio();
		
		RepositorioEmpresas.inicializarRepositorio();
		RepositorioEmpresas.setEmpresas(datosPruebaEmpresas);
		
		RepositorioNombresCuentas.inicializarRepositorio();
		RepositorioNombresCuentas.setNombresCuentas(datosPruebaNombresCuentas);
		
		RepositorioPeriodos.inicializarRepositorio();
		RepositorioPeriodos.setPeriodos(datosPruebaPeriodos);
	}
}
