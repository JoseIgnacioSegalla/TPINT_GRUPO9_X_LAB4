package NegocioImpl;

import java.util.ArrayList;
import DaoImpl.DaoImplUsuarios;
import entidad.Usuario;
import Negocio.NegUsuarios;
import dao.DaoUsuarios;

public class NegImplUsuario implements NegUsuarios {

	private DaoUsuarios DaoUs = new DaoImplUsuarios();
	DaoImplUsuarios DNUsu = new DaoImplUsuarios();
	
	Usuario NUsu = new Usuario();
	@Override
	public ArrayList<Usuario> ListarUsuarios() {
		
		return (ArrayList<Usuario>) DaoUs.readAll();
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
