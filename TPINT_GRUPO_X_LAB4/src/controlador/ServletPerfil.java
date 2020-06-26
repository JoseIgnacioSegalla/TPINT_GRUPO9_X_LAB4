package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidad.Profesor;

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
	
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Profesor NPro = new Profesor();
		//LADO IZQUIERDO
		NPro.setNombre(request.getParameter("Nombre"));
		NPro.setLegajo(request.getParameter("Legajo"));
		NPro.setFechaNac(request.getParameter("FechNac"));
		NPro.setLocalidad(request.getParameter("Localidad"));
		NPro.setEmail(request.getParameter("Email"));
		
		//LADO DERECHO
		NPro.setApellido(request.getParameter("Apellido"));
		NPro.setDni(request.getParameter("Dni"));
		NPro.setDireccion(request.getParameter("Direccion"));
		NPro.setProvincia(request.getParameter("Provincia"));
		NPro.setTelefono(request.getParameter("Telefono"));
		
		System.out.print(NPro.toString());
		
		//doGet(request, response);
	}

}
