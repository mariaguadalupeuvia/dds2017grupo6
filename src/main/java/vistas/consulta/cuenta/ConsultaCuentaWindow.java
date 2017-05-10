package vistas.consulta.cuenta;

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
import utils.Graficos;
import vm.consulta.cuenta.ConsultaCuentaVM;

@SuppressWarnings("serial")
public class ConsultaCuentaWindow extends SimpleWindow<ConsultaCuentaVM> 
{
	public ConsultaCuentaWindow(WindowOwner owner) 
	{
		super(owner, new ConsultaCuentaVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		setTitle("Consulta de cuentas");
		panelPrincipal.setLayout(new VerticalLayout());
		Graficos.graficarDolares(panelPrincipal);
		Graficos.graficarEspacio(panelPrincipal, 400);
		
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
		
		new Label(panelFiltrado).setText("Cuenta");
		Selector<CuentaEmpresaPeriodo> comboCuenta = new Selector<CuentaEmpresaPeriodo>(panelFiltrado);
		comboCuenta.bindValueToProperty("nombreCuentaSeleccionada");
		comboCuenta.bindItemsToProperty("nombresCuentas");
		
		Table<CuentaEmpresaPeriodo> tablaCuentas = new Table<CuentaEmpresaPeriodo>(panelPrincipal, CuentaEmpresaPeriodo.class).setNumberVisibleRows(5);
		tablaCuentas.bindItemsToProperty("cuentas");
		
		new Column<CuentaEmpresaPeriodo>(tablaCuentas).setTitle("Empresa").setFixedSize(150).bindContentsToProperty("empresa");
		new Column<CuentaEmpresaPeriodo>(tablaCuentas).setTitle("Periodo").setFixedSize(100).bindContentsToProperty("periodo");
		new Column<CuentaEmpresaPeriodo>(tablaCuentas).setTitle("Cuenta").setFixedSize(100).bindContentsToProperty("nombreCuenta");
		new Column<CuentaEmpresaPeriodo>(tablaCuentas).setTitle("Valor").setFixedSize(80).bindContentsToProperty("valor");	
	}
	
	@Override
	protected void addActions(Panel botonera) 
	{
		botonera.setLayout(new VerticalLayout());
		Panel panel= new Panel(botonera);
		panel.setLayout(new HorizontalLayout());
		new Button(panel).setCaption("Consultar").onClick(this::consultar);
		Graficos.graficarBorde(botonera, 400);	
	}
	
	public void consultar() 
	{
		getModelObject().consultar();
	}
}
