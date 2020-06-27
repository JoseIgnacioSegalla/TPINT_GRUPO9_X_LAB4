package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Profesor;

public class DaoImplProfesores {


	private static final String insert = "INSERT INTO profesores(Legajo, Dni, Nombre,Apellido,FechaNac,Direccion,Localidad,Provincia,Email,Telefono) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String edit = "UPDATE profesores SET Legajo= ?,Dni= ?, Nombre= ?,Apellido= ?,FechaNac= ?,Direccion= ?,Email= ?,Telefono=?,IdLpcalidad = ? WHERE IdAlumno = ?";
	private static final String logic_delete = "UPDATE profesores SET Estado = 0 WHERE IdAlumno = ?";
	private static final String readall = "SELECT * FROM profesores where Estado = 1";
	private static final String find = "SELECT Dni FROM  WHERE IdAlumno = ? AND Estado = 1";
	
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
			statement.setInt(9, NProf.getLocalidad().getIdLocalidad());
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
			statement.setInt(9, NProf.getLocalidad().getIdLocalidad());
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
		return isfindExitoso;
		
	}
	public List<Profesor> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Profesor> personas = new ArrayList<Profesor>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
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
		return personas;
	}
	
	private Profesor getProfesor(ResultSet resultSet) throws SQLException
	{
		Profesor NProf = new Profesor(); 
		NProf.setLegajo(resultSet.getString("a.Legajo"));
		NProf.setDni(resultSet.getString("a.Dni"));
		NProf.setNombre(resultSet.getString("a.Nombre"));
		NProf.setApellido(resultSet.getString("a.Apellido"));
		NProf.setFechaNac(resultSet.getString("a.FechaNac"));
		NProf.setDireccion(resultSet.getString("a.Direccion"));
		NProf.setEmail(resultSet.getString("a.Email"));
		NProf.setTelefono(resultSet.getString("a.Telefono"));
		NProf.getLocalidad().setNombre(resultSet.getString("l.Nombre"));
		
	
		return NProf;
	}
}