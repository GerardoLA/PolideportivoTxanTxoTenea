package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		ModeloMonitor modMon = new ModeloMonitor();
		Grupo grupo = new Grupo(request.getParameter("id_grupo"), request.getParameter("dias") ,request.getParameter("horas") , Integer.parseInt(request.getParameter("maxPartic")) , Integer.parseInt(request.getParameter("numPartic")));
		
		
		try {
			modMon.modificarGrupo(grupo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("VerActividades").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
