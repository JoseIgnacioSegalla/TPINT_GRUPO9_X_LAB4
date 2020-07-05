package Negocio;

import entidad.Profesor;
import java.util.List;

public interface NegProfesores {

	public List<Profesor> ListarProfesores();
	public Profesor ListarUno_X_Dni(int Dni);
	public boolean Buscar(Profesor Pro);
	public boolean Borrar(Profesor Pro);
	public boolean Insertar(Profesor Pro);
	public boolean Editar(Profesor Pro);
	
}
