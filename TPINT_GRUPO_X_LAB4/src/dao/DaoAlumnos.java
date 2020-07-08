package dao;

import java.util.List;
import java.util.ArrayList;
import entidad.Alumno;

public interface DaoAlumnos {

	public List<Alumno> readAll();
	public ArrayList<Alumno> Listar_Notas();
	public boolean insert(Alumno NAlum);
	public boolean edit(Alumno NAlum);
	public boolean logic_delete(int x);
	public Alumno find(int x);
	public boolean Update_Notas(Alumno alumno);
	
}
