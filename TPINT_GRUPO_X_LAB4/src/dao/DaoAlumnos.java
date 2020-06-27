package dao;

import java.util.List;

import entidad.Alumno;

public interface DaoAlumnos {

	public List<Alumno> readall();
	public boolean insert(Alumno NAlum);
	public boolean edit(Alumno NAlum);
	public boolean logic_delete(Alumno NAlum);
	public boolean find(Alumno NAlum);
	
}
