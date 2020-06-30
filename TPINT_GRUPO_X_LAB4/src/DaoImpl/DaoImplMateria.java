package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entidad.Materia;

public class DaoImplMateria {
	
private static final String readall = "SELECT IdMateria,Nombre FROM materias";
	
	public List<Materia> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Materia> LMate = new ArrayList<Materia>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				LMate.add(getMateria(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return LMate;
	}

	private Materia getMateria(ResultSet resultSet) throws SQLException
	{
		Materia NMate = new Materia(); 
		NMate.setIdMateria(resultSet.getInt("IdMateria"));
		NMate.setNombre(resultSet.getString("Nombre"));


		return NMate;
	}
}
