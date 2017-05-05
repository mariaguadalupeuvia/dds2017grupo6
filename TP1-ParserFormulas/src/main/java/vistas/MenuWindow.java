package vistas;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import vm.Formula;

@SuppressWarnings("serial")
public class MenuWindow extends SimpleWindow<Formula> {

	public MenuWindow(WindowOwner parent) {
		super(parent, new Formula());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) {
		this.setTitle("Formulas");

		panelPrincipal.setLayout(new VerticalLayout());

		Panel form1 = new Panel(panelPrincipal);
		form1.setLayout(new VerticalLayout());

		Panel panel1 = new Panel(form1);
		panel1.setLayout(new HorizontalLayout());
		
		new Label(panel1).setText("Nombre");
		new TextBox(panel1).setWidth(150).bindValueToProperty("nombre");
		
		Panel panel2 = new Panel(form1);
		panel2.setLayout(new HorizontalLayout());
		new Label(panel2).setText("Ingrese su formula =");
		new TextBox(panel2).setWidth(150).bindValueToProperty("formula");
		new Label(panel2).setText("Ej: (12+6)/2;");

	}

	public void validarFormula() {
		this.getModelObject().validarFormula();
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("Validar formula").onClick(this::validarFormula);
		new Label(actionsPanel).setText("resultado:").bindValueToProperty("resultado");

	}
}