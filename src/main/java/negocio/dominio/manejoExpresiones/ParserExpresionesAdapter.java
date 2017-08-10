package negocio.dominio.manejoExpresiones;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import negocio.dominio.excepciones.ExpresionInvalidaException;
import negocio.dominio.manejoExpresiones.arbol.Expresion;
import negocio.dominio.manejoExpresiones.javacc.ParseException;
import negocio.dominio.manejoExpresiones.javacc.ParserExpresiones;
import negocio.dominio.manejoExpresiones.javacc.TokenMgrError;

public class ParserExpresionesAdapter {

	public Expresion parsear(String expresion) throws ExpresionInvalidaException
	{
		try
		{
			return new ParserExpresiones(new ByteArrayInputStream(expresion.getBytes("UTF-8"))).parsear();
		}
		catch(TokenMgrError | ParseException e)
		{
			throw new ExpresionInvalidaException(e);
		} 
		catch (UnsupportedEncodingException e) {
			
			//ACA NO SE BIEN QUE PONER
			throw new RuntimeException(e);
		}
	}
}