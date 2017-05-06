package vm.carga.indicador;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.uqbar.commons.utils.Observable;

import parser.AnalizadorDeFormulas;

@Observable
public class MenuCargaIndicadoresVM 
{
	private String formula;
	private String resultado;
	private String nombre;

	static AnalizadorDeFormulas parser = null;

	public Boolean validarFormula() {
		if (formula == null)
			return false;

		InputStream input = new ByteArrayInputStream(formula.getBytes());

		if (parser == null)
			parser = new AnalizadorDeFormulas(input);
		else
			AnalizadorDeFormulas.ReInit(input);

		try {
			switch (AnalizadorDeFormulas.one_line()) {
			case 0:
				System.out.println("Formula ok");
				resultado = "Formula ok";
				return true;

			case 1:
				System.out.println("Goodbye.");
				return false;
			default:
				return false;
			}
		} catch (parser.ParseException e) {
			System.out.println("Formula mal, verificar sintaxis");
			resultado = "Verificar sintaxis, " + e.getMessage();
			System.out.println(e.getMessage());
			return false;
		} catch (Error e) {
			System.out.println("Se produjo un error");
			resultado = "Se produjo un error, " + e.getMessage();
			System.out.println(e.getMessage());
			return false;
		}
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
