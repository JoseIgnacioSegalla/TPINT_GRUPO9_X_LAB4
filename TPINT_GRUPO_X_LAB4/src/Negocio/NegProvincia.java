package Negocio;

import entidad.Provincia;
import java.util.List;

public interface NegProvincia {
	
	public List<Provincia> Readall();
	public Provincia Find(int x);
}
