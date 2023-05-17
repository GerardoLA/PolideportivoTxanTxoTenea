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
 * recibe los datos y modifica el grupo indicado por id_grupo y redirecciona a verActividades
 */
@WebServlet("/ModificarGrupo")
public class ModificarGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarGrupo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			
			if((Integer) session.getAttribute("id_empleado")==null) {
				request.setAttribute("error", "Inicia sesion antes de hacer cualquier operacion");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			else{

				ModeloMonitor modMon = new ModeloMonitor();
				Grupo grupo = new Grupo(request.getParameter("id_grupo"), request.getParameter("dias") ,request.getParameter("horas") , Integer.parseInt(request.getParameter("maxPartic")) , Integer.parseInt(request.getParameter("numPartic")));
				
				
				try {
					
					boolean funciona=modMon.modificarGrupo(grupo);
					if(funciona) {
						request.setAttribute("confirmacion", "Grupo modificado correctamente");
					}
					else {
						request.setAttribute("error", "No se ha modificado el grupo correctamente");
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.getRequestDispatcher("VerActividades").forward(request, response);
			}
			
			
		} catch (Exception e) {
			request.setAttribute("error", "Ha ocurrido un error, inicio sesion de nuevo porfavor");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
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
