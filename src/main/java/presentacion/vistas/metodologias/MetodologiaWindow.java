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
import negocio.dominio.evaluacionEmpresas.EmpresaNoFiltrada;
import negocio.dominio.evaluacionEmpresas.ParEmpresasNoComparadas;
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
		new Label(panelPrincipal).setText("");
		
		
		Panel panelEvaluadas = new Panel(panelPrincipal);
		panelEvaluadas.setLayout(new HorizontalLayout());
		new Label(panelEvaluadas).setText("Empresas correctamente evaluadas");
		Table<Empresa> tablaEmpresasEvaluadas = new Table<>(panelPrincipal, Empresa.class).setNumberVisibleRows(5);
		tablaEmpresasEvaluadas.bindItemsToProperty("empresasEvaluadas");
		new Column<>(tablaEmpresasEvaluadas).setTitle("Se puede invertir en").bindContentsToProperty("nombre");
		new Label(panelPrincipal).setText("");
		
		
		Panel panelnf = new Panel(panelPrincipal);
		panelnf.setLayout(new HorizontalLayout());
		new Label(panelnf).setText("Empresas no filtradas");
		Table<EmpresaNoFiltrada> tablaEmpresasNoFiltradas = new Table<>(panelPrincipal, EmpresaNoFiltrada.class).setNumberVisibleRows(5);
		tablaEmpresasNoFiltradas.bindItemsToProperty("empresasNoFiltradas");
		new Column<>(tablaEmpresasNoFiltradas).setTitle("Nombre empresa:").bindContentsToProperty("empresa.nombre");
		new Column<>(tablaEmpresasNoFiltradas).setTitle("Motivo:").bindContentsToProperty("motivo");
		
		Panel panelnc = new Panel(panelPrincipal);
		panelnc.setLayout(new HorizontalLayout());
		new Label(panelnc).setText("Empresas no comparadas");
		Table<ParEmpresasNoComparadas> tablaEmpresasNoComparadas = new Table<>(panelPrincipal, ParEmpresasNoComparadas.class).setNumberVisibleRows(5);
		tablaEmpresasNoComparadas.bindItemsToProperty("empresasNoComparadas");
		new Column<>(tablaEmpresasNoComparadas).setTitle("Nombre empresa 1:").bindContentsToProperty("unaEmpresa.nombre");
		new Column<>(tablaEmpresasNoComparadas).setTitle("Nombre empresa 2:").bindContentsToProperty("otraEmpresa.nombre");
		new Column<>(tablaEmpresasNoComparadas).setTitle("Motivo:").bindContentsToProperty("motivo");
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