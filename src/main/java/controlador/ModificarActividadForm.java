package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Actividad;
import modelo.dao.ModeloMonitor;

/**
 * Redirecciona al formulario de modificar mostrando la actividad segun su id
 */
@WebServlet("/ModificarActividadForm")
public class ModificarActividadForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarActividadForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Actividad actividad = new Actividad();
		
		ModeloMonitor modMon = new ModeloMonitor();
		
		try {
			actividad=modMon.getActividad(request.getParameter("id_actividad"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("actividad", actividad);
		
		request.getRequestDispatcher("ModificarActividadForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
