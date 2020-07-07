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
import entidad.Alumno;

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

			if(request.getParameter("Alumnos").equals("1")) {
				

				NegImplAlumno NAlumno = new NegImplAlumno();
				List<Alumno> LAlumnos = NAlumno.ListarAlumnos();
				
				request.setAttribute("Tabla", LAlumnos);
				request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdminAlumnos"));
				
				
				RequestDispatcher rd = request.getRequestDispatcher("MenuAdministradorAlumnos.jsp");
				rd.include(request, response);
			
			}
			
			
			if(request.getParameter("EliminarAlumno")!= null)
			{
				NegImplAlumno NegAlum = new NegImplAlumno();
				NegAlum.Borrar(Integer.parseInt(request.getParameter("EliminarAlumno")));
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
