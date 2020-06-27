package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Alumno;

public class DaoAlumnos {

	private static final String insert = "INSERT INTO alumnos(Legajo, Dni, Nombre,Apellido,FechaNac,Direccion,Email,Telefono,IdLocalidad) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String edit = "UPDATE alumnos SET Legajo= ?,Dni= ?, Nombre= ?,Apellido= ?,FechaNac= ?,Direccion= ?,Email= ?,Telefono=?,IdLocalidad= ? WHERE IdAlumno = ?";
	private static final String logic_delete = "UPDATE alumnos SET Estado = 0 WHERE IdAlumno = ?";
	private static final String readall =  "SELECT a.Legajo,a.Dni,a.Nombre,a.Apellido,a.FechaNac,a.Direccion,a.Email,a.Telefono,l.Nombre FROM alumnos as a inner join localidades as l on l.IdLocalidad = a.IdLocalidad where Estado = 1";
	private static final String find_Alumno = "SELECT Dni FROM alumnos WHERE IdAlumno = ? AND Estado = 1";
	
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
			statement.setInt(9, NAlum.getLocalidad().getIdLocalidad());
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
			statement.setString(7, NAlum.getEmail());
			statement.setString(8, NAlum.getTelefono());
			statement.setInt(9, NAlum.getLocalidad().getIdLocalidad());
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
	
	public boolean find(Alumno NAlum)
	{
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isfindExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(find_Alumno);
			statement.setInt(1, NAlum.getIdAlumno());
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				
				if(NAlum.getIdAlumno() == resultSet.getInt("IdAlumno"))
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
		NAlum.setLegajo(resultSet.getString("a.Legajo"));
		NAlum.setDni(resultSet.getString("a.Dni"));
		NAlum.setNombre(resultSet.getString("a.Nombre"));
		NAlum.setApellido(resultSet.getString("a.Apellido"));
		NAlum.setFechaNac(resultSet.getString("a.FechaNac"));
		NAlum.setDireccion(resultSet.getString("a.Direccion"));
		NAlum.setEmail(resultSet.getString("a.Email"));
		NAlum.setTelefono(resultSet.getString("a.Telefono"));
		NAlum.getLocalidad().setNombre(resultSet.getString("l.Nombre"));
	
		return NAlum;
	}
	
}
