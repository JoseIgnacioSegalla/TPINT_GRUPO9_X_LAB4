package controlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NegocioImpl.NegImplUsuario;
import entidad.Curso;
import entidad.Usuario;
import NegocioImpl.NegImplCursos;

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
			
	
			
		out.println(OtrasFunciones.Advertencia(1));

			
			
		
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
				out.println("<script>					\r\n" + 
						"   $('#TablaMenuAdmin').DataTable({\r\n" + 
						"\r\n" + 
						"	   pagingType: 'full_numbers'\r\n" + 
						"   });\r\n" + 
						"</script>"); 
				

				RequestDispatcher rd = request.getRequestDispatcher("MenuProfesor.jsp");
				rd.include(request, response);
			}
			else 
			{

				NegImplCursos NCursos = new NegImplCursos();
				List<Curso> NLCursos = NCursos.ListarCursos();
				
				request.setAttribute("Tabla", NLCursos);
				request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdmin"));
				
				
				
				
				RequestDispatcher rd = request.getRequestDispatcher("MenuAdministrador.jsp");
				rd.include(request, response);
			}

		}
		else 
		{
			out.println(OtrasFunciones.Advertencia(2)); 


			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);

		}
		}

	}
}