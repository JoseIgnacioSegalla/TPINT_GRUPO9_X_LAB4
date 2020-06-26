package entidad;


public class Persona {

	private String Legajo;
	private String Dni;
	private String Nombre;
	private String Apellido;
	private String FechaNac;
	private String Direccion;
	private String Localidad;
	private String Provincia;
	private String Email;
	private String telefono;
	
	public String getLegajo() {
		return Legajo;
	}
	public void setLegajo(String legajo) {
		Legajo = legajo;
	}
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getFechNac() {
		return FechaNac;
	}
	public void setFechaNac(String fechaNac) {
		FechaNac = fechaNac;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


}
