package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoAlumnos;
import entidad.Alumno;

public class DaoImplAlumnos implements DaoAlumnos {

	private static final String insert = "INSERT INTO alumnos(Legajo, Dni, Nombre,Apellido,FechaNac,Direccion,Email,Telefono,IdLocalidad) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String edit = "UPDATE alumnos SET Legajo= ?,Dni= ?, Nombre= ?,Apellido= ?,FechaNac= ?,Direccion= ?,Email= ?,Telefono=?,IdLocalidad= ? WHERE IdAlumno = ?";
	private static final String logic_delete = "UPDATE alumnos SET Estado = 0 WHERE IdAlumno = ?";
	private static final String readall =  "select IdAlumno,Legajo,concat(Nombre,' ',Apellido) as Nombre,dni from Alumnos where estado = 1";
	private static final String find_Alumno = "SELECT *  FROM alumnos WHERE IdAlumno = ?";
	
	public DaoImplAlumnos()
	{
	}
	
	
	public boolean insert(Alumno NAlum)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, NAlum.getLegajo());
			statement.setString(2, NAlum.getDni());
			statement.setString(3, NAlum.getNombre());
			statement.setString(4, NAlum.getApellido());
			statement.setString(5, NAlum.getFechNac());
			statement.setString(6, NAlum.getDireccion());
			statement.setString(7, NAlum.getEmail());
			statement.setString(8, NAlum.getTelefono());
			statement.setString(9, NAlum.getLocalidad().getNombre());
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
	public boolean edit (Alumno NAlum)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isEditExistoso = false;
		try
		{
			statement = conexion.prepareStatement(edit);
			
			statement.setString(1, NAlum.getLegajo());
			statement.setString(2, NAlum.getDni());
			statement.setString(3, NAlum.getNombre());
			statement.setString(4, NAlum.getApellido());
			statement.setString(5, NAlum.getFechNac());
			statement.setString(6, NAlum.getDireccion());
			statement.setString(7, NAlum.getEmail());
			statement.setString(8, NAlum.getTelefono());
			statement.setString(9, NAlum.getLocalidad().getNombre());
			statement.setInt(10, NAlum.getIdAlumno());
			
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
	public boolean logic_delete(int x) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(logic_delete);
			statement.setInt(1, x);
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
	
	public Alumno find(int x)
	{
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isfindExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(find_Alumno);
			statement.setInt(1, x);
			resultSet = statement.executeQuery();
			if(resultSet.next())
			{
				
				if(resultSet.getInt("IdAlumno") == x)
				{
					Alumno NAlum = new Alumno();
					
					NAlum.setIdAlumno(resultSet.getInt("IdAlumno"));
					NAlum.setNombre(resultSet.getString("Nombre"));
					NAlum.setApellido(resultSet.getString("Apellido"));
					NAlum.setFechaNac(resultSet.getString("FechaNac"));
					NAlum.setDireccion(resultSet.getString("Direccion"));
					NAlum.setEmail(resultSet.getString("Email"));
					NAlum.setTelefono(resultSet.getString("Telefono"));
					NAlum.getLocalidad().setIdLocalidad(resultSet.getInt("IdLocalicad"));
					
					return NAlum;
					
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
	public List<Alumno> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet;
		List<Alumno> personas = new ArrayList<Alumno>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
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
		return personas;
	}
	
	private Alumno getPersona(ResultSet resultSet) throws SQLException
	{
		Alumno NAlum = new Alumno();
		NAlum.setIdAlumno(resultSet.getInt("IdAlumno"));
		NAlum.setLegajo(resultSet.getString("Legajo"));
		NAlum.setNombre(resultSet.getString("Nombre"));
		NAlum.setDni(resultSet.getString("Dni"));
		
		
		return NAlum;
	}

	
	
}