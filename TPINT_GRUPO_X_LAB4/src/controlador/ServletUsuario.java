package controlador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NegocioImpl.NegImplUsuario;
import entidad.Usuario;
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  
 
    public ServletUsuario() {
        super();
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario NUs = new Usuario();
		PrintWriter out = response.getWriter();
		NUs.setNombre(request.getParameter("Txt_NomUs"));
		NUs.setClave(request.getParameter("Txt_ClvUs"));
		
		
		
		if (NUs.getNombre().isEmpty() || NUs.getClave().isEmpty()) {
			
		out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js\"></script>"
				+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>"
				+ "<script>"
				+ " $(document).ready(function(){"
				+ "swal('Error', 'Los campos Usuario y Clave no deben estar vacios' ,'error');"
				+ "})" 
				+ "</script>\r\n"); 
		
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		} else {


			NegImplUsuario NegUsu = new NegImplUsuario();
			NUs = NegUsu.BuscarUsu(NUs);

		if(NUs.getIdUsuario() != 0) 
		{


			HttpSession session = request.getSession();

			session.setAttribute("Nombre", NUs.getNombre());
			session.setAttribute("IdUsuario", NUs.getIdUsuario());

			if(NUs.getTipo())
			{

				RequestDispatcher rd = request.getRequestDispatcher("MenuProfesor.jsp");
				rd.include(request, response);
			}
			else 
			{

				RequestDispatcher rd = request.getRequestDispatcher("MenuAdministrador.jsp");
				rd.include(request, response);
			}

		}
		else 
		{
			out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js\"></script>"
					+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>"
					+ "<script>"
					+ " $(document).ready(function(){"
					+ "swal('Error', 'El usuario no esta registrado' ,'error');"
					+ "})" 
					+ "</script>\r\n"); 


			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);

		}
		}

	}
}