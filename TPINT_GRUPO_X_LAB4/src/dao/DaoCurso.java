package dao;

import java.util.List;

import entidad.Alumno;
import entidad.Curso;

public interface DaoCurso {

	public List<Curso> readAll_Cursos();
	public List<Alumno> readAll_AlumnosxCurso();
	public List<Curso> readAll_Cursos_Nombres();
	public boolean insert(Curso NCurs);
	public boolean edit (Curso NCurs);
	public boolean logic_delete(int x);
	public boolean delete(Curso NCurso);
	public boolean find(Curso NCurso);
	
	public int getID_V2(int idMateria, int idProfesor, int año, String cuatrimestre);
	public int getID(int idMateria, int idProfesor);
	public boolean insert_Alumno(Alumno a);
	public boolean VerificarExistencia_EnCurso_x(Alumno alumno);
	public boolean Existe(String idMateria, String idProfesor, String cuatrimestre, String año);
	public boolean Insertar(String idMateria, String idProfesor, String cuatrimestre, String año);
	
}
