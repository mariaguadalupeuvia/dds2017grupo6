package negocio.dominio.manejoExpresiones.arbol;

import negocio.dominio.Contexto;

public class Constante implements Expresion {

	private Double valor;
	
	public Constante(Double valor) {
		
		this.valor = valor;
	}
	
	@Override
	public Double evaluate(Contexto contexto) {

		return valor;
	}
}