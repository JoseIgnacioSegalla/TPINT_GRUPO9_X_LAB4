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
	public ArrayList<Alumno> ListarNotas();
	public boolean Update_Notas(Alumno Alumno);
	
}
