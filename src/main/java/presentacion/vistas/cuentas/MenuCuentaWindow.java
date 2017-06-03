package presentacion.vistas.cuentas;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import presentacion.vistas.cuentas.carga.MenuCargaCuentaWindow;
import presentacion.vistas.cuentas.consulta.ConsultaCuentaWindow;
import presentacion.vm.cuentas.MenuCuentasVM;

@SuppressWarnings("serial")
public class MenuCuentaWindow extends SimpleWindow<MenuCuentasVM>
{
	public MenuCuentaWindow(WindowOwner parent) 
	{
		super(parent, new MenuCuentasVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		panelPrincipal.setLayout(new VerticalLayout());
		
		this.setTitle("Cuentas");
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
		new MenuCargaCuentaWindow(this).open();
	}
	public void consulta()
	{
		new ConsultaCuentaWindow(this).open();
	}
}