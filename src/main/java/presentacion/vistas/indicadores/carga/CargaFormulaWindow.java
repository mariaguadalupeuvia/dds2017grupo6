package presentacion.vistas.indicadores.carga;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import presentacion.vm.indicadores.carga.CargaFormulaVM;

@SuppressWarnings("serial")
public class CargaFormulaWindow extends Dialog<CargaFormulaVM>
{
	public CargaFormulaWindow(WindowOwner owner) 
	{
		super(owner, new CargaFormulaVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		setTitle("Carga de formulas");
		
		panelPrincipal.setLayout(new VerticalLayout());
		
		GroupPanel formDatos = new GroupPanel(panelPrincipal);
		formDatos.setTitle("Datos de la formula");
		formDatos.setLayout(new ColumnLayout(2));
	
		new Label(formDatos).setText("Nombre:");
		new TextBox(formDatos).setWidth(200).bindValueToProperty("nombreFormula");
		
		new Label(formDatos).setText("Expresion:");
		new TextBox(formDatos).setWidth(200).bindValueToProperty("expresion");
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
		getModelObject().guardarFormula();
		
		super.executeTask();
	}
}