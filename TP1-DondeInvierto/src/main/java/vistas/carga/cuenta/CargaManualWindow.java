package vistas.carga.cuenta;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import dominio.Cuenta;
import vm.carga.cuenta.CargaManualVM;

@SuppressWarnings("serial")
public class CargaManualWindow extends Dialog<CargaManualVM>
{
	public CargaManualWindow(WindowOwner owner) 
	{
		super(owner, new CargaManualVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		setTitle("Carga manual de cuentas");
		
		panelPrincipal.setLayout(new VerticalLayout());
		
		GroupPanel formDatos = new GroupPanel(panelPrincipal);
		formDatos.setTitle("Datos de la cuenta");
		formDatos.setLayout(new ColumnLayout(2));
	
		new Label(formDatos).setText("Empresa:");
		Selector<Cuenta> comboEmpresa = new Selector<Cuenta>(formDatos);
		comboEmpresa.bindValueToProperty("empresaSeleccionada");
		comboEmpresa.bindItemsToProperty("empresas");
		
		new Label(formDatos).setText("Periodo:");
		Selector<Cuenta> comboPeriodo = new Selector<Cuenta>(formDatos);
		comboPeriodo.bindValueToProperty("periodoSeleccionado");
		comboPeriodo.bindItemsToProperty("periodos");
		
		new Label(formDatos).setText("Cuenta:");
		Selector<Cuenta> comboCuenta = new Selector<Cuenta>(formDatos);
		comboCuenta.bindValueToProperty("nombreCuentaSeleccionada");
		comboCuenta.bindItemsToProperty("nombresCuentas");
		
		new Label(formDatos).setText("Valor:");
		new NumericField(formDatos).setWidth(100).bindValueToProperty("valor");
	}
	
	@Override
	protected void addActions(Panel actions) 
	{
		new Button(actions).setCaption("Guardar").onClick(this::accept).setAsDefault();
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}
	
	@Override
	protected void executeTask()
	{
		getModelObject().guardarCuenta();
		
		super.executeTask();
	}
}
