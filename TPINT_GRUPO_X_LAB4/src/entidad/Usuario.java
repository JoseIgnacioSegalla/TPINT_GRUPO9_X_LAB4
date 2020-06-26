package entidad;

public class Usuario {

	private int IdUsuario;
	private String Nombre;
	private String Clave;
	private Boolean Tipo;
	
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getClave() {
		return Clave;
	}
	public void setClave(String clave) {
		Clave = clave;
	}
	public Boolean getTipo() {
		return Tipo;
	}
	public void setTipo(Boolean tipo) {
		Tipo = tipo;
	}


	
}
