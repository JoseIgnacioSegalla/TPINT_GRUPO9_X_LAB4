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
import NegocioImpl.NegImplLocalidad;
import NegocioImpl.NegImplProvincia;
import entidad.Alumno;
import entidad.Localidad;
import entidad.Provincia;

/**
 * Servlet implementation class ServletAlumnos
 */
@WebServlet("/ServletAlumnos")
public class ServletAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			if(request.getParameter("Alumnos") != null) {
				

				NegImplAlumno NAlumno = new NegImplAlumno();
				List<Alumno> LAlumnos = NAlumno.ListarAlumnos();
				
				request.setAttribute("Tabla", LAlumnos);
				request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdminAlumnos"));
				
				
				RequestDispatcher rd = request.getRequestDispatcher("MenuAdministradorAlumnos.jsp");
				rd.include(request, response);
			
			}
			
			if(request.getParameter("AgregarAlumno") != null)
			{
				
				request.setAttribute("Tipo", "3");
				request.setAttribute("Nombre", "");
				request.setAttribute("Legajo", "");
				request.setAttribute("FechaNac", "");
				request.setAttribute("Email", "");
				request.setAttribute("Apellido", "");
				request.setAttribute("Dni", "");
				request.setAttribute("Direccion", "");
				request.setAttribute("Telefono", "");
			
				
				
				NegImplProvincia NegProv = new NegImplProvincia();
				
				List<Provincia> LProvincia = NegProv.Readall();
				
				request.setAttribute("Provincia", LProvincia);	
				
				request.setAttribute("IdProvincia", 0);
			
				NegImplLocalidad NegLoc = new NegImplLocalidad();
		
				List<Localidad> LLocalidad = NegLoc.readAll();
				
				request.setAttribute("Localidad", LLocalidad);
				
				request.setAttribute("IdLocalidad", 0);
				
				RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
				rd.include(request, response);
			}
			
			
			if(request.getParameter("EliminarAlumno")!= null)
			{
				NegImplAlumno NegAlum = new NegImplAlumno();
				NegAlum.Borrar(Integer.parseInt(request.getParameter("EliminarAlumno")));

				List<Alumno> LAlumnos = NegAlum.ListarAlumnos();
				
				request.setAttribute("Tabla", LAlumnos);
				request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdminAlumnos"));
				
				request.setAttribute("Script", OtrasFunciones.Advertencia(4));
				
				RequestDispatcher rd = request.getRequestDispatcher("MenuAdministradorAlumnos.jsp");
				rd.include(request, response);
			}
	
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	
		doGet(request, response);
	}

}
