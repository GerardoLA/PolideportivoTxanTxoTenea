package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		ModeloJefe mp = new ModeloJefe();
		Trabajo trabajo = new Trabajo();
		trabajo.setNombre(request.getParameter("nombre"));

		try {
			mp.AltaTrabajo(trabajo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("VerTrabajos").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
