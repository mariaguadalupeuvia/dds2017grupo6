package vm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.uqbar.commons.utils.Observable;

import parser.AnalizadorDeFormulas;

@Observable
public class Formula {
	private String formula;
	static AnalizadorDeFormulas parser = null;

	public Boolean validarFormula() {
		InputStream input = new ByteArrayInputStream(formula.getBytes());

		if (parser == null)
			parser = new AnalizadorDeFormulas(input);
		else
			AnalizadorDeFormulas.ReInit(input);

		try {
			switch (AnalizadorDeFormulas.one_line()) {
			case 0:
				System.out.println("Formula ok");
				return true;

			case 1:
				System.out.println("Goodbye.");
				return false;
			default:
				return false;
			}
		} catch (parser.ParseException e) {
			System.out.println("Formula mal, verificar sintaxis");
			System.out.println(e.getMessage());
			return false;
		} catch (Error e) {
			System.out.println("Se produjo un error");
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

}
