package negocio.dominio.manejoArchivos.parser;

import negocio.dominio.Empresa;

public interface Parser 
{
	Empresa parsear(String fila);
}