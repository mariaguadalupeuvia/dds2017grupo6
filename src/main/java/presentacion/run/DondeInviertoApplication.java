package presentacion.run;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import negocio.repositorio.RepositorioEmpresas;
import presentacion.vistas.MenuPrincipalWindow;

public class DondeInviertoApplication extends Application
{	
	public static void main(String[] args) throws Exception 
	{				
		RepositorioEmpresas.inicializarRepositorio();
		
		new DondeInviertoApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() 
	{
		return new MenuPrincipalWindow(this);
	}
}
