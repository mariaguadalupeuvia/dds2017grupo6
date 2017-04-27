package dominio;

public class EstructuraEsperadaExcel {
	private String empresa;
	private String periodo;
	private String nombreCuenta;
	private double ValorCuenta;
	
	public String getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	
	public double getValorCuenta() {
		return ValorCuenta;
	}
	
	public void setValorCuenta(double valorCuenta) {
		ValorCuenta = valorCuenta;
	}
	
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
