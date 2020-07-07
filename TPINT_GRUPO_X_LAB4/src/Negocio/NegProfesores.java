package Negocio;

import entidad.Profesor;
import java.util.List;

public interface NegProfesores {

	public List<Profesor> ListarProfesores();
	public Profesor Buscar(int x);
	public boolean Borrar(int x);
	public boolean Insertar(Profesor Pro);
	public boolean Editar(Profesor Pro);
	
}
