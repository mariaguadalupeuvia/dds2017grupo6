package vistas.consulta.cuenta;

import org.uqbar.arena.layout.ColumnLayout;
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

import dominio.Cuenta;
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
		
		GroupPanel panelFiltrado = new GroupPanel(panelPrincipal);
		panelFiltrado.setTitle("Filtrar datos");
		panelFiltrado.setLayout(new ColumnLayout(2));
		
		new Label(panelFiltrado).setText("Empresa");
		Selector<Cuenta> comboEmpresa = new Selector<Cuenta>(panelFiltrado);
		comboEmpresa.bindValueToProperty("empresaSeleccionada");
		comboEmpresa.bindItemsToProperty("empresas");
		
		new Label(panelFiltrado).setText("Periodo");
		Selector<Cuenta> comboPeriodo = new Selector<Cuenta>(panelFiltrado);
		comboPeriodo.bindValueToProperty("periodoSeleccionado");
		comboPeriodo.bindItemsToProperty("periodos");
		
		new Label(panelFiltrado).setText("Cuenta");
		Selector<Cuenta> comboCuenta = new Selector<Cuenta>(panelFiltrado);
		comboCuenta.bindValueToProperty("nombreCuentaSeleccionada");
		comboCuenta.bindItemsToProperty("nombresCuentas");
		
		Table<Cuenta> tablaCuentas = new Table<Cuenta>(panelPrincipal, Cuenta.class).setNumberVisibleRows(5);
		tablaCuentas.bindItemsToProperty("cuentas");
		
		new Column<Cuenta>(tablaCuentas).setTitle("Empresa").setFixedSize(150).bindContentsToProperty("empresa");
		new Column<Cuenta>(tablaCuentas).setTitle("Periodo").setFixedSize(100).bindContentsToProperty("periodo");
		new Column<Cuenta>(tablaCuentas).setTitle("Cuenta").setFixedSize(100).bindContentsToProperty("nombreCuenta");
		new Column<Cuenta>(tablaCuentas).setTitle("Valor").setFixedSize(80).bindContentsToProperty("valor");	
	}
	
	@Override
	protected void addActions(Panel actions) 
	{
		new Button(actions).setCaption("Consultar").onClick(this::consultar);
	}
	
	public void consultar() 
	{
		getModelObject().consultar();
	}
}
