package vm.carga.cuenta;

import dominio.ProcesarArchivoExcel;
import dominio.datos.DatosExcelCargaMasiva;

public class CargaMasivaVM {
	private String nombredelArchivo;
	
	public void Procesar(){
		String rutaArchivo = "C:/Users/HUCHIHA/Documents/prueba_excel.xls";
		DatosExcelCargaMasiva resultado = new DatosExcelCargaMasiva(); 
		resultado = ProcesarArchivoExcel.CargarInformaciondeExcel(rutaArchivo);
		
		System.out.print(resultado.getEmpresas().size());
		System.out.println();
		resultado.getRegistros("sabe1").forEach(registro->System.out.print(registro.getNombreCuenta()+"  "+registro.getPeriodo()));
		System.out.println();
		resultado.getRegistros("sabe1","sabe2").forEach(registro->System.out.print(registro.getNombreCuenta()+"  "+registro.getPeriodo()));
		/*
		System.out.println();
		System.out.print(resultado.periodos().size());
		System.out.println();
		resultado.periodos().forEach(periodo->System.out.print(periodo));
		System.out.println();
		System.out.print(resultado.Nombrecuentas().size());
		System.out.println();
		resultado.Nombrecuentas().forEach(cuenta->System.out.print(cuenta));
		*/
	}

	public String getNombredelArchivo() {
		return nombredelArchivo;
	}

	public void setNombredelArchivo(String nombredelArchivo) {
		this.nombredelArchivo = nombredelArchivo;
	}
}
