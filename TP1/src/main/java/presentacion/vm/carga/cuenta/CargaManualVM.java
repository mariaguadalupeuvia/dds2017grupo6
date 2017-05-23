package presentacion.vm.carga.cuenta;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.Cuenta;
import negocio.dominio.Empresa;
import negocio.dominio.Periodo;
import negocio.repositorio.RepositorioEmpresas;

@Observable
public class CargaManualVM 
{
	private String nombreEmpresa;
	private Integer aņoPeriodo;
	private String nombreCuenta;
	private Double valorCuenta;

	public void guardarEmpresa() 
	{
		Empresa empresa = new Empresa();
		Periodo periodo = new Periodo();
		Cuenta cuenta = new Cuenta();
		
		cuenta.setNombre(nombreCuenta);
		cuenta.setValor(valorCuenta);
		periodo.setAņo(aņoPeriodo);
		periodo.agregarCuenta(cuenta);
		empresa.setNombre(nombreEmpresa);
		empresa.agregarPeriodo(periodo);
		
		RepositorioEmpresas.agregarEmpresa(empresa);
	}
	
	
	
	// PROPIEDADES
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public Integer getAņoPeriodo() {
		return aņoPeriodo;
	}

	public void setAņoPeriodo(Integer aņoPeriodo) {
		this.aņoPeriodo = aņoPeriodo;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public Double getValorCuenta() {
		return valorCuenta;
	}

	public void setValorCuenta(Double valorCuenta) {
		this.valorCuenta = valorCuenta;
	}
}