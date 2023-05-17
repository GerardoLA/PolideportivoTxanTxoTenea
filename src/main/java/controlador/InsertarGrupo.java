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
		
		try {
			HttpSession session = request.getSession();
			
			if((Integer) session.getAttribute("id_empleado")==null) {
				request.setAttribute("error", "Inicia sesion antes de hacer cualquier operacion");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			else{
				ModeloMonitor modMon = new ModeloMonitor();
				Grupo grupo = new Grupo (request.getParameter("id_grupo"),request.getParameter("dias"),request.getParameter("horas"),Integer.parseInt(request.getParameter("maxPartic")),0);
				Actividad actividad = (Actividad) session.getAttribute("actividad");

				
				
				if(grupo.comprobarId(actividad.getId_actividad())) {
					Imparten imparten= new Imparten();
					
					imparten.setActividad((Actividad) session.getAttribute("actividad"));
					session.removeAttribute("actividad");
					imparten.setGrupo(grupo);
					
					
					try {
						
						imparten.setEmpleado(modMon.getEmpleado((Integer)session.getAttribute("id_empleado")));
						boolean funcionaG=modMon.insertarGrupo(grupo);
						boolean funciona=modMon.insertarCruso(imparten);
						
						if(funciona && funcionaG) {
							request.setAttribute("confirmacion", "Se ha insertado la actividad correctamente");
						}
						else {
							request.setAttribute("error", "No se ha insertado la actividad correctamente");
						}
						
						request.getRequestDispatcher("VerActividades").forward(request, response);
						
						
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
		} catch (Exception e) {
			request.setAttribute("error", "Ha ocurrido un error, inicio sesion de nuevo porfavor");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
