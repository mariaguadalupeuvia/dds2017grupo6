package dominio.datos;
import org.uqbar.commons.utils.Observable;

@Observable
public class EstructuraEsperada 
{
	private String empresa;
	private String periodo;
	private String nombreCuenta;
	private double valorCuenta;
	
	public EstructuraEsperada()
	{
	}
	
	public EstructuraEsperada( String empresa, String periodo, String nombreCuenta, double valorCuenta)
	{
		this.empresa = empresa;
		this.periodo = periodo;
		this.nombreCuenta = nombreCuenta;
		this.valorCuenta = valorCuenta;
	}
	
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
		return valorCuenta;
	}
	
	public void setValorCuenta(double valorCuenta) {
		this.valorCuenta = valorCuenta;
	}
}
