package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.ModeloRecepcion;

/**
 * Muestra las reservas que se han realizado en la sala indicada
 */
@WebServlet("/VerReservasSala")
public class VerReservasSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerReservasSala() {
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
				ModeloRecepcion modRec = new ModeloRecepcion();		
				
				try {
					request.setAttribute("reservas", modRec.getAlquilerSala(modRec.getIdSala(request.getParameter("codigo"))));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				request.getRequestDispatcher("VerReservas.jsp").forward(request, response);
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
