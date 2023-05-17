package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.bean.Grupo;
import modelo.dao.ModeloMonitor;

/**
 * Crea un grupo 
 */
@WebServlet("/InsertarGrupoSolo")
public class InsertarGrupoSolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarGrupoSolo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloMonitor modMon = new ModeloMonitor();
		HttpSession session= request.getSession();
		
		try {
			request.setAttribute("actividades", modMon.getActividade((Integer)session.getAttribute("id_empleado"))); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("InsertarGrupo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloMonitor modMon = new ModeloMonitor();
		HttpSession session= request.getSession();
		Grupo grupo = new Grupo (request.getParameter("id_grupo"),request.getParameter("dias"),request.getParameter("horas"),Integer.parseInt(request.getParameter("maxPartic")),Integer.parseInt(request.getParameter("numPartic")));
		
		if(grupo.comprobarId(request.getParameter("id_actividad"))) {
			try {
				modMon.insertarGrupo(grupo,request.getParameter("id_actividad"), (Integer)session.getAttribute("id_empleado"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("VerActividades").forward(request, response);
		}
		else {
			request.getRequestDispatcher("InsertarGrupo.jsp").forward(request, response);
		}	
		
	}

}
