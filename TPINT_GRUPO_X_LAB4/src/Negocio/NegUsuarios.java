package negocio;

import entidad.Usuario;
import java.util.ArrayList;

public interface NegUsuarios {


	public ArrayList<Usuario> ListarUsuarios();
	public Usuario BuscarUsu(Usuario Usu);
	public boolean Borrar(Usuario Usu);
	public boolean Insertar(Usuario Usu);
	public boolean Editar(Usuario Usu);
}
