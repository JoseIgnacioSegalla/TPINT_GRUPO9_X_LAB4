package Negocio;

import entidad.Usuario;
import java.util.List;

public interface NegUsuarios {


	public List<Usuario> ListarUsuarios();
	public Usuario BuscarUsu(Usuario Usu);
	public boolean BuscarUsuReg(int IdProfesor);
	public int BuscarNombreUsu(String Nombre);
	public boolean Borrar(Usuario Usu);
	public boolean Insertar(Usuario Usu);
	public boolean Editar(Usuario Usu);
}
