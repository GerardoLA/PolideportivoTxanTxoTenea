package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.bean.Actividad;
import modelo.dao.ModeloMonitor;
/**
 * Crea una actividad y redirecciona a insertar grupo.
 */
@WebServlet("/InsertarActividad")
public class InsertarActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("InsertarActividadForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloMonitor modMon= new ModeloMonitor();
		
		Actividad actividad = new Actividad(request.getParameter("id_actividad"),request.getParameter("nombre"),Double.parseDouble(request.getParameter("precio")));
		HttpSession session = request.getSession();
		
		session.setAttribute("actividad", actividad);

		try {
			modMon.insertarActividad(actividad);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("InsertarGrupoForm.jsp").forward(request, response);
	}

}
