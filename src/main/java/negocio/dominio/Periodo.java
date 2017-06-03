package negocio.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import negocio.dominio.excepciones.NoExisteMedibleException;
import negocio.dominio.excepciones.NoSePuedeAgregarMedibleException;
import negocio.repositorio.RepositorioFormulas;

@Observable
public class Periodo 
{
    private Integer año;
    private List<Medible> medibles = new ArrayList<>();
    
	public void onConsultaDeIndicadores() {
		
		RepositorioFormulas.getFormulas()
		.forEach(formula -> {
			if(!existeMedibleDeNombre(formula.getNombre()))
				agregarMedible(new Indicador(this, formula));
			}
		);
	}

    public List<Indicador> getIndicadores()
    {
    	return medibles.stream()
    			.filter(medible -> medible instanceof Indicador)
    			.map(indicador -> (Indicador) indicador)
    			.collect(Collectors.toList());
    }
    
    public List<Cuenta> getCuentas()
    {
    	return medibles.stream()
    			.filter(medible -> medible instanceof Cuenta)
    			.map(cuenta -> (Cuenta) cuenta)
    			.collect(Collectors.toList());
    }
    
    public Medible buscarMedible(String nombre)
    {
    	return medibles.stream().filter(medible -> medible.getNombre().equals(nombre))
    			.findAny().orElseThrow(() -> new NoExisteMedibleException("No existe el indicador o la cuenta")) ;
    }
    
    public void agregarVariosMedibles(List<Medible> mediblesNuevos)
    {
    	mediblesNuevos.forEach(medibleNuevo -> agregarMedible(medibleNuevo));
	}
    
    public void agregarMedible(Medible medibleNuevo)
    {
    	if (!existeMedibleDeNombre(medibleNuevo.getNombre())) 
		{
    		medibles = new ArrayList<>(medibles);
    		medibles.add(medibleNuevo);
		}
		else
		{
			throw new NoSePuedeAgregarMedibleException("Dato duplicado: '" + medibleNuevo.getNombre() + "' ya existe para esa empresa en el periodo " + this.getAño());
		}
    }
    
    private boolean existeMedibleDeNombre(String nombre)
    {
    	return medibles.stream().anyMatch(medible -> medible.getNombre().equals(nombre) );
    }
	
	

	//PROPIEDADES
    public Integer getAño() {
		return año;
	}
	public void setAño(Integer año) {
		this.año = año;
	}
	public List<Medible> getMedibles() {
		return medibles;
	}
	
	@Override
	public String toString()
	{
		return año.toString();
	}
}