package run;

	import org.uqbar.arena.Application;
	import org.uqbar.arena.windows.Window;

	import vistas.MenuWindow;

	public class InversorApplication extends Application 
	{

		public static void main(String[] args) throws Exception 
		{		
			new InversorApplication().start();
		}

		@Override
		protected Window<?> createMainWindow() 
		{
			return new MenuWindow(this);
		}
	}

