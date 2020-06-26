package entidad;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Persona{

	private int IdAlumno;
	private List<Instancia> LInst = new ArrayList<Instancia>();//PRIMER PARCIAL //SEGUNDO PARCIAL //REC. PRIMER PARCIAL //REC. SEGUNDO PARCIAL
	private String Estado_Alumno; //EL ALUMNO PUEDE ESTAR LIBRE O REGULAR
	
	public Alumno() {
		super();
		
	}
	public int getIdAlumno() {
		return IdAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		IdAlumno = idAlumno;
	}
	
	public List<Instancia> getLInst() {
		return LInst;
	}
	public void setLInst(List<Instancia> lInst) {
		LInst = lInst;
	}
	
	
	public String getEstado_Alumno() {
		return Estado_Alumno;
	}
	public void setEstado_Alumno(String estado_Alumno) {
		Estado_Alumno = estado_Alumno;
	}
	
	

	
}
