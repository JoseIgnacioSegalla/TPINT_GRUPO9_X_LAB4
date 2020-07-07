package Negocio;

import entidad.Usuario;
import java.util.List;

public interface NegUsuarios {


	public List<Usuario> ListarUsuarios();
	public Usuario BuscarUsu(Usuario Usu);
	public int BuscarUsuReg(int IdProfesor);
	public int BuscarNombreUsu(String Nombre);
	public boolean Borrar(Usuario Usu);
	public boolean Insertar(Usuario Usu);
	public boolean Insertar_usuario_x_profesor(int IdUsuario,int IdProfesor);
	public boolean Editar(Usuario Usu);
}
