package dao;


import java.util.List;

import entidad.Materia;

public interface DaoMateria {

	public List<Materia> readAll();
	public int getId(String NombreMateria);
}
