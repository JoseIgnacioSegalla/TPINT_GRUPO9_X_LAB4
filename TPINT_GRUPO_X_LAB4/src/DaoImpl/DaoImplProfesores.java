package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoProfesores;
import entidad.Profesor;
import entidad.Usuario;

public class DaoImplProfesores implements DaoProfesores {


	private static final String insert = "INSERT INTO profesores(Legajo, Dni, Nombre,Apellido,FechaNac,Direccion,Localidad,Provincia,Email,Telefono) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String edit = "UPDATE profesores SET Legajo= ?,Dni= ?, Nombre= ?,Apellido= ?,FechaNac= ?,Direccion= ?,Email= ?,Telefono=?,IdLpcalidad = ? WHERE IdAlumno = ?";
	private static final String logic_delete = "UPDATE profesores SET Estado = 0 WHERE idprofesores = ?";
	private static final String readAll = "select p.IdProfesor as IdProfesor,Legajo,concat(p.nombre,' ',p.apellido) as Nombre,Dni,ifnull(u.IdUsuario,'') as IdUsuario,ifnull(u.nombre,'') as Usuario, ifnull(u.Clave,'') as Clave from Profesores as p\r\n" + 
			"left join usuarioxprofesor as uxp on uxp.IdProfesor = p.IdProfesor\r\n" + 
			"left join usuarios as u on u.IdUsuario = uxp.IdUsuario\r\n" + 
			"where p.estado = 1";
	private static final String readOne = "SELECT * FROM profesores where Estado = 1 AND Dni=?";
	private static final String find = "SELECT Dni FROM  WHERE idprofesores = ? AND Estado = 1";
	
	public boolean insert(Profesor NProf)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, NProf.getLegajo());
			statement.setString(2, NProf.getDni());
			statement.setString(3, NProf.getNombre());
			statement.setString(4, NProf.getApellido());
			statement.setString(5, NProf.getFechNac());
			statement.setString(6, NProf.getDireccion());
			statement.setString(7, NProf.getEmail());
			statement.setString(8, NProf.getTelefono());
			statement.setString(9, NProf.getLocalidad().getNombre());
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
	public boolean edit (Profesor NProf)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isEditExistoso = false;
		try
		{
			statement = conexion.prepareStatement(edit);
			
			statement.setString(1, NProf.getLegajo());
			statement.setString(2, NProf.getDni());
			statement.setString(3, NProf.getNombre());
			statement.setString(4, NProf.getApellido());
			statement.setString(5, NProf.getFechNac());
			statement.setString(6, NProf.getDireccion());
			statement.setString(7, NProf.getEmail());
			statement.setString(8, NProf.getTelefono());
			statement.setString(9, NProf.getLocalidad().getNombre());
			statement.setInt(10, NProf.getIdProfesor());
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
	public boolean logic_delete(Profesor NProf) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(logic_delete);
			statement.setInt(1, NProf.getIdProfesor());
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
	
	public boolean find(Profesor NProf)
	{
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isfindExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(find);
			statement.setInt(1, NProf.getIdProfesor());
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				
				if(NProf.getIdProfesor() == resultSet.getInt("IdProfesor") )
				{
					
					return true;
					
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
		return isfindExitoso;
		
	}
	
	public List<Profesor> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet;
		List<Profesor> personas = new ArrayList<Profesor>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readAll);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getProfesor(resultSet));
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
		System.out.print("Dao");
		return personas;
	}
	
	private Profesor getProfesor(ResultSet resultSet) throws SQLException
	{
		Profesor NProf = new Profesor();
		
		NProf.setIdProfesor(resultSet.getInt("IdProfesor"));
		NProf.setLegajo(resultSet.getString("Legajo"));
		NProf.setNombre(resultSet.getString("Nombre"));
		NProf.setDni(resultSet.getString("Dni"));
		NProf.getNUs().setIdUsuario(resultSet.getInt("IdUsuario"));
		NProf.getNUs().setNombre(resultSet.getString("Usuario"));
		NProf.getNUs().setClave(resultSet.getString("Clave"));

		return NProf;
	}
	@Override
	public Profesor readOne(int x) {
		PreparedStatement statement;
		ResultSet resultSet;
		
		Profesor p = new Profesor();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readOne);
			statement.setInt(1, x);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				p = getProfesor(resultSet);
				
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
		return p;
	}
}