package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Localidad;

public class DaoLocalidad {

	
private static final String readall_Localidad_x_Provincia = "SELECT IdLocalidad,Nombre FROM Localidad where IdProvincia = ?";

	
	
	public List<Localidad> readAll(int x)
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Localidad> LLocal = new ArrayList<Localidad>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall_Localidad_x_Provincia);
			statement.setInt(1, x);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				LLocal.add(getLocalidad(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return LLocal;
	}

	private Localidad getLocalidad(ResultSet resultSet) throws SQLException
	{
		Localidad NLocal= new Localidad(); 
		NLocal.setIdProvincia(resultSet.getInt("IdLocalidad"));
		NLocal.setNombre(resultSet.getString("Nombre"));


		return NLocal;
	}
}
