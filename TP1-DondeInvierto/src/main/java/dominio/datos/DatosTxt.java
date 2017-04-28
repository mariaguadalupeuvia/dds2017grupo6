package dominio.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.swing.JOptionPane;

import interfases.IOrigenDatos;

public class DatosTxt implements IOrigenDatos
{
	private  List<String> empresas = new ArrayList<String>();
	private  List<String> cuentas = new ArrayList<String>();
	private  List<String> periodos = new ArrayList<String>();
	private List<EstructuraEsperada> registros = new ArrayList<EstructuraEsperada>();
 
    public void cargarDatos()
    {
    	cargarDatosDe("archivoPruebas.txt");
    }
    
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
	    cuentas.add(datos[1]);
	    periodos.add(datos[2]);
	    registros.add(new EstructuraEsperada(datos[0], datos[2], datos[1], Double.parseDouble(datos[3])));
	}
	
	public List<String> getEmpresas()
	{
		return eliminarDuplicadosLista(empresas);
	}
	
	public List<String> getPeriodos()
	{
		return eliminarDuplicadosLista(periodos);
	}
	
	public List<String> getNombresCuentas()
	{
		return eliminarDuplicadosLista(cuentas);	
	}
	
	private List<String> eliminarDuplicadosLista(List<String> lista)
	{
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		lhs.addAll(lista);
		lista.clear();
		lista.addAll(lhs);
		return lista;
	}

	@Override
	public List<EstructuraEsperada> getRegistros() 
	{
		return registros;
	}
}