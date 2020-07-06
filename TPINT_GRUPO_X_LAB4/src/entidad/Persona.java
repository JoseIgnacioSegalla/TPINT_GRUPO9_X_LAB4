package entidad;


public class Persona {

	private String Legajo;
	private String Dni;
	private String Nombre;
	private String Apellido;
	private String FechaNac;
	private String Direccion;
	private Localidad Localidad = new Localidad();
	private Provincia Provincia = new Provincia();
	private Usuario NUs = new Usuario();
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
	
	public Localidad getLocalidad() {
		return Localidad;
	}
	
	public void setLocalidad(Localidad localidad) {
		Localidad = localidad;
	}
	public Usuario getNUs() {
		return NUs;
	}
	public void setNUs(Usuario nUs) {
		NUs = nUs;
	}
	public Provincia getProvincia() {
		return Provincia;
	}
	public void setProvincia(Provincia provincia) {
		Provincia = provincia;
	}



}
