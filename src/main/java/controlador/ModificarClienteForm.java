package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.bean.Cliente;
import modelo.dao.ModeloRecepcion;

/**
 * Selecciona el cliente segun el dni y redirecciona al formulario de modificar cliente.
 */
@WebServlet("/ModificarClienteForm")
public class ModificarClienteForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarClienteForm() {
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
				
				Cliente cliente = new Cliente();
				
				try {
					cliente=modRec.getCliente(request.getParameter("dni"));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.setAttribute("cliente", cliente);
				
				request.getRequestDispatcher("ModificarClienteForm.jsp").forward(request, response);
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
