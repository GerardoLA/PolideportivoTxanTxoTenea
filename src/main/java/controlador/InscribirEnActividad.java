package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		try {
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
		} catch (Exception e) {
			request.setAttribute("error", "Ha ocurrido un error, inicio sesion de nuevo porfavor");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
		
		
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
				ModeloRecepcion modRec = new ModeloRecepcion();
				
				Inscripcion inscripcion = new Inscripcion();
				
				try {
					inscripcion.setCliente(modRec.getCliente(request.getParameter("dni")));
					inscripcion.setActividad(modRec.getActividadPorGrupo(request.getParameter("actividad")));
					inscripcion.setGrupo(modRec.getGrupo(request.getParameter("actividad")));
					
					boolean funciona=modRec.crearInscripcion(inscripcion);
					if(funciona) {
						request.setAttribute("confirmacion", "Inscripcion insertada correctamente");
					}
					else {
						request.setAttribute("error", "No se ha insertado la inscripcion correctamente");
					}
					
					request.getRequestDispatcher("VerInscripciones").forward(request, response);
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} catch (Exception e) {
			request.setAttribute("error", "Ha ocurrido un error, inicio sesion de nuevo porfavor");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
		
		
		
	}

}
