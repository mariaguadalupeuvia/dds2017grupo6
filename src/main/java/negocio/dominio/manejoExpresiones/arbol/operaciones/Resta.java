package negocio.dominio.manejoExpresiones.arbol.operaciones;

import negocio.dominio.Contexto;
import negocio.dominio.excepciones.NoSePuedeRealizarElCalculoException;
import negocio.dominio.manejoExpresiones.arbol.Expresion;

public class Resta extends Operacion {

	public Resta(Expresion operandoIzquierdo, Expresion operandoDerecho) {
		
		super(operandoIzquierdo, operandoDerecho);
	}

	@Override
	public Double evaluate(Contexto contexto) throws NoSePuedeRealizarElCalculoException {
		
		return operandoIzquierdo.evaluate(contexto) - operandoDerecho.evaluate(contexto);
	}
}