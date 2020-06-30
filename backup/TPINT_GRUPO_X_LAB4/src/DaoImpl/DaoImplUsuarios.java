package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoUsuarios;
import entidad.Usuario;

public class DaoImplUsuarios implements DaoUsuarios {
	
	private static final String insert = "INSERT INTO usuarios(Nombre, Clave,Tipo) VALUES(?, ?, ?)";
	private static final String edit = "UPDATE usuarios SET Nombre= ?,Clave= ?, Tipo= ?,Estado= ? WHERE IdUsuario= ?";
	private static final String logic_delete = "UPDATE usuarios SET Estado = 0 WHERE IdUsuarios= ?";
	private static final String readall = "SELECT * FROM usuarios where Estado = 1";
	private static final String find = "SELECT IdUsuario,Tipo FROM usuarios WHERE Nombre= ? AND Clave=? AND Estado = 1";
	
	public boolean insert(Usuario NUsu)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, NUsu.getNombre());
			statement.setString(2, NUsu.getClave());
			statement.setBoolean(3, NUsu.getTipo());
			
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	public boolean edit (Usuario NUsu)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isEditExistoso = false;
		try
		{
			statement = conexion.prepareStatement(edit);
			
			statement.setString(1, NUsu.getNombre());
			statement.setString(2, NUsu.getClave());
			statement.setBoolean(3, NUsu.getTipo());
			statement.setInt(4, NUsu.getIdUsuario());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isEditExistoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return isEditExistoso;
	}
	public boolean logic_delete(Usuario NUsu) 
	{
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(logic_delete);
			statement.setInt(1, NUsu.getIdUsuario());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public Usuario find(Usuario NUsu)
	{
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try 
		{
			statement = conexion.prepareStatement(find);
			statement.setString(1, NUsu.getNombre());
			statement.setString(2, NUsu.getClave());
			
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				
				if(resultSet.getInt("IdUsuario") > 0)
				{
					NUsu.setIdUsuario(resultSet.getInt("IdUsuario"));
					NUsu.setTipo(resultSet.getBoolean("Tipo"));
					return NUsu;
					
				}
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return NUsu;
		
	}
	public List<Usuario> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Usuario> LUsu = new ArrayList<Usuario>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				LUsu.add(getUsuario(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return LUsu;
	}
	
	private Usuario getUsuario(ResultSet resultSet) throws SQLException
	{
		Usuario NUsu = new Usuario(); 
		NUsu.setIdUsuario(resultSet.getInt("IdUsuario"));
		NUsu.setNombre(resultSet.getString("Nombre"));
		NUsu.setClave(resultSet.getString("Clave"));
		NUsu.setTipo(resultSet.getBoolean("Tipo"));
		
		
	
		return NUsu;
	}
}
