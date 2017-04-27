package vistas;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import utils.Paleta;
import vm.MenuPrincipalViewModel;

@SuppressWarnings("serial")
public class MenuPrincipalWindow extends SimpleWindow<MenuPrincipalViewModel>
{
	public MenuPrincipalWindow(WindowOwner parent) 
	{
		super(parent, new MenuPrincipalViewModel());
	}

	@Override
	protected void addActions(Panel botonera) 
	{
		new Button(botonera).setCaption("Gestionar Cuentas").onClick(this::gestionarCuentas);
		new Button(botonera).setCaption("Gestionar Indicadores").onClick(this::gestionarIndicadores);
		new Button(botonera).setCaption("Consultar Cuentas").onClick(this::consultarCuentas);
		new Button(botonera).setCaption("Gestionar Metodologia").onClick(this::gestionarMetodologia);
		new Button(botonera).setCaption("Analizar empresa").onClick(this::analizarEmpresa);
		new Button(botonera).setCaption("Visualizar graficos").onClick(this::visualizarGraficos);
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) 
	{
		this.setTitle("Inversor");
		
		panelPrincipal.setLayout(new VerticalLayout());
		
		Panel form1 = new Panel(panelPrincipal);
		
		form1.setLayout(new HorizontalLayout());
		
		
		//estetica
		Panel unPanel = new Panel(form1);
		unPanel.setLayout(new HorizontalLayout());
		
		Panel panelColor = new Panel(unPanel);
		panelColor.setLayout(new HorizontalLayout());
		new Label(panelColor).setText("_____________").setBackground(Paleta.colorBajo());
		new Label(panelColor).setText("_________________").setBackground(Paleta.colorMedioBajo());
		new Label(panelColor).setText("_________________").setBackground(Paleta.colorMedio());
		new Label(panelColor).setText("_________________").setBackground(Paleta.colorMedioAlto());
		new Label(panelColor).setText("___").setBackground(Paleta.colorAlto());
		
		new Label(panelColor).setText("_____________").setBackground(Paleta.colorBajo());
		new Label(panelColor).setText("_________________").setBackground(Paleta.colorMedioBajo());
		new Label(panelColor).setText("_________________").setBackground(Paleta.colorMedio());
		new Label(panelColor).setText("_________________").setBackground(Paleta.colorMedioAlto());
		new Label(panelColor).setText("___").setBackground(Paleta.colorAlto());
	}
	
	public void gestionarCuentas()
	{	
		
	}
	public void gestionarIndicadores()
	{	
		
	}
	public void consultarCuentas()
	{	
	
	}
	public void gestionarMetodologia()
	{	
	
	}
	public void analizarEmpresa()
	{
		
	}
	public void visualizarGraficos()
	{	

	}
}
