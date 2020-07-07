package controlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import entidad.Profesor;
import entidad.Usuario;
import NegocioImpl.NegImplCursos;
import NegocioImpl.NegImplProfesores;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  
 
    public ServletUsuario() {
        super();
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		NegImplProfesores NegProfesor = new NegImplProfesores();
		
		
		if(request.getParameter("GuardarUsuario") != null)
		{
		
		
			if(request.getParameter("Nombre").isEmpty() || request.getParameter("Clave").isEmpty()){
			
				request.setAttribute("Script", OtrasFunciones.Advertencia(1));

			}
			else
			{
				
				NegImplUsuario NegUs = new NegImplUsuario();
				Usuario NUsu = new Usuario();
				NUsu.setNombre(request.getParameter("Nombre"));
				NUsu.setClave(request.getParameter("Clave"));
				NUsu.setIdUsuario(NegUs.BuscarUsuReg(Integer.parseInt(request.getParameter("IdProfesor"))));
				System.out.print(NUsu.getIdUsuario());
				if(NUsu.getIdUsuario() > 1)
				{
					int x = NegUs.BuscarNombreUsu(request.getParameter("Nombre"));
					if(x == 0) {
						
						
						
						NegUs.Editar(NUsu);
						request.setAttribute("Script", OtrasFunciones.Advertencia(3));
						
					}
					else
					if(x == Integer.parseInt(request.getParameter("IdProfesor"))) {
						
						
						
						
						NegUs.Editar(NUsu);
						request.setAttribute("Script", OtrasFunciones.Advertencia(3));
						
					}
					else 
					{
						request.setAttribute("Script", OtrasFunciones.Advertencia(5));
					}
				}
				else
				{
					int x = NegUs.BuscarNombreUsu(request.getParameter("Nombre"));
					if(x == 0) {
						
						NegUs.Insertar(NUsu);
						Usuario NUsuario = new Usuario();
						NUsuario = NegUs.BuscarUsu(NUsu);
						NegUs.Insertar_usuario_x_profesor(NUsuario.getIdUsuario(),Integer.parseInt(request.getParameter("IdProfesor")));
						
						request.setAttribute("Script", OtrasFunciones.Advertencia(3));
						
					}
					else
					if(x == Integer.parseInt(request.getParameter("IdProfesor"))) {
						
						NegUs.Insertar(NUsu);
						Usuario NUsuario = new Usuario();
						NUsuario = NegUs.BuscarUsu(NUsu);
						NegUs.Insertar_usuario_x_profesor(NUsuario.getIdUsuario(),Integer.parseInt(request.getParameter("IdProfesor")));
						
						request.setAttribute("Script", OtrasFunciones.Advertencia(3));
				
					}
					else 
					{
						request.setAttribute("Script", OtrasFunciones.Advertencia(5));
					}
				}
				
				//NegProfesor.Editar(NProf);

			}
			
		}
		else
		{
			
	
			
			/*if(request.getParameter("Nombre").isEmpty() || request.getParameter("Clave").isEmpty()){
				
				request.setAttribute("Script", OtrasFunciones.Advertencia(1));
			}
			else
			{
				System.out.print(request.getParameter("Nombre"));
				System.out.print(request.getParameter("Clave"));
				Profesor NProf = new Profesor();
				NegImplProfesores NegProfesor = new NegImplProfesores();
				NegProfesor.insert(NProf);
				
				RequestDispatcher rd = request.getRequestDispatcher("MenuAdministradorProfesores.jsp");
				rd.include(request, response);
			}*/
			
			
			
			
		}
		
		List<Profesor> LProf = new ArrayList<Profesor>();
		LProf = NegProfesor.ListarProfesores();
		

		request.setAttribute("Tabla", LProf);
		request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdminProfesores"));
		
		RequestDispatcher rd=request.getRequestDispatcher("MenuAdministradorProfesores.jsp");
		rd.forward(request, response);
		
	
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
				
				NegImplCursos NCursos = new NegImplCursos();
				List<Curso> NLCursos = NCursos.ListarCursos();
				
				request.setAttribute("Tabla", NLCursos);
				request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuProf"));

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