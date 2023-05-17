package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Inscripcion;
import modelo.dao.ModeloRecepcion;

/**
 * 
 */
@WebServlet("/InscribirEnActividad")
public class InscribirEnActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Inscribe clientes en un grupo de una actividad.
     */
    public InscribirEnActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloRecepcion modRec = new ModeloRecepcion();
		try {
			
			request.setAttribute("clientes", modRec.getClientes());
			request.setAttribute("actividades", modRec.getActividadesImpartidas());
			request.setAttribute("grupos", modRec.getGruposImpartidos());
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		request.getRequestDispatcher("InscribirClienteForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloRecepcion modRec = new ModeloRecepcion();
		
		Inscripcion inscripcion = new Inscripcion();
		
		try {
			inscripcion.setCliente(modRec.getCliente(request.getParameter("dni")));
			inscripcion.setActividad(modRec.getActividadPorGrupo(request.getParameter("actividad")));
			inscripcion.setGrupo(modRec.getGrupo(request.getParameter("actividad")));
			modRec.crearInscripcion(inscripcion);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		request.getRequestDispatcher("VerInscripciones").forward(request, response);
	}

}
