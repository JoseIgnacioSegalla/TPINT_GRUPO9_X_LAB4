package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoCurso;
import entidad.Alumno;
import entidad.Curso;
import entidad.Materia;
import entidad.Profesor;

public class DaoImplCurso implements DaoCurso {

	private static final String insert = "INSERT INTO cursos(IdMateria,IdProfesor,Cuatrimestre,Año) VALUES(?, ?, ?, ?)";
	private static final String edit = "UPDATE cursos SET IdMateria= ?,IdProfesor= ?, Cuatrimestre= ?,Año= ? WHERE IdCurso  = ?";
	private static final String delete = "DELETE FROM cursos WHERE IdCurso= ?";
	private static final String logic_delete = "UPDATE cursos SET Estado = 0 WHERE IdCurso = ?";
	private static final String readall_Cursos = "select c.IdCurso as IdCurso, m.Nombre as Materia,c.Cuatrimestre as Cuatrimestre,c.Año,c.IdProfesor as IdProfesor, concat(p.nombre,' ',p.apellido) as Profesor,p.legajo as Legajo,p.dni as dni from Cursos as c \r\n" + 
			"inner join materias as m on m.IdMateria = c.IdMateria \r\n" + 
			"inner join profesores as p on p.IdProfesor = c.IdProfesor\r\n" + 
			"where c.Estado = 1";
	
	private static final String readall_Cursos_X_Profesor = "select c.IdCurso as IdCurso, m.Nombre as Materia,c.Cuatrimestre as Cuatrimestre,c.Año,c.IdProfesor as IdProfesor, concat(p.nombre,' ',p.apellido) as Profesor,p.legajo as Legajo,p.dni as dni from Cursos as c\r\n" + 
			"inner join materias as m on m.IdMateria = c.IdMateria \r\n" + 
			"inner join profesores as p on p.IdProfesor = c.IdProfesor\r\n" + 
			"where  p.IdProfesor = ? and c.Estado = 1";
	
	private static final String readall_Cursos_Nombre = "select materias.Nombre, cursos.Cuatrimestre,cursos.Año,profesores.Nombre AS 'pNombre',"
			+ "cursos.IdCurso from cursos inner join materias on materias.IdMateria = cursos.IdMateria  "
			+ "inner join profesores on profesores.IdProfesor = cursos.IdProfesor where cursos.Estado =1";
	
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
		finally
		{
		 Conexion.getConexion().cerrarConexion();	
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
		finally
		{
		 Conexion.getConexion().cerrarConexion();	
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
		finally
		{
		 Conexion.getConexion().cerrarConexion();	
		}
		return isfindExitoso;
		
	}
	public List<Curso> readAll_Cursos_x_Profesor(int x){
		
		PreparedStatement statement;
		ResultSet resultSet;
		List<Curso> LCursos = new ArrayList<Curso>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall_Cursos_X_Profesor);
			statement.setInt(1,x );
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				LCursos.add(getCurso(resultSet));
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
		return LCursos;
	}
	public List<Curso> readAll_Cursos()
	{
		PreparedStatement statement;
		ResultSet resultSet;
		List<Curso> Cursos = new ArrayList<Curso>();
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
		finally
		{
		 Conexion.getConexion().cerrarConexion();	
		}
		return Cursos;
	}
	
	private Curso getCurso(ResultSet resultSet) throws SQLException
	{
		Curso NCurso = new Curso();
		
		NCurso.setIdNumCurso(resultSet.getInt("IdCurso"));
		NCurso.getNMateria().setNombre(resultSet.getString("Materia"));
		NCurso.setCuatrimestre(resultSet.getString("Cuatrimestre"));
		NCurso.setAño(resultSet.getString("Año"));	
		NCurso.getNProfesor().setIdProfesor(resultSet.getInt("IdProfesor"));
		NCurso.getNProfesor().setNombre(resultSet.getString("Profesor"));
		NCurso.getNProfesor().setLegajo(resultSet.getString("Legajo"));
		NCurso.getNProfesor().setDni(resultSet.getString("dni"));
		
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
		finally
		{
		 Conexion.getConexion().cerrarConexion();	
		}
		return AlumnosXCurso;
	
	}
	
	
	private Alumno getAlumnosxCurso(ResultSet resultSet) throws SQLException
	{
		
		Alumno NAlumno = new Alumno();
		
		NAlumno.getNombre();
		
		
		return NAlumno;
	}
	
	@Override
	public List<Curso> readAll_Cursos_Nombres(){
		
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Curso> Cursos = new ArrayList<Curso>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall_Cursos_Nombre);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Cursos.add(getCurso_Nombre(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
			conexion.cerrarConexion();
	
		return Cursos;
	}
	
	
	private Curso getCurso_Nombre(ResultSet resultSet) throws SQLException
	{
		Curso NCurso = new Curso(); 
		Profesor p = new Profesor();
		Materia m = new Materia();
		
		NCurso.setIdNumCurso(resultSet.getInt("IdCurso"));
		m.setNombre(resultSet.getString("Nombre"));
		p.setNombre(resultSet.getString("pNombre"));
		NCurso.setCuatrimestre(resultSet.getString("Cuatrimestre"));
		NCurso.setAño(resultSet.getString("Año"));
		NCurso.setNMateria(m);
		NCurso.setNProfesor(p);
		return NCurso;
	}
}
