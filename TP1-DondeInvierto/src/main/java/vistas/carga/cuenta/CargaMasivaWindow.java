package vistas.carga.cuenta;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import vm.carga.cuenta.CargaMasivaVM;

@SuppressWarnings("serial")
public class CargaMasivaWindow extends Dialog<CargaMasivaVM>{

	public CargaMasivaWindow(WindowOwner owner) {
		super(owner, new CargaMasivaVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		setTitle("Carga masiva de cuentas");
		
		panelPrincipal.setLayout(new VerticalLayout());
		
		GroupPanel formDatos = new GroupPanel(panelPrincipal);
		formDatos.setTitle("Ruta de acceso del archivo:");
		formDatos.setLayout(new HorizontalLayout());
		
		new TextBox(formDatos).setWidth(250);
		new Button(formDatos).setCaption("Examinar").setWidth(75);
		
		Panel panelVistaPrevia = new Panel(panelPrincipal);
		panelVistaPrevia.setLayout(new HorizontalLayout());
		new Button(panelVistaPrevia).setCaption("Vista Previa").setWidth(100);
	}
	
	@Override
	protected void addActions(Panel actions) 
	{
		new Button(actions).setCaption("Guardar").onClick(()->this.getModelObject().Procesar()).setAsDefault();
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}
	@Override
	protected void executeTask()
	{
		//getModelObject()
		
		super.executeTask();
	}
}
