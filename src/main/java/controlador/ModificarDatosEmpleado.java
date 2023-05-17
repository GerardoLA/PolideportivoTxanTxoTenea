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
		
		try {
			HttpSession session = request.getSession();
			
			if((Integer) session.getAttribute("id_empleado")==null) {
				request.setAttribute("error", "Inicia sesion antes de hacer cualquier operacion");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			else{
				Empleado empleado = new Empleado();
				empleado.setId_empleado(Integer.parseInt(request.getParameter("id")));
				empleado.setNombre(request.getParameter("nombre"));
				empleado.setApellido(request.getParameter("apellido"));
				empleado.setDni(request.getParameter("dni"));
				empleado.setEdad(Integer.parseInt(request.getParameter("edad")));
				Date antiguedad = null;			
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
					boolean funciona=mj.modificarDatosEmpleado(empleado);
					if(funciona) {
						request.setAttribute("confirmacion", "Empleado modificado correctamente");
					}
					else {
						request.setAttribute("error", "No se ha modificado el empleado correctamente");
					}
					
					request.getRequestDispatcher("VerEmpleados").forward(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
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
