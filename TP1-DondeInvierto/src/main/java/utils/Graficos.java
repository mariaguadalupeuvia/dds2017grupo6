package utils;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;

public class Graficos 
{
	public static Panel graficarBorde(Panel panelMain, Integer width)
	{
		Panel unPanel = new Panel(panelMain);
		unPanel.setLayout(new VerticalLayout());
		
		new Label(unPanel).setWidth(width);
		new Label(unPanel);
		new Label(unPanel).setBackground(Paleta.colorMedioAlto()).setFontSize(2);
		
		return unPanel;
	}
	
	public static Panel graficarDolares(Panel panelMain)
	{
		Panel unPanel = new Panel(panelMain);
		unPanel.setLayout(new VerticalLayout());
		
		Panel panelDolar = new Panel(unPanel);
		panelDolar.setLayout(new HorizontalLayout());
		
		new Label(panelDolar).setText("  |     U$D     |  ").setBackground(Paleta.colorBajo()).setForeground(Paleta.fuenteAlta()).setFontSize(8);
		new Label(panelDolar).setText("  |     U$D     |  ").setBackground(Paleta.colorMedioBajo()).setFontSize(8);
		new Label(panelDolar).setText("  |     U$D     |  ").setBackground(Paleta.colorMedio()).setForeground(Paleta.fuenteAlta()).setFontSize(8);
		new Label(panelDolar).setText("  |     U$D     |  ").setBackground(Paleta.colorMedioAlto()).setFontSize(8);
		new Label(panelDolar).setText("  |     U$D     |  ").setBackground(Paleta.colorAlto()).setForeground(Paleta.fuenteAlta()).setFontSize(8);

		new Label(unPanel);
		return unPanel;
	}
}