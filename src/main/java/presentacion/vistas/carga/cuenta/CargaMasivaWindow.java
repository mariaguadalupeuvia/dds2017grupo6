package presentacion.vistas.carga.cuenta;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.FileSelector;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;

import presentacion.vm.carga.cuenta.CargaMasivaVM;

@SuppressWarnings("serial")
public class CargaMasivaWindow extends Dialog<CargaMasivaVM>{
	
	public CargaMasivaWindow(WindowOwner owner) {
		super(owner, new CargaMasivaVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		setTitle("Carga masiva de cuentas");
		
		panelPrincipal.setLayout(new VerticalLayout());
		
		GroupPanel formDatos = new GroupPanel(panelPrincipal);
		formDatos.setTitle("Ruta de acceso del archivo:");
		formDatos.setLayout(new HorizontalLayout());
		
		new TextBox(formDatos).setWidth(250).bindValueToProperty("rutaDelArchivo");
		new FileSelector(formDatos).extensions("*.txt", "*xls", "*.xlsx").setCaption("Examinar").setWidth(75).bindValueToProperty("rutaDelArchivo");
		
		new RadioSelector<String>(panelPrincipal, "tiposArchivos").bindValueToProperty("tipoArchivoSeleccionado");
	}

	@Override
	protected void addActions(Panel actions) 
	{
		actions.setLayout(new VerticalLayout());
		
		Panel panel= new Panel(actions);
		panel.setLayout(new HorizontalLayout());
		
		new Button(panel).setCaption("Guardar").onClick(this::accept).setAsDefault();
		new Button(panel).setCaption("Cancelar").onClick(this::cancel);
	}

	@Override
	protected void executeTask()
	{
		try 
		{
			getModelObject().cargarDatos();
		} 
		catch (EncryptedDocumentException | InvalidFormatException | IOException e)
		{				
			throw new UserException(e.getMessage());
		}
		
		super.executeTask();
	}
}