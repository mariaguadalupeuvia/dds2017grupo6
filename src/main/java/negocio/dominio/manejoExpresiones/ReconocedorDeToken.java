package negocio.dominio.manejoExpresiones;

import java.util.regex.Pattern;

import negocio.dominio.excepciones.ExpresionIncorrectaException;

public class ReconocedorDeToken
{
	private String letras = "[a-zA-Z]";
	private String digitos = "[0-9\\.]";
	private String operadores = "+-*/";
	private String parentesisIz = "(";
	private String parentesisDer = ")";
	private String neutros = "\\n\\t\\b ";
	private int cantidadParentesis = 0;
	
	public int obtenerToken(Character caracter) 
	{
		if (Pattern.matches(this.letras, Character.toString(caracter)))
		{
			return 0;
		}
		if (Pattern.matches(this.digitos, Character.toString(caracter))) 
		{
			return 1;
		}
		if (this.operadores.contains(Character.toString(caracter))) 
		{
			return 2;
		}
		if (this.parentesisIz.contains(Character.toString(caracter))) 
		{
			this.cantidadParentesis++;
			return 3;
		}
		if (this.parentesisDer.contains(Character.toString(caracter))) 
		{
			this.cantidadParentesis--;
			return 4;
		}
		if (this.neutros.contains(Character.toString(caracter))) 
		{
			return 5;
		}
		if (caracter == ';')//Fin de Cadena a evaluar
		{
			return 6;
		}
		throw new ExpresionIncorrectaException("Expresion invalida. El caracter \'" + caracter + "\' no es valido");
	}
	
	public Boolean esCorrectaLaCantidadParentesis()
    {
		return cantidadParentesis == 0;
	}
}
