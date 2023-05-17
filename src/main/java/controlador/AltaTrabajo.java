package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.bean.Trabajo;
import modelo.dao.ModeloJefe;

/**
 * Alta de trabajo(puesto de trabajo);Prepara los datos, crea/dar de alta el trabajo y envía a VerTrabajos, donde los muestra.
 */
@WebServlet("/AltaTrabajo")
public class AltaTrabajo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaTrabajo() {
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
				ModeloJefe mp = new ModeloJefe();
				Trabajo trabajo = new Trabajo();
				trabajo.setNombre(request.getParameter("nombre"));

				try {					
					boolean funciona=mp.AltaTrabajo(trabajo);
					if(funciona) {
						request.setAttribute("confirmacion", "Trabajo insertado correctamente");
					}
					else {
						request.setAttribute("error", "No se ha insertado el trabajo correctamente");
					}
					
					request.getRequestDispatcher("VerTrabajos").forward(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.getRequestDispatcher("VerTrabajos").forward(request, response);
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
	
	}

}
