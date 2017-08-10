package negocio.dominio.manejoExpresiones.arbol.operaciones;

import negocio.dominio.manejoExpresiones.arbol.Expresion;

public abstract class Operacion implements Expresion {

	protected Expresion operandoIzquierdo;
	protected Expresion operandoDerecho;
	
	public Operacion(Expresion operandoIzquierdo, Expresion operandoDerecho) {

		this.operandoIzquierdo = operandoIzquierdo;
		this.operandoDerecho = operandoDerecho;
	}
}