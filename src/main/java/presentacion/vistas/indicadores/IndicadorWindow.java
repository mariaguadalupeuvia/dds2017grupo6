package presentacion.vistas.indicadores;

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

import negocio.dominio.Empresa;
import negocio.dominio.Periodo;
import presentacion.vm.indicadores.IndicadorEvaluado;
import presentacion.vm.indicadores.IndicadorNoEvaluado;
import presentacion.vm.indicadores.IndicadorVM;

@SuppressWarnings("serial")
public class IndicadorWindow extends SimpleWindow<IndicadorVM>
{
	public IndicadorWindow(WindowOwner parent) 
	{
		super(parent, new IndicadorVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		panelPrincipal.setLayout(new VerticalLayout());
		
		this.setTitle("Indicadores");
		
		GroupPanel panelFiltrado = new GroupPanel(panelPrincipal);
		panelFiltrado.setTitle("Consultar");
		panelFiltrado.setLayout(new ColumnLayout(2));
		
		new Label(panelFiltrado).setText("Empresa");
		Selector<Empresa> comboEmpresa = new Selector<Empresa>(panelFiltrado);
		comboEmpresa.setWidth(200);
		comboEmpresa.bindValueToProperty("empresaSeleccionada");
		comboEmpresa.bindItemsToProperty("empresas");
		
		new Label(panelFiltrado).setText("Periodo");
		Selector<Periodo> comboPeriodo = new Selector<Periodo>(panelFiltrado);
		comboPeriodo.setWidth(200);
		comboPeriodo.bindValueToProperty("periodoSeleccionado");
		comboPeriodo.bindItemsToProperty("empresaSeleccionada.periodos");
		
		Panel botonera = new Panel(panelPrincipal);
		new Button(botonera).setCaption("Calcular Indicadores").onClick(this::calcularIndicadores);
		
		Table<IndicadorEvaluado> tablaIndicadoresEvaluados = new Table<>(panelPrincipal, IndicadorEvaluado.class).setNumberVisibleRows(5);
		tablaIndicadoresEvaluados.bindItemsToProperty("indicadoresEvaluados");
		
		new Column<>(tablaIndicadoresEvaluados).setTitle("Indicador").bindContentsToProperty("nombre");
		new Column<>(tablaIndicadoresEvaluados).setTitle("Valor").bindContentsToProperty("valor");
		
		Table<IndicadorNoEvaluado> tablaIndicadoresNoEvaluados = new Table<>(panelPrincipal, IndicadorNoEvaluado.class).setNumberVisibleRows(5);
		tablaIndicadoresNoEvaluados.bindItemsToProperty("indicadoresNoEvaluados");
		
		new Column<>(tablaIndicadoresNoEvaluados).setTitle("Indicador no evaluado").bindContentsToProperty("nombre");
		new Column<>(tablaIndicadoresNoEvaluados).setTitle("Motivo").bindContentsToProperty("motivo");
	}
	
	@Override
	protected void addActions(Panel botonera) 
	{		
		new Button(botonera).setCaption("Agregar indicador").onClick(() -> new CargaIndicadorWindow(this).open());
	}
	
	private void calcularIndicadores() 
	{	
		getModelObject().calcularIndicadores();
	}
}