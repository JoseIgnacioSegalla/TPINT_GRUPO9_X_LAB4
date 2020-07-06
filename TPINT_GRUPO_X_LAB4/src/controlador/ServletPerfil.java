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
	
		System.out.printf(request.getParameter("VerAlumno"));
		
		if(request.getParameter("VerAlumno") != null) {
		
			NegImplAlumno NegAlum = new NegImplAlumno();
			Alumno NAlum = new Alumno();
			NAlum  = NegAlum.Buscar(Integer.parseInt(request.getParameter("VerAlumno")));
			
		if(NAlum != null) {
			System.out.print("Genial");
			
			
			
			request.setAttribute("IdAlumno", NAlum.getIdAlumno());
			request.setAttribute("Legajo",NAlum.getLegajo());
			request.setAttribute("Dni",NAlum.getDni());
			request.setAttribute("Nombre", NAlum.getNombre());
			request.setAttribute("Apellido",NAlum.getApellido());
			request.setAttribute("FechaNac",NAlum.getFechNac());
			request.setAttribute("Direccion",NAlum.getDireccion());
			request.setAttribute("Email",NAlum.getEmail());
			request.setAttribute("Telefono",NAlum.getTelefono());
	
			
			NegImplProvincia NegProv = new NegImplProvincia();
			
			List<Provincia> LProvincia = NegProv.Readall();
		
			request.setAttribute("Provincia", LProvincia);	
			request.setAttribute("ScriptDDLProvincia", OtrasFunciones.DDL(1, "DDLProvincia", NAlum.getProvincia().getIdProvincia()));
			
		
			NegImplLocalidad NegLoc = new NegImplLocalidad();
	
			List<Localidad> LLocalidad = NegLoc.Find(NAlum.getProvincia().getIdProvincia());
			
			request.setAttribute("Localidad", LLocalidad);
			request.setAttribute("ScriptDDLLocalidad", OtrasFunciones.DDL(1, "DDLLocalidad", NAlum.getLocalidad().getIdLocalidad()));
			
		
			
			RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
			rd.include(request, response);
			
			
		}
			
			
			
	
			
		}

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
