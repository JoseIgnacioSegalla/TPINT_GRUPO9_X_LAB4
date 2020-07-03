package entidad;

import java.util.ArrayList;
import java.util.List;

public class Curso {

	private int IdCurso;
	private Materia NMateria = new Materia();
	private String Cuatrimestre;
	private String A�o;
	private Profesor NProfesor = new Profesor();
	private List<Alumno> LAlum = new ArrayList<Alumno>();
	
	public int getIdNumCurso() {
		return IdCurso;
	}
	public void setIdNumCurso(int idCurso) {
		IdCurso = idCurso;
	}
	public Materia getNMateria() {
		return NMateria;
	}
	public void setNMateria(Materia nMateria) {
		NMateria = nMateria;
	}
	public String getCuatrimestre() {
		return Cuatrimestre;
	}
	public void setCuatrimestre(String cuatrimestre) {
		Cuatrimestre = cuatrimestre;
	}
	public String getA�o() {
		return A�o;
	}
	public void setA�o(String a�o) {
		A�o = a�o;
	}
	public Profesor getNProfesor() {
		return NProfesor;
	}
	public void setNProfesor(Profesor nProfesor) {
		NProfesor = nProfesor;
	}
	public List<Alumno> getLAlum() {
		return LAlum;
	}
	public void setLAlum(List<Alumno> lAlum) {
		LAlum = lAlum;
	}
	
	
}
