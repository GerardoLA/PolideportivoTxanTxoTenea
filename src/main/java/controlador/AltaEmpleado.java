package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.bean.Empleado;
import modelo.bean.Trabajo;
import modelo.bean.Usuario;
import modelo.dao.ModeloJefe;

/**
 * Altaempleado, Prepara los datos, trabajo y usuario, manda a AltaEmpleado.jsp, recibe los datos y pro ultimo manda a VerEmpleados para enseñarnos los empleados.
 */
@WebServlet("/AltaEmpleado")
public class AltaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloJefe modJefe = new ModeloJefe();
		
		try {
			request.setAttribute("trabajos",modJefe.getTrabajos());
			request.setAttribute("usuarios", modJefe.getUsuariosParaform());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("AltaEmpleadoForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloJefe  modJefe = new ModeloJefe();
		HttpSession session = request.getSession();
		
		
		Trabajo trabajo = new Trabajo();
		Usuario usuario = new Usuario();
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String dni = request.getParameter("dni");
		int edad = Integer.parseInt(request.getParameter("edad"));
		int id_jefe = (Integer)session.getAttribute("id_empleado");
		try {
			 usuario = modJefe.getUsuarioPorId(request.getParameter("Id_usuario"));
			 trabajo = modJefe.getTrabajo(request.getParameter("trabajo"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Empleado empleado = new Empleado();
		empleado.setNombre(nombre);
		empleado.setApellido(apellido);
		empleado.setDni(dni);
		empleado.setEdad(edad);
		empleado.setId_jefe(id_jefe);
		empleado.setUsuario(usuario);
		empleado.setTrabajo(trabajo);
		
		try {
			modJefe.altaEmpleado(empleado);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("VerEmpleados").forward(request, response);
		
		
	}

}
