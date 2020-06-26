package entidad;

public class Profesor extends Persona{

	
	private int IdProfesor;
	
	public Profesor() {
		super();
	}

	public int getIdProfesor() {
		return IdProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		IdProfesor = idProfesor;
	}

	@Override
	public String toString() {
		return "Profesor [IdProfesor=" + IdProfesor + ", getLegajo()=" + getLegajo() + ", getDni()=" + getDni()
				+ ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getFechNac()=" + getFechNac()
				+ ", getDireccion()=" + getDireccion() + ", getLocalidad()=" + getLocalidad() + ", getProvincia()="
				+ getProvincia() + ", getEmail()=" + getEmail() + ", getTelefono()=" + getTelefono() + "]";
	}

	
}
