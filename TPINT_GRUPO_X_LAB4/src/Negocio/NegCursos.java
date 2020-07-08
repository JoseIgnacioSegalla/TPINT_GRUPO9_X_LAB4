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
	public boolean Borrar(Curso Cur);
	public boolean Insertar(Curso Cur);
	public boolean Editar(Curso Cur);
}
