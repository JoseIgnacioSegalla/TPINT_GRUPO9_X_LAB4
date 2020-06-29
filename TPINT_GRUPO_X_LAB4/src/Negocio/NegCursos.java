package negocio;

import java.util.ArrayList;

import entidad.Curso;

public interface NegCursos {

	public ArrayList<Curso> ListarCursos();
	public Curso Buscar(Curso Cur);
	public boolean Borrar(Curso Cur);
	public boolean Insertar(Curso Cur);
	public boolean Editar(Curso Cur);
}
