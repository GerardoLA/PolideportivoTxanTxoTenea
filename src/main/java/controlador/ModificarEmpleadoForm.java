package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Empleado;
import modelo.bean.Trabajo;
import modelo.dao.ModeloJefe;

/**
 * Selecciona  empleado, segun id, para ser modificado y redirecciona a ModificarDatosEmpleado
 */
@WebServlet("/ModificarEmpleadoForm")
public class ModificarEmpleadoForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarEmpleadoForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloJefe mj = new ModeloJefe();
		Empleado empleado = new Empleado();
		int id_empleado = Integer.parseInt(request.getParameter("id"));
		
		ArrayList<Trabajo>trabajos = new ArrayList<>();
		try {
			empleado = mj.getEmpleado(id_empleado);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			trabajos = mj.getTrabajos();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			mj.getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("empleado",empleado);
		request.setAttribute("trabajos", trabajos);
	
		request.getRequestDispatcher("ModificarDatosEmpleado.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
