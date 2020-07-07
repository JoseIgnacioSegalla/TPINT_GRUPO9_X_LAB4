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

import NegocioImpl.NegImplAlumno;
import NegocioImpl.NegImplProfesores;
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
		
		List<Profesor> LProf = new ArrayList<Profesor>();
		NegImplProfesores NProf = new NegImplProfesores();
		LProf = NProf.ListarProfesores();

		
		//if(request.getParameter("Profesores") != null) 
	
	
		if(request.getParameter("EliminarProfesor")!= null)
		{
			NegImplProfesores NegProf = new NegImplProfesores();
			
			if(NegProf.Borrar(Integer.parseInt(request.getParameter("EliminarProfesor")))) {
				
				request.setAttribute("Script", OtrasFunciones.Advertencia(4));
				
				
				
			}
			
			
			
		}
		
		request.setAttribute("Tabla", LProf);
		request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdminProfesores"));
		
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
