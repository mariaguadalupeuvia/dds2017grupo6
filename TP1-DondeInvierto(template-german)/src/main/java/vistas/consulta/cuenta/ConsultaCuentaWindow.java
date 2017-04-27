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
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import dominio.Cuenta;
import dominio.CuentaEmpresa;
import dominio.Empresa;
import dominio.Periodo;
import vm.consulta.cuenta.ConsultaCuentaVM;

@SuppressWarnings("serial")
public class ConsultaCuentaWindow extends SimpleWindow<ConsultaCuentaVM> {

	public ConsultaCuentaWindow(WindowOwner owner) {
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
		Selector<Empresa> comboEmpresa = new Selector<Empresa>(panelFiltrado);
		
		new Label(panelFiltrado).setText("Periodo");
		Selector<Periodo> comboPeriodo = new Selector<Periodo>(panelFiltrado);
		
		new Label(panelFiltrado).setText("Cuenta");
		Selector<Cuenta> comboCuenta = new Selector<Cuenta>(panelFiltrado);
		
		
		Table<CuentaEmpresa> tablaCuentas = new Table<CuentaEmpresa>(panelPrincipal, CuentaEmpresa.class);
		
		tablaCuentas.setNumberVisibleRows(5);
		//tablaNotas.bindItemsToProperty("asignacionSeleccionada.notas");
		new Column<CuentaEmpresa>(tablaCuentas).setTitle("Empresa").setFixedSize(150);
		new Column<CuentaEmpresa>(tablaCuentas).setTitle("Periodo").setFixedSize(100);
		new Column<CuentaEmpresa>(tablaCuentas).setTitle("Cuenta").setFixedSize(100);
		new Column<CuentaEmpresa>(tablaCuentas).setTitle("Valor").setFixedSize(80);
	}
	
	@Override
	protected void addActions(Panel actions) 
	{
		new Button(actions).setCaption("Consultar").onClick(this::consultar);
	}
	
	public void consultar() {}
}
