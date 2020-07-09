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


import Negocio.NegAlumno;
import NegocioImpl.NegImplAlumno;
import entidad.Alumno;
import entidad.Curso;
import entidad.Instancia;
/**
 * Servlet implementation class ServletAlumnosXCurso
 */
@WebServlet("/ServletAlumnosXCurso")
public class ServletAlumnosXCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumnosXCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("VerAlumnosXCurso")!=null)
		{
			
			
			Curso NCurso = new Curso();
			//int id =listarNotas.get(0).getLInst().get(0).getIdCurso();
			
			NCurso.setIdNumCurso(Integer.parseInt(request.getParameter("IdCurso").trim()));
			NCurso.getNMateria().setNombre(request.getParameter("Materia"));
			NCurso.setCuatrimestre(request.getParameter("Cuatrimestre"));
			NCurso.setAño(request.getParameter("Año"));
			
			NegAlumno NegAlumno = new NegImplAlumno();
			ArrayList<Alumno> listarNotas = NegAlumno.ListarNotas(NCurso.getIdNumCurso());
			
			//HttpSession session = request.getSession(true);
			//session.setAttribute("CursoID", Integer.toString(id));
			//session.setAttribute("CursoID", NCurso.getIdNumCurso());
			request.setAttribute("listarNotas", listarNotas);
			request.setAttribute("IdCurso",NCurso.getIdNumCurso());
			request.setAttribute("Materia",NCurso.getNMateria().getNombre());
			request.setAttribute("Cuatrimestre",NCurso.getCuatrimestre());
			request.setAttribute("Año", NCurso.getAño());

			RequestDispatcher rd = request.getRequestDispatcher("MenuProfesorAlumnosXCurso.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("Btn_Guardar_Cambios")!=null)
		{	
			
			Curso NCurso = new Curso();
			
			NCurso.setIdNumCurso(Integer.parseInt(request.getParameter("IdCurso").trim()));
			NCurso.getNMateria().setNombre(request.getParameter("Materia"));
			NCurso.setCuatrimestre(request.getParameter("Cuatrimestre"));
			NCurso.setAño(request.getParameter("Año"));
			
			request.setAttribute("IdCurso",NCurso.getIdNumCurso());
			request.setAttribute("Materia",NCurso.getNMateria().getNombre());
			request.setAttribute("Cuatrimestre",NCurso.getCuatrimestre());
			request.setAttribute("Año", NCurso.getAño());
			
			NegAlumno NegAlu = new NegImplAlumno();
			String[] Legajo = request.getParameterValues("Legajo");
			String[] Dni = request.getParameterValues("Dni");
			String[] Nota1 = request.getParameterValues("1erParcial");
			String[] Nota2 = request.getParameterValues("2doParcial");
			String[] Nota3 = request.getParameterValues("1erRecuperatorio");
			String[] Nota4 = request.getParameterValues("2doRecuperatorio");
			String[] Estado = request.getParameterValues("AlumnoEstado");
			//HttpSession session = request.getSession(true);
			//String IdCursoString = (String) session.getAttribute("CursoID");
			int IdCurso = Integer.parseInt(request.getParameter("IdCurso"));
					
			CargaMasiva(Nota1, Legajo.length+1);
			CargaMasiva(Nota2, Legajo.length+1);
			CargaMasiva(Nota3, Legajo.length+1);
			CargaMasiva(Nota4, Legajo.length+1);
			
			for(int i=0; i<Legajo.length;i++)
			{
				Alumno Alu = new Alumno();
				List<Instancia> LInst = new ArrayList<Instancia>();
				Alu.setIdAlumno(Integer.valueOf(Legajo[i]));
				Alu.setDni(Dni[i]);
				Alu.setEstado_Alumno(Estado[i]);
				for(int x=1;x<5;x++)
				{
					LInst.add(Set_Nota(Nota1,Nota2,Nota3,Nota4,x,i+1,IdCurso));
				}
				Alu.setLInst(LInst);
				NegAlu.Update_Notas(Alu);
			}
			
			NegAlumno NegAlumno = new NegImplAlumno();
			ArrayList<Alumno> listarNotas = NegAlumno.ListarNotas(IdCurso);
			request.setAttribute("listarNotas", listarNotas);
			request.setAttribute("IdCurso", IdCurso);
			
			
			request.setAttribute("Script", OtrasFunciones.Advertencia(4));
			
			RequestDispatcher rd = request.getRequestDispatcher("MenuProfesorAlumnosXCurso.jsp");
			rd.forward(request, response);
		}
		
	}
	private String[] CargaMasiva(String[] N,int TotalTabla)
	{
		if(N[0]!=null && N[0] != "" )
		{
			for(int i=1;i<TotalTabla;i++)
			{
				N[i] = N[0];
				
			}
		}
		return N;
	}
 	

	private Instancia Set_Nota(String N1[],String N2[],String N3[],String N4[],int NumNota,int i,int IdCurso)
	{
		Instancia Ins = new Instancia();
		switch(NumNota)
		{
		case(1):
			Ins.setIdIntancia(NumNota);
			Ins.setNota(Integer.parseInt(N1[i]));
			Ins.setIdCurso(IdCurso);
			break;
		case(2):
			Ins.setIdIntancia(NumNota);
			Ins.setNota(Integer.parseInt(N2[i]));
			break;
		case(3):
			Ins.setIdIntancia(NumNota);
			Ins.setNota(Integer.parseInt(N3[i]));
			break;
		case(4):
			Ins.setIdIntancia(NumNota);
			Ins.setNota(Integer.parseInt(N4[i]));
			break;
		}
		
		return Ins;
	}
	

}
