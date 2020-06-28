package NegocioImpl;

import java.util.ArrayList;
import Negocio.NegAlumno;
import entidad.Alumno;
import dao.DaoAlumnos;
import DaoImpl.DaoImplAlumnos;

public class  NegImplAlumno implements NegAlumno {

	private DaoAlumnos DaoAlum = new DaoImplAlumnos();
	
	public NegImplAlumno(DaoAlumnos DaoAlum) {
		this.DaoAlum = DaoAlum;
	}
	
	public ArrayList<Alumno> ListarAlumnos()
	{
		return (ArrayList<Alumno>) DaoAlum.readAll();
	}
	
	public boolean Insertar (Alumno Alumno)
	{
		return DaoAlum.insert(Alumno);
	}
	
	public boolean Editar (Alumno Alumno)
	{
		return DaoAlum.edit(Alumno);
	}
	
	public boolean Borrar (Alumno Alumno)
	{
		return DaoAlum.logic_delete(Alumno);
	}
	
	public boolean BuscarDni (Alumno Alumno)
	{
		return DaoAlum.find(Alumno);
	}
}
