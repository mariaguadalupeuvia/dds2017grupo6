package dominio;

import java.util.List;

public class Periodo {
	private List<Cuenta> cuentas;

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
}
