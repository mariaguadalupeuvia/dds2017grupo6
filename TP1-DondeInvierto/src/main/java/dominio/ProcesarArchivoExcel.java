package dominio;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProcesarArchivoExcel {
	private static void LeerArchivoXLSX(String rutaArchivo) throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream(rutaArchivo);
		
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
		
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					System.out.print(cell.getNumericCellValue()+" ");
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}
			System.out.println();
		}
	}

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
					System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
				{
					registro.setearMetodoPorPosicion(i, String.valueOf(cell.getNumericCellValue()));
					System.out.print(cell.getNumericCellValue()+" ");
				}
				i++;
			}
			registrosProcesados.setRegistro(registro.clone());
			System.out.println();
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
