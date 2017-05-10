package run;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import fixture.Fixture;
import vistas.MenuPrincipalWindow;

public class DondeInviertoApplication extends Application
{	
	public static void main(String[] args) throws Exception 
	{		
		Fixture.generarJuegoDeDatos();
		
		new DondeInviertoApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() 
	{
		return new MenuPrincipalWindow(this);
	}
}
