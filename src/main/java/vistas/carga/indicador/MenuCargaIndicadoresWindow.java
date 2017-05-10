package vistas.carga.indicador;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;

import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import utils.Graficos;
import vm.carga.indicador.MenuCargaIndicadoresVM;

@SuppressWarnings("serial")
public class MenuCargaIndicadoresWindow extends SimpleWindow<MenuCargaIndicadoresVM> 
{

	public MenuCargaIndicadoresWindow(WindowOwner parent) {
		super(parent, new MenuCargaIndicadoresVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		panelPrincipal.setLayout(new VerticalLayout());
		this.setTitle("Cargar indicadores");
		Graficos.graficarDolares(panelPrincipal);
		Graficos.graficarEspacio(panelPrincipal, 340);
	}
	
	@Override
	protected void addActions(Panel botonera) 
	{
		botonera.setLayout(new VerticalLayout());
		
		new Button(botonera).setCaption("3.1 - Carga manual").onClick(this::cargaManual).setWidth(200);
		new Button(botonera).setCaption("3.2 - Carga masiva").onClick(this::cargaMasiva).setWidth(200);
		
		Graficos.graficarBorde(botonera, 340);
	}
	
	public void cargaManual() {
		Dialog<?> dialog = new CargaManualIndicadorWindow(this);
		dialog.open();
	}
	public void cargaMasiva(){
		Dialog<?> dialog = new CargaMasivaIndicadoresWindow(this);
		dialog.open();
	}

}