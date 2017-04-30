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
		form1.setLayout(new HorizontalLayout());

		new Label(form1).setText("Ingrese su formula =");
		new TextBox(form1).setWidth(150).bindValueToProperty("formula");

	}

	public void validarFormula() {
		this.getModelObject().validarFormula();
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("Validar formula").onClick(this::validarFormula);
	}
}