package negocio.dominio.manejoExpresiones.arbol;

import negocio.dominio.Contexto;
import negocio.dominio.excepciones.NoSePuedeRealizarElCalculoException;

public interface Expresion {

	public abstract Double evaluate(Contexto contexto) throws NoSePuedeRealizarElCalculoException;

}