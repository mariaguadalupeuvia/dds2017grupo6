package dominio.manejoDeArchivos.excel;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import dominio.Cuenta;
import dominio.manejoDeArchivos.FormatoDatos;

public class DatosExcel implements FormatoDatos 
{
	private List<Cuenta> cuentas = new ArrayList<Cuenta>();

	@SuppressWarnings("deprecation")
	@Override
	public void cargarDatosDe(String rutaDelArchivo)
	{
		HSSFWorkbook wb = null;
		try {
			wb = new HSSFWorkbook(new FileInputStream(rutaDelArchivo));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HSSFSheet hoja = wb.getSheetAt(0);
		HSSFRow fila;
		HSSFCell celda;

		Iterator<Row> filas = hoja.rowIterator();

		int i = 0;

		while (filas.hasNext()) 
		{
			fila = (HSSFRow) filas.next();
			Iterator<Cell> cells = fila.cellIterator();
			Cuenta cuenta = new Cuenta();

			i = 0;
			while (cells.hasNext()) 
			{
				celda = (HSSFCell) cells.next();

				if (celda.getCellType() == HSSFCell.CELL_TYPE_STRING) 
				{
					setearMetodoPorPosicion(cuenta, i, celda.getStringCellValue());
				} 
				else if (celda.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) 
				{
					setearMetodoPorPosicion(cuenta, i, String.valueOf(celda.getNumericCellValue()));
				}

				i++;
			}
			cuentas.add(cuenta);
		}
	}
	
	@Override
	public List<Cuenta> getCuentas() 
	{
		return cuentas;
	}

	@Override
	public List<String> getEmpresas() 
	{
		List<String> empresas = new ArrayList<String>();
		cuentas.forEach(cuenta -> empresas.add(cuenta.getEmpresa()));
		return empresas;
	}

	@Override
	public List<Integer> getPeriodos() 
	{
		List<Integer> periodos = new ArrayList<Integer>();
		cuentas.forEach(registro -> periodos.add(registro.getPeriodo()));
		return periodos;
	}

	@Override
	public List<String> getNombresCuentas() 
	{
		List<String> nombresCuentas = new ArrayList<String>();
		cuentas.forEach(cuenta -> nombresCuentas.add(cuenta.getNombreCuenta()));
		return nombresCuentas;
	}
	
	public void setearMetodoPorPosicion(Cuenta cuenta, int posicion, String valor)
	{
		switch (posicion) 
		{
		case 0:
			cuenta.setEmpresa(valor);
			break;
		case 1:
			cuenta.setNombreCuenta(valor);
			break;
		case 2:
			cuenta.setPeriodo((int)Double.parseDouble(valor));
			break;
		case 3:
			cuenta.setValor(Double.parseDouble(valor));
			break;
        default:
            break;
		}
	}
}