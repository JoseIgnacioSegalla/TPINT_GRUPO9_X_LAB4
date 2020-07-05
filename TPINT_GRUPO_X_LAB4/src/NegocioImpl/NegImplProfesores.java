package NegocioImpl;

import java.util.List;

import DaoImpl.DaoImplProfesores;
import Negocio.NegProfesores;
import dao.DaoProfesores;
import entidad.Profesor;

public class NegImplProfesores implements NegProfesores {

	DaoProfesores DaoPro = new DaoImplProfesores();
	
	@Override
	public List<Profesor> ListarProfesores() {
		
		System.out.print("Neg");
		return DaoPro.readAll();
	}

	@Override
	public boolean Buscar(Profesor Pro) {
		
		return DaoPro.find(Pro);
	}

	@Override
	public boolean Borrar(Profesor Pro) {
		
		return DaoPro.logic_delete(Pro);
	}

	@Override
	public boolean Insertar(Profesor Pro) {
		
		return DaoPro.insert(Pro);
	}

	@Override
	public boolean Editar(Profesor Pro) {
		
		return DaoPro.edit(Pro);
	}

	@Override
	public Profesor ListarUno_X_Dni(int Dni) {
		
		return DaoPro.readOne(Dni);
	}



}
