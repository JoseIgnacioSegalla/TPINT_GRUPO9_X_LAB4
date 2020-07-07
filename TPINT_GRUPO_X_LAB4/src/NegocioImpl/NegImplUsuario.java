package NegocioImpl;

import java.util.List;
import DaoImpl.DaoImplUsuarios;
import entidad.Usuario;
import Negocio.NegUsuarios;

public class NegImplUsuario implements NegUsuarios {


	DaoImplUsuarios DNUsu = new DaoImplUsuarios();
	
	Usuario NUsu = new Usuario();
	@Override
	public List<Usuario> ListarUsuarios() {
		
		return  DNUsu.readAll();
	}

	public int BuscarUsuReg(int IdProfesor){
		
		return DNUsu.find_Usuario_Registrado(IdProfesor);
	}
	

	@Override
	public int BuscarNombreUsu(String Nombre) {
		
		return DNUsu.find_Nombre_Usuario(Nombre);
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

	@Override
	public boolean Insertar_usuario_x_profesor(int IdUsuario, int IdProfesor) {
		
		return DNUsu.insert_usuario_x_profesor(IdUsuario, IdProfesor);
	}



	
	
	
	
}
