package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoProvincia;
import entidad.Provincia;

public class DaoImplProvincia implements DaoProvincia {
private static final String readall = "SELECT IdProvincia,Nombre FROM provincias";

	
	
	public List<Provincia> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Provincia> LProv = new ArrayList<Provincia>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				LProv.add(getPersona(resultSet));
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
		return LProv;
	}

	private Provincia getPersona(ResultSet resultSet) throws SQLException
	{
		Provincia NProv = new Provincia(); 
		NProv.setIdProvincia(resultSet.getInt("IdProvincia"));
		NProv.setNombre(resultSet.getString("Nombre"));


		return NProv;
	}

} 

