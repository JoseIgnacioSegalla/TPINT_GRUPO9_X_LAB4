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
	
	private static final String insert = "INSERT INTO usuarios(Nombre, Clave) VALUES(?,?)";
	private static final String insert_usuario_x_profesor = "INSERT INTO usuarioxprofesor(IdUsuario,IdProfesor) VALUES(?,?)";
	private static final String edit = "UPDATE usuarios SET Nombre= ?,Clave= ? WHERE IdUsuario= ?";
	private static final String logic_delete = "UPDATE usuarios SET Estado = 0 WHERE IdUsuario= ?";
	private static final String readall = "SELECT * FROM usuarios where Estado = 1";
	private static final String find_Usuario_Registrado = "SELECT IdUsuario FROM usuarioxprofesor WHERE IdProfesor = ?";
	private static final String find_Usuario = "SELECT IdProfesor from usuarioxprofesor as uxp\r\n" + 
			"inner join usuarios as u on u.IdUsuario = uxp.IdUsuario\r\n" + 
			"where u.nombre = ? and u.Estado = 1";
	private static final String  find = "select IdUsuario,tipo from usuarios\r\n" + 
			"where nombre = ? and clave = ? and Estado = 1";
	
	
	
	public boolean insert_usuario_x_profesor(int IdUsuario,int IdProfesor) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert_usuario_x_profesor);
			statement.setInt(1, IdUsuario);
			statement.setInt(2, IdProfesor);
			
			
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
		finally
		{
		 Conexion.getConexion().cerrarConexion();	
		}
		
		return isInsertExitoso;
	}
	
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
		finally
		{
		 Conexion.getConexion().cerrarConexion();	
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
			System.out.print(NUsu.getNombre());
			System.out.print(NUsu.getClave());
			statement.setString(1, NUsu.getNombre());
			statement.setString(2, NUsu.getClave());
			statement.setInt(3, NUsu.getIdUsuario());
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
		finally
		{
		 Conexion.getConexion().cerrarConexion();	
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
		finally
		{
		 Conexion.getConexion().cerrarConexion();	
		}
		return isdeleteExitoso;
	}
	
	public int find_Usuario_Registrado(int x)
	{
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try 
		{
			statement = conexion.prepareStatement(find_Usuario_Registrado);
			statement.setInt(1, x);
			
			resultSet = statement.executeQuery();
			if(resultSet.next())
			{
				
				if(resultSet.getInt("IdUsuario") > 1)
				{
					
				
					return resultSet.getInt("IdUsuario");
					
				}
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
		return 0;
		
	}
	public int find_Nombre_Usuario(String Nombre)
	{
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try 
		{
			statement = conexion.prepareStatement(find_Usuario);
			statement.setString(1, Nombre);
	
			resultSet = statement.executeQuery();
			if(resultSet.next())
			{
				
				if(resultSet.getInt("IdProfesor") > 0)
				{
					
					
					return resultSet.getInt("IdProfesor");
					
				}
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
		return 0;
		
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
		finally
		{
		 Conexion.getConexion().cerrarConexion();	
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

	@Override
	public Usuario find(Usuario NUsu) {
		
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Usuario NUs = new Usuario();
		try 
		{
			statement = conexion.prepareStatement(find);
	
			statement.setString(1, NUsu.getNombre());
			statement.setString(2, NUsu.getClave());
	
			resultSet = statement.executeQuery();
			if(resultSet.next())
			{
				
				if(resultSet.getInt("IdUsuario") > 0)
				{
					
					NUs.setIdUsuario(resultSet.getInt("IdUsuario"));
					NUs.setNombre(NUsu.getNombre());
					NUs.setTipo(resultSet.getBoolean("Tipo"));
					return NUs;
					
				}
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
		return null;
	}
}
