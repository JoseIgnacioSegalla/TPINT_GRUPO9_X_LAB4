package NegocioImpl;


import java.util.ArrayList;
import java.util.List;

import DaoImpl.DaoImplCurso;
import Negocio.NegCursos;
import entidad.Alumno;
import entidad.Curso;

public class NegImplCursos implements NegCursos {

	private DaoImplCurso DaoCur = new DaoImplCurso();
	
	@Override
	public List<Curso> ListarCursos() {
		
		return DaoCur.readAll_Cursos();
	}

	public List<Curso> ListarCursosxProfesor(int x){
		return DaoCur.readAll_Cursos_x_Profesor(x);
	}
	@Override
	public boolean Buscar(Curso Cur) {
		
		return DaoCur.find(Cur);
	}

	@Override
	public boolean Borrar(int x) {
	
		return DaoCur.logic_delete(x);
	}

	@Override
	public boolean Insertar(Curso Cur) {
		
		return DaoCur.insert(Cur);
	}

	@Override
	public boolean Editar(Curso Cur) {
		
		return DaoCur.edit(Cur);
	}

	@Override
	public List<Alumno> Alumnos_X_Curso() {
	
		return DaoCur.readAll_AlumnosxCurso();
	}

	@Override
	public ArrayList<Curso> ListarCursosNombres() {
		return (ArrayList<Curso>) DaoCur.readAll_Cursos_Nombres();
	}

	

}
