package Negocio;

import java.util.List;

import entidad.Localidad;
public interface NegLocalidad {

	public List<Localidad> readAll();
	public List<Localidad> Find(int x);
	
}
