package presentacion.vistas.cuentas.consulta;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import negocio.dominio.Cuenta;
import negocio.dominio.Empresa;
import negocio.dominio.Periodo;
import presentacion.vm.cuentas.consulta.ConsultaCuentaVM;

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
		Selector<Empresa> comboEmpresa = new Selector<Empresa>(panelFiltrado);
		comboEmpresa.setWidth(200);
		comboEmpresa.bindValueToProperty("empresaSeleccionada");
		comboEmpresa.bindItemsToProperty("empresas");
		
		new Label(panelFiltrado).setText("Periodo");
		Selector<Periodo> comboPeriodo = new Selector<Periodo>(panelFiltrado);
		comboPeriodo.setWidth(200);
		comboPeriodo.bindValueToProperty("periodoSeleccionado");
		comboPeriodo.bindItemsToProperty("empresaSeleccionada.periodos");
		
		Table<Cuenta> tablaCuentas = new Table<>(panelPrincipal, Cuenta.class).setNumberVisibleRows(5);
		tablaCuentas.bindItemsToProperty("periodoSeleccionado.cuentas");
		
		new Column<>(tablaCuentas).setTitle("Cuenta").bindContentsToProperty("nombre");
		
		new Column<>(tablaCuentas).setTitle("Valor").bindContentsToProperty("valor");	
	}

	@Override
	protected void addActions(Panel arg0) {
			
	}
}
