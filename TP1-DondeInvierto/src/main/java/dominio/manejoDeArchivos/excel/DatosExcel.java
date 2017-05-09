package dominio.manejoDeArchivos.excel;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import dominio.interfases.OrigenDatos;
import dominio.interfases.ParserDatos;


public class DatosExcel implements OrigenDatos 
{
	ParserDatos parser;
	public DatosExcel(ParserDatos unParser)
	{
		this.parser = unParser;
	}

	@Override
	public void cargarDatosDe(String rutaDelArchivo)
	{
		HSSFWorkbook wb = null;
		try {
			wb = new HSSFWorkbook(new FileInputStream(rutaDelArchivo));
			HSSFSheet hoja = wb.getSheetAt(0);
			Iterator<Row> filas = hoja.rowIterator();
			
			while (filas.hasNext()) 
			{
				parser.parsear((HSSFRow) filas.next());
			}
			JOptionPane.showMessageDialog(null, "Se obtuvieron los datos con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "No se encontro el archivo de datos", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "Se produjo un error al acceder al archivo", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

}