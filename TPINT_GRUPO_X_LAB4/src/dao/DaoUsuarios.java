package dao;

import java.util.List;

import entidad.Usuario;

public interface DaoUsuarios {

	public List<Usuario> readAll();
	public boolean insert(Usuario NUsu);
	public boolean edit (Usuario NUsu);
	public boolean logic_delete(Usuario NUsu);
	public Usuario find(Usuario NUsu);
	public boolean find_Usuario_Registrado(int x);
	public int find_Nombre_Usuario(String Nombre);
}
