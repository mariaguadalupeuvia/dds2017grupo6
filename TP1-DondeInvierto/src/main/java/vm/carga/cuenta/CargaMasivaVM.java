package vm.carga.cuenta;

import dominio.DatosExcelCargaMasiva;
import dominio.ProcesarArchivoExcel;

public class CargaMasivaVM {
	private String nombredelArchivo;
	
	public void Procesar(){
		String rutaArchivo = "C:/Users/HUCHIHA/Documents/prueba_excel.xls";
		
		DatosExcelCargaMasiva resultado = new DatosExcelCargaMasiva(); 
		resultado = ProcesarArchivoExcel.CargarInformaciondeExcel(rutaArchivo);
		System.out.print(resultado.empresas().size());
		resultado.empresas().forEach(empresa->System.out.print(empresa));
		System.out.print(resultado.periodos().size());
		resultado.periodos().forEach(periodo->System.out.print(periodo));
		System.out.print(resultado.cuentas().size());
		resultado.cuentas().forEach(cuenta->System.out.print(cuenta));
		System.out.print(resultado.getRegistros().size());
	}

	public String getNombredelArchivo() {
		return nombredelArchivo;
	}

	public void setNombredelArchivo(String nombredelArchivo) {
		this.nombredelArchivo = nombredelArchivo;
	}
}
