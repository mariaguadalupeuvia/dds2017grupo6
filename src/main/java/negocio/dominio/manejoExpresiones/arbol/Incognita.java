package negocio.dominio.manejoExpresiones.arbol;

import negocio.dominio.Contexto;
import negocio.dominio.excepciones.NoSePuedeRealizarElCalculoException;

public class Incognita implements Expresion {

	private String nombre;
	
	public Incognita(String nombre) {
		
		this.nombre = nombre;
	}

	@Override
	public Double evaluate(Contexto contexto) throws NoSePuedeRealizarElCalculoException {
		
		return contexto.calcularValorDeIncognita(nombre);
	}
}