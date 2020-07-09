package Negocio;


import java.util.ArrayList;
import java.util.List;

import entidad.Alumno;

public interface NegAlumno {

	public List<Alumno> ListarAlumnos();
	public Alumno Buscar(int x);
	public boolean Borrar(int x);
	public boolean Insertar(Alumno Alumno);
	public boolean Editar(Alumno Alumno);
	public ArrayList<Alumno> ListarNotas(int x);
	public boolean Update_Notas(Alumno Alumno);
	
	public ArrayList<Alumno> ListarAlumnos_x_Materia(int IdCurso);
	public ArrayList<Alumno> ListarAlumnos_v2();
	public Alumno TraerUno(int IdALumno);
	public boolean BajaLogica_Curso_x_Materia(Alumno alumno);
	public boolean CheckAlumnoId(Alumno a);
	public boolean Update_Curso_Materia(Alumno alumno);
	
}
