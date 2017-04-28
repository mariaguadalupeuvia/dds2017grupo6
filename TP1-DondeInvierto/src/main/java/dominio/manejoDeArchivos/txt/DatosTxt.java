package dominio.manejoDeArchivos.txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dominio.Cuenta;
import dominio.manejoDeArchivos.FormatoDatos;

public class DatosTxt implements FormatoDatos
{
	private  List<String> empresas = new ArrayList<String>();
	private  List<String> nombresCuentas = new ArrayList<String>();
	private  List<Integer> periodos = new ArrayList<Integer>();
	private List<Cuenta> cuentas = new ArrayList<Cuenta>();
    
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
            
        	 separarRegistro(linea);
         }
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
	
	private void separarRegistro(String registro)
	{
	    String[] datos = registro.split(" "); 
	    empresas.add(datos[0]);
	    nombresCuentas.add(datos[1]);
	    periodos.add(Integer.parseInt(datos[2]));
	    cuentas.add(new Cuenta(datos[0], datos[1], Integer.parseInt(datos[2]), Double.parseDouble(datos[3])));
	}

	@Override
	public List<Cuenta> getCuentas() 
	{
		return cuentas;
	}
	
	@Override
	public List<String> getEmpresas() 
	{
		return empresas;
	}

	@Override
	public List<String> getNombresCuentas()
	{
		return nombresCuentas;
	}
	
	@Override
	public List<Integer> getPeriodos() 
	{
		return periodos;
	}
}