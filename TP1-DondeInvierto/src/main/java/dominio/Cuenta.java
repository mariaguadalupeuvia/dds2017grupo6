package dominio;

public class Cuenta {
	
    //private int idCuenta;//Opcional, quizás nos sirva luego
    private String nombreCuenta;
    private String empresa; //Por ahora es así
	private double valor;
    private int periodo; //Pensé en formato AAAAMM


	/*public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}*/

	

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	
	
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	public int getPeriodo() {
			return periodo;
	}

	public void setPeriodo(int periodo) {
			this.periodo = periodo;
	}


}
