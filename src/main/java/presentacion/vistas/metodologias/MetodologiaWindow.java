package presentacion.vistas.metodologias;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
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
		panelPrincipal.setLayout(new VerticalLayout());
		
		setTitle("Metodologias");
		GroupPanel panelFiltrado = new GroupPanel(panelPrincipal);
		panelFiltrado.setTitle("Aplicar");
		panelFiltrado.setLayout(new ColumnLayout(2));
		
		new Label(panelFiltrado).setText("Metodologia");
		Selector<Metodologia> comboMetodologia = new Selector<Metodologia>(panelFiltrado);
		comboMetodologia.setWidth(200);
		comboMetodologia.bindValueToProperty("metodologiaSeleccionada");
		comboMetodologia.bindItemsToProperty("metodologias");
		
		new Button(panelFiltrado).setCaption("Aplicar").onClick(this::aplicarMetodologia);
		
		Table<Empresa> tablaEmpresasEvaluadas = new Table<>(panelPrincipal, Empresa.class).setNumberVisibleRows(5);
		tablaEmpresasEvaluadas.bindItemsToProperty("empresasEvaluadas");
		
		new Column<>(tablaEmpresasEvaluadas).setTitle("Se puede invertir en").bindContentsToProperty("nombre");

	}
	
	@Override
	protected void addActions(Panel botonera) 
	{
		new Button(botonera).setCaption("Agregar metodologia").onClick(() -> new CargaMetodologiaWindow(this).open());
		
		ObservableUtils.firePropertyChanged(getModelObject(), "metodologias");
	}
	
	private void aplicarMetodologia() 
	{	
		getModelObject().aplicarMetodologia();	
	}
}