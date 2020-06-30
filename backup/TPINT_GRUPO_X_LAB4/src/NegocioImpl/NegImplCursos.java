package NegocioImpl;

import java.util.ArrayList;

import DaoImpl.DaoImplCurso;
import Negocio.NegCursos;
import dao.DaoCurso;
import entidad.Alumno;
import entidad.Curso;

public class NegImplCursos implements NegCursos {

	private DaoCurso DaoCur = new DaoImplCurso();
	
	@Override
	public ArrayList<Curso> ListarCursos() {
		
		return (ArrayList<Curso>) DaoCur.readAll_Cursos();
	}

	@Override
	public boolean Buscar(Curso Cur) {
		
		return DaoCur.find(Cur);
	}

	@Override
	public boolean Borrar(Curso Cur) {
	
		return DaoCur.logic_delete(Cur);
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
	public ArrayList<Alumno> Alumnos_X_Curso() {
	
		return (ArrayList<Alumno>) DaoCur.readAll_AlumnosxCurso();
	}

	

}