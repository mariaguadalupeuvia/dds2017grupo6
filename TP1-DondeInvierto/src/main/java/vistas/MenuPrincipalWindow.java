package vistas;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import utils.Graficos;
import vistas.carga.cuenta.MenuCargaCuentasWindow;
import vistas.carga.indicador.MenuCargaIndicadoresWindow;
import vistas.consulta.cuenta.ConsultaCuentaWindow;
import vistas.consulta.indicador.ConsultaIndicadorWindow;
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
		
		Graficos.graficarDolares(panelPrincipal);
	}

	@Override
	protected void addActions(Panel botonera) 
	{
		botonera.setLayout(new VerticalLayout());
		
		Graficos.graficarEspacio(botonera, 340);
		new Button(botonera).setCaption("1. Carga de cuentas").onClick(this::carga).setWidth(200);
		new Button(botonera).setCaption("2. Consulta de cuentas").onClick(this::consulta).setWidth(200);
		
		Graficos.graficarEspacio(botonera, 340);	
		new Button(botonera).setCaption("3. Carga de indicadores").onClick(this::cargaIndicador).setWidth(200);
		new Button(botonera).setCaption("4. Consulta de indicadores").onClick(this::consultaIndicador).setWidth(200);
		
		Graficos.graficarBorde(botonera, 340);
	}
	
	public void carga()
	{
		SimpleWindow<?> ventana = new MenuCargaCuentasWindow(this);
		ventana.open();
	}
	public void cargaIndicador()
	{
		SimpleWindow<?> ventana = new MenuCargaIndicadoresWindow(this);
		ventana.open();
	}
	public void consulta()
	{
		SimpleWindow<?> ventana = new ConsultaCuentaWindow(this);
		ventana.open();
	}
	
	public void consultaIndicador()
	{
		SimpleWindow<?> ventana = new ConsultaIndicadorWindow(this);
		ventana.open();
	}
}