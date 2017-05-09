package dominio.manejoDeArchivos.txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
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
         JOptionPane.showMessageDialog(null, "Se obtuvieron los datos con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
      }
      catch(FileNotFoundException e)
      {
    	  JOptionPane.showMessageDialog(null, "No se encontro el archivo de datos", "Error", JOptionPane.ERROR_MESSAGE);
    	  e.printStackTrace();
      }
      catch(IOException e)
      {
    	  JOptionPane.showMessageDialog(null, "Se produjo un error al acceder al archivo", "Error", JOptionPane.ERROR_MESSAGE);
    	  e.printStackTrace();
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
        	JOptionPane.showMessageDialog(null, "Se produjo un error al liberar el recurso usado para leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            e2.printStackTrace();
         }
      }
   }

}