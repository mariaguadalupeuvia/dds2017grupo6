package dominio;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import dominio.datos.DatosExcelCargaMasiva;

public class ProcesarArchivoExcel 
{

	public static DatosExcelCargaMasiva LeerArchivoXLS(String rutaArchivo) throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream(rutaArchivo);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

		HSSFSheet sheet=wb.getSheetAt(0);
		HSSFRow row; 
		HSSFCell cell;

		Iterator rows = sheet.rowIterator();
		int i=0;
		EstructuraEsperadaExcel registro = new EstructuraEsperadaExcel();
		DatosExcelCargaMasiva registrosProcesados = new DatosExcelCargaMasiva();
		while (rows.hasNext())
		{
			row=(HSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			i=0;
			while (cells.hasNext())
			{
				cell=(HSSFCell) cells.next();
				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
				{
					registro.setearMetodoPorPosicion(i, cell.getStringCellValue());
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
				{
					registro.setearMetodoPorPosicion(i, String.valueOf(cell.getNumericCellValue()));
				}
				i++;
			}
			registrosProcesados.setRegistro(registro.clonarDatos(registro));
		}
		return registrosProcesados;
	}
	
    public static DatosExcelCargaMasiva CargarInformaciondeExcel(String rutaArchivo)
    {
    	DatosExcelCargaMasiva retorno = new DatosExcelCargaMasiva();
        try {
        	retorno = LeerArchivoXLS(rutaArchivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return retorno;
    }
}
