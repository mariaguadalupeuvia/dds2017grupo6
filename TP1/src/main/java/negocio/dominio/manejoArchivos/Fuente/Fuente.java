package negocio.dominio.manejoArchivos.Fuente;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public interface Fuente 
{
	void leerDatos(String ruta) throws EncryptedDocumentException, InvalidFormatException, IOException;
	
	List<String> getDatos();
}