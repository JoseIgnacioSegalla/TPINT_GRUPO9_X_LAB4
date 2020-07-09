package dao;

import java.util.List;
import java.util.ArrayList;
import entidad.Alumno;

public interface DaoAlumnos {

	public List<Alumno> readAll();
	public List<Alumno> Listar();
	public ArrayList<Alumno> Listar_Notas(int x);
	public boolean insert(Alumno NAlum);
	public boolean edit(Alumno NAlum);
	public boolean logic_delete(int x);
	public Alumno find(int x);
	public boolean Update_Notas(Alumno alumno);
	
	public ArrayList<Alumno> Listas_Alumnos_X_Materia(int IdCurso);
	public Alumno BuscarPorIdALumno(int idALumno);
	public boolean BajaLogica_Curso_x_Materia(Alumno alumno);
	public boolean CheckId_Materia_Curso(Alumno a);
	public boolean Update_Estado_Materia_Curso(Alumno alumno);
	
}
