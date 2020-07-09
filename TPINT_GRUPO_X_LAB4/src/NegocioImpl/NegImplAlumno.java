package NegocioImpl;


import java.util.ArrayList;
import java.util.List;

import Negocio.NegAlumno;
import entidad.Alumno;
import DaoImpl.DaoImplAlumnos;

public class  NegImplAlumno implements NegAlumno {

	DaoImplAlumnos DaoAlum = new DaoImplAlumnos();
	
	
	
	public List<Alumno> ListarAlumnos()
	{
		return DaoAlum.readAll();
	}
	
	public boolean Insertar (Alumno Alumno)
	{
		return DaoAlum.insert(Alumno);
	}
	
	public boolean Editar (Alumno Alumno)
	{
		return DaoAlum.edit(Alumno);
	}
	
	public boolean Borrar (int x)
	{
		return DaoAlum.logic_delete(x);
	}
	
	public Alumno Buscar (int x)
	{
		return DaoAlum.find(x);
	}
	public ArrayList<Alumno> ListarNotas(int x) {

		return (ArrayList<Alumno>) DaoAlum.Listar_Notas(x);
	}
	@Override
	public boolean Update_Notas(Alumno Alumno) {

		return DaoAlum.Update_Notas(Alumno);
	}
	@Override
	public ArrayList<Alumno> ListarAlumnos_x_Materia(int IdCurso) {

		return (ArrayList<Alumno>) DaoAlum.Listas_Alumnos_X_Materia(IdCurso);
	}
	@Override
	public ArrayList<Alumno> ListarAlumnos_v2() {

		return (ArrayList<Alumno>) DaoAlum.Listar();
	}
	@Override
	public Alumno TraerUno(int IdALumno) {

		return DaoAlum.BuscarPorIdALumno(IdALumno);
	}
	@Override
	public boolean BajaLogica_Curso_x_Materia(Alumno alumno) {

		return DaoAlum.BajaLogica_Curso_x_Materia(alumno);
	}
	public boolean CheckAlumnoId(Alumno a) {
		return DaoAlum.CheckId_Materia_Curso(a);
	}
	@Override
	public boolean Update_Curso_Materia(Alumno alumno) {

		return DaoAlum.Update_Estado_Materia_Curso(alumno);

	}
}
