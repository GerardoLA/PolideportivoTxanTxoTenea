package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.bean.Empleado;
import modelo.dao.ModeloJefe;

/**
 * Modifica datos empleado sin posibilidad de cambiar el campo usuario
 */
@WebServlet("/ModificarDatosEmpleado")
public class ModificarDatosEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarDatosEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Empleado empleado = new Empleado();
		empleado.setId_empleado(Integer.parseInt(request.getParameter("id")));
		empleado.setNombre(request.getParameter("nombre"));
		empleado.setApellido(request.getParameter("apellido"));
		empleado.setDni(request.getParameter("dni"));
		empleado.setEdad(Integer.parseInt(request.getParameter("edad")));
		Date antiguedad = null;
		HttpSession session= request.getSession();
		
		try {
			antiguedad = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empleado.setAntiguedad(antiguedad);
		empleado.setId_jefe((Integer) session.getAttribute("id_empleado"));
		// NO SE PUEDE MODIFICAR EL CAMPO DE USUARIO!!
		ModeloJefe mj = new ModeloJefe();
		try {
			empleado.setUsuario(mj.getUsuarioPorId(request.getParameter("id_usuario")));
			empleado.setTrabajo(mj.getTrabajo(request.getParameter("trabajo")));
			
			mj.modificarDatosEmpleado(empleado);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		response.sendRedirect("VerEmpleados");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
