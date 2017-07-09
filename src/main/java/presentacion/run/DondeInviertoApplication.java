package presentacion.run;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import negocio.dominio.fixtures.FixtureCriteriosPredefinidos;
import negocio.dominio.fixtures.FixtureIndicadoresPredefinidos;
import negocio.repositorio.RepositorioCriterios;
import negocio.repositorio.RepositorioEmpresas;
import negocio.repositorio.RepositorioIndicadores;
import negocio.repositorio.RepositorioMetodologias;
import presentacion.vistas.MenuPrincipalWindow;

public class DondeInviertoApplication extends Application
{	
	public static void main(String[] args) throws Exception 
	{				
		RepositorioEmpresas.inicializarRepositorio();
		RepositorioIndicadores.inicializarRepositorio();
		RepositorioCriterios.inicializarRepositorio();
		RepositorioMetodologias.inicializarRepositorio();
		
		RepositorioIndicadores.agregarPredefinidos(new FixtureIndicadoresPredefinidos().getIndicadores());
		RepositorioCriterios.agregarPredefinidos(new FixtureCriteriosPredefinidos().getCriterios());
		
		new DondeInviertoApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() 
	{
		return new MenuPrincipalWindow(this);
	}
}