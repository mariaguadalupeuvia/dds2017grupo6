package presentacion.vistas;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import presentacion.utils.Graficos;
import presentacion.vistas.cuentas.CuentaWindow;
import presentacion.vistas.indicadores.IndicadorWindow;
import presentacion.vistas.metodologias.MetodologiaWindow;
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
		
		new Button(botonera).setCaption("1. Cuentas").onClick(() -> new CuentaWindow(this).open()).setWidth(200);
		new Button(botonera).setCaption("2. Indicadores").onClick(() -> new IndicadorWindow(this).open()).setWidth(200);
		new Button(botonera).setCaption("3. Metodologias").onClick(() -> new MetodologiaWindow(this).open()).setWidth(200);
		
		Graficos.graficarBorde(botonera, 360);
	}
}