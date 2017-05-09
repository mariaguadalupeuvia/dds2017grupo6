package vistas.carga.cuenta;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.FileSelector;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import utils.Graficos;
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
		Graficos.graficarDolares(panelPrincipal);
		Graficos.graficarEspacio(panelPrincipal, 340);
		
		GroupPanel formDatos = new GroupPanel(panelPrincipal);
		formDatos.setTitle("Ruta de acceso del archivo:");
		formDatos.setLayout(new HorizontalLayout());
		
		new TextBox(formDatos).setWidth(250).bindValueToProperty("rutaDelArchivo");
		new FileSelector(formDatos)
		.extensions("*.txt","*.xls")
		.setCaption("Examinar")
		.setWidth(75)
		.bindValueToProperty("rutaDelArchivo");
	}
	
	@Override
	protected void addActions(Panel botonera) 
	{
		botonera.setLayout(new VerticalLayout());
		
		Panel panel= new Panel(botonera);
		panel.setLayout(new HorizontalLayout());
		
		new Button(panel).setCaption("Guardar").onClick(this::accept).setAsDefault();
		new Button(panel).setCaption("Cancelar").onClick(this::cancel);
		Graficos.graficarBorde(botonera, 340);
	}
	@Override
	protected void executeTask()
	{
		getModelObject().cargarDatos();
		
		super.executeTask();
	}
}
