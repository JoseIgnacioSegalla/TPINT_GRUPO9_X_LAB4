package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Alumno;
import entidad.Curso;

public class DaoCurso {

	private static final String insert = "INSERT INTO cursos(IdMateria,IdProfesor,Cuatrimestre,Año) VALUES(?, ?, ?, ?)";
	private static final String edit = "UPDATE cursos SET IdMateria= ?,IdProfesor= ?, Cuatrimestre= ?,Año= ? WHERE IdCurso  = ?";
	private static final String delete = "DELETE FROM cursos WHERE IdCurso= ?";
	private static final String logic_delete = "UPDATE cursos SET Estado = 0 WHERE IdCurso = ?";
	private static final String readall_Cursos = "select m.Nombre as Materia,c.Cuatrimestre,c.Año from Cursos as c\r\n" + 
			"inner join materias as m on m.IdMateria = c.IdMateria where c.Estado = 1";
	private static final String readall_Alumnos_x_Curso = "SELECT * FROM cursos where Estado = 1";
	private static final String find = "select a.Legajo,concat(a.nombre,' ',a.Apellido) as \"Nombre y Apellido\",a.Dni,c.EstadoAlumno from alumnos as a\r\n" + 
			"inner join alumnosxcurso as c on c.IdAlumno = a.IdAlumno\r\n" + 
			"where Idcurso = ? AND Estado = 1";
	
	public boolean insert(Curso NCurs)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, NCurs.getNMateria().getIdMateria());
			statement.setInt(2, NCurs.getNProfesor().getIdProfesor());
			statement.setString(3, NCurs.getCuatrimestre());
			statement.setString(4, NCurs.getAño());
	
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
	public boolean edit (Curso NCurs)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isEditExistoso = false;
		try
		{
			statement = conexion.prepareStatement(edit);
			
			statement.setInt(1, NCurs.getNMateria().getIdMateria());
			statement.setInt(2, NCurs.getNProfesor().getIdProfesor());
			statement.setString(3, NCurs.getCuatrimestre());
			statement.setString(4, NCurs.getAño());

			
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
	public boolean logic_delete(Curso NCurs) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(logic_delete);
			statement.setInt(1, NCurs.getIdNumCurso());
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
	
	public boolean delete(Curso NCurso)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, NCurso.getIdNumCurso());
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
	public boolean find(Curso NCurso)
	{
		PreparedStatement statement;
		ResultSet resultSet;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isfindExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(find);
			statement.setInt(1, NCurso.getIdNumCurso());
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				
				if(NCurso.getIdNumCurso() == resultSet.getInt("IdCurso") )
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
	public List<Curso> readAll_Cursos()
	{
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Curso> Cursos = new ArrayList<Curso>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall_Cursos);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Cursos.add(getCurso(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return Cursos;
	}
	
	private Curso getCurso(ResultSet resultSet) throws SQLException
	{
		Curso NCurso = new Curso(); 
		NCurso.setIdNumCurso(resultSet.getInt("IdCurso"));
		NCurso.getNMateria().setIdMateria(resultSet.getInt("IdMateria"));
		NCurso.getNProfesor().setIdProfesor(resultSet.getInt("IdProfesor"));
		NCurso.setCuatrimestre(resultSet.getString("Cuatrimestre"));
		NCurso.setAño(resultSet.getString("Año"));

		return NCurso;
	}
	
	public List<Alumno> readAll_AlumnosxCurso()
	{
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Alumno> AlumnosXCurso = new ArrayList<Alumno>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall_Alumnos_x_Curso);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				AlumnosXCurso.add(getAlumnosxCurso(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return Cursos;
	
	}
	
	
	private Alumno getAlumnosxCurso(ResultSet resultSet) throws SQLException
	{
		
		Alumno NAlumno = new Alumno();
		
		NAlumno.getNombre();
		
		
		return NAlumno;
	}
}
