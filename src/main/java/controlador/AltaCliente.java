package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Cliente;
import modelo.dao.ModeloRecepcion;

/**
 * Alta de cliente,manda  a AltaCliente.jsp, recibimos los datos y crea el cliente, por ultimo nos lleva a verClientes 
 */
@WebServlet("/AltaCliente")
public class AltaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("AltaClienteForm.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloRecepcion modRec = new ModeloRecepcion();
		
		Cliente cliente = new Cliente();
		
		cliente.setDni(request.getParameter("dni"));
		cliente.setNombre(request.getParameter("nombre"));
		cliente.setApellido(request.getParameter("apellido"));
		cliente.setTelefono(request.getParameter("telefono"));
		cliente.setMail(request.getParameter("mail"));
		
		try {
			modRec.crearCliente(cliente);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("VerClientes").forward(request, response);
		
	}

}
