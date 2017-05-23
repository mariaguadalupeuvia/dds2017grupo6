package presentacion.vistas.carga.cuenta;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import presentacion.vm.carga.cuenta.CargaManualVM;

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
		new TextBox(formDatos).bindValueToProperty("nombreEmpresa");
		
		new Label(formDatos).setText("Periodo:");
		new NumericField(formDatos).bindValueToProperty("a�oPeriodo");
		
		new Label(formDatos).setText("Cuenta:");
		new TextBox(formDatos).bindValueToProperty("nombreCuenta");
		
		new Label(formDatos).setText("Valor:");
		new NumericField(formDatos).bindValueToProperty("valorCuenta");
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
		getModelObject().guardarEmpresa();
		
		super.executeTask();
	}
}
