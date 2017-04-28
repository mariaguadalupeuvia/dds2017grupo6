package vistas;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import vistas.carga.cuenta.MenuCargaCuentasWindow;
import vistas.consulta.cuenta.ConsultaCuentaWindow;
import vm.MenuPrincipalVM;

@SuppressWarnings("serial")
public class MenuPrincipalWindow extends SimpleWindow<MenuPrincipalVM>
{
	public MenuPrincipalWindow(WindowOwner parent) 
	{
		super(parent, new MenuPrincipalVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		panelPrincipal.setLayout(new VerticalLayout());
		
		this.setTitle("Menu");
	}
	
	@Override
	protected void addActions(Panel botonera) 
	{
		botonera.setLayout(new VerticalLayout());
		
		new Button(botonera).setCaption("1. Carga de cuentas").onClick(this::carga).setWidth(200);

		new Button(botonera).setCaption("2. Consulta de cuentas").onClick(this::consulta).setWidth(200);
	}
	
	public void carga()
	{
		SimpleWindow<?> ventana = new MenuCargaCuentasWindow(this);
		ventana.open();
	}
	public void consulta()
	{
		SimpleWindow<?> ventana = new ConsultaCuentaWindow(this);
		ventana.open();
	}
}