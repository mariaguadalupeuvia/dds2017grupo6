package negocio.dominio.manejoExpresiones;

public class Automata
{
	
	private String msjError;
	private int[][] tablaTransiciones = 
									{ 
										//Cada fila corresponde a un estado distinto en un automata finito.
										//Cada columna corresponde a un token (en orden de aparicion): letras, digitos, operadores, parentesisIz, parentesisDer, neutro, fdc
										//El 10 es un estado de rechazo, el 11 es neutro y se ignora,
										//el 9 es un estado final que acepta o rechaza en funcion de que la cantidad de parentesis usados en la expresion sea correcto
										
										{ 3,  2,  10, 1,  10, 11, 10 }, 
										{ 3,  2,  10, 1,  10, 11, 10 },
										{ 10, 2,  4,  10, 10, 11, 9 }, 
										{ 3,  3,  4,  10, 10, 11, 9 }, 
										{ 6,  5,  10, 1,  10, 11, 10 },
										{ 10, 5,  4,  10, 7,  11, 9 }, 
										{ 6,  6,  4,  10, 7,  11, 9 }, 
										{ 10, 10, 8,  10, 7,  11, 9 },
										{ 6,  6,  10, 1,  10, 11, 10 }
								
									};

	private int estadoActual;
	private int caracteresLeidos;

	
	public Boolean reconocerExpresion(String expresion)
	{
		this.estadoActual = 0;
		this.caracteresLeidos = 0;
		ReconocedorDeToken reconocedorTokens = new ReconocedorDeToken();
		return ((expresion != "") && (expresion != null) ? expresion.chars().mapToObj(i -> (char) i).allMatch(c -> esCaracterValido(c,reconocedorTokens)) : false);
	}
	
	//funciones auxiliares--------------------------------------------------------
	private Boolean esCaracterValido(Character caracter,ReconocedorDeToken reconocedorTokens)
	{
		return evaluarEstado((int)tablaTransiciones[this.estadoActual][reconocedorTokens.obtenerToken(caracter)],reconocedorTokens);
	}

	private Boolean evaluarEstado(int estado,ReconocedorDeToken reconocedorTokens) 
	{
		 if (estado == 10)// estado de rechazo
		 {
			 setMsjError("Expresion invalida. El caracter en la posicion " + this.caracteresLeidos + " produjo un error de sintaxis");
			 return false;
		 }
		 if (estado == 11)// estado neutro
		 {
			 this.caracteresLeidos++;
			 return true;
		 }
		 if ((estado == 9) && !reconocedorTokens.esCorrectaLaCantidadParentesis()) // estado que evalua que la cantidad de parentesis sea valida
		 {
			 setMsjError("Expresion invalida. Cantidad de parentesis incorrectos");
			 return false;
		 }

		 this.estadoActual = estado;
		 this.caracteresLeidos++;
		 return true;
	}

	public String getMsjError() {
		return msjError;
	}

	public void setMsjError(String msjError) {
		this.msjError = msjError;
	}

}
