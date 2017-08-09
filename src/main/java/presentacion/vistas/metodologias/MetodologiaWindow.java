package presentacion.vistas.metodologias;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.ObservableUtils;

import negocio.dominio.Empresa;
import negocio.dominio.Metodologia;
import presentacion.vm.metodologias.MetodologiaVM;

@SuppressWarnings("serial")
public class MetodologiaWindow extends SimpleWindow<MetodologiaVM>
{
	public MetodologiaWindow(WindowOwner parent) 
	{
		super(parent, new MetodologiaVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		setTitle("Metodologias");
		
		GroupPanel panelOpciones = new GroupPanel(panelPrincipal);
		panelOpciones.setTitle("Opciones");
		Panel panelLabels = new Panel(panelOpciones);
		panelLabels.setLayout(new HorizontalLayout());
		new Label(panelLabels).setText("Seleccione una metodologia:              ");
		Selector<Metodologia> comboMetodologia = new Selector<Metodologia>(panelLabels);
		comboMetodologia.setWidth(200);
		comboMetodologia.bindValueToProperty("metodologiaSeleccionada");
		comboMetodologia.bindItemsToProperty("metodologias");
		Panel panelBotones = new Panel(panelOpciones);
		panelBotones.setLayout(new HorizontalLayout());
		new Button(panelBotones).setCaption("Aplicar").onClick(this::aplicarMetodologia).setWidth(90);
		new Button(panelBotones).setCaption("Agregar metodologia").onClick(this::agregarMetodologia).setWidth(200);
		
		
		Table<Empresa> tablaEmpresasEvaluadas = new Table<>(panelPrincipal, Empresa.class).setNumberVisibleRows(5);
		tablaEmpresasEvaluadas.bindItemsToProperty("empresasEvaluadas");
		new Column<>(tablaEmpresasEvaluadas).setTitle("Se puede invertir en").bindContentsToProperty("nombre");
		
		Table<EmpresaNoEvaluada> tablaEmpresasNoEvaluadas = new Table<>(panelPrincipal, EmpresaNoEvaluada.class).setNumberVisibleRows(5);
		tablaEmpresasNoEvaluadas.bindItemsToProperty("empresasNoEvaluadas");
		new Column<>(tablaEmpresasNoEvaluadas).setTitle("Nombre empresa:").bindContentsToProperty("empresa.nombre");
		new Column<>(tablaEmpresasNoEvaluadas).setTitle("Motivo:").bindContentsToProperty("motivo");
	}
	
	@Override
	protected void addActions(Panel botonera) { }
	
	private void aplicarMetodologia() 
	{	
		getModelObject().aplicarMetodologia();	
	}
	
	private void agregarMetodologia()
	{
		new CargaMetodologiaWindow(this).open();
		
		ObservableUtils.firePropertyChanged(getModelObject(), "metodologias");
	}
}