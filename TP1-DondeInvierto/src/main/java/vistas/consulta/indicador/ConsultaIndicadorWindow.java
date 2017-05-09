package vistas.consulta.indicador;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import dominio.CuentaEmpresaPeriodo;
import dominio.Indicador;
import utils.Graficos;
import vm.consulta.indicador.ConsultaIndicadorVM;

@SuppressWarnings("serial")
public class ConsultaIndicadorWindow extends SimpleWindow<ConsultaIndicadorVM> 
{
	public ConsultaIndicadorWindow(WindowOwner owner) 
	{
		super(owner, new ConsultaIndicadorVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		setTitle("Consulta de indicadores");
		panelPrincipal.setLayout(new VerticalLayout());
		Graficos.graficarDolares(panelPrincipal);
		Graficos.graficarEspacio(panelPrincipal,340);
		GroupPanel panelFiltrado = new GroupPanel(panelPrincipal);
		panelFiltrado.setTitle("Filtrar datos");
		panelFiltrado.setLayout(new ColumnLayout(2));
		
		new Label(panelFiltrado).setText("Empresa");
		Selector<CuentaEmpresaPeriodo> comboEmpresa = new Selector<CuentaEmpresaPeriodo>(panelFiltrado);
		comboEmpresa.bindValueToProperty("empresaSeleccionada");
		comboEmpresa.bindItemsToProperty("empresas");
		
		new Label(panelFiltrado).setText("Periodo");
		Selector<CuentaEmpresaPeriodo> comboPeriodo = new Selector<CuentaEmpresaPeriodo>(panelFiltrado);
		comboPeriodo.bindValueToProperty("periodoSeleccionado");
		comboPeriodo.bindItemsToProperty("periodos");
		
		new Label(panelFiltrado).setText("Indicador");
		Selector<Indicador> comboCuenta = new Selector<Indicador>(panelFiltrado);
		comboCuenta.bindValueToProperty("nombreIndicadorSeleccionado");
		comboCuenta.bindItemsToProperty("nombresIndicadores");
		
		Table<Indicador> tablaIndicadores = new Table<Indicador>(panelPrincipal, Indicador.class).setNumberVisibleRows(5);
		tablaIndicadores.bindItemsToProperty("indicadores");
		
		new Column<Indicador>(tablaIndicadores).setTitle("Cod.").setFixedSize(150).bindContentsToProperty("codigo");
		new Column<Indicador>(tablaIndicadores).setTitle("Indicador").setFixedSize(100).bindContentsToProperty("nombre");
		new Column<Indicador>(tablaIndicadores).setTitle("Valor").setFixedSize(80).bindContentsToProperty("valor");	
	}
	
	@Override
	protected void addActions(Panel botonera) 
	{
		botonera.setLayout(new VerticalLayout());
		Panel panel= new Panel(botonera);
		panel.setLayout(new HorizontalLayout());
		new Button(panel).setCaption("Consultar").onClick(this::consultar);
		Graficos.graficarBorde(botonera, 340);
	}
	
	public void consultar() 
	{
		getModelObject().consultar();
	}
}
