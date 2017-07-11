package presentacion.vistas.indicadores;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import negocio.dominio.Indicador;
import presentacion.vm.indicadores.CargaIndicadorVM;


@SuppressWarnings("serial")
public class CargaIndicadorWindow  extends SimpleWindow<CargaIndicadorVM>
{
	public CargaIndicadorWindow(WindowOwner parent) 
	{
		super(parent, new CargaIndicadorVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		panelPrincipal.setLayout(new VerticalLayout());
		
		this.setTitle("Indicadores");
		
		GroupPanel formDatos = new GroupPanel(panelPrincipal);
		formDatos.setTitle("Agregar indicador");
		formDatos.setLayout(new ColumnLayout(2));
	
		new Label(formDatos).setText("(*) Nombre:");
		new TextBox(formDatos).setWidth(200).bindValueToProperty("nombreIndicador");
		
		new Label(formDatos).setText("(*) Expresion:");
		new TextBox(formDatos).setWidth(200).bindValueToProperty("expresionPlana");
		
		new Label(formDatos).setText("Campos obligatorios (*)").setFontSize(8);
		new Button(formDatos).setCaption("Guardar").onClick(this::guardar).setAsDefault(); 

		Table<Indicador> tablaIndicadores = new Table<>(panelPrincipal, Indicador.class).setNumberVisibleRows(10);
		tablaIndicadores.bindItemsToProperty("indicadores");
		
		new Column<>(tablaIndicadores).setTitle("Indicador").bindContentsToProperty("nombre");
		new Column<>(tablaIndicadores).setTitle("Expresion").bindContentsToProperty("formula");	
	}
	
	private void guardar()
	{
		getModelObject().guardarIndicador();
	}

	@Override
	protected void addActions(Panel actionsPanel) {}
}