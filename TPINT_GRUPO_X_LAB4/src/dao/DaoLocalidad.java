package dao;

import java.util.List;

import entidad.Localidad;

public interface DaoLocalidad {

	public List<Localidad> readAll();	
	public Localidad Find(int x);
}