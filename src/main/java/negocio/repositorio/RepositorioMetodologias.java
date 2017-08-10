package negocio.repositorio;

import java.util.ArrayList;
import java.util.List;

import negocio.dominio.Metodologia;

public class RepositorioMetodologias {

	private static List<Metodologia> metodologias;
	
	public static void agregarMetodologia(Metodologia metodologia) {
		
		metodologias.add(metodologia);
	}

	public static List<Metodologia> getMetodologias() {
		
		return metodologias;
	}

	public static void inicializarRepositorio() {
		metodologias = new ArrayList<>();
	}

}
