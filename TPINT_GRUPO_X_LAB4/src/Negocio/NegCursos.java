package Negocio;

import java.util.ArrayList;
import entidad.Alumno;
import entidad.Curso;

public interface NegCursos {

	public ArrayList<Curso> ListarCursos();
	public ArrayList<Alumno> Alumnos_X_Curso();
	public boolean Buscar(Curso Cur);
	public boolean Borrar(Curso Cur);
	public boolean Insertar(Curso Cur);
	public boolean Editar(Curso Cur);
}
