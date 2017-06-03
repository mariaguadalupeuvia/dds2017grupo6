package presentacion.vistas.indicadores.consulta;

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


import negocio.dominio.Formula;
import presentacion.vm.indicadores.consulta.ConsultaFormulaVM;

@SuppressWarnings("serial")
public class ConsultaFormulaWindow extends SimpleWindow<ConsultaFormulaVM> 
{
	public ConsultaFormulaWindow(WindowOwner owner) 
	{
		super(owner, new ConsultaFormulaVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		setTitle("Consulta de Formulas");
		panelPrincipal.setLayout(new VerticalLayout());
		
		GroupPanel panelFiltrado = new GroupPanel(panelPrincipal);
		panelFiltrado.setTitle("Filtrar datos");
		panelFiltrado.setLayout(new ColumnLayout(2));
		
		new Label(panelFiltrado).setText("Formula");
		Selector<Formula> comboFormula = new Selector<Formula>(panelFiltrado);
		comboFormula.setWidth(200);
		comboFormula.bindValueToProperty("formulaSeleccionada");
		comboFormula.bindItemsToProperty("formulas");
		comboFormula.onSelection(this::filtrar);
		
		
		Table<Formula> tablaFormulas = new Table<>(panelPrincipal, Formula.class).setNumberVisibleRows(5);
		tablaFormulas.bindItemsToProperty("formulas");
		

		new Column<>(tablaFormulas).setTitle("Nombre").bindContentsToProperty("nombre");
		
		new Column<>(tablaFormulas).setTitle("Expresion").bindContentsToProperty("expresion");	
	}

	@Override
	protected void addActions(Panel arg0) {
			
	}
	
	public void filtrar()
	{
		getModelObject().filtrarFormulas();
	}
}