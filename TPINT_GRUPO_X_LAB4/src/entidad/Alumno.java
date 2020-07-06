package entidad;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Persona{

	private int IdAlumno;
	private String Estado_Alumno; 
	public Alumno() {
		super();
		
	}
	public int getIdAlumno() {
		return IdAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		IdAlumno = idAlumno;
	}

	public String getEstado_Alumno() {
		return Estado_Alumno;
	}
	public void setEstado_Alumno(String estado_Alumno) {
		Estado_Alumno = estado_Alumno;
	}
	
	

	
}
