package presentacion.vistas.cuentas;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.FileSelector;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import presentacion.vm.cuentas.CargaMasivaCuentaVM;

@SuppressWarnings("serial")
public class CargaMasivaCuentaWindow extends Dialog<CargaMasivaCuentaVM>{
	
	public CargaMasivaCuentaWindow(WindowOwner owner) {
		super(owner, new CargaMasivaCuentaVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		setTitle("Carga masiva de cuentas");
		
		panelPrincipal.setLayout(new VerticalLayout());
		
		GroupPanel formDatos = new GroupPanel(panelPrincipal);
		formDatos.setTitle("Ruta de acceso del archivo:");
		formDatos.setLayout(new HorizontalLayout());
		
		new TextBox(formDatos).setWidth(250).bindValueToProperty("rutaDelArchivo");
		new FileSelector(formDatos).extensions("*.txt", "*xls", "*.xlsx").setCaption("Examinar").setWidth(75).bindValueToProperty("rutaDelArchivo");
		
		new RadioSelector<String>(panelPrincipal, "tiposArchivos").bindValueToProperty("tipoArchivoSeleccionado");
	}
	
	@Override
	protected void addActions(Panel actions) 
	{
		actions.setLayout(new VerticalLayout());
		
		Panel panel= new Panel(actions);
		panel.setLayout(new HorizontalLayout());
		
		new Button(panel).setCaption("Guardar").onClick(this::accept).setAsDefault();
		new Button(panel).setCaption("Cancelar").onClick(this::cancel);
	}
	
	
	@Override
	protected void executeTask()
	{
		getModelObject().cargarDatos();
		
		super.executeTask();
	}
}