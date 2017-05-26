package negocio.dominio.manejoArchivos.Parser;

import negocio.dominio.Empresa;

public interface Parser 
{
	Empresa parsear(String fila);
}