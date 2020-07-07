package NegocioImpl;

import java.util.List;

import DaoImpl.DaoImplProfesores;
import Negocio.NegProfesores;
import entidad.Profesor;

public class NegImplProfesores implements NegProfesores {

	DaoImplProfesores DaoPro = new DaoImplProfesores();
	
	@Override
	public List<Profesor> ListarProfesores() {
		
		
		return DaoPro.readAll();
	}

	@Override
	public Profesor Buscar(int i) {
		
		return DaoPro.find(i);
	}

	@Override
	public boolean Borrar(int i) {
		
		return DaoPro.logic_delete(i);
	}

	@Override
	public boolean Insertar(Profesor Pro) {
		
		return DaoPro.insert(Pro);
	}

	@Override
	public boolean Editar(Profesor Pro) {
		
		return DaoPro.edit(Pro);
	}



}
