package negocio.dominio.excepciones;

@SuppressWarnings("serial")
public class NoSePuedeAgregarFormulaException extends RuntimeException {

	public NoSePuedeAgregarFormulaException(String mensaje) {

		super(mensaje);
	}
}
