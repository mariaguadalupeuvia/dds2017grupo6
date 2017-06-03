package presentacion.vistas.cuentas.carga;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import presentacion.vm.cuentas.carga.MenuCargaCuentaVM;

@SuppressWarnings("serial")
public class MenuCargaCuentaWindow extends SimpleWindow<MenuCargaCuentaVM>
{

	public MenuCargaCuentaWindow(WindowOwner parent) {
		
		super(parent, new MenuCargaCuentaVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		panelPrincipal.setLayout(new VerticalLayout());
		this.setTitle("Cargar cuentas");
	}
	
	@Override
	protected void addActions(Panel botonera) 
	{
		botonera.setLayout(new VerticalLayout());
		
		new Button(botonera).setCaption("1.1 - Carga manual").onClick(this::cargaManual).setWidth(200);

		new Button(botonera).setCaption("1.2 - Carga masiva").onClick(this::cargaMasiva).setWidth(200);
	}
	
	public void cargaManual() 
	{
		new CargaManualCuentaWindow(this).open();
	}
	public void cargaMasiva()
	{
		new CargaMasivaCuentaWindow(this).open();
	}
}
