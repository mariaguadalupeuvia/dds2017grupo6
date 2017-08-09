package presentacion.vistas.metodologias;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import negocio.dominio.condiciones.CondicionFiltrado;
import negocio.dominio.condiciones.CondicionOrdenamiento;
import presentacion.vistas.metodologias.condiciones.CargaCondicionFiltradoWindow;
import presentacion.vistas.metodologias.condiciones.CargaCondicionOrdenamientoWindow;
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
		
		GroupPanel panelMetodologia = new GroupPanel(panelPrincipal);
		panelMetodologia.setTitle("Agregar metodologia");
		
		Panel panelNombre = new Panel(panelMetodologia);
		panelNombre.setLayout(new ColumnLayout(2));
		
		new Label(panelNombre).setText("(*) Nombre:");
		new TextBox(panelNombre).setWidth(200).bindValueToProperty("nombreMetodologia");
		
		
		//CONDICIONES
		GroupPanel panelCondiciones = new GroupPanel(panelMetodologia);
		panelCondiciones.setTitle("Agregar condiciones");
		
		Panel panelBotonFiltro = new Panel(panelCondiciones);
		panelBotonFiltro.setLayout(new HorizontalLayout());
		new Button(panelBotonFiltro).setCaption("Condicion de filtrado").onClick(() -> new CargaCondicionFiltradoWindow(this, getModelObject()).open());
	
		Table<CondicionFiltrado> tablaCondFiltro = new Table<>(panelCondiciones, CondicionFiltrado.class).setNumberVisibleRows(5);
		tablaCondFiltro.bindItemsToProperty("condicionesFiltrado");
		new Column<>(tablaCondFiltro).setTitle("Criterio").bindContentsToProperty("criterioFiltrado");
		new Column<>(tablaCondFiltro).setTitle("Indicador Que Utiliza").bindContentsToProperty("indicador");
		new Column<>(tablaCondFiltro).setTitle("Valor").bindContentsToProperty("valor");
		new Column<>(tablaCondFiltro).setTitle("Cantidad de periodos que aplica").bindContentsToProperty("cantidadPeriodos");
		
		
		Panel panelBotonOrdenamiento = new Panel(panelCondiciones);
		panelBotonOrdenamiento.setLayout(new HorizontalLayout());
		new Button(panelBotonOrdenamiento).setCaption("Condicion de ordenamiento").onClick(() -> new CargaCondicionOrdenamientoWindow(this, getModelObject()).open());
		
		Table<CondicionOrdenamiento> tablaCondOrdenamiento = new Table<>(panelCondiciones, CondicionOrdenamiento.class).setNumberVisibleRows(5);
		tablaCondOrdenamiento.bindItemsToProperty("condicionesOrdenamiento");
		new Column<>(tablaCondOrdenamiento).setTitle("Criterio").bindContentsToProperty("criterioOrdenamiento");
		new Column<>(tablaCondOrdenamiento).setTitle("Indicador Que Utiliza").bindContentsToProperty("indicador");
		new Column<>(tablaCondOrdenamiento).setTitle("Cantidad de periodos que aplica").bindContentsToProperty("cantidadPeriodos");
		new Column<>(tablaCondOrdenamiento).setTitle("Prioridad").bindContentsToProperty("prioridad");	
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