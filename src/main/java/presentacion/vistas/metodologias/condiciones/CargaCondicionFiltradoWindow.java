package presentacion.vistas.metodologias.condiciones;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import negocio.dominio.Indicador;
import negocio.dominio.condiciones.criterios.filtrado.CriterioFiltrado;
import presentacion.vm.metodologias.CargaMetodologiaVM;
import presentacion.vm.metodologias.condiciones.CargaCondicionFiltradoVM;

@SuppressWarnings("serial")
public class CargaCondicionFiltradoWindow extends Dialog<CargaCondicionFiltradoVM> {

	private CargaMetodologiaVM cargaMetodologiaVM;
	
	public CargaCondicionFiltradoWindow(WindowOwner owner, CargaMetodologiaVM cargaMetodologiaVM)
	{
		super(owner, new CargaCondicionFiltradoVM());
		
		this.cargaMetodologiaVM = cargaMetodologiaVM;
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		
		GroupPanel panelCondiciones = new GroupPanel(mainPanel);
		panelCondiciones.setTitle("Agregar condiciones");
		panelCondiciones.setLayout(new ColumnLayout(2));
		
		new Label(panelCondiciones).setText("(*) Indicador:");
		Selector<Indicador> comboIndicador = new Selector<Indicador>(panelCondiciones);
		comboIndicador.setWidth(200);
		comboIndicador.bindValueToProperty("indicadorSeleccionado");
		comboIndicador.bindItemsToProperty("indicadores");
		
		new Label(panelCondiciones).setText("(*) Criterio:");
		Selector<CriterioFiltrado> comboCriterio = new Selector<CriterioFiltrado>(panelCondiciones);
		comboCriterio.setWidth(200);
		comboCriterio.bindValueToProperty("criterioFiltradoSeleccionado");
		comboCriterio.bindItemsToProperty("criteriosFiltrado");
				
		new Label(panelCondiciones).setText("(*) Valor:");
		new NumericField(panelCondiciones).setWidth(200).bindValueToProperty("valor");
		
		new Label(panelCondiciones).setText("(*) Ultimos N periodos a aplicar:");
		new NumericField(panelCondiciones).setWidth(200).bindValueToProperty("cantidadPeriodos");
	}
	
	@Override
	protected void addActions(Panel actions) 
	{
		new Button(actions).setCaption("Agregar").onClick(this::accept).setAsDefault();
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}
	
	@Override
	protected void executeTask()
	{
		cargaMetodologiaVM.agregarCondicionFiltrado(getModelObject().agregarCondicionFiltrado());
		
		super.executeTask();
	}
}