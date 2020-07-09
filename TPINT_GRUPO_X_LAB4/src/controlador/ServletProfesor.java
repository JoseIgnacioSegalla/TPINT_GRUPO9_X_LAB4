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
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;

import Negocio.NegAlumno;
import Negocio.NegCursos;
import Negocio.NegMateria;
import Negocio.NegProfesores;
import NegocioImpl.NegImplAlumno;
import NegocioImpl.NegImplCursos;
import NegocioImpl.NegImplLocalidad;
import NegocioImpl.NegImplMateria;
import NegocioImpl.NegImplProfesores;
import entidad.Alumno;
import entidad.Instancia;
import entidad.Materia;
import NegocioImpl.NegImplLocalidad;
import NegocioImpl.NegImplProfesores;
import NegocioImpl.NegImplProvincia;
import NegocioImpl.NegImplUsuario;
import entidad.Localidad;
import entidad.Profesor;
import entidad.Provincia;
import entidad.Usuario;

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
			NegImplUsuario NegUs = new NegImplUsuario();
			Usuario Us = new Usuario();
			
			NegProf.Borrar(Integer.parseInt(request.getParameter("EliminarProfesor")));
			Us.setIdUsuario(NegUs.BuscarUsuReg(Integer.parseInt(request.getParameter("EliminarProfesor"))));
			if(Us.getIdUsuario() != 0){
				
				NegUs.Borrar(Us);
				
				
				
				
			}
			
			List<Profesor> LProf = new ArrayList<Profesor>();
			LProf = NegProf.ListarProfesores();
			
			request.setAttribute("Tabla", LProf);
			request.setAttribute("ScriptTabla", OtrasFunciones.Tablas(1, "#TablaMenuAdminProfesores"));
			
			request.setAttribute("Script", OtrasFunciones.Advertencia(4));	
			
			RequestDispatcher rd=request.getRequestDispatcher("MenuAdministradorProfesores.jsp");
			rd.forward(request, response);
			
			
			
		}
		
	

		
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("BtnActualizar")!=null)
		{
			Actualizar(request, response,1);		
			RequestDispatcher rd = request.getRequestDispatcher("/MenuAdministradorCursos.jsp");
			rd.forward(request, response);
		}

		if(request.getParameter("BtnCargaDeDatos")!=null)
		{
			//PASAR ESTE CODIGO A UN EVENTO DEL ULTIMO DDL
			NegMateria NegMat = new NegImplMateria();
			NegProfesores NegP= new NegImplProfesores();
			NegAlumno NegAlumno = new NegImplAlumno();
			NegCursos NegCur = new NegImplCursos();
			String IdMateria = request.getParameter("DDLMaterias");
			String IdProf = request.getParameter("DDLProfesores");
			String Cuatrimestre = request.getParameter("cuatri");
			String Año = request.getParameter("año");
			//int idMateria = NegMat.getIdMateria(IdMateria);
			//int IdProfesor = NegP.getID(IdProf);
			//crear curso
			if(NegCur.ExisteCurso(IdMateria,IdProf,Cuatrimestre,Año)==false)
			{
				NegCur.AgregarCurso(IdMateria,IdProf,Cuatrimestre,Año);
			}
			

			int IdCurs=  NegCur.getID_V2(Integer.parseInt(IdMateria),Integer.parseInt(IdProf),Integer.parseInt(Año),Cuatrimestre);
		//	int idMateria = NegMat.getIdMateria(IdMateria);
			//int IdProfesor = NegP.getID(IdProf);
			//int IdCurs=  NegCur.getID(idMateria,IdProfesor);

			HttpSession session = request.getSession(true);
			session.setAttribute("IdCurso_MenuAdmin", Integer.toString(IdCurs));

			ArrayList<Alumno> listarAlumnosMat = NegAlumno.ListarAlumnos_x_Materia(IdCurs);

			session.setAttribute("ListaCursando", listarAlumnosMat);

			request.setAttribute("listarAlumnoIns", listarAlumnosMat);
			Actualizar(request, response,0);
			ActualizarListaAlumnos_Dado_Cursando(request,response);
			RequestDispatcher rd = request.getRequestDispatcher("/MenuAdministradorCursos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("BtnInsertar")!=null)
		{

			HttpSession session = request.getSession(true);
			NegAlumno NegAlumno = new NegImplAlumno();
			//Agarra alumnno seleccionado
			String AlumSelec= request.getParameter("Alum");
			//Trae el alumno selecciondo de la base
			Alumno AlumInsSelec = NegAlumno.TraerUno(Integer.parseInt(AlumSelec));
			//Trae lista session
			ArrayList<Alumno> a =  (ArrayList<Alumno>) session.getAttribute("ListaAlumnos");

			//Actualizar Session lista Alumnos
			for(int i=0;i<a.size();i++)
			{
				if(a.get(i).getIdAlumno()==AlumInsSelec.getIdAlumno())
				{
					a.remove(i);
				}
			}
			session.setAttribute("ListaAlumnos",a);

			//Actualizar Session lista Inscriptos
			ArrayList<Alumno> Alum =  (ArrayList<Alumno>) session.getAttribute("ListaCursando");
			Alum.add(AlumInsSelec);
			session.setAttribute("ListaCursando",Alum);
			Actualizar(request, response, 0);
			RequestDispatcher rd = request.getRequestDispatcher("/MenuAdministradorCursos.jsp");
			rd.forward(request, response);



 		}
		if(request.getParameter("BtnGuardar")!=null)
		{
			HttpSession session = request.getSession(true);
			NegCursos NegCur = new NegImplCursos();
			NegAlumno NegAlumno = new NegImplAlumno();
			ActualizarListaAlumnos_Dado_Cursando(request,response);
			Instancia ia = new Instancia();
			@SuppressWarnings("unchecked")

			String[] AlumInscriptos = request.getParameterValues("AlumInscriptos");

			//ArrayList<Alumno> b =  (ArrayList<Alumno>) session.getAttribute("ListaCursando");
			ArrayList<Alumno> b =  new ArrayList<Alumno>();
			ArrayList<Instancia> ins = new ArrayList<Instancia>();
			ins.add(ia);
			Alumno a= new Alumno();
			String id = (String)session.getAttribute("IdCurso_MenuAdmin");
			for(int i =0 ;i<AlumInscriptos.length;i++)
			{
				a.setIdAlumno(Integer.valueOf( AlumInscriptos[i]));
				a.setEstado_Alumno("1");
				ins.get(0).setIdCurso(Integer.parseInt( id));
				b.add(a);
				b.get(i).setLInst(ins);
				if(NegCur.CheckAlumnoExista(b.get(i))==false)
				{
					NegCur.insertar_Alumno(a);
				}
				else if(NegAlumno.CheckAlumnoId(b.get(i))==true) {
					NegAlumno.Update_Curso_Materia(b.get(i));
				}
			}

			ArrayList<Alumno> AlumnosIz =  (ArrayList<Alumno>) session.getAttribute("ListaAlumnos");
			ArrayList<Alumno> listarAlumnosMat = NegAlumno.ListarAlumnos_x_Materia(Integer.parseInt((String)request.getSession().getAttribute("IdCurso_MenuAdmin")));
			CargarIdCurso(listarAlumnosMat,id);
			CargarIdCurso(AlumnosIz,id);
			for(int i =0; i<AlumnosIz.size();i++)
			{
				for(int x = 0 ;x<listarAlumnosMat.size();x++)
				{
					if(AlumnosIz.get(i).getIdAlumno()==listarAlumnosMat.get(x).getIdAlumno())
					{
						if(NegAlumno.BajaLogica_Curso_x_Materia(AlumnosIz.get(i)))
						{
							String Baja ="Se dio baja logica";
						}

					}

				}
			}

			//ArrayList<Alumno> listarAlumnosMat = NegAlumno.ListarAlumnos_x_Materia(Integer.parseInt((String)request.getSession().getAttribute("IdCurso_MenuAdmin")));

			session.setAttribute("ListaCursando", listarAlumnosMat);
			RequestDispatcher rd = request.getRequestDispatcher("/MenuAdministradorCursos.jsp");
			rd.forward(request, response);	
		}
		if(request.getParameter("Desinscribir")!=null)
		{
			HttpSession session = request.getSession(true);
			NegAlumno NegAlumno = new NegImplAlumno();
			//Agarra alumnno seleccionado
			String AlumSelec= request.getParameter("AlumInscriptos2");
			//Trae el alumno selecciondo de la base
			Alumno AlumInsSelec = NegAlumno.TraerUno(Integer.parseInt(AlumSelec));
			//Trae lista session
			ArrayList<Alumno> a =  (ArrayList<Alumno>) session.getAttribute("ListaCursando");

			//Actualizar Session lista inscriptos
			for(int i=0;i<a.size();i++)
			{
				if(a.get(i).getIdAlumno()==AlumInsSelec.getIdAlumno())
				{
					a.remove(i);
				}
			}
			session.setAttribute("AlumInscriptos",a);

			//Actualizar Session lista Alumnos
			ArrayList<Alumno> Alum =  (ArrayList<Alumno>) session.getAttribute("ListaAlumnos");
			Alum.add(AlumInsSelec);
			session.setAttribute("ListaAlumnos",Alum);

			request.setAttribute("listarAlumnoIns", (ArrayList<Alumno>) session.getAttribute("ListaCursando"));
			Actualizar(request, response, 0);
			//ActualizarListaAlumnos_Dado_Cursando(request,response);

			RequestDispatcher rd = request.getRequestDispatcher("/MenuAdministradorCursos.jsp");
			rd.forward(request, response);

		}


	}
	public ArrayList<Alumno> CargarListaInscriptos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		NegAlumno NegAlumno = new NegImplAlumno();		
		Integer IdCurs =  Integer.parseInt((String)request.getSession().getAttribute("IdCurso_MenuAdmin"));
		ArrayList<Alumno> listarAlumnosMat = NegAlumno.ListarAlumnos_x_Materia(IdCurs);

		return listarAlumnosMat;
	}
	@SuppressWarnings("unchecked")
	public void Actualizar(HttpServletRequest request, HttpServletResponse response,int Carga) throws ServletException, IOException
	{

		NegMateria NegMat = new NegImplMateria();
		NegProfesores NegP= new NegImplProfesores();
		NegAlumno NegAlumno = new NegImplAlumno();
		NegCursos NegCur = new NegImplCursos();
		ArrayList<Alumno> listarAlumnos = NegAlumno.ListarAlumnos_v2();
		ArrayList<Profesor> listarProfesores = (ArrayList<Profesor>) NegP.ListarProfesores();
		ArrayList<Materia> listarMaterias = (ArrayList<Materia>) NegMat.ListarTodos();

		HttpSession session = request.getSession(true);
		if(Carga==1)
		{
			session.setAttribute("ListaAlumnos",listarAlumnos);
		}
		if(Carga==0)
		{

			request.setAttribute("listarAlumnoIns", (ArrayList<Alumno>) session.getAttribute("ListaCursando"));
		}
		request.setAttribute("listarAlumno", (ArrayList<Alumno>) session.getAttribute("ListaAlumnos"));
		request.setAttribute("listarProfesor", listarProfesores);
		request.setAttribute("listarMaterias", listarMaterias);

	}

	@SuppressWarnings("unchecked")
	public void ActualizarListaAlumnos_Dado_Cursando(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		ArrayList<Alumno> a =  (ArrayList<Alumno>) session.getAttribute("ListaAlumnos");
		ArrayList<Alumno> b =  (ArrayList<Alumno>) session.getAttribute("ListaCursando");
		for(int i=0;i< a.size();i++)
		{
			for(int x =0; x<b.size();x++)
			{
				if(b.get(x).getIdAlumno()==a.get(i).getIdAlumno())
				{
					a.remove(i);
				}

			}
		}
		session.setAttribute("ListaAlumnos",a);
		session.setAttribute("listarAlumnoIns",b);

	}
	public void CargarIdCurso(ArrayList <Alumno> a,String id)
	{
		ArrayList <Instancia> ins = new ArrayList<>();
		Instancia in = new Instancia();
		ins.add(in);
		ins.get(0).setIdCurso(Integer.parseInt( id));
		for(int i=0;i<a.size();i++)
		{
			a.get(i).setLInst(ins);
		}
	}
	
	
	

}
