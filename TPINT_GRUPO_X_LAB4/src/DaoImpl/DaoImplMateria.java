package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoMateria;
import entidad.Materia;

public class DaoImplMateria implements DaoMateria {
	
private static final String readall = "SELECT IdMateria,Nombre FROM materias";
private static final String SelectId= "select materias.IdMateria from materias where Nombre = ?";
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
		finally
		{
		 Conexion.getConexion().cerrarConexion();	
		}
		return LMate;
	}
	public int getId(String NombreMateria) {

		PreparedStatement statement;
		ResultSet resultSet;
		int id = -1;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(SelectId);
			statement.setString(1, NombreMateria);
			resultSet = statement.executeQuery();
			if(resultSet.next())
			{
				id = resultSet.getInt("IdMateria");
			}

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return id;
	}
	private Materia getMateria(ResultSet resultSet) throws SQLException
	{
		Materia NMate = new Materia(); 
		NMate.setIdMateria(resultSet.getInt("IdMateria"));
		NMate.setNombre(resultSet.getString("Nombre"));


		return NMate;
	}
}
