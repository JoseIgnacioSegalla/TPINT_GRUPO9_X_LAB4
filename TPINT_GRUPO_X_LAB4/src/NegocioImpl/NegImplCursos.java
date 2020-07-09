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
	@Override
	public int getID(int idMateria, int idProfesor) {

		return DaoCur.getID(idMateria,idProfesor);
	}

	@Override
	public boolean insertar_Alumno(Alumno b) {

		return DaoCur.insert_Alumno(b);
	}

	@Override
	public boolean CheckAlumnoExista(Alumno alumno) {

		return DaoCur.VerificarExistencia_EnCurso_x(alumno);
	}

	@Override
	public boolean ExisteCurso(String IdMateria, String IdProfesor, String Cuatrimestre, String Año) {

		return DaoCur.Existe(IdMateria,IdProfesor,Cuatrimestre,Año);
	}

	@Override
	public boolean AgregarCurso(String idMateria, String idProfesor, String cuatrimestre, String año) {

		return DaoCur.Insertar(idMateria,idProfesor,cuatrimestre,año);

	}
	public int getID_V2(int idMateria, int idProfesor, int año, String cuatrimestre) {

		return DaoCur.getID_V2(idMateria, idProfesor,año,cuatrimestre);
	}

	

}
