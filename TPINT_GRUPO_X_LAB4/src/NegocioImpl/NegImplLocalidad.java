package NegocioImpl;

import Negocio.NegLocalidad;
import entidad.Localidad;
import DaoImpl.DaoImplLocalidad;
import java.util.ArrayList;
public class NegImplLocalidad implements NegLocalidad{

	private DaoImplLocalidad DaoLoc = new DaoImplLocalidad();
	DaoImplLocalidad DILoc = new DaoImplLocalidad();
	Localidad loc = new Localidad();
	
	@Override
	public ArrayList<Localidad> readAll(int x) {
		
		return (ArrayList<Localidad>)DaoLoc.readAll(x);
	}
	
}
