package vistas.carga.indicador;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import dominio.Indicador;
import utils.Graficos;
import vm.carga.indicador.CargaManualIndicadorVM;

@SuppressWarnings("serial")
public class CargaManualIndicadorWindow extends Dialog<CargaManualIndicadorVM> 
{
	public CargaManualIndicadorWindow(WindowOwner parent) 
	{
		super(parent, new CargaManualIndicadorVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		this.setTitle("Carga manual de indicadores");

		panelPrincipal.setLayout(new VerticalLayout());
		Graficos.graficarDolares(panelPrincipal);
		Graficos.graficarEspacio(panelPrincipal, 460);
		
		Panel form1 = new Panel(panelPrincipal);
		form1.setLayout(new VerticalLayout());

		Panel panel1 = new Panel(form1);
		panel1.setLayout(new HorizontalLayout());

		new Label(panel1).setText("Nombre");
		new TextBox(panel1).setWidth(150).bindValueToProperty("nombre");

		Panel panel2 = new Panel(form1);
		panel2.setLayout(new HorizontalLayout());
		new Label(panel2).setText("Ingrese su formula =");
		new TextBox(panel2).setWidth(150).bindValueToProperty("formula");
		new Label(panel2).setText("Ej: (12+6)/2;");
		
		
		Table<Indicador> tablaCuentas = new Table<Indicador>(panelPrincipal, Indicador.class).setNumberVisibleRows(5);
		tablaCuentas.bindItemsToProperty("indicadores");
		
		new Column<Indicador>(tablaCuentas).setTitle("Codigo").setFixedSize(150).bindContentsToProperty("codigo");
		new Column<Indicador>(tablaCuentas).setTitle("Nombre").setFixedSize(100).bindContentsToProperty("nombre");

	}
	
	@Override
	protected void addActions(Panel botonera)
	{
		botonera.setLayout(new VerticalLayout());
		Panel panel= new Panel(botonera);
		panel.setLayout(new HorizontalLayout());
		
		new Button(panel).setCaption("Validar formula").onClick(this::validarFormula);
		new Label(botonera).setText("resultado:").setWidth(500).bindValueToProperty("resultado");
		new Button(panel).setCaption("Guardar").onClick(this::guardarIndicador);
		
		Graficos.graficarBorde(botonera, 460);
	}
	
	public void validarFormula() {
		this.getModelObject().validarFormula();
	}
	public void guardarIndicador() {
		this.getModelObject().guardarIndicador();
	}
}
