package Negocio;

import java.util.ArrayList;
import java.util.List;

import entidad.Alumno;
import entidad.Curso;

public interface NegCursos {

	public List<Curso> ListarCursos();
	public ArrayList<Curso> ListarCursosNombres();
	public List<Alumno> Alumnos_X_Curso();
	public boolean Buscar(Curso Cur);
	public boolean Borrar(int x);
	public boolean Insertar(Curso Cur);
	public boolean Editar(Curso Cur);
	
	public int getID(int idMateria, int idProfesor);
	public boolean insertar_Alumno(Alumno b);
	public boolean CheckAlumnoExista(Alumno alumno);
	public boolean ExisteCurso(String a, String b, String c, String d);
	public boolean AgregarCurso(String idMateria, String idProfesor, String cuatrimestre, String año);
	public int getID_V2(int idMateria,int idProfesor,int año,String cuatrimestre);
}
