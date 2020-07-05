package NegocioImpl;

import Negocio.NegLocalidad;
import entidad.Localidad;
import DaoImpl.DaoImplLocalidad;
import java.util.ArrayList;
import java.util.List;
public class NegImplLocalidad implements NegLocalidad{

	private DaoImplLocalidad DaoLoc = new DaoImplLocalidad();
	Localidad loc = new Localidad();
	
	@Override

	public List<Localidad> readAll() {
	
		return DaoLoc.readAll();
	}

	@Override
	public Localidad Find() {
	
		return null;
	}
	
}
