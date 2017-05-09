package dominio;

import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;

import repositorio.RepositorioCuentas;
import repositorio.RepositorioEmpresas;
import repositorio.RepositorioNombresCuentas;
import repositorio.RepositorioPeriodos;

public class ParserCuentasExcel 
{
	@SuppressWarnings("deprecation")
	public static void parsear(HSSFRow fila) 
	{
		HSSFCell celda;
		Iterator<Cell> cells = fila.cellIterator();
		CuentaEmpresaPeriodo cuenta = new CuentaEmpresaPeriodo();

		int i = 0;
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
		RepositorioCuentas.agregar(cuenta);
	}
	
	public static void setearMetodoPorPosicion(CuentaEmpresaPeriodo cuenta, int posicion, String valor)
	{
		switch (posicion) 
		{
		case 0:
			cuenta.setEmpresa(valor);
			RepositorioEmpresas.agregar(new Empresa(valor,null));
			break;
		case 1:
			cuenta.setNombreCuenta(valor);
			RepositorioNombresCuentas.agregar(valor);
			break;
		case 2:
			cuenta.setPeriodo((int)Double.parseDouble(valor));
			RepositorioPeriodos.agregar((int)Double.parseDouble(valor));
			break;
		case 3:
			cuenta.setValor(Double.parseDouble(valor));
			break;
        default:
            break;
		}
	}
}
