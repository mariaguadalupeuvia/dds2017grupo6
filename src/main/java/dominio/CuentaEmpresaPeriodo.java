package dominio;

import org.uqbar.commons.utils.Observable;

@Observable
public class CuentaEmpresaPeriodo 
{
	private String empresa;
    private String nombreCuenta;
    private Integer periodo;
	private Double valor;

	public CuentaEmpresaPeriodo(String empresa, String nombreCuenta, Integer periodo, Double valor)
	{
		this.empresa = empresa;
		this.nombreCuenta = nombreCuenta;
		this.periodo = periodo;
		this.valor = valor;
	}
	
	public CuentaEmpresaPeriodo() { }
 
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	
	public Integer getPeriodo() {
			return periodo;
	}

	public void setPeriodo(Integer periodo) {
			this.periodo = periodo;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
}