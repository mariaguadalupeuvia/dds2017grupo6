package dominio;

import dominio.datos.EstructuraEsperada;

public class EstructuraEsperadaExcel extends EstructuraEsperada
{
	public void setearMetodoPorPosicion(int posicion, String valor){
		switch (posicion) {
			case 0:
				setEmpresa(valor);
				break;
			case 1:
				setPeriodo(valor);
				break;
			case 2:
				setNombreCuenta(valor);
				break;
			case 3:
				setValorCuenta(Double.parseDouble(valor));
				break;
	        default:
	            break;
		}
	}
	
	public EstructuraEsperadaExcel clonarDatos(EstructuraEsperadaExcel Registro){
		EstructuraEsperadaExcel RegistroClonado = new EstructuraEsperadaExcel();
			RegistroClonado.setEmpresa(new String(Registro.getEmpresa()));
			RegistroClonado.setPeriodo(new String(Registro.getPeriodo()));
			RegistroClonado.setNombreCuenta(new String(Registro.getNombreCuenta()));
			RegistroClonado.setValorCuenta(new Double(Registro.getValorCuenta()));
		return RegistroClonado;
	}
}
