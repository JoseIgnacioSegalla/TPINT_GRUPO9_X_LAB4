package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NegocioImpl.NegImplAlumno;
import NegocioImpl.NegImplCursos;
import NegocioImpl.NegImplLocalidad;
import NegocioImpl.NegImplProfesores;
import NegocioImpl.NegImplProvincia;
import NegocioImpl.NegImplUsuario;
import entidad.Alumno;
import entidad.Curso;
import entidad.Localidad;
import entidad.Profesor;
import entidad.Provincia;

@WebServlet("/ServletPerfil")
public class ServletPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		//MENU PROFESOR
		if(request.getParameter("VerPerfilProfesor") != null) {
			NegImplUsuario NegUs = new NegImplUsuario();
			NegImplProfesores NegProf = new NegImplProfesores();
			Profesor NProf = new Profesor();
			NProf  = NegProf.Buscar(NegUs.BuscarNombreUsu(request.getParameter("VerPerfilProfesor")));
			
			if(NProf != null) {
			
			request.setAttribute("Tipo", "0");
			request.setAttribute("IdProfesor", NProf.getIdProfesor());
			request.setAttribute("Legajo",NProf.getLegajo());
			request.setAttribute("Dni",NProf.getDni());
			request.setAttribute("Nombre", NProf.getNombre());
			request.setAttribute("Apellido",NProf.getApellido());
			request.setAttribute("FechaNac",NProf.getFechNac());
			request.setAttribute("Direccion",NProf.getDireccion());
			request.setAttribute("Email",NProf.getEmail());
			request.setAttribute("Telefono",NProf.getTelefono());
	
			
			NegImplProvincia NegProv = new NegImplProvincia();
			
			List<Provincia> LProvincia = NegProv.Readall();
		
			request.setAttribute("Provincia", LProvincia);	
			request.setAttribute("IdProvincia", NProf.getProvincia().getIdProvincia());
			
			
		
			NegImplLocalidad NegLoc = new NegImplLocalidad();
	
			List<Localidad> LLocalidad = NegLoc.Find(NProf.getProvincia().getIdProvincia());
			
			request.setAttribute("Localidad", LLocalidad);
			request.setAttribute("IdLocalidad", NProf.getLocalidad().getIdLocalidad());
			
			
			RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
			rd.include(request, response);
			
		}
			
		}
		
		
		
		if(request.getParameter("VerPerfilAlumno") != null) {
			
			NegImplAlumno NegAlum = new NegImplAlumno();
			Alumno NAlum = new Alumno();
			NAlum  = NegAlum.Buscar(Integer.parseInt(request.getParameter("VerPerfilAlumno")));
			
		if(NAlum != null) {
			
			request.setAttribute("Tipo", "0");
			request.setAttribute("IdAlumno", NAlum.getIdAlumno());
			request.setAttribute("Legajo",NAlum.getLegajo());
			request.setAttribute("Dni",NAlum.getDni());
			request.setAttribute("Nombre", NAlum.getNombre());
			request.setAttribute("Apellido",NAlum.getApellido());
			request.setAttribute("FechaNac",NAlum.getFechNac());
			request.setAttribute("Direccion",NAlum.getDireccion());
			request.setAttribute("Email",NAlum.getEmail());
			request.setAttribute("Telefono",NAlum.getTelefono());
	
			
			NegImplProvincia NegProv = new NegImplProvincia();
			
			List<Provincia> LProvincia = NegProv.Readall();
		
			request.setAttribute("Provincia", LProvincia);	
			request.setAttribute("IdProvincia", NAlum.getProvincia().getIdProvincia());
			
			
		
			NegImplLocalidad NegLoc = new NegImplLocalidad();
	
			List<Localidad> LLocalidad = NegLoc.Find(NAlum.getProvincia().getIdProvincia());
			
			request.setAttribute("Localidad", LLocalidad);
			request.setAttribute("IdLocalidad", NAlum.getLocalidad().getIdLocalidad());
			
			
			RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
			rd.include(request, response);
			
			
			}
			
		}
		
		//MENU ADMINISTRADOR
		if(request.getParameter("VerAlumno") != null) {
		
			NegImplAlumno NegAlum = new NegImplAlumno();
			Alumno NAlum = new Alumno();
			NAlum  = NegAlum.Buscar(Integer.parseInt(request.getParameter("VerAlumno")));
			
		if(NAlum != null) {
			
			request.setAttribute("Tipo", "1");
			request.setAttribute("IdAlumno", NAlum.getIdAlumno());
			request.setAttribute("Legajo",NAlum.getLegajo());
			request.setAttribute("Dni",NAlum.getDni());
			request.setAttribute("Nombre", NAlum.getNombre());
			request.setAttribute("Apellido",NAlum.getApellido());
			request.setAttribute("FechaNac",NAlum.getFechNac());
			request.setAttribute("Direccion",NAlum.getDireccion());
			request.setAttribute("Email",NAlum.getEmail());
			request.setAttribute("Telefono",NAlum.getTelefono());
	
			
			NegImplProvincia NegProv = new NegImplProvincia();
			
			List<Provincia> LProvincia = NegProv.Readall();
		
			request.setAttribute("Provincia", LProvincia);	
			request.setAttribute("IdProvincia", NAlum.getProvincia().getIdProvincia());
			
			
		
			NegImplLocalidad NegLoc = new NegImplLocalidad();
	
			List<Localidad> LLocalidad = NegLoc.Find(NAlum.getProvincia().getIdProvincia());
			
			request.setAttribute("Localidad", LLocalidad);
			request.setAttribute("IdLocalidad", NAlum.getLocalidad().getIdLocalidad());
			
			
			RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
			rd.include(request, response);
			
			
			}
			
		}
		
		if(request.getParameter("VerProfesor") != null) {
			
			NegImplProfesores NegProf = new NegImplProfesores();
			Profesor NProf = new Profesor();
			NProf  = NegProf.Buscar(Integer.parseInt(request.getParameter("VerProfesor").trim()));
			
			if(NProf != null) {
			
			request.setAttribute("Tipo", "1");
			request.setAttribute("IdProfesor", NProf.getIdProfesor());
			request.setAttribute("Legajo",NProf.getLegajo());
			request.setAttribute("Dni",NProf.getDni());
			request.setAttribute("Nombre", NProf.getNombre());
			request.setAttribute("Apellido",NProf.getApellido());
			request.setAttribute("FechaNac",NProf.getFechNac());
			request.setAttribute("Direccion",NProf.getDireccion());
			request.setAttribute("Email",NProf.getEmail());
			request.setAttribute("Telefono",NProf.getTelefono());
	
			
			NegImplProvincia NegProv = new NegImplProvincia();
			
			List<Provincia> LProvincia = NegProv.Readall();
		
			request.setAttribute("Provincia", LProvincia);	
			request.setAttribute("IdProvincia", NProf.getProvincia().getIdProvincia());
			
			
		
			NegImplLocalidad NegLoc = new NegImplLocalidad();
	
			List<Localidad> LLocalidad = NegLoc.Find(NProf.getProvincia().getIdProvincia());
			
			request.setAttribute("Localidad", LLocalidad);
			request.setAttribute("IdLocalidad", NProf.getLocalidad().getIdLocalidad());
			
			
			RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
			rd.include(request, response);
			
			
			}
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("AgregarProfesor") != null) {
			
			
			System.out.print("AgregarProfesor");
			NegImplProfesores NegProf = new NegImplProfesores();
			Profesor NProf = new Profesor();
			
			
			NProf.setLegajo(request.getParameter("Legajo"));
			NProf.setDni(request.getParameter("Dni"));
			NProf.setNombre(request.getParameter("Nombre"));
			NProf.setApellido(request.getParameter("Apellido"));
			NProf.setFechaNac(request.getParameter("FechaNac"));
			NProf.setDireccion(request.getParameter("Direccion"));
			NProf.setEmail(request.getParameter("Email"));
			NProf.setTelefono(request.getParameter("Telefono"));
			NProf.getLocalidad().setIdLocalidad(Integer.parseInt(request.getParameter("DDLLocalidad")));
			NProf.getProvincia().setIdProvincia(Integer.parseInt(request.getParameter("DDLProvincia")));
			
			if(NProf.getLocalidad().getIdLocalidad() == 0 || NProf.getProvincia().getIdProvincia() == 0) {
				
				request.setAttribute("Script", OtrasFunciones.Advertencia(6));
				
			}else {
				
			
			
			NegProf.Insertar(NProf);
			
			
			List<Profesor> LProf = NegProf.ListarProfesores();
			
			request.setAttribute("Tabla", LProf);
			request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdminProfesores"));
			
			request.setAttribute("Script", OtrasFunciones.Advertencia(3));
			
			RequestDispatcher rd = request.getRequestDispatcher("MenuAdministradorProfesores.jsp");
			rd.include(request, response);
			
			}
			
			
		}
		
		if(request.getParameter("AgregarAlumno") != null) {
			
			
			System.out.print("AgregarAlumno");
			NegImplAlumno NegAlum = new NegImplAlumno();
			Alumno Nalum = new Alumno();
			
			Nalum.setLegajo(request.getParameter("Legajo"));
			Nalum.setDni(request.getParameter("Dni"));
			Nalum.setNombre(request.getParameter("Nombre"));
			Nalum.setApellido(request.getParameter("Apellido"));
			Nalum.setFechaNac(request.getParameter("FechaNac"));
			Nalum.setDireccion(request.getParameter("Direccion"));
			Nalum.setEmail(request.getParameter("Email"));
			Nalum.setTelefono(request.getParameter("Telefono"));
			Nalum.getLocalidad().setIdLocalidad(Integer.parseInt(request.getParameter("DDLLocalidad")));
			Nalum.getProvincia().setIdProvincia(Integer.parseInt(request.getParameter("DDLProvincia")));
			

			
			NegAlum.Insertar(Nalum);
			
			List<Alumno> LAlumnos = NegAlum.ListarAlumnos();
			
			request.setAttribute("Tabla", LAlumnos);
			request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdminAlumnos"));
			
			request.setAttribute("Script", OtrasFunciones.Advertencia(3));
			
			RequestDispatcher rd = request.getRequestDispatcher("MenuAdministradorAlumnos.jsp");
			rd.include(request, response);
			
		}
		
		
		if(request.getParameter("GuardarAlumno") != null){
			
			
			System.out.print("GuardarAlumno");
			NegImplAlumno NegAlum = new NegImplAlumno();
			Alumno Nalum = new Alumno();
			
			Nalum.setIdAlumno(Integer.parseInt(request.getParameter("IdAlumno")));
			Nalum.setLegajo(request.getParameter("Legajo"));
			Nalum.setDni(request.getParameter("Dni"));
			Nalum.setNombre(request.getParameter("Nombre"));
			Nalum.setApellido(request.getParameter("Apellido"));
			Nalum.setFechaNac(request.getParameter("FechaNac"));
			Nalum.setDireccion(request.getParameter("Direccion"));
			Nalum.setEmail(request.getParameter("Email"));
			Nalum.setTelefono(request.getParameter("Telefono"));
			Nalum.getLocalidad().setIdLocalidad(Integer.parseInt(request.getParameter("DDLLocalidad")));
			Nalum.getProvincia().setIdProvincia(Integer.parseInt(request.getParameter("DDLProvincia")));
			
			if(Nalum.getLocalidad().getIdLocalidad() == 0 || Nalum.getProvincia().getIdProvincia() == 0) {
				
				request.setAttribute("Script", OtrasFunciones.Advertencia(6));
				
				
			}else {
			
			
			NegAlum.Editar(Nalum);
			
			List<Alumno> LAlumnos = NegAlum.ListarAlumnos();
			
			request.setAttribute("Tabla", LAlumnos);
			request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdminAlumnos"));
			
			request.setAttribute("Script", OtrasFunciones.Advertencia(3));
			
			RequestDispatcher rd = request.getRequestDispatcher("MenuAdministradorAlumnos.jsp");
			rd.include(request, response);
			}
		}
		
		
		
		if(request.getParameter("GuardarProfesor") != null){
			
			System.out.print("GuardarProfesor");
			NegImplProfesores NegProf = new NegImplProfesores();
			Profesor NProf = new Profesor();
			
			NProf.setIdProfesor(Integer.parseInt(request.getParameter("IdProfesor").trim()));
			NProf.setLegajo(request.getParameter("Legajo"));
			NProf.setDni(request.getParameter("Dni"));
			NProf.setNombre(request.getParameter("Nombre"));
			NProf.setApellido(request.getParameter("Apellido"));
			NProf.setFechaNac(request.getParameter("FechaNac"));
			NProf.setDireccion(request.getParameter("Direccion"));
			NProf.setEmail(request.getParameter("Email"));
			NProf.setTelefono(request.getParameter("Telefono"));
			NProf.getLocalidad().setIdLocalidad(Integer.parseInt(request.getParameter("DDLLocalidad")));
			NProf.getProvincia().setIdProvincia(Integer.parseInt(request.getParameter("DDLProvincia")));
			
			if(NProf.getLocalidad().getIdLocalidad() == 0 || NProf.getProvincia().getIdProvincia() == 0) {
				
				request.setAttribute("Script", OtrasFunciones.Advertencia(6));
				
			}else {
				
			
			
			NegProf.Editar(NProf);
			
			
			List<Profesor> LProf = NegProf.ListarProfesores();
			
			request.setAttribute("Tabla", LProf);
			request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdminProfesores"));
			
			request.setAttribute("Script", OtrasFunciones.Advertencia(3));
			
			RequestDispatcher rd = request.getRequestDispatcher("MenuAdministradorProfesores.jsp");
			rd.include(request, response);
			
			}
		}		
		
		
		if(request.getParameter("GuardarPerfilProfesor") != null){
			
			
			System.out.print("GuardarPerfilProfesor");
			NegImplProfesores NegProf = new NegImplProfesores();
			Profesor NProf = new Profesor();
			
			NProf.setIdProfesor(Integer.parseInt(request.getParameter("IdProfesor").trim()));
			NProf.setLegajo(request.getParameter("Legajo"));
			NProf.setDni(request.getParameter("Dni"));
			NProf.setNombre(request.getParameter("Nombre"));
			NProf.setApellido(request.getParameter("Apellido"));
			NProf.setFechaNac(request.getParameter("FechaNac"));
			NProf.setDireccion(request.getParameter("Direccion"));
			NProf.setEmail(request.getParameter("Email"));
			NProf.setTelefono(request.getParameter("Telefono"));
			NProf.getLocalidad().setIdLocalidad(Integer.parseInt(request.getParameter("DDLLocalidad")));
			NProf.getProvincia().setIdProvincia(Integer.parseInt(request.getParameter("DDLProvincia")));
			
			if(NProf.getLocalidad().getIdLocalidad() == 0 || NProf.getProvincia().getIdProvincia() == 0) {
				
				request.setAttribute("Script", OtrasFunciones.Advertencia(6));
				
			}else {
				
			
			
			NegProf.Editar(NProf);
			
			
			NegImplCursos NCursos = new NegImplCursos();
			
			List<Curso> NLCursos = NCursos.ListarCursosxProfesor(NProf.getIdProfesor());
			
			request.setAttribute("Tabla", NLCursos);
			request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuProf"));

			request.setAttribute("Script", OtrasFunciones.Advertencia(3));
			
			RequestDispatcher rd = request.getRequestDispatcher("MenuProfesor.jsp");
			rd.include(request, response);
			
			}
		}		
		
		
	}

}
