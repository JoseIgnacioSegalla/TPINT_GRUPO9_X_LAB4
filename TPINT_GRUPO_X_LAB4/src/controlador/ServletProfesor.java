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

import NegocioImpl.NegImplLocalidad;
import NegocioImpl.NegImplProfesores;
import NegocioImpl.NegImplProvincia;
import entidad.Localidad;
import entidad.Profesor;
import entidad.Provincia;

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
		
		

		if(request.getParameter("Profesores") != null){
			List<Profesor> LProf = new ArrayList<Profesor>();
			NegImplProfesores NProf = new NegImplProfesores();
			LProf = NProf.ListarProfesores();
			
			request.setAttribute("Tabla", LProf);
			request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdminProfesores"));
			
			RequestDispatcher rd=request.getRequestDispatcher("MenuAdministradorProfesores.jsp");
			rd.forward(request, response);
			
			
		}
		
		
		
		if(request.getParameter("AgregarProfesor") != null)
		{
			
			request.setAttribute("Tipo", "2");
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
		
		
	
	
		if(request.getParameter("EliminarProfesor")!= null)
		{
			NegImplProfesores NegProf = new NegImplProfesores();
			
			if(NegProf.Borrar(Integer.parseInt(request.getParameter("EliminarProfesor")))) {
				
				List<Profesor> LProf = new ArrayList<Profesor>();
				LProf = NegProf.ListarProfesores();
				
				request.setAttribute("Tabla", LProf);
				request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdminProfesores"));
				
				request.setAttribute("Script", OtrasFunciones.Advertencia(4));	
				
				RequestDispatcher rd=request.getRequestDispatcher("MenuAdministradorProfesores.jsp");
				rd.forward(request, response);
				
				
			}
			
			
			
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
