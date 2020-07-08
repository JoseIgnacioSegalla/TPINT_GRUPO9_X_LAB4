package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NegocioImpl.NegImplCursos;
import NegocioImpl.NegImplUsuario;
import entidad.Curso;

/**
 * Servlet implementation class ServletCurso
 */
@WebServlet("/ServletCurso")
public class ServletCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("AgregarCurso") != null) {
			
			RequestDispatcher rd = request.getRequestDispatcher("MenuAdministradorCursos.jsp");
			rd.include(request, response);
			
		}
		
		if(request.getParameter("EliminarCurso") != null) {
			
			NegImplCursos NCursos = new NegImplCursos();
			
			
			if(NCursos.Borrar(Integer.parseInt(request.getParameter("EliminarCurso").trim()))) {
				
			
				List<Curso> NLCursos = NCursos.ListarCursos();
		
				
				request.setAttribute("Tabla", NLCursos);
				
				request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdmin"));
				
				request.setAttribute("Script", OtrasFunciones.Advertencia(4));
				
				RequestDispatcher rd = request.getRequestDispatcher("MenuAdministrador.jsp");
				rd.include(request, response);
				
			}
			
			
			
		
		
		}
			
		if(request.getParameter("Cursos") != null)
		{
			
				NegImplCursos NCursos = new NegImplCursos();
				List<Curso> NLCursos = NCursos.ListarCursos();
				
				request.setAttribute("Tabla", NLCursos);
				request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdmin"));
				
				
				
				
				RequestDispatcher rd = request.getRequestDispatcher("MenuAdministrador.jsp");
				rd.include(request, response);
			
			
			
			
		}
		
		
		if(request.getParameter("VerCursosProfesor") != null)
		{
			
			NegImplCursos NCursos = new NegImplCursos();
			NegImplUsuario NegUsu = new NegImplUsuario();
			
			List<Curso> NLCursos = NCursos.ListarCursosxProfesor(NegUsu.BuscarNombreUsu(request.getParameter("VerCursosProfesor")));
			
			request.setAttribute("Tabla", NLCursos);
			request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuProf"));

			RequestDispatcher rd = request.getRequestDispatcher("MenuProfesor.jsp");
			rd.include(request, response);
		}
		
		if(request.getParameter("VerAlumnoXCurso") != null) {
			
			
			RequestDispatcher rd = request.getRequestDispatcher("MenuProfesorAlumnosXCurso.jsp");
			rd.include(request, response);
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		if(request.getParameter("BtnActualizar")!=null)
		{
			NegImplCursos NegCur = new NegImplCursos();
			ArrayList<Curso> ListaCur = NegCur.ListarCursosNombres();

			request.setAttribute("ListaCurso", ListaCur);
			
			RequestDispatcher rd = request.getRequestDispatcher("/MenuAdministrador.jsp");
			rd.forward(request, response);
		}
	
		
		
		
		
	}

}
