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
import entidad.Profesor;
import entidad.Provincia;

@WebServlet("/ServletPerfil")
public class ServletPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		System.out.print("F0");
		
		if(request.getParameter("VerAlumno") != null) {
		
			NegImplAlumno NegAlum = new NegImplAlumno();
			
			Alumno NAlum  = NegAlum.Buscar(Integer.parseInt(request.getParameter("Alumno")));
			
			System.out.print("F1");
			
			request.setAttribute("Nombre", NAlum.getNombre());
			request.setAttribute("Legajo",NAlum.getLegajo());
			request.setAttribute("FechaNac",NAlum.getFechNac());
			
			Localidad NLoc = new Localidad();
			NegImplLocalidad NegLoc = new NegImplLocalidad();
			
			System.out.print("F2");
			List<Localidad> LLocalidad = NegLoc.readAll();
			
			request.setAttribute("DDLLocalidad", LLocalidad);
			
			Provincia NProv = new Provincia();
			NegImplProvincia NegProv = new NegImplProvincia();
			
		
			List<Provincia> LProvincia = NegProv.Readall();
			
			System.out.print("F3");
			request.setAttribute("DDLProvincia", LProvincia);
		
			request.setAttribute("Email",NAlum.getEmail());
			request.setAttribute("Apellido",NAlum.getApellido());
			request.setAttribute("Dni",NAlum.getDni());
			request.setAttribute("Direccion",NAlum.getDireccion());
			request.setAttribute("Telefono",NAlum.getTelefono());
		
			
			RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
			rd.include(request, response);
			
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		
		
		/*Profesor NPro = new Profesor();
		Localidad loc = new Localidad();
		//LADO IZQUIERDO
		NPro.setNombre(request.getParameter("Nombre"));
		NPro.setLegajo(request.getParameter("Legajo"));
		NPro.setFechaNac(request.getParameter("FechNac"));
		Npro.
		loc.setNombre(request.getParameter("Localidad"));
		NPro.setEmail(request.getParameter("Email"));
		NPro.getLocalidad().setNombre(getNombre());
		//LADO DERECHO
		NPro.setApellido(request.getParameter("Apellido"));
		NPro.setDni(request.getParameter("Dni"));
		NPro.setDireccion(request.getParameter("Direccion"));
		NPro.setProvincia(request.getParameter("Provincia"));
		NPro.setTelefono(request.getParameter("Telefono"));
		
		System.out.print(NPro.toString());
		
		//doGet(request, response);*/
	}

}
