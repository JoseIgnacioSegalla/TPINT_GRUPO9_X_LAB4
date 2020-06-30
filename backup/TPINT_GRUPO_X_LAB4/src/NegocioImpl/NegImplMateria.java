package NegocioImpl;

import java.util.ArrayList;

import DaoImpl.DaoImplMateria;
import Negocio.NegMateria;
import dao.DaoMateria;
import entidad.Materia;

public class NegImplMateria implements NegMateria {
	
	private DaoMateria DaoMat = new DaoImplMateria();
	
	@Override
	public ArrayList<Materia> ListarTodos() {
		
		return (ArrayList<Materia>) DaoMat.readAll();
	}

	
}
