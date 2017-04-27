package run;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import vistas.MenuPrincipalWindow;

public class DondeInviertoApplication extends Application
{	
	public static void main(String[] args) throws Exception 
	{
		new DondeInviertoApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		return new MenuPrincipalWindow(this);
	}
}
