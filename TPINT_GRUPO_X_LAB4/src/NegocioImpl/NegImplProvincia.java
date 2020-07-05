package NegocioImpl;

import java.util.List;

import DaoImpl.DaoImplProvincia;
import Negocio.NegProvincia;
import dao.DaoProvincia;
import entidad.Provincia;

public class NegImplProvincia implements NegProvincia{

	private DaoProvincia DaoPro = new DaoImplProvincia();
	@Override
	public List<Provincia> Readall() {
		
		return DaoPro.readAll();
	}
	@Override
	public Provincia Find(int x) {
		// TODO Auto-generated method stub
		return null;
	}

}
