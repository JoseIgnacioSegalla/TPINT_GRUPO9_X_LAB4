package entidad;

public class Instancia {

	private int idIntancia;
	private String NombreInstancia;
	private int nota;
	private int IdCurso;

	public int getIdCurso() {
		return IdCurso;
	}
	public void setIdCurso(int idCurso) {
		IdCurso = idCurso;
	}
	public int getIdIntancia() {
		return idIntancia;
	}
	public void setIdIntancia(int idIntancia) {
		this.idIntancia = idIntancia;
	}
	public String getNombreInstancia() {
		return NombreInstancia;
	}
	public void setNombreInstancia(String nombreInstancia) {
		NombreInstancia = nombreInstancia;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	@Override
	public String toString() {
		return "Instancia [idIntancia=" + idIntancia + ", NombreInstancia=" + NombreInstancia + ", nota=" + nota + "]";
	}
}
