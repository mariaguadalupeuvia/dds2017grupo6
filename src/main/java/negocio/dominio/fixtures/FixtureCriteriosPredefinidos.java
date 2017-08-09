package negocio.dominio.fixtures;

import java.util.Arrays;
import java.util.List;

import negocio.dominio.condiciones.criterios.filtrado.CriterioFiltrado;
import negocio.dominio.condiciones.criterios.filtrado.MayorA;
import negocio.dominio.condiciones.criterios.filtrado.MenorA;
import negocio.dominio.condiciones.criterios.filtrado.PromedioMayorA;
import negocio.dominio.condiciones.criterios.filtrado.PromedioMenorA;
import negocio.dominio.condiciones.criterios.filtrado.SiempreCreciente;
import negocio.dominio.condiciones.criterios.filtrado.SiempreDecreciente;
import negocio.dominio.condiciones.criterios.filtrado.SumatoriaMayorA;
import negocio.dominio.condiciones.criterios.filtrado.SumatoriaMenorA;
import negocio.dominio.condiciones.criterios.ordenamiento.CriterioOrdenamiento;
import negocio.dominio.condiciones.criterios.ordenamiento.MayorToMenor;
import negocio.dominio.condiciones.criterios.ordenamiento.MenorToMayor;

public class FixtureCriteriosPredefinidos {

	public List<CriterioFiltrado> getCriteriosFiltrado()
	{
		return Arrays.asList(
				new MayorA(), new MenorA(), 
				new PromedioMayorA(), new PromedioMenorA(), 
				new SiempreCreciente(), new SiempreDecreciente(), 
				new SumatoriaMayorA(), new SumatoriaMenorA());
	}
	
	public List<CriterioOrdenamiento> getCriteriosOrdenamiento() 
	{
		return Arrays.asList(new MenorToMayor(), new MayorToMenor());
	}
}