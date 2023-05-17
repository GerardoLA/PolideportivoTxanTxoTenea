package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Grupo;
import modelo.dao.ModeloMonitor;

/**
 * Manda a VerGrupos.jsp y eseña el grupo con la id indicada
 */
@WebServlet("/VerGrupo")
public class VerGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerGrupo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloMonitor modMon = new ModeloMonitor();
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		
		try {
			grupos.add(modMon.getGrupo(request.getParameter("idGrupo")));
		} catch (NumberFormatException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//PONERLO COMO ARRAYLIST
		request.setAttribute("grupos", grupos);
		request.getRequestDispatcher("VerGrupos.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
