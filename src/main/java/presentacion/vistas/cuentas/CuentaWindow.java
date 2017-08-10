package presentacion.vistas.cuentas;



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
import org.uqbar.commons.model.ObservableUtils;

import negocio.dominio.Cuenta;
import negocio.dominio.Empresa;
import negocio.dominio.Periodo;
import presentacion.vm.cuentas.CuentaVM;

@SuppressWarnings("serial")
public class CuentaWindow extends SimpleWindow<CuentaVM>
{
	public CuentaWindow(WindowOwner parent) 
	{
		super(parent, new CuentaVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		panelPrincipal.setLayout(new VerticalLayout());
		this.setTitle("Cuentas");
		GroupPanel panelFiltrado = new GroupPanel(panelPrincipal);
		panelFiltrado.setTitle("Consultar");
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
	
	public void cargaMasiva()
	{
		new CargaMasivaCuentaWindow(this).open();
		ObservableUtils.firePropertyChanged(getModelObject(), "empresas");
	}
	
	public void cargaManual()
	{
		new CargaManualCuentaWindow(this).open();
		ObservableUtils.firePropertyChanged(getModelObject(), "empresas");
	}

	@Override
	protected void addActions(Panel actionsPanel) 
	{
		new Button(actionsPanel).setCaption("Carga Masiva").onClick(this::cargaMasiva);
		new Button(actionsPanel).setCaption("Carga Manual").onClick(this::cargaManual);
	}
}