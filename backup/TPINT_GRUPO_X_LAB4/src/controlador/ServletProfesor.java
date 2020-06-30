package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.DaoImplProfesores;
import entidad.Profesor;

/**
 * Servlet implementation class ServletProfesor
 */
@WebServlet("/ServletProfesor")
public class ServletProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletProfesor() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		DaoImplProfesores DProf= new DaoImplProfesores();
		List<Profesor> P = DProf.readAll();
		//String test= "alan";		
		if(request.getParameter("Param")!=null) 
		{
			request.setAttribute("listaP", P);
			RequestDispatcher rd=request.getRequestDispatcher("MenuAdministradorProfesores.jsp");
			rd.forward(request, response);
		}
		
		
				//////////RequestDispatcher
		RequestDispatcher rd=request.getRequestDispatcher("MenuAdministradorProfesores.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
