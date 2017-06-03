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

import negocio.dominio.Empresa;
import negocio.dominio.Periodo;
import presentacion.vm.indicadores.consulta.ConsultaIndicadorVM;
import negocio.dominio.Indicador;

@SuppressWarnings("serial")
public class ConsultaIndicadorWindow extends SimpleWindow<ConsultaIndicadorVM> 
{
	public ConsultaIndicadorWindow(WindowOwner owner) 
	{
		super(owner, new ConsultaIndicadorVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		setTitle("Consulta de indicadores");
		panelPrincipal.setLayout(new VerticalLayout());
		
		GroupPanel panelFiltrado = new GroupPanel(panelPrincipal);
		panelFiltrado.setTitle("Filtrar datos");
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
		
		Table<Indicador> tablaIndicadores = new Table<>(panelPrincipal, Indicador.class).setNumberVisibleRows(5);
		tablaIndicadores.bindItemsToProperty("periodoSeleccionado.indicadores");
		
		new Column<>(tablaIndicadores).setTitle("Indicador").bindContentsToProperty("nombre");
		
		new Column<>(tablaIndicadores).setTitle("Formula").bindContentsToProperty("formula.expresion");
		
		new Column<>(tablaIndicadores).setTitle("Valor").bindContentsToProperty("valor").setTransformer((valor) -> 
		{
			if(valor != null)
				return String.valueOf(valor);
			
			return "ERROR: existen cuentas/indicadores no cargados";
		});	
	}

	@Override
	protected void addActions(Panel arg0) {
			
	}
}
