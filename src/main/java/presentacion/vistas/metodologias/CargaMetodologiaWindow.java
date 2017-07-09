package presentacion.vistas.metodologias;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import negocio.dominio.Indicador;
import negocio.dominio.condiciones.Condicion;
import negocio.dominio.condiciones.criterios.Criterio;
import presentacion.vm.metodologias.CargaMetodologiaVM;


@SuppressWarnings("serial")
public class CargaMetodologiaWindow extends Dialog<CargaMetodologiaVM> 
{
	public CargaMetodologiaWindow(WindowOwner parent) 
	{
		super(parent, new CargaMetodologiaVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		setTitle("Metodologias");
		
		panelPrincipal.setLayout(new VerticalLayout());
		
		GroupPanel panelMetodologia = new GroupPanel(panelPrincipal);
		panelMetodologia.setTitle("Agregar metodologia");
		panelMetodologia.setLayout(new VerticalLayout());
		
		Panel panelNombre = new Panel(panelMetodologia);
		panelNombre.setLayout(new ColumnLayout(2));
		new Label(panelNombre).setText("(*) Nombre:");
		new TextBox(panelNombre).setWidth(200).bindValueToProperty("nombreMetodologia");
		
		GroupPanel panelCondiciones = new GroupPanel(panelMetodologia);
		panelCondiciones.setTitle(" Agregar condiciones");
		panelCondiciones.setLayout(new ColumnLayout(2));
		
		new Label(panelCondiciones).setText("(*) Indicador:");
		Selector<Indicador> comboIndicador = new Selector<Indicador>(panelCondiciones);
		comboIndicador.setWidth(200);
		comboIndicador.bindValueToProperty("indicadorSeleccionado");
		comboIndicador.bindItemsToProperty("indicadores");
		
		new Label(panelCondiciones).setText("(*) Criterio:");
		Selector<Criterio> comboCriterio = new Selector<Criterio>(panelCondiciones);
		comboCriterio.setWidth(200);
		comboCriterio.bindValueToProperty("criterioSeleccionado");
		comboCriterio.bindItemsToProperty("criterios");
				
		new Label(panelCondiciones).setText("Valor:");
		new NumericField(panelCondiciones).setWidth(200).bindValueToProperty("valor");
		
		new Label(panelCondiciones).setText("(*) Ultimos N periodos a aplicar:");
		new NumericField(panelCondiciones).setWidth(200).bindValueToProperty("cantidadPeriodos");
		
		new Label(panelCondiciones).setText("Prioridad de orden:");
		new NumericField(panelCondiciones).setWidth(200).bindValueToProperty("prioridad");
		
		new Button(panelCondiciones).setCaption("Agregar").onClick(() -> this.getModelObject().agregarCondicion()); 
	
		Table<Condicion> tablaCondiciones = new Table<>(panelPrincipal, Condicion.class).setNumberVisibleRows(5);
		tablaCondiciones.bindItemsToProperty("condiciones");
		new Column<>(tablaCondiciones).setTitle("Criterio").bindContentsToProperty("criterio");
		new Column<>(tablaCondiciones).setTitle("Indicador Que Utiliza").bindContentsToProperty("indicador");
		new Column<>(tablaCondiciones).setTitle("Valor").bindContentsToProperty("valor");
		new Column<>(tablaCondiciones).setTitle("Cantidad de periodos que aplica").bindContentsToProperty("cantidadPeriodos");
		new Column<>(tablaCondiciones).setTitle("Prioridad").bindContentsToProperty("prioridad");
		
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
		getModelObject().guardarMetodologia();
		
		super.executeTask();
	}
}
