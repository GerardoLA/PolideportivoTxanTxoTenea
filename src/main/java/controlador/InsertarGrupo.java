package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.bean.Actividad;
import modelo.bean.Grupo;
import modelo.bean.Imparten;
import modelo.dao.ModeloMonitor;

/**
 * Crea grupo de una actividad determinada
 */
@WebServlet("/InsertarGrupo")
public class InsertarGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarGrupo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("actividad", (Actividad) session.getAttribute("actividad"));
		
		request.getRequestDispatcher("InsertarGrupoForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloMonitor modMon = new ModeloMonitor();
		HttpSession session = request.getSession();
		Grupo grupo = new Grupo (request.getParameter("id_grupo"),request.getParameter("dias"),request.getParameter("horas"),Integer.parseInt(request.getParameter("maxPartic")),0);
		Actividad actividad = (Actividad) session.getAttribute("actividad");

		
		
		if(grupo.comprobarId(actividad.getId_actividad())) {
			Imparten imparten= new Imparten();
			
			imparten.setActividad((Actividad) session.getAttribute("actividad"));
			session.removeAttribute("actividad");
			imparten.setGrupo(grupo);
			
			
			try {
				modMon.insertarGrupo(grupo);
				imparten.setEmpleado(modMon.getEmpleado((Integer)session.getAttribute("id_empleado")));
				
				modMon.insertarCruso(imparten);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("VerActividades").forward(request, response);
		}
		else {
			request.getRequestDispatcher("InsertarGrupoForm.jsp").forward(request, response);
		}
		
		
	}

}
