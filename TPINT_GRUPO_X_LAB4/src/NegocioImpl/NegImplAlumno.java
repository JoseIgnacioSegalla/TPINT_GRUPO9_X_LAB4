package NegocioImpl;


import java.util.List;

import Negocio.NegAlumno;
import entidad.Alumno;
import dao.DaoAlumnos;
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
}
