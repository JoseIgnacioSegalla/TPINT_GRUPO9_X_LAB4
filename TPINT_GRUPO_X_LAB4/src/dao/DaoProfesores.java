package dao;

import java.util.List;

import entidad.Profesor;

public interface DaoProfesores {

	public List<Profesor> readAll();
	public Profesor readOne(int dni);
	public boolean insert(Profesor NProf);
	public boolean edit (Profesor NProf);
	public boolean logic_delete(int i);
	public Profesor find(int i);
	
}
