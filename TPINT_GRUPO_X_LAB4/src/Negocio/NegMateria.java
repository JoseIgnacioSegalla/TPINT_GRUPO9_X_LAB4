package Negocio;

import entidad.Materia;
import java.util.List;

public interface NegMateria {
	
	public List<Materia> ListarTodos();
	
	public int getIdMateria(String NombreMateria);
	
}
