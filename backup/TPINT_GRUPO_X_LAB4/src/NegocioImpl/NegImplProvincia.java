package NegocioImpl;

import java.util.ArrayList;

import DaoImpl.DaoImplProvincia;
import Negocio.NegProvincia;
import dao.DaoProvincia;
import entidad.Provincia;

public class NegImplProvincia implements NegProvincia{

	private DaoProvincia DaoPro = new DaoImplProvincia();
	@Override
	public ArrayList<Provincia> Readall() {
		
		return (ArrayList<Provincia>) DaoPro.readAll();
	}

}
