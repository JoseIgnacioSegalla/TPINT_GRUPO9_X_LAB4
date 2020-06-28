package Negocio;

import java.util.ArrayList;
import entidad.Alumno;

public interface NegAlumno {

	public ArrayList<Alumno> ListarAlumnos();
	public boolean BuscarDni(Alumno Alumno);
	public boolean Borrar(Alumno Alumno);
	public boolean Insertar(Alumno Alumno);
	public boolean Editar(Alumno Alumno);
	
}
