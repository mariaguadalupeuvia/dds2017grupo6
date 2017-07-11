package negocio.dominio.fixtures;

import java.util.Arrays;
import java.util.List;

import negocio.dominio.condiciones.criterios.Criterio;
import negocio.dominio.condiciones.criterios.deFiltro.MayorA;
import negocio.dominio.condiciones.criterios.deFiltro.MenorA;
import negocio.dominio.condiciones.criterios.deFiltro.PromedioMayorA;
import negocio.dominio.condiciones.criterios.deFiltro.PromedioMenorA;
import negocio.dominio.condiciones.criterios.deFiltro.SiempreCreciente;
import negocio.dominio.condiciones.criterios.deFiltro.SiempreDecreciente;
import negocio.dominio.condiciones.criterios.deFiltro.SumatoriaMayorA;
import negocio.dominio.condiciones.criterios.deFiltro.SumatoriaMenorA;
import negocio.dominio.condiciones.criterios.deOrden.MayorToMenor;
import negocio.dominio.condiciones.criterios.deOrden.MenorToMayor;

public class FixtureCriteriosPredefinidos {

	public List<Criterio> getCriterios()
	{
		return Arrays.asList(
				new MayorA(), new MenorA(), 
				new PromedioMayorA(), new PromedioMenorA(), 
				new SiempreCreciente(), new SiempreDecreciente(), 
				new SumatoriaMayorA(), new SumatoriaMenorA(), 
				new MenorToMayor(), new MayorToMenor());
	}
}
