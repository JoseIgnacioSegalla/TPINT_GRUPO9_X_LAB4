package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Alumno;

public class DaoAlumnos {

	private static final String insert = "INSERT INTO alumnos(Legajo, Dni, Nombre,Apellido,FechaNac,Direccion,Localidad,Provincia,Email,Telefono) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String edit = "UPDATE alumnos SET Legajo= ?,Dni= ?, Nombre= ?,Apellido= ?,FechaNac= ?,Direccion= ?,Localidad= ?,Provincia= ?,Email= ?,Telefono=? WHERE IdAlumno = ?";
	private static final String delete = "DELETE FROM alumnos WHERE IdAlumno= ?";
	private static final String logic_delete = "UPDATE alumnos SET Estado = 0 WHERE IdAlumno = ?";
	private static final String readall = "SELECT * FROM alumnos where Estado = 1";
	private static final String find = "SELECT Dni FROM alumnos WHERE IdAlumno = ? AND Estado = 1";
	
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
			statement.setString(7, NAlum.getLocalidad());
			statement.setString(8, NAlum.getProvincia());
			statement.setString(9, NAlum.getEmail());
			statement.setString(10, NAlum.getTelefono());
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
			statement.setString(7, NAlum.getLocalidad());
			statement.setString(8, NAlum.getProvincia());
			statement.setString(9, NAlum.getEmail());
			statement.setString(10, NAlum.getTelefono());
			statement.setInt(11, NAlum.getIdAlumno());
			
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
	public boolean logic_delete(Alumno NAlum) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(logic_delete);
			statement.setInt(1, NAlum.getIdAlumno());
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
	
	public boolean delete(Alumno NAlum)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, NAlum.getIdAlumno());
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
	public boolean find(Alumno NAlum)
	{
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isfindExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(find);
			statement.setInt(1, NAlum.getIdAlumno());
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				
				if(NAlum.getIdAlumno() == resultSet.getInt("IdAlumno") )
				{
					
					return true;
					
				}
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isfindExitoso;
		
	}
	public List<Alumno> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Alumno> personas = new ArrayList<Alumno>();
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
		return personas;
	}
	
	private Alumno getPersona(ResultSet resultSet) throws SQLException
	{
		Alumno NAlum = new Alumno(); 
		NAlum.setIdAlumno(resultSet.getInt("IdAlumno"));
		NAlum.setLegajo(resultSet.getString("Legajo"));
		NAlum.setDni(resultSet.getString("Dni"));
		NAlum.setNombre(resultSet.getString("Nombre"));
		NAlum.setApellido(resultSet.getString("Apellido"));
		NAlum.setFechaNac(resultSet.getString("FechaNac"));
		NAlum.setDireccion(resultSet.getString("Direccion"));
		NAlum.setLocalidad(resultSet.getString("Localidad"));
		NAlum.setProvincia(resultSet.getString("Provincia"));
		NAlum.setEmail(resultSet.getString("Email"));
		NAlum.setTelefono(resultSet.getString("Telefono"));
		
	
		return NAlum;
	}
	
}
