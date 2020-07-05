package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NegocioImpl.NegImplCursos;
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
		

		if(request.getParameter("param").equals("1"))
		{
			
				
				NegImplCursos NCursos = new NegImplCursos();
				List<Curso> NLCursos = NCursos.ListarCursos();
				
				request.setAttribute("Tabla", NLCursos);
				request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdmin"));
				
				
				
				
				RequestDispatcher rd = request.getRequestDispatcher("MenuAdministrador.jsp");
				rd.include(request, response);
			
			
			
			
		}
		
		if(request.getParameter("VerCurso") != null) {
			
			System.out.print(request.getParameter("VerCurso"));
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
