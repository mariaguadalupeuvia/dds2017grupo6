package presentacion.vistas;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import presentacion.utils.Graficos;
import presentacion.vistas.carga.cuenta.MenuCargaCuentasWindow;
import presentacion.vistas.consulta.cuenta.ConsultaCuentaWindow;
import presentacion.vm.MenuPrincipalVM;

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
		
		Graficos.graficarDolares(panelPrincipal);
	}
	
	@Override
	protected void addActions(Panel botonera) 
	{
		botonera.setLayout(new VerticalLayout());
		
		Graficos.graficarEspacio(botonera, 360);
		
		new Button(botonera).setCaption("1. Carga de cuentas").onClick(this::carga).setWidth(200);
		new Button(botonera).setCaption("2. Consulta de cuentas").onClick(this::consulta).setWidth(200);
		
		Graficos.graficarBorde(botonera, 360);
	}
	
	public void carga()
	{
		new MenuCargaCuentasWindow(this).open();
	}
	public void consulta()
	{
		new ConsultaCuentaWindow(this).open();
	}
}