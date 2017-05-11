package fixture;

import java.util.ArrayList;
import java.util.Arrays;

import dominio.Empresa;
import dominio.Indicador;
import repositorio.RepositorioCuentas;
import repositorio.RepositorioEmpresas;
import repositorio.RepositorioNombresCuentas;
import repositorio.RepositorioIndicadores;
import repositorio.RepositorioPeriodos;

public class Fixture 
{
	public static void generarJuegoDeDatos()
	{
		//INICIALIZO TODOS LOS REPOSITORIOS
		
		ArrayList<Empresa>datosPruebaEmpresas = new ArrayList<Empresa>(Arrays.asList(new Empresa("facebook",null), new Empresa("twitter",null), new Empresa("pinterest",null)));
		ArrayList<String>datosPruebaNombresCuentas = new ArrayList<String>(Arrays.asList("ebidata","fds","cashflow"));
		ArrayList<String>datosPruebaPeriodos = new ArrayList<String>(Arrays.asList("2015","2016","2017"));
		ArrayList<Indicador>datosPruebaNombresIndicadores = new ArrayList<Indicador>(Arrays.asList(new Indicador("12+4;","I1","ingresoNeto"),new Indicador("12+4;","I2","roe"),new Indicador("12+4;","I3","roa")));
		
		RepositorioCuentas.inicializarRepositorio();
		
		RepositorioEmpresas.inicializarRepositorio();
		RepositorioEmpresas.setEmpresas(datosPruebaEmpresas);
		
		RepositorioNombresCuentas.inicializarRepositorio();
		RepositorioNombresCuentas.setNombresCuentas(datosPruebaNombresCuentas);
		
		RepositorioPeriodos.inicializarRepositorio();
		RepositorioPeriodos.setPeriodos(datosPruebaPeriodos);
		
		RepositorioIndicadores.inicializarRepositorio();
		RepositorioIndicadores.setIndicadores(datosPruebaNombresIndicadores);
	}
}
