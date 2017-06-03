package presentacion.vistas.indicadores;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import presentacion.vistas.indicadores.carga.CargaFormulaWindow;
import presentacion.vistas.indicadores.consulta.ConsultaFormulaWindow;
import presentacion.vistas.indicadores.consulta.ConsultaIndicadorWindow;
import presentacion.vm.indicadores.MenuIndicadorVM;

@SuppressWarnings("serial")
public class MenuIndicadorWindow extends SimpleWindow<MenuIndicadorVM>
{
	public MenuIndicadorWindow(WindowOwner parent) 
	{
		super(parent, new MenuIndicadorVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		panelPrincipal.setLayout(new VerticalLayout());
		
		this.setTitle("Indicadores");
	}
	
	@Override
	protected void addActions(Panel botonera) 
	{
		botonera.setLayout(new VerticalLayout());
		
		new Button(botonera).setCaption("1. Carga de formulas").onClick(this::cargaFormula).setWidth(200);
		new Button(botonera).setCaption("2. Consulta de formulas").onClick(this::consultaFormula).setWidth(200);
		new Button(botonera).setCaption("3. Consulta de indicadores").onClick(this::consultaIndicador).setWidth(200);
	}
	
	public void cargaFormula()
	{
		new CargaFormulaWindow(this).open();
	}
	
	public void consultaFormula()
	{
		new ConsultaFormulaWindow(this).open();
		
	}
	
	public void consultaIndicador()
	{
		new ConsultaIndicadorWindow(this).open();
	}
	
	
}