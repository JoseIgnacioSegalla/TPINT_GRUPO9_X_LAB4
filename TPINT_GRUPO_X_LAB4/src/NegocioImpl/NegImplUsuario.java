package negocioImpl;

import java.util.ArrayList;
import daoImpl.DaoImplUsuarios;
import entidad.Usuario;
import negocio.NegUsuarios;

public class NegImplUsuario implements NegUsuarios {

	DaoImplUsuarios DNUsu = new DaoImplUsuarios();
	Usuario NUsu = new Usuario();
	@Override
	public ArrayList<Usuario> ListarUsuarios() {
		
		return null;
	}

	@Override
	public Usuario BuscarUsu(Usuario Usu) {
	
		return DNUsu.find(Usu);
	}

	@Override
	public boolean Borrar(Usuario Usu) {
		
		return DNUsu.logic_delete(Usu);
		
	}

	@Override
	public boolean Insertar(Usuario Usu) {
		
		return DNUsu.insert(Usu);
	}

	@Override
	public boolean Editar(Usuario Usu) {
		
		return DNUsu.edit(Usu);
	}

	
	
	
	
}
