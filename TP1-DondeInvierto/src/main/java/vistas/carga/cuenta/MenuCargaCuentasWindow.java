package vistas.carga.cuenta;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import utils.Graficos;
import vm.carga.cuenta.MenuCargarCuentasVM;

@SuppressWarnings("serial")
public class MenuCargaCuentasWindow extends SimpleWindow<MenuCargarCuentasVM>
{

	public MenuCargaCuentasWindow(WindowOwner parent) {
		
		super(parent, new MenuCargarCuentasVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		panelPrincipal.setLayout(new VerticalLayout());
		Graficos.graficarDolares(panelPrincipal);
		this.setTitle("Cargar cuentas");
	}
	
	@Override
	protected void addActions(Panel botonera) 
	{
		botonera.setLayout(new VerticalLayout());
		
		new Button(botonera).setCaption("1.1 - Carga manual").onClick(this::cargaManual).setWidth(200);

		new Button(botonera).setCaption("1.2 - Carga masiva").onClick(this::cargaMasiva).setWidth(200);
		Graficos.graficarBorde(botonera, 340);
	}
	
	public void cargaManual() {
		Dialog<?> dialog = new CargaManualWindow(this);
		dialog.open();
	}
	public void cargaMasiva(){
		Dialog<?> dialog = new CargaMasivaWindow(this);
		dialog.open();
	}
}
