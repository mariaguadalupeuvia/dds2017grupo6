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
import dominio.Empresa;
import dominio.Periodo;
import dominio.datos.EstructuraEsperada;
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
		
		GroupPanel panelFiltrado = new GroupPanel(panelPrincipal);
		panelFiltrado.setTitle("Filtrar datos");
		panelFiltrado.setLayout(new ColumnLayout(2));
		
		new Label(panelFiltrado).setText("Empresa");
		Selector<Empresa> comboEmpresa = new Selector<Empresa>(panelFiltrado);
		comboEmpresa.bindItemsToProperty("empresas");
		
		new Label(panelFiltrado).setText("Periodo");
		Selector<Periodo> comboPeriodo = new Selector<Periodo>(panelFiltrado);
		comboPeriodo.bindItemsToProperty("periodos");
		
		new Label(panelFiltrado).setText("Cuenta");
		Selector<Cuenta> comboCuenta = new Selector<Cuenta>(panelFiltrado);
		comboCuenta.bindItemsToProperty("nombresCuentas");
		
		Table<EstructuraEsperada> tablaCuentas = new Table<EstructuraEsperada>(panelPrincipal, EstructuraEsperada.class);
		
		tablaCuentas.setNumberVisibleRows(5);
		tablaCuentas.bindItemsToProperty("registros");
		
		new Column<EstructuraEsperada>(tablaCuentas).setTitle("Empresa").setFixedSize(150).bindContentsToProperty("empresa");
		new Column<EstructuraEsperada>(tablaCuentas).setTitle("Periodo").setFixedSize(100).bindContentsToProperty("periodo");
		new Column<EstructuraEsperada>(tablaCuentas).setTitle("Cuenta").setFixedSize(100).bindContentsToProperty("nombreCuenta");
		new Column<EstructuraEsperada>(tablaCuentas).setTitle("Valor").setFixedSize(80).bindContentsToProperty("valorCuenta");
//		new Column<CuentaEmpresa>(tablaCuentas).setTitle("Empresa").setFixedSize(150).bindContentsToProperty("empresa");
//		new Column<CuentaEmpresa>(tablaCuentas).setTitle("Periodo").setFixedSize(100).bindContentsToProperty("periodo");
//		new Column<CuentaEmpresa>(tablaCuentas).setTitle("Cuenta").setFixedSize(100).bindContentsToProperty("cuenta");
//		new Column<CuentaEmpresa>(tablaCuentas).setTitle("Valor").setFixedSize(80).bindContentsToProperty("valor");
		
	}
	
	@Override
	protected void addActions(Panel actions) 
	{
		new Button(actions).setCaption("Consultar").onClick(this::consultar);
		Graficos.graficarBorde(actions, 340);
	}
	
	public void consultar() {}
}
