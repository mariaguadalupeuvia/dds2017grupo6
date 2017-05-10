package dominio.manejoDeArchivos.txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dominio.OrigenDatosException;
import dominio.interfases.OrigenDatos;
import dominio.interfases.ParserDatos;

public class DatosTxt implements OrigenDatos
{
	ParserDatos parser;
	public DatosTxt(ParserDatos unParser)
	{
		this.parser = unParser;
	}
	
	@Override
    public void cargarDatosDe(String rutaArchivoTxt)
    {
      File archivo = null;
      FileReader reader = null;
      BufferedReader buffer = null;

      try {

         archivo = new File(rutaArchivoTxt);
         reader = new FileReader (archivo);
         buffer = new BufferedReader(reader);

         String linea;
         while((linea = buffer.readLine())!=null)
         {
        	 parser.parsear(linea);
         }
         
      }
      catch(FileNotFoundException e)
      {
    	  throw new OrigenDatosException("No se encontro el archivo de datos");
    	 
      }
      catch(IOException e)
      {
    	  throw new OrigenDatosException("Se produjo un error al acceder al archivo");
      }

      finally
      {

         try
         {                    
            if( null != reader)
            {   
            	reader.close();     
            }                  
         }
         catch (Exception e2)
         { 
            throw new OrigenDatosException("Se produjo un error al liberar el recurso usado para leer el archivo");
         }
      }
   }

}